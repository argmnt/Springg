<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
  <title>Job Application</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">Job Applicant</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/">All Jobs</a></li>
      <li><a href="/secured/newJob">New Job</a></li>
      <li><a href="/secured/findAllApplicants">Applications</a></li>
      <li><a href="/newapplicant">Get Join Our Team!</a></li>
    </ul>
  </div>
</nav>
  
<div class="container">

		<c:choose>
			<c:when test="${mode == 'BOOK_VIEW' }"> 
			<table class="table">
			    <thead>
			      <tr>
			        <th>Id</th>
			        <th>Job title</th>
			        <th>Number of application</th>
			        <th>Last Applicant Date</th>
			        <th>Job Description</th>
			        <th>Edit</th>
			        <th>Delete</th>
			      </tr>
			    </thead>
			    <tbody>
			    	<c:forEach var="job" items="${jobs}">
			    							<tr>
			    								<td>${job.id}</td>
			    								<td>${job.jobTitle}</td>
			    								<td>${job.hireNumber}</td>
			    								<td>${job.lastAppDate}</td>
			    								<td>${job.jobDescription}</td>
			    								<td><a href="/secured/updateJob?id=${job.id}"><div class="glyphicon glyphicon-pencil"></div></a></td>
			    								<td><a href="/secured/deleteJob?id=${job.id}"><div class="glyphicon glyphicon-trash"></div></a></td>
			    							</tr>
			    	</c:forEach>
			    </tbody>
	  </table>
			
			</c:when>
			
			<c:when test="${mode == 'BOOK_EDIT' || mode == 'BOOK_NEW'}">
			  		 <form action="/secured/save" method="POST">
  		 <input type="hidden" class="form-control" value="${job.id}" name="id" id="id">
			  <div class="form-group">
			    <label for="jobTitle">Job title:</label>
			    <input type="text" class="form-control" value="${job.jobTitle}" name="jobTitle" id="jobTitle">
			  </div>
			  <div class="form-group">
			    <label for="author">Number of Application</label>
			    <input type="text" class="form-control" value="${job.hireNumber}" name="hireNumber" id="hireNumber">
			  </div>
			  <div class="form-group">
			    <label for="purchaseDate">Last Application Date</label>
			    <input type="date" class="form-control" value="${job.lastAppDate}" name="lastAppDate" id="lastAppDate">
			  </div>
			  <div class="form-group">
			    <label for="author">Description of a job</label>
			    <input type="text" class="form-control" value="${job.jobDescription}" name="jobDescription" id="jobDescription">
			  </div>
			  <button type="submit" class="btn btn-default">Submit</button>
</form> 
			</c:when>
			
			<c:when test="${mode == 'APPLICANTS_VIEW'}">
						<table class="table">
			    <thead>
			      <tr>
			        <th>Id</th>
			        <th>Name</th>
			        <th>Email</th>
			        <th>Phone</th>
			        <th>Adress</th>
			        <th>Thoughts</th>
			        <th>Resume</th>
			        <th>Edit</th>
			      </tr>
			    </thead>
			    <tbody>
			    	<c:forEach var="applicant" items="${applicants}">
			    							<tr>
			    								<td>${applicant.id}</td>
			    								<td>${applicant.name}</td>
			    								<td>${applicant.email}</td>
			    								<td>${applicant.phone}</td>
			    								<td>${applicant.adress}</td>
			    								<td>${applicant.thoughts}</td>
			    								<td>${applicant.resume}</td>
			    								<td><a href="/secured/updateApplication?id=${applicant.id}"><div class="glyphicon glyphicon-pencil"></div></a></td>
			    								
			    							</tr>
			    	</c:forEach>
			    </tbody>
	  </table>
	  
	  
			</c:when>
						
			<c:when test="${mode == 'APPLICANT_NEW' || mode == 'APPLICANT_EDIT'}">
			  		 <form action="/secured/saveApplication" method="POST">
  		 <input type="hidden" class="form-control" value="${applicants.id}" name="id" id="id">
			  <div class="form-group">
			    <label for="name">Name and Surname:</label>
			    <input type="text" class="form-control" value="${applicants.name}" name="name" id="name">
			  </div>
			  <div class="form-group">
			    <label for="email">Email</label>
			    <input type="text" class="form-control" value="${applicants.email}" name="email" id="email">
			  </div>
			  <div class="form-group">
			    <label for="phone">Phone</label>
			    <input type="text" class="form-control" value="${applicants.phone}" name="phone" id="phone">
			  </div>
			  <div class="form-group">
			    <label for="adress">Adress</label>
			    <input type="text" class="form-control" value="${applicants.adress}" name="adress" id="adress">
			  </div>
			  <div class="form-group">
			    <label for="thoughts">Thoughts</label>
			    <input type="text" class="form-control" value="${applicants.thoughts}" name="thoughts" id="thoughts">
			  </div>
			  <div class="form-group">
			    <label for="author">Resume</label>
			    <input type="text" class="form-control" value="${applicants.resume}" name="resume" id="resume">
			  </div>
			  <button type="submit" class="btn btn-default">Submit</button>
</form> 
			</c:when>
		</c:choose>
</div>