package com.jam.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jam.models.Applicants;

@Repository
public interface ApplicantsRepository extends CrudRepository<Applicants, Long>{
		
}
