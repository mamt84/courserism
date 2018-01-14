package com.example.courserism.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.courserism.model.Institution;

@RepositoryRestResource( collectionResourceRel = "intitutions", path = "institutions" )
public interface InstitutionRepository extends PagingAndSortingRepository<Institution, String>
{

}
