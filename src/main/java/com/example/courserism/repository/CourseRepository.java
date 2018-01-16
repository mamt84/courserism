package com.example.courserism.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.courserism.model.Course;

@RepositoryRestResource( collectionResourceRel = "courses", path = "courses" )
public interface CourseRepository extends PagingAndSortingRepository<Course, String>
{

}
