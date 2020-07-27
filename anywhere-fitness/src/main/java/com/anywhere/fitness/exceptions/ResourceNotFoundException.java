package com.anywhere.fitness.exceptions;


public class ResourceNotFoundException
        extends RuntimeException
{
    public ResourceNotFoundException(String message)
    {
        super("Application Error: " + message);
    }
}