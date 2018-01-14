package com.example.courserism.model;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ScheduledCourse extends PersistentEntity
{
    private Course    course;

    private LocalDate start;

    private LocalDate end;

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
