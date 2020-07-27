package com.anywhere.fitness.services;

import com.anywhere.fitness.models.Course;

import java.util.List;

public interface CourseService
{

    /**
     * Returns a list Containing all of the courses
     *
     * @return List of Courses. If no Courses, empty List.
     */
    List<Course> findAllCourses();

    /**
     * Returns a list Containing all courses that contain the given String
     *
     * @return List of matched Courses. If no match, empty List.
     */
    List<Course> findByNameContaining(String name);

    /**
     * Returns a list Containing all courses that contain the given String
     *
     * @return List of matched Courses. If no match, empty List.
     */
    List<Course> findByInstructor(String username);


}
