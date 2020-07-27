package com.anywhere.fitness.services;

import com.anywhere.fitness.models.Course;
import com.anywhere.fitness.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Course save(Course course)
    {
        return courserepo.save(course);
    }

    @Override
    public void deleteAll()
    {
        courserepo.deleteAll();
    }
}
