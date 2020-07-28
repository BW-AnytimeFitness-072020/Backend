package com.anywhere.fitness.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "instructor", allowSetters = true)
    private Set<Course> instructorcourses = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "user", allowSetters = true)
    private Set<UserRole> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "user", allowSetters = true)
//    @JsonIgnore
    private Set<UserCourse> courses = new HashSet<>();

    public User()
    {
    }

    public User(String username,
                String email,
                String password)
    {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public long getUserid()
    {
        return userid;
    }

    public void setUserid(long userid)
    {
        this.userid = userid;
    }

    public String getUsername()
    {
        return username.toLowerCase();
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email.toLowerCase();
    }

    public String getPassword()
    {
        return password;
    }

    public void setPasswordNoEncrypt(String password)
    {
        this.password = password;
    }

    public void setPassword(String password)
    {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = password;//Encoder.encode(password);
    }


    public Set<UserRole> getRoles()
    {
        return roles;
    }

    public void setRoles(Set<UserRole> roles)
    {
        this.roles = roles;
    }

    public Set<UserCourse> getCourses()
    {
        return courses;
    }

    public void setCourses(Set<UserCourse> courses)
    {
        this.courses = courses;
    }

    public Set<Course> getInstructorcourses()
    {
        return instructorcourses;
    }

    public void setInstructorcourses(Set<Course> instructorcourses)
    {
        this.instructorcourses = instructorcourses;
    }

    @JsonIgnore
    public List<SimpleGrantedAuthority> getAuthority()
    {
        List<SimpleGrantedAuthority> rtnList = new ArrayList<>();

        for (UserRole r : this.roles)
        {
            String myRole = "ROLE_" + r.getRole()
                    .getName()
                    .toUpperCase();
            rtnList.add(new SimpleGrantedAuthority(myRole));
        }

        return rtnList;
    }
}
