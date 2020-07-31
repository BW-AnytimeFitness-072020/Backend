package com.anywhere.fitness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing
@SpringBootApplication
public class FitnessApplicationTests
{

    public static void main(String[] args)
    {
        SpringApplication.run(FitnessApplication.class,
                args);
    }

}
