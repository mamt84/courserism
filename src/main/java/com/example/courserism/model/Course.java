package com.example.courserism.model;

import static java.util.Optional.ofNullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.courserism.model.Grade.Review;

@Document
public abstract class Course extends PersistentEntity
{
    private CourseInfo         info;

    private List<Lecture>      lectures    = new ArrayList<>();

    private List<Assignment>   assignments = new ArrayList<>();

    @DBRef( lazy = true )
    private Institution        institution;

    private Integer            credits;

    private Double             fee;

    private Collection<Review> reviews     = new ArrayList<>();

    public CourseInfo getInfo()
    {
        return info;
    }

    public void setInfo( CourseInfo info )
    {
        this.info = info;
    }

    public List<Lecture> getLectures()
    {
        return lectures;
    }

    public void setLectures( List<Lecture> lectures )
    {
        this.lectures = ofNullable( lectures ).orElseGet( ArrayList::new );
    }

    public List<Assignment> getAssignments()
    {
        return assignments;
    }

    public void setAssignments( List<Assignment> assignments )
    {
        this.assignments = ofNullable( assignments ).orElseGet( ArrayList::new );
    }

    public Institution getInstitution()
    {
        return institution;
    }

    public void setInstitution( Institution institution )
    {
        this.institution = institution;
    }

    public Integer getCredits()
    {
        return credits;
    }

    public void setCredits( Integer credits )
    {
        this.credits = credits;
    }

    public Double getFee()
    {
        return fee;
    }

    public void setFee( Double fee )
    {
        this.fee = fee;
    }

    public Collection<Review> getReviews()
    {
        return reviews;
    }

    public void setReviews( Collection<Review> reviews )
    {
        this.reviews = ofNullable( reviews ).orElseGet( ArrayList::new );
    }

    public double getQuality()
    {
        return 0.4 * Grade.average( reviews ) + 0.6 * institution.getPrestige().getValue();
    }
}
