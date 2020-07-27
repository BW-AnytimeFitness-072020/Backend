package com.anywhere.fitness.models;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UserCourseId implements Serializable
{
    private long user;

    private long course;

    public UserCourseId()
    {
    }

    public long getUser()
    {
        return user;
    }

    public void setUser(long user)
    {
        this.user = user;
    }

    public long getCourse()
    {
        return course;
    }

    public void setCourse(long course)
    {
        this.course = course;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        UserCourseId that = (UserCourseId) o;
        return user == that.user &&
                course == that.course;
    }

    @Override
    public int hashCode()
    {
        return 37;
    }
}
