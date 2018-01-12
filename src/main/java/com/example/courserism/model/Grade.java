package com.example.courserism.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

public interface Grade
{
    int getValue();

    static double average( Collection<? extends Grade> grades )
    {
        return grades.stream().mapToInt( Grade::getValue ).average().orElse( 0 );
    }

    public enum Review implements Grade
    {
        WORTHLESS( 0 ), BAD( 1 ), OK( 2 ), GOOD( 3 ), VERY_GOOD( 4 ), EXCELLENT( 5 );

        private int value;

        private Review( int value )
        {
            this.value = value;
        }

        @Override
        public int getValue()
        {
            return value;
        }

        public static Optional<Review> valueOf( int value )
        {
            return Arrays.stream( values() ).filter( v -> v.value == value ).findFirst();
        }
    }

    public enum Prestige implements Grade
    {
        WORTHLESS( 0 ), BAD( 1 ), OK( 2 ), GOOD( 3 ), VERY_GOOD( 4 ), EXCELLENT( 5 );

        private int value;

        private Prestige( int value )
        {
            this.value = value;
        }

        @Override
        public int getValue()
        {
            return value;
        }
    }
}

