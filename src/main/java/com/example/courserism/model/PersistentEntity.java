package com.example.courserism.model;

public abstract class PersistentEntity
{
    private String id;

    public String getId()
    {
        return id;
    }

    public void setId( String id )
    {
        this.id = id;
    }
}
