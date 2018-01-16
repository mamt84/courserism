package com.example.courserism.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.courserism.model.ScheduledCourse;

@RepositoryRestResource( collectionResourceRel = "scheduledcourses", path = "scheduledcourses" )
public interface ScheduledCourseRepository
        extends PagingAndSortingRepository<ScheduledCourse, String>, ScheduledCourseRepositoryCustom
{

}
