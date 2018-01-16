package com.example.courserism.model;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ScheduledCourse extends PersistentEntity
{
    @NotNull
    @DBRef( lazy = true )
    private Course    course;

    @NotNull
    // @Future
    private LocalDate start;

    @NotNull
    // @Future
    private LocalDate end;

    @NotNull
    @DBRef( lazy = true )
    private Teacher   teacher;

    public Course getCourse()
    {
        return course;
    }

    public void setCourse( Course course )
    {
        this.course = course;
    }

    public LocalDate getStart()
    {
        return start;
    }

    public void setStart( LocalDate start )
    {
        this.start = start;
    }

    public LocalDate getEnd()
    {
        return end;
    }

    public void setEnd( LocalDate end )
    {
        this.end = end;
    }

    public Teacher getTeacher()
    {
        return teacher;
    }

    public void setTeacher( Teacher teacher )
    {
        requireNonNull( teacher );

        if ( course.getInstitution() != teacher.getInstitution() )
        {
            throw new IllegalArgumentException();
        }

        this.teacher = teacher;
    }

}
