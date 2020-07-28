package com.anywhere.fitness.services;

import com.anywhere.fitness.exceptions.ResourceNotFoundException;
import com.anywhere.fitness.models.*;
import com.anywhere.fitness.repositories.CourseRepository;
import com.anywhere.fitness.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        newuser.setPassword(user.getPassword());
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

    @Override
    public void deleteAll()
    {
        userrepo.deleteAll();
    }
}
