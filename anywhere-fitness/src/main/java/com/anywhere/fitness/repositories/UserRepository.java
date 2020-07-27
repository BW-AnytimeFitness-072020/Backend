package com.anywhere.fitness.repositories;

import com.anywhere.fitness.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
}
