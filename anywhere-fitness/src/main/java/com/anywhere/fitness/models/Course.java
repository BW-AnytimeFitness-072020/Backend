package com.anywhere.fitness.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

//    @Column(nullable = false)
    private String coursename;

    private String type;

    private int starttime;

    private int duration;

    private String intensitylevel;

    private String location;

    private long sizecapacity;


    @ManyToOne
    @JoinColumn(name = "instructorid")
    @JsonIgnoreProperties(value = "instructorcourses", allowSetters = true)
//    @Column(nullable = false)
    private User instructor;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
//    @JsonIgnoreProperties(value = "course", allowSetters = true)
    @JsonIgnore
    private Set<UserCourse> users = new HashSet<>();

    public Course()
    {
    }

    public Course(String coursename,
                  String type,
                  int starttime,
                  int duration,
                  String intensitylevel,
                  String location,
                  long sizecapacity,
                  User instructor)
    {
        this.coursename = coursename;
        this.type = type;
        this.starttime = starttime;
        this.duration = duration;
        this.intensitylevel = intensitylevel;
        this.location = location;
        this.sizecapacity = sizecapacity;
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

    public long registeredAttendees(){
        return this.users.size();
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public int getStarttime()
    {
        return starttime;
    }

    public void setStarttime(int starttime)
    {
        this.starttime = starttime;
    }

    public int getDuration()
    {
        return duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public String getIntensitylevel()
    {
        return intensitylevel;
    }

    public void setIntensitylevel(String intensitylevel)
    {
        this.intensitylevel = intensitylevel;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public long getSizecapacity()
    {
        return sizecapacity;
    }

    public void setSizecapacity(long sizecapacity)
    {
        this.sizecapacity = sizecapacity;
    }

    @Override
    public String toString()
    {
        return "Course{" +
                "courseid=" + courseid +
                ", coursename='" + coursename + '\'' +
                ", type='" + type + '\'' +
                ", starttime=" + starttime +
                ", duration=" + duration +
                ", intensitylevel='" + intensitylevel + '\'' +
                ", location='" + location + '\'' +
                ", sizecapacity=" + sizecapacity +
                ", instructor=" + instructor +
                ", users=" + users +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
