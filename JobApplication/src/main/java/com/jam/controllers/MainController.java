package com.jam.controllers;

import java.io.IOException;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jam.models.Applicants;
import com.jam.models.Job;
import com.jam.services.ApplicantsService;
import com.jam.services.JobService;

@Controller
public class MainController {
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private ApplicantsService applicantsService;
	
	@GetMapping("/")
	public String init(HttpServletRequest req) {
		req.setAttribute("jobs", jobService.findAllJobs() );
		req.setAttribute("mode", "BOOK_VIEW");
		return "index";
	}
		@PreAuthorize("hasAnyRole('ADMIN')")
		@GetMapping("/secured/updateJob")
	public String init(@RequestParam long id, HttpServletRequest req) {
		req.setAttribute("job", jobService.findOne(id) );
		 req.setAttribute("mode", "BOOK_EDIT");
		return "index";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor( Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), false));
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/secured/save")
	public void save(@ModelAttribute Job job,BindingResult bindingResult,HttpServletRequest req,HttpServletResponse resp) throws IOException {
		job.setLastAppDate(new java.util.Date());
		jobService.save(job);

		resp.sendRedirect("/");
		
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/secured/newJob")
	public String newBook(HttpServletRequest req) {
		req.setAttribute("mode", "BOOK_NEW");
		return "index";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/secured/findAllApplicants")
	public String getAllApplicants(HttpServletRequest req){
		req.setAttribute("mode", "APPLICANTS_VIEW");
		req.setAttribute("applicants", applicantsService.findAllApplicants());
		return "index";
	}
	

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/secured/updateApplication")
	public String updateBook(@RequestParam long id, HttpServletRequest req) {
		req.setAttribute("applicants", applicantsService.findOne(id));
		req.setAttribute("mode", "APPLICANT_EDIT");
		return "index";
	}
	
	@PostMapping("/secured/saveApplication")
	public void saveApplication(@ModelAttribute Applicants applicants,HttpServletRequest req,HttpServletResponse resp) throws IOException {
		applicantsService.save(applicants);
		resp.sendRedirect("/");
	}
	
	
	@GetMapping("/newapplicant")
	public String newApplicant(HttpServletRequest req) {
		req.setAttribute("mode", "APPLICANT_NEW");
		return "index";
	}
	
}

