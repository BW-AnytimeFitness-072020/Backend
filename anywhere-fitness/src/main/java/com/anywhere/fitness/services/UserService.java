package com.anywhere.fitness.services;

import com.anywhere.fitness.models.User;

public interface UserService
{

    User save(User user);

    User update(User user, long id);

    void delete(long id);

    User addUserCourse(long courseid, String username);


    User findUserByName(String name);

    void deleteAll();
}
