package com.anywhere.fitness.controllers;

import com.anywhere.fitness.models.Course;
import com.anywhere.fitness.models.User;
import com.anywhere.fitness.services.CourseService;
import com.anywhere.fitness.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;

    @Autowired
    private UserService userService;

    // http://localhost:2019/courses/courses
    @GetMapping(value = "/courses", produces = {"application/json"})
    public ResponseEntity<?> listAllCourses() {
        List<Course> myCourses = courseService.findAllCourses();
        return new ResponseEntity<>(myCourses, HttpStatus.OK);
    }

    //http://localhost:2019/courses/courses/{id}
    @GetMapping(value ="/courses/{id}", produces = {"application/json"})
    public ResponseEntity<?> getCourseById(@PathVariable Long id) {
     Course c = courseService.findCourseById(id);
     return new ResponseEntity<>(c, HttpStatus.OK);
    }

    //http://localhost:2019/courses/course
    @PostMapping(value = "/course", consumes = "application/json")
    public ResponseEntity<?> addNewCourse(@Valid @RequestBody Course newCourse) {
        newCourse.setCourseid(0);
        newCourse = courseService.save(newCourse);
        return new ResponseEntity<>(null,
                HttpStatus.CREATED);
    }

    //UPDATE mapping
    @PutMapping(value = "/courses/{id}",
            consumes = "application/json")
    public ResponseEntity<?> updateFullCourse(
            @Valid
            @RequestBody
                    Course updateCourse,
            @PathVariable
                    long id)
    {
        updateCourse.setCourseid(id);
        courseService.save(updateCourse);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    //Search mapping


    //class time
    //class date
    //class duration
    //class type
    //intensity level
    //class location


    //http://localhost:2019/courses/courses{id}
    @DeleteMapping(value = "/courses/{id}")
    public ResponseEntity<?> deleteByCourseId(@PathVariable long id) {
        courseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    TODO: figure out how to get the authenticated users username from a GET request.
    @GetMapping(value = "/userinfo",
            produces = {"application/json"})
    public ResponseEntity<?> getCurrentUserInfo()
    {
        User u = userService.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
//        System.out.println(u.getUsername()); //nullPointerException
        return new ResponseEntity<>(u,
                HttpStatus.OK);
    }
}
