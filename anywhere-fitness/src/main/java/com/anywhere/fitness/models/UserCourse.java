package com.anywhere.fitness.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "usercourses")
@IdClass(UserCourseId.class)
public class UserCourse extends Auditable implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "courses", allowSetters = true)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "courseid")
    @JsonIgnoreProperties(value = "users", allowSetters = true)
    private Course course;

    public UserCourse()
    {
    }

    public UserCourse(User user,
                      Course course)
    {
        this.user = user;
        this.course = course;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof UserCourse))
        {
            return false;
        }
        UserCourse that = (UserCourse) o;
        return ((user == null) ? 0 : user.getUserid()) == ((that.user == null) ? 0 : that.user.getUserid()) &&
                ((course == null) ? 0 : course.getCourseid()) == ((that.course == null) ? 0 : that.course.getCourseid());
    }

    @Override
    public int hashCode()
    {
        return 37;
    }
}
