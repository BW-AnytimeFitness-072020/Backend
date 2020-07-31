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
    UserService userService;

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
        User u = userService.findUserByName(SecurityContextHolder.getContext().getAuthentication().getName());
        newCourse.setCourseid(0);
        newCourse = courseService.save(newCourse, SecurityContextHolder.getContext().getAuthentication().getName());
        return new ResponseEntity<>(newCourse,
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
        courseService.save(updateCourse, SecurityContextHolder.getContext().getAuthentication().getName());

        return new ResponseEntity<>(HttpStatus.OK);
    }


    //Search mapping
    @GetMapping(value = "/times/{startTime}", produces = {"application/json"})
    public ResponseEntity<?> searchByTime(@PathVariable int startTime) {
        List<Course> c = courseService.findByStarttime(startTime);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }


    @GetMapping(value = "/dates/{startdate}", produces = {"application/json"})
    public ResponseEntity<?> searchByDate(@PathVariable String startdate) {
        List<Course> c = courseService.findByStartdate(startdate);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }


    @GetMapping(value = "/durations/{duration}", produces = {"application/json"})
    public ResponseEntity<?> searchByDuration(@PathVariable int duration) {
        List<Course> c = courseService.findByDuration(duration);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }


    @GetMapping(value = "/types/{type}", produces = {"application/json"})
    public ResponseEntity<?> searchByType(@PathVariable String type) {
        List<Course> c = courseService.findByType(type);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }


    @GetMapping(value = "/levels/{intensitylevel}", produces = {"application/json"})
    public ResponseEntity<?> searchByLevel(@PathVariable String intensitylevel) {
        List<Course> c = courseService.findByIntensitylevel(intensitylevel);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }


    @GetMapping(value = "/locations/{location}", produces = {"application/json"})
    public ResponseEntity<?> searchByLocation(@PathVariable String location) {
        List<Course> c = courseService.findByLocation(location);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }



    //class time
    //class date
    //class duration
    //class type
    //intensity level
    //class location


    //http://localhost:2019/courses/courses{id}
    @DeleteMapping(value = "/course/{id}")
    public ResponseEntity<?> deleteByCourseId(@PathVariable long id) {
        courseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/getuserinfo",
            produces = {"application/json"})
    public ResponseEntity<?> getCurrentUserInfo()
    {
        User u = userService.findUserByName(SecurityContextHolder.getContext().getAuthentication().getName());
        return new ResponseEntity<>(u,
                                    HttpStatus.OK);
    }
}
