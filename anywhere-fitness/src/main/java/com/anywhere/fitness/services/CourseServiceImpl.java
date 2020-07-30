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
        return courserepo.findByStarttime(time);
    }

    @Override
    public List<Course> findByDuration(int duration) {
        return courserepo.findByDuration(duration);
    }

    @Override
    public List<Course> findByType(String type) {
        return courserepo.findByType(type);
    }

    @Override
    public List<Course> findByLocation(String location) {
        return courserepo.findByLocation(location);
    }

    @Override
    public List<Course> findByStartdate(String startdate) {
        return courserepo.findByStartdate(startdate);
    }

    @Override
    public List<Course> findByIntensitylevel(String intensitylevel) {
        return courserepo.findByIntensitylevel(intensitylevel);
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
        newCourse.setStartdate(course.getStartdate());

        newCourse.getUsers().clear();
        for(UserCourse uc : course.getUsers()) {
            newCourse.getUsers().add(new UserCourse(uc.getUser(), newCourse));
        }

        return courserepo.save(newCourse);
    }

    @Transactional
    @Override
    public Course update(Course course, long id) {
        Course currentCourse = findCourseById(id);

        if (course.getCoursename() != null) {
            currentCourse.setCoursename(course.getCoursename());
        }
        if (course.hasvalueforduration) {
            currentCourse.setDuration(course.getDuration());
        }
        if (course.getIntensitylevel() != null) {
            currentCourse.setIntensitylevel(course.getIntensitylevel());
        }
        if (course.getLocation() != null) {
            currentCourse.setLocation(course.getLocation());
        }
        if (course.hasvalueforsizecapacity) {
            currentCourse.setSizecapacity(course.getSizecapacity());
        }
        if (course.hasvalueforstarttime) {
            currentCourse.setStarttime(course.getStarttime());
        }
        if (course.getType() != null) {
            currentCourse.setType(course.getType());
        }
        if (course.getStartdate() != null) {
            currentCourse.setStartdate(course.getStartdate());
        }
        return courserepo.save(currentCourse);
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
