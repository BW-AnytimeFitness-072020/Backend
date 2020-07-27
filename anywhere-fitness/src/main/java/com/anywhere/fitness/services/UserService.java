package com.anywhere.fitness.services;

import com.anywhere.fitness.models.User;

public interface UserService
{

    User save(User user);

    void deleteAll();
}
