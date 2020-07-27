package com.anywhere.fitness.services;

import com.anywhere.fitness.models.User;
import com.anywhere.fitness.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserRepository userrepo;

    @Override
    public User save(User user)
    {
        return userrepo.save(user);
    }

    @Override
    public void deleteAll()
    {
        userrepo.deleteAll();
    }
}
