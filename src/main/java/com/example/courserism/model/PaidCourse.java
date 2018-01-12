package com.example.courserism.model;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import com.example.courserism.model.Grade.Review;
import com.example.courserism.util.Booleans;

public class PaidCourse extends Course implements CreditProvider
{
    private FreeCourse course;

    private Integer    credits;

    private Double     fee;

    public PaidCourse( FreeCourse course, Integer credits, Double fee )
    {
        super();
        this.course = requireNonNull( course );
        Booleans.requireAllTrue( credits <= 0, fee <= 0 );
        this.credits = credits;
        this.fee = fee;
    }

    public PaidCourse( FreeCourse course )
    {
        super();
        this.course = Objects.requireNonNull( course );
    }

    @Override
    public String getId()
    {
        return course.getId();
    }

    @Override
    public void setId( String id )
    {
        course.setId( id );
    }

    @Override
    public CourseInfo getInfo()
    {
        return course.getInfo();
    }

    @Override
    public void setInfo( CourseInfo info )
    {
        course.setInfo( info );
    }

    @Override
    public List<Lecture> getLectures()
    {
        return course.getLectures();
    }

    @Override
    public void setLectures( List<Lecture> lectures )
    {
        course.setLectures( lectures );
    }

    @Override
    public List<Assignment> getAssignments()
    {
        return course.getAssignments();
    }

    @Override
    public void setAssignments( List<Assignment> assignments )
    {
        course.setAssignments( assignments );
    }

    @Override
    public Institution getInstitution()
    {
        return course.getInstitution();
    }

    @Override
    public void setInstitution( Institution institution )
    {
        course.setInstitution( institution );
    }

    @Override
    public Collection<Review> getReviews()
    {
        return course.getReviews();
    }

    @Override
    public void setReviews( Collection<Review> reviews )
    {
        course.setReviews( reviews );
    }

    @Override
    public double getQuality()
    {
        return course.getQuality();
    }

    @Override
    public int hashCode()
    {
        return course.hashCode();
    }

    @Override
    public boolean equals( Object obj )
    {
        return course.equals( obj );
    }

    @Override
    public String toString()
    {
        return course.toString();
    }

    public Double getFee()
    {
        return fee;
    }

    public void setFee( Double fee )
    {
        Booleans.requireAllTrue( fee > 0 );
        this.fee = fee;
    }

    @Override
    public Integer getCredits()
    {
        return credits;
    }
}
