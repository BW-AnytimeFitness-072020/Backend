package com.anywhere.fitness.controllers;

import com.anywhere.fitness.models.Course;
import com.anywhere.fitness.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;

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

    //http://localhost:2019/courses/courses{id}
    @DeleteMapping(value = "/courses/{id}")
    public ResponseEntity<?> deleteByCourseId(@PathVariable long id) {
        courseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
