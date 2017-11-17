package com.jam.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jam.dao.ApplicantsRepository;
import com.jam.models.Applicants;

@Service
public class ApplicantsService {
	
	@Autowired
	private ApplicantsRepository applicantsRepository;
	
	public Collection<Applicants> findAllApplicants(){
	List<Applicants> applicants = new ArrayList<Applicants>();
		for(Applicants applicant : applicantsRepository.findAll() ) {
			applicants.add(applicant);
		}
		return applicants;
	}
	
	
	public Applicants findOne(long id) {
		return applicantsRepository.findOne(id);
	}
	
	public void save(Applicants applicant) {
		applicantsRepository.save(applicant);
	}
	
}
