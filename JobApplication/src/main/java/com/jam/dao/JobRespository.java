package com.jam.dao;

import org.springframework.data.repository.CrudRepository;

import com.jam.models.Job;

public interface JobRespository  extends CrudRepository<Job, Long>{

}
