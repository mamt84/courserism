package com.example.courserism.model;

import static java.util.Optional.ofNullable;

import java.util.ArrayList;
import java.util.List;

public class CourseInfo
{
    private String       about;

    private List<String> subjects = new ArrayList<>();

    public String getAbout()
    {
        return about;
    }

    public void setAbout( String about )
    {
        this.about = about;
    }

    public List<String> getSubjects()
    {
        return subjects;
    }

    public void setSubjects( List<String> subjects )
    {
        this.subjects = ofNullable( subjects ).orElseGet( ArrayList::new );
        ;
    }
}
