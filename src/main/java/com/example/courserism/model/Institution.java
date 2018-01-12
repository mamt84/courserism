package com.example.courserism.model;

import static java.util.Optional.ofNullable;

import java.util.ArrayList;
import java.util.Collection;

import com.example.courserism.model.Grade.Prestige;
import com.example.courserism.model.Grade.Review;

public class Institution extends PersistentEntity
{
    private String              name;

    private String              Country;

    private Prestige            prestige;

    private Collection<Teacher> teachers = new ArrayList<>();

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getCountry()
    {
        return Country;
    }

    public void setCountry( String country )
    {
        Country = country;
    }

    public Prestige getPrestige()
    {
        return prestige;
    }

    public void setPrestige( Prestige prestige )
    {
        this.prestige = prestige;
    }

    public Collection<Teacher> getTeachers()
    {
        return teachers;
    }

    public void setTeachers( Collection<Teacher> teachers )
    {
        this.teachers = ofNullable( teachers ).orElseGet( ArrayList::new );
    }

    public Review getReview()
    {
        double average =
                teachers.stream().flatMapToInt( teacher -> teacher.getReviews().stream().mapToInt( Grade::getValue ) )
                        .average().orElse( 0 );

        return Review.valueOf( Long.valueOf( Math.round( average ) ).intValue() ).orElse( Review.WORTHLESS );
    }
}
