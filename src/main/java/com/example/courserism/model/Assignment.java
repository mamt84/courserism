package com.example.courserism.model;

import static java.util.Optional.ofNullable;

import java.util.ArrayList;
import java.util.List;

public class Assignment
{
    private List<String> questions = new ArrayList<>();

    public List<String> getQuestions()
    {
        return questions;
    }

    public void setQuestions( List<String> questions )
    {
        this.questions = ofNullable( questions ).orElseGet( ArrayList::new );
    }
}
