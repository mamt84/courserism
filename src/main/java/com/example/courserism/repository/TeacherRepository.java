package com.example.courserism.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.courserism.model.Teacher;

@RepositoryRestResource( collectionResourceRel = "teachers", path = "teachers" )
public interface TeacherRepository extends PagingAndSortingRepository<Teacher, String>
{

}
