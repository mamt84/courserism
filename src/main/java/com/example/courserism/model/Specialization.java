package com.example.courserism.model;

import static java.util.Optional.ofNullable;

import java.util.ArrayList;
import java.util.Collection;

public class Specialization implements CreditProvider
{
    private Collection<PaidCourse> paidCourses = new ArrayList<>();

    public Collection<PaidCourse> getPaidCourses()
    {
        return paidCourses;
    }

    public void setPaidCourses( Collection<PaidCourse> paidCourses )
    {
        this.paidCourses = ofNullable( paidCourses ).orElseGet( ArrayList::new );
    }

    @Override
    public Integer getCredits()
    {
        return paidCourses.stream().mapToInt( course -> course.getCredits() ).sum();
    }
}
