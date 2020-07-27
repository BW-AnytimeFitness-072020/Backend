package com.anywhere.fitness.exceptions;


public class ResourceFoundException
        extends RuntimeException
{
    public ResourceFoundException(String message)
    {
        super("Application Error: " + message);
    }
}