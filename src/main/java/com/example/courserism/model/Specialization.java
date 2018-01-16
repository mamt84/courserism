package com.example.courserism.model;

import static java.util.Optional.ofNullable;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Specialization implements CreditProvider
{
    @DBRef
    private Collection<Course> courses = new ArrayList<>();

    public Collection<Course> getPaidCourses()
    {
        return courses;
    }

    public void setPaidCourses( Collection<Course> courses )
    {
        this.courses = ofNullable( courses ).orElseGet( ArrayList::new );
    }

    @Override
    public Integer getCredits()
    {
        return courses.stream().mapToInt( course -> course.getCredits() ).sum();
    }
}
