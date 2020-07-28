package com.anywhere.fitness.services;

import com.anywhere.fitness.models.Course;
import com.anywhere.fitness.models.UserCourse;
import com.anywhere.fitness.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "courseService")
public class CourseServiceImpl
        implements CourseService
{
    @Autowired
    private CourseRepository courserepo;

    @Override
    public List<Course> findAllCourses()
    {
        List<Course> rtn = new ArrayList<>();
        courserepo.findAll()
                .iterator()
                .forEachRemaining(rtn::add);
        return rtn;
    }

    @Override
    public Course findCourseById(long id) {
        return courserepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course with id " + id + " Not Found"));
    }

    @Override
    public List<Course> findByNameContaining(String name)
    {
        List<Course> rtn = courserepo.findByCoursenameContainingIgnoreCase(name);
        return rtn;
    }

    @Override
    public List<Course> findByInstructor(String username)
    {
        return courserepo.findCoursesByInstructor_Username(username);
    }

    @Override
    public List<Course> findByStarttime(int time)
    {
        return null;
    }

    @Transactional
    @Override
    public Course save(Course course)
    {
        Course newCourse = new Course();

        if(course.getCourseid() != 0) {
            courserepo.findById(course.getCourseid())
                    .orElseThrow(() -> new EntityNotFoundException("Course id " + course.getCourseid() + " Not Found"));
        }
        newCourse.setCoursename(course.getCoursename());
        newCourse.setDuration(course.getDuration());

        if (course.getInstructor() != null) {
            newCourse.setInstructor(course.getInstructor());
        }

        newCourse.setIntensitylevel(course.getIntensitylevel());
        newCourse.setLocation(course.getLocation());
        newCourse.setSizecapacity(course.getSizecapacity());
        newCourse.setStarttime(course.getStarttime());
        newCourse.setType(course.getType());

        newCourse.getUsers().clear();
        for(UserCourse uc : course.getUsers()) {
            newCourse.getUsers().add(new UserCourse(uc.getUser(), newCourse));
        }

        return courserepo.save(newCourse);
//        return courserepo.save(course);
    }

    @Override
    public void delete(long id) {
        if (courserepo.findById(id)
        .isPresent()) {
            courserepo.deleteById(id);
        } else {
            throw new EntityNotFoundException("Course with id " + id + " Not Found");
        }
    }

    @Override
    public void deleteAll()
    {
        courserepo.deleteAll();
    }
}
