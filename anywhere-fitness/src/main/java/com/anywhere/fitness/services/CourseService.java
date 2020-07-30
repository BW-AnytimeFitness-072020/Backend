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

    Course findCourseById(long id);

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

    /**
     * Returns a list Containing all courses that start at the given int time.
     *
     * @return List of matched Courses. If no match, empty List.
     */
    List<Course> findByStarttime(int time);

    List<Course> findByDuration(int duration);

    List<Course> findByStartdate(String startdate);

    List<Course> findByType(String type);

    List<Course> findByIntensitylevel(String intensitylevel);

    List<Course> findByLocation(String location);

    Course save(Course course, String username);

    Course save(Course course);

    Course update(Course course, long id);

    void delete(long id);

    void deleteAll();

}
