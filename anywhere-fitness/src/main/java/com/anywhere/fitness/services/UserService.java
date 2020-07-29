package com.anywhere.fitness.services;

import com.anywhere.fitness.models.User;

public interface UserService
{

    User save(User user);

    User update(User user);

    void delete(long id);

    User addUserCourse(long courseid, String username);

    void removeUserCourse(long courseid, String username);


    void deleteAll();
    User findByName(String name);
}
