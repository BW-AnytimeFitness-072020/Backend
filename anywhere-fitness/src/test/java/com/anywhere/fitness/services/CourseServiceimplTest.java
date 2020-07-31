package com.anywhere.fitness.services;

import com.anywhere.fitness.FitnessApplication;
import com.anywhere.fitness.exceptions.ResourceNotFoundException;
import com.anywhere.fitness.models.Course;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FitnessApplication.class)
public class CourseServiceimplTest {

    @Autowired
    CourseService courseService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findAllCourses(){assertEquals(12, courseService.findAllCourses().size());
    }

    @Test
    public void findByStartTime(){assertEquals(2, courseService.findByStarttime(8).size());}

    @Test
    public void findByIntensitylevel(){assertEquals(4, courseService.findByIntensitylevel("Easy").size());}

    @Test
    public void findByLocation(){assertEquals(1, courseService.findByLocation("Texas").size());}

    @Test
    public void findByStartdate(){assertEquals(1, courseService.findByStartdate("2020-01-01").size());}

    @Test
    public void findCourseById(){assertEquals("Wing Chun", courseService.findCourseById(12).getCoursename());}

    @Test(expected = ResourceNotFoundException.class)
    public void notFindCourseById()
    {
        assertEquals("Wing Chun", courseService.findCourseById(999).getCoursename());
    }

    @Test
    public void delete()
    {
        courseService.delete(11);assertEquals(12, courseService.findAllCourses().size());
    }

    @Test
    public void save() {
        Course course = new Course();
        course.setCourseid(99);
        course.setCoursename("Yeehaw");
        course.setType("Combat");
        course.setStarttime(930);
        course.setDuration(30);
        course.setIntensitylevel("medium");
        course.setLocation("Texas");
        course.setStartdate("2020-06-09");
        course.setSizecapacity(100);

        assertEquals(course.getCourseid(), 99);
    }
}
