package com.example.courserism.model;

import static java.util.Optional.ofNullable;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.courserism.model.Grade.Review;

@Document
public class Teacher extends Person
{
    private String             title;

    private Collection<Review> reviews = new ArrayList<>();

    @DBRef( lazy = true )
    private Institution        institution;

    public String getTitle()
    {
        return title;
    }

    public void setTitle( String title )
    {
        this.title = title;
    }

    public Collection<Review> getReviews()
    {
        return reviews;
    }

    public void setReviews( Collection<Review> reviews )
    {
        this.reviews = ofNullable( reviews ).orElseGet( ArrayList::new );
    }

    public Institution getInstitution()
    {
        return institution;
    }

    public void setInstitution( Institution institution )
    {
        this.institution = institution;
    }
}
