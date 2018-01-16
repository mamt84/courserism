package com.example.courserism.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student extends Person
{
    private Integer            creditsEarned;

    @DBRef
    private Collection<Course> passedCourses = new HashSet<>();

    public Integer getCreditsEarned()
    {
        return creditsEarned;
    }

    public void setCreditsEarned( Integer creditsEarned )
    {
        this.creditsEarned = creditsEarned;
    }

    public Collection<Course> getPassedCourses()
    {
        return passedCourses;
    }

    public void setPassedCourses( Collection<Course> passedCourses )
    {
        this.passedCourses = Optional.ofNullable( passedCourses ).orElseGet( HashSet::new );
    }

}
