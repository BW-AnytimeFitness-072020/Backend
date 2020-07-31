package com.anywhere.fitness.services;

import com.anywhere.fitness.exceptions.ResourceNotFoundException;
import com.anywhere.fitness.models.*;
import com.anywhere.fitness.repositories.CourseRepository;
import com.anywhere.fitness.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserRepository userrepo;

    @Autowired
    private CourseService courseService;

    @Autowired
    private RoleService roleService;
    
    @Autowired
    private HelperFunctions helperFunctions;

    @Transactional
    @Override
    public User save(User user)
    {
        User newuser = new User();
        if(user.getUserid() != 0){
            userrepo.findById(user.getUserid())
                    .orElseThrow(()-> new ResourceNotFoundException("User ID: "+ user.getUserid()+" Not Found..."));
            newuser.setUserid(user.getUserid());
        }
        newuser.setEmail(user.getEmail());
        newuser.setPasswordNoEncrypt(user.getPassword());
        newuser.setUsername(user.getUsername());

        newuser.getCourses().clear();
        for(UserCourse uc : user.getCourses()){
//            Course course = courseService.findById(uc.getCourse().getCourseid());

//            UserCourse nuc = new UserCourse(newuser,course);
//            uc.setUser(newuser);
            newuser.getCourses().add(new UserCourse(newuser, uc.getCourse()));
        }

        newuser.getRoles().clear();
        for (UserRole ur : user.getRoles()){
            Role role = roleService.findRoleById(ur.getRole().getRoleid());

            newuser.getRoles().add(new UserRole(newuser, role));
        }

        newuser.getInstructorcourses().clear();
        for(Course c : user.getInstructorcourses()){
            Course course = courseService.findCourseById(c.getCourseid());
            course.setInstructor(newuser);

            newuser.getInstructorcourses().add(course);
        }

        return userrepo.save(newuser);
    }

    @Transactional
    @Override
    public void deleteAll()
    {
        userrepo.deleteAll();
    }

    @Transactional
    @Override
    public User update(User user, long id)
    {
        User updateuser = userrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User ID: "+ id +" Not Found..."));
        if(helperFunctions.isAuthorizedToMakeChange(updateuser.getUsername()))
        {
            if (user.getEmail() != null)
            {
                updateuser.setEmail(user.getEmail());
            }
            if (user.getPassword() != null)
            {
                updateuser.setPasswordNoEncrypt(user.getPassword());
            }
            if (user.getUsername() != null)
            {
                updateuser.setUsername(user.getUsername());
            }

            if (user.getCourses()
                    .size() > 0)
            {
                updateuser.getCourses()
                        .clear();
                for (UserCourse uc : user.getCourses())
                {
//            Course course = courseService.findById(uc.getCourse().getCourseid());

//            UserCourse nuc = new UserCourse(newuser,course);
//            uc.setUser(newuser);
                    updateuser.getCourses()
                            .add(new UserCourse(updateuser,
                                    uc.getCourse()));
                }
            }

            if (user.getRoles()
                    .size() > 0)
            {
                updateuser.getRoles()
                        .clear();
                for (UserRole ur : user.getRoles())
                {
                    Role role = roleService.findRoleById(ur.getRole()
                            .getRoleid());

                    updateuser.getRoles()
                            .add(new UserRole(updateuser,
                                    role));
                }
            }

            if (user.getInstructorcourses()
                    .size() > 0)
            {
                updateuser.getInstructorcourses()
                        .clear();
                for (Course c : user.getInstructorcourses())
                {
                    Course course = courseService.findCourseById(c.getCourseid());
                    course.setInstructor(updateuser);

                    updateuser.getInstructorcourses()
                            .add(course);
                }
            }

            return userrepo.save(updateuser);
        }
        throw new ResourceNotFoundException("User Not Authorized to Make This Change");
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        if(userrepo.findById(id).isPresent())
        {
            User u = userrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User ID: " + id + " Not Found..."));
            if(helperFunctions.isAuthorizedToMakeChange(u.getUsername()))
            {
                userrepo.deleteById(id);
            }
        }else
        {
            throw new ResourceNotFoundException("User ID: " + id + " Not Found...");
        }
    }

    @Transactional
    @Override
    public User addUserCourse(long courseid, String username)
    {

        if(helperFunctions.isAuthorizedToMakeChange(username))
        {
            User u = userrepo.findByUsername(username.toLowerCase());
            Course c = courseService.findCourseById(courseid);
            u.getCourses()
                    .add(new UserCourse(u,
                            c));
//        c.getUsers().add(new UserCourse(u,c));

            return u;
        }
        throw new EntityNotFoundException("User name '" + username + "' not found!");
    }



    @Transactional
    @Override
    public User findUserByName(String name)
    {
        
        User uu = userrepo.findByUsername(name.toLowerCase());
        if (uu == null)
        {
            throw new ResourceNotFoundException("User name " + name + " not found!");
        }
        return uu;
    }

    @Override
    public List<User> findAllUsers()
    {
        List<User> rtn = new ArrayList<>();
        userrepo.findAll()
        .iterator()
        .forEachRemaining(rtn::add);
        return rtn;
    }

    @Override
    public User findById(long id)
    {
        return userrepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No User Found With ID " + id));
    }


}
