package com.example.courserism.controller;

import static java.util.Optional.ofNullable;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.IdentifiableResourceAssemblerSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.courserism.model.Course;
import com.example.courserism.model.PersistentEntity;
import com.example.courserism.model.ScheduledCourse;
import com.example.courserism.repository.CourseRepository;
import com.example.courserism.repository.ScheduledCourseRepository;

@RepositoryRestController
@RequestMapping( "scheduledcourses" )
public class ScheduledCourseController
{
    @Autowired
    private LocalValidatorFactoryBean beanValidator;

    @Autowired
    private ScheduledCourseRepository scheduledCourseRepository;

    @Autowired
    private CourseRepository          courseRepository;

    @InitBinder
    protected void initBinder( WebDataBinder binder )
    {
        binder.addValidators( beanValidator );
    }

    @PostMapping
    public ResponseEntity<Resource<ScheduledCourse>> create( @Valid @RequestBody ScheduledCourse scheduledCourse )
    {
        Course course = ofNullable( scheduledCourse.getCourse() ).map( c -> c.getId() ).map( courseRepository::findOne )
                .orElseThrow( IllegalArgumentException::new );

        ofNullable( course.getInstitution() )
                .filter( institution -> institution.getTeachers().stream().map( teacher -> teacher.getId() )
                        .anyMatch( id -> id.equals( scheduledCourse.getTeacher().getId() ) ) )
                .orElseThrow( IllegalArgumentException::new );

        Criteria startCriteria = Criteria.where( "start" ).lte( scheduledCourse.getStart() ).and( "end" )
                .gte( scheduledCourse.getStart() );
        Criteria endCriteria =
                Criteria.where( "start" ).lte( scheduledCourse.getEnd() ).and( "end" ).gte( scheduledCourse.getEnd() );
        Criteria criteria = new Criteria().orOperator( startCriteria, endCriteria );
        ofNullable( scheduledCourseRepository.streamFunction( criteria, stream -> stream.anyMatch( x -> true ) ) )
                .filter( collision -> !collision ).orElseThrow( IllegalArgumentException::new );

        return new ResponseEntity<Resource<ScheduledCourse>>(
                toResource( scheduledCourseRepository.save( scheduledCourse ) ), HttpStatus.CREATED );
    }

    @SuppressWarnings(
    { "unchecked", "rawtypes" } )
    protected <T extends PersistentEntity> Resource<T> toResource( T entity )
    {
        DefaultResourceAssembler<T> assembler = new DefaultResourceAssembler( this.getClass(), Resource.class );
        return assembler.toResource( entity );
    }

    class DefaultResourceAssembler<T extends PersistentEntity>
            extends IdentifiableResourceAssemblerSupport<T, Resource<T>>
    {

        public DefaultResourceAssembler( Class<?> controllerClass, Class<Resource<T>> resourceType )
        {
            super( controllerClass, resourceType );
        }

        @Override
        public Resource<T> toResource( T entity )
        {
            return createResource( entity );
        }

        @Override
        protected Resource<T> instantiateResource( T entity )
        {
            return new Resource<T>( entity );
        }

    }
}
