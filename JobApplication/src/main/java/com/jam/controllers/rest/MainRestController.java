package com.jam.controllers.rest;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jam.models.Applicants;
import com.jam.models.Job;
import java.util.Collection;

import com.jam.services.ApplicantsService;
import com.jam.services.JobService;

@RestController
public class MainRestController {

	@Autowired
	private JobService jobService;
	
	@Autowired
	 private ApplicantsService applicantsService;
	
	@GetMapping("/findAllJobs")
	public Collection<Job> getAllJobs(){
		return jobService.findAllJobs();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/secured/deleteJob")
	public void deleteJob(@RequestParam long id,HttpServletRequest req,HttpServletResponse resp) throws IOException {
		req.setAttribute("mode", "BOOK_NEW");
		jobService.delete(id);
		resp.sendRedirect("/");
	}
	

	
}


