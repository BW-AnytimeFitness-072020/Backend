package com.anywhere.fitness.controllers;

import com.anywhere.fitness.models.User;
import com.anywhere.fitness.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/addcourse/{courseid}", produces = {"application/json"})
    public ResponseEntity<?> addCourse(@PathVariable long courseid){

        User u = userService.findUserByName(SecurityContextHolder.getContext().getAuthentication().getName());
        User nu = userService.addUserCourse(courseid, u.getUsername());

        return new ResponseEntity<>(nu, HttpStatus.OK);
    }


    @PutMapping(value = "/user/{id}", consumes = {"application/json"})
    public ResponseEntity<?> updateUser(@Valid @RequestBody User user,
                                          @PathVariable long id){
        user.setUserid(id);
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/users", produces = {"application/json"})
    public ResponseEntity<?> listAllUsers(){
        List<User> rtn = userService.findAllUsers();
        return new ResponseEntity<>(rtn, HttpStatus.OK);
    }

    @PatchMapping(value = "/user/{id}", produces = {"application/json"})
    public ResponseEntity<?> patchUser(@RequestBody User user, @PathVariable long id){
        userService.update(user, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }





//    @GetMapping(value = "/getuserinfo",
//            produces = {"application/json"})
//    public ResponseEntity<?> getCurrentUserInfo()
//    {
//        User u = userService.findUserByName(SecurityContextHolder.getContext().getAuthentication().getName());
//        return new ResponseEntity<>(u,
//                HttpStatus.OK);
//    }
}
