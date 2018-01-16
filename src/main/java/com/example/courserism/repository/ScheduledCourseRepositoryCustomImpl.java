package com.example.courserism.repository;

import java.util.Collection;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.util.CloseableIterator;

import com.example.courserism.model.ScheduledCourse;

public class ScheduledCourseRepositoryCustomImpl implements ScheduledCourseRepositoryCustom
{
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Collection<ScheduledCourse> findAll( Criteria criteria )
    {
        return mongoTemplate.find( Query.query( criteria ), ScheduledCourse.class );
    }

    @Override
    public void streamConsumer( Criteria criteria, Consumer<Stream<ScheduledCourse>> consumer )
    {
        try (CloseableIterator<ScheduledCourse> closeable =
                mongoTemplate.stream( Query.query( criteria ), ScheduledCourse.class ))
        {
            Stream<ScheduledCourse> stream = StreamSupport
                    .stream( Spliterators.spliteratorUnknownSize( closeable, Spliterator.IMMUTABLE ), true );
            consumer.accept( stream );
        }
    }

    @Override
    public <T> T streamFunction( Criteria criteria, Function<Stream<ScheduledCourse>, T> function )
    {
        try (CloseableIterator<ScheduledCourse> closeable =
                mongoTemplate.stream( Query.query( criteria ), ScheduledCourse.class ))
        {
            Stream<ScheduledCourse> stream = StreamSupport
                    .stream( Spliterators.spliteratorUnknownSize( closeable, Spliterator.IMMUTABLE ), true );
            return function.apply( stream );
        }
    }

}
