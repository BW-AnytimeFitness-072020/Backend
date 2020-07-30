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

//    @Column(nullable = false)
    private String coursename;

    private String type;

    @org.springframework.data.annotation.Transient
    public boolean hasvalueforstarttime = false;
    private int starttime;

    @org.springframework.data.annotation.Transient
    public boolean hasvalueforduration = false;
    private int duration;

    private String intensitylevel;

    private String location;

    private String startdate;

    @org.springframework.data.annotation.Transient
    public boolean hasvalueforsizecapacity = false;
    private long sizecapacity;




    @ManyToOne
    @JoinColumn(name = "instructorid")
    @JsonIgnoreProperties(value = {"instructorcourses", "courses"}, allowSetters = true)

//    @Column(nullable = false)
//    @JsonIgnore
    private User instructor;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "course", allowSetters = true)
//    @JsonIgnore
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
                  String startdate,
                  long sizecapacity,
                  User instructor)
    {
        this.coursename = coursename;
        this.type = type;
        this.starttime = starttime;
        this.duration = duration;
        this.intensitylevel = intensitylevel;
        this.location = location;
        this.startdate = startdate;
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
        hasvalueforstarttime = true;
        this.starttime = starttime;
    }

    public int getDuration()
    {
        return duration;
    }

    public void setDuration(int duration)
    {
        hasvalueforduration = true;
        this.duration = duration;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
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
        hasvalueforsizecapacity = true;
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
