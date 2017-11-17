package com.jam.models;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="job_tbl")
public class Job implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="job_title")
	private String jobTitle;
	
	@Column(name="job_Description")
	private String jobDescription;
	
	@Column(name="job_Number")
	private String hireNumber;
	
	@Column(name="job_lDate")
	@Temporal(TemporalType.DATE)
	private Date lastAppDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getHireNumber() {
		return hireNumber;
	}

	public void setHireNumber(String hireNumber) {
		this.hireNumber = hireNumber;
	}

	public Date getLastAppDate() {
		return lastAppDate;
	}

	public void setLastAppDate(Date lastAppDate) {
		this.lastAppDate = lastAppDate;
	}
	
	

	
	
}
