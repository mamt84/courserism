package com.example.courserism.repository;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import org.springframework.data.mongodb.core.query.Criteria;

import com.example.courserism.model.ScheduledCourse;

public interface ScheduledCourseRepositoryCustom
{
    Collection<ScheduledCourse> findAll( Criteria criteria );

    void streamConsumer( Criteria criteria, Consumer<Stream<ScheduledCourse>> consumer );

    <T> T streamFunction( Criteria criteria, Function<Stream<ScheduledCourse>, T> function );
}
