package com.anywhere.fitness.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long courseid;

    @Column(nullable = false)
    private String coursename;

    @ManyToOne
    @JoinColumn(name = "instructorid")
    @JsonIgnoreProperties(value = "courses", allowSetters = true)
    @Column(nullable = false)
    private User instructor;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "course", allowSetters = true)
    private Set<UserCourse> users = new HashSet<>();

    public Course()
    {
    }

    public Course(String coursename,
                  User instructor)
    {
        this.coursename = coursename;
        this.instructor = instructor;
    }

    public long getCourseid()
    {
        return courseid;
    }

    public void setCourseid(long courseid)
    {
        this.courseid = courseid;
    }

    public String getCoursename()
    {
        return coursename;
    }

    public void setCoursename(String coursename)
    {
        this.coursename = coursename;
    }

    public User getInstructor()
    {
        return instructor;
    }

    public void setInstructor(User instructor)
    {
        this.instructor = instructor;
    }

    public Set<UserCourse> getUsers()
    {
        return users;
    }

    public void setUsers(Set<UserCourse> users)
    {
        this.users = users;
    }

}
