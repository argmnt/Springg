package com.jam.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jam.dao.JobRespository;
import com.jam.models.Job;

@Service
public class JobService {
	
	@Autowired
	private JobRespository jobRepository;
	
	public Collection<Job> findAllJobs(){
		List<Job> jobs = new ArrayList<Job>();
		for(Job job : jobRepository.findAll()) {
			jobs.add(job);
		}
		return jobs;
	}
	
	public void delete(long id) {
		jobRepository.delete(id);
	}
	
	public Job findOne(long id) {
		return jobRepository.findOne(id);
	}
	
	public void save(Job job) {
		jobRepository.save(job);
	}
}
