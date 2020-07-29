package com.anywhere.fitness;

import com.anywhere.fitness.models.*;
import com.anywhere.fitness.services.CourseService;
import com.anywhere.fitness.services.RoleService;
import com.anywhere.fitness.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * SeedData puts both known and random data into the database. It implements CommandLineRunner.
 * <p>
 * CoomandLineRunner: Spring Boot automatically runs the run method once and only once
 * after the application context has been loaded.
 */
@Transactional
@Component
public class SeedData
        implements CommandLineRunner
{
    /**
     * Connects the Role Service to this process
     */
    @Autowired
    RoleService roleService;
    /**
     * Connects the user service to this process
     */
    @Autowired
    UserService userService;
    @Autowired
    CourseService courseService;
    /**
     * Generates test, seed data for our application
     * First a set of known data is seeded into our database.
     * Second a random set of data using Java Faker is seeded into our database.
     * Note this process does not remove data from the database. So if data exists in the database
     * prior to running this process, that data remains in the database.
     *
     * @param args The parameter is required by the parent interface but is not used in this process.
     */
    @Transactional
    @Override
    public void run(String[] args) throws
            Exception
    {
        userService.deleteAll();
        roleService.deleteAll();
        courseService.deleteAll();
        Role r1 = new Role("ADMIN");
        Role r2 = new Role("user");
//        Role r3 = new Role("data");
        r1 = roleService.save(r1);
        r2 = roleService.save(r2);
//        r3 = roleService.save(r3);
        // admin, user
        User u1 = new User("admin",
                "password",
                "$2a$04$ipZV/EonKZrdrlyKIJGLH.awQjAprT6Taf8MIRIS//yqjaYfrxYwa");
        u1.getRoles()
                .add(new UserRole(u1, r1));
        u1.getRoles()
                .add(new UserRole(u1, r2));
        u1 = userService.save(u1);
        // data, user
        User u2 = new User("cinnamon",
                "1234567",
                "$2a$04$ipZV/EonKZrdrlyKIJGLH.awQjAprT6Taf8MIRIS//yqjaYfrxYwa");
        u2.getRoles()
                .add(new UserRole(u2,r2));
        u2 = userService.save(u2);
        // user
        User u3 = new User("barnbarn",
                "ILuvM4th!",
                "$2a$04$ipZV/EonKZrdrlyKIJGLH.awQjAprT6Taf8MIRIS//yqjaYfrxYwa");
        u3.getRoles()
                .add(new UserRole(u3, r1));
        u3 = userService.save(u3);
        User u4 = new User("puttat",
                "password",
                "puttat@school.lambda");
        u4.getRoles()
                .add(new UserRole(u4, r2));
        u4 = userService.save(u4);
        User u5 = new User("misskitty",
                "password",
                "$2a$04$ipZV/EonKZrdrlyKIJGLH.awQjAprT6Taf8MIRIS//yqjaYfrxYwa");
        u5.getRoles()
                .add(new UserRole(u5, r1));
        u5 = userService.save(u5);
        /************
         * Seed course
         ************/
//        (String coursename,
//            String type,
//        int starttime,
//        int duration,
//        String intensitylevel,
//        String location,
//        long sizecapacity,
//        User instructor)
        Course c2 = new Course("Wing Chun", "Combat",6, 45, "Easy", "Virginia",15 ,u5);
        Course c7 = new Course("Jiu Jitsu", "Combat",19, 30, "Hard", "Brazil",110 ,u5);
        Course c6 = new Course("Hip Hop", "Dance",9, 60, "Easy", "Texas",45 ,u5);
        Course c3 = new Course("Tibo", "Cardio",19, 30, "Medium", "California",100 ,u3);
        Course c4 = new Course("YOGA", "cardio",8, 45, "Easy", "Indiana",55 ,u3);
        Course c9 = new Course("HIIT", "Cardio",19, 30, "Medium", "Kentucky",105 ,u3);
        Course c10 = new Course("Parkour", "Cardio",17, 80, "Hard", "New York",55 ,u3);
        Course c1 = new Course("Zoomba", "Cardio",12, 50, "Medium", "Florida",25 ,u1);
        Course c5 = new Course("Ballet", "Dance",13, 50, "Hard", "New Jersey",25 ,u1);
        Course c8 = new Course("YOGA", "cardio",8, 45, "Easy", "Michigan",55 ,u1);
        u4.getCourses().add(new UserCourse(u4,c1));
        u5.getCourses().add(new UserCourse(u5,c3));
        u5.getCourses().add(new UserCourse(u5,c1));
        u4.getCourses().add(new UserCourse(u4,c8));
        u2.getCourses().add(new UserCourse(u2,c8));
        u2.getCourses().add(new UserCourse(u2,c9));
        c1.getUsers().add(new UserCourse(u4,c1));
        c1.getUsers().add(new UserCourse(u5,c1));
        c3.getUsers().add(new UserCourse(u5,c3));
        c8.getUsers().add(new UserCourse(u4,c8));
        c8.getUsers().add(new UserCourse(u2,c8));
        c9.getUsers().add(new UserCourse(u2,c9));
//        u4.getRoles()
//                .add(new UserRole(u4, r2));
//        u4 = userService.save(u4);
//        u5.getRoles()
//                .add(new UserRole(u5, r1));
//        u5 = userService.save(u5);
//        u3.getRoles()
//                .add(new UserRole(u3, r1));
//        u3 = userService.save(u3);
//        u2.getRoles()
//                .add(new UserRole(u2,r2));
//        u2 = userService.save(u2);
//
//        u1.getRoles()
//                .add(new UserRole(u1, r1));
//        u1.getRoles()
//                .add(new UserRole(u1, r2));
//        u1 = userService.save(u1);
        userService.save(u2);
        userService.save(u4);
        userService.save(u5);

        courseService.save(c1);
        courseService.save(c2);
        courseService.save(c3);
        courseService.save(c4);
        courseService.save(c5);
        courseService.save(c6);
        courseService.save(c7);
        courseService.save(c8);
        courseService.save(c9);
        courseService.save(c10);
        System.out.println("hello ending");
    }
}