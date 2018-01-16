package com.example.courserism.model;

import org.springframework.data.annotation.Id;
import org.springframework.hateoas.Identifiable;

public abstract class PersistentEntity implements Identifiable<String>
{
    @Id
    private String id;

    @Override
    public String getId()
    {
        return id;
    }

    public void setId( String id )
    {
        this.id = id;
    }
}
