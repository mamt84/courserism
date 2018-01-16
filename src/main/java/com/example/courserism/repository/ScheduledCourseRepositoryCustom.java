package com.example.courserism.repository;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.courserism.model.ScheduledCourse;

public interface ScheduledCourseRepositoryCustom
{
    @RestResource( exported = false )
    Collection<ScheduledCourse> findAll( Criteria criteria );

    @RestResource( exported = false )
    void streamConsumer( Criteria criteria, Consumer<Stream<ScheduledCourse>> consumer );

    @RestResource( exported = false )
    <T> T streamFunction( Criteria criteria, Function<Stream<ScheduledCourse>, T> function );
}
