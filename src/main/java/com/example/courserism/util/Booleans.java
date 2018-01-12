package com.example.courserism.util;

import static java.util.Optional.ofNullable;

import java.util.Arrays;

public abstract class Booleans
{
    public static void requireAllTrue( Boolean... values )
    {
        ofNullable( values ).filter( v -> Arrays.asList( v ).stream().allMatch( e -> e ) )
                .orElseThrow( () -> new IllegalArgumentException() );
    }
}
