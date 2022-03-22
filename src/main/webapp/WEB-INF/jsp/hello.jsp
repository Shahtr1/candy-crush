<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${app.getTitle()}</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body class="container">
	
	<div class="jumbotron" style="margin-top:5rem">
		<div class="text-center" style="display: flex;justify-content: center">
			<img src="${app.getIcon()}" width="70px" style="margin-right: 1rem">
			<h2 style="text-decoration: underline;">${app.getTitle()}</h2>
		</div>
		
		
		<div class="table-responsive">
		  <table class="table">
		  <thead>
	    <tr>
	      <th scope="col">Id</th>
	      <th scope="col">App Id</th>
	      <th scope="col">Url</th>
	      <th scope="col">Content rating</th>
	      <th scope="col">Size</th>
	      <th scope="col">Version</th>
	      <th scope="col">Free</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr>
	    	<td>${app.getId()}</td>
	    	<td>${app.getAppId()}</td>
	    	<td>${app.getUrl()}</td>
	    	<td>${app.getContentRating()}</td>
	    	<td>${app.getSize()}</td>
	    	<td>${app.getVersion()}</td>
	    	<td>${app.isFree()}</td>
	    </tr>
	  </tbody>
		  </table>
		</div>
		
		<h3>Description</h3>
		<div class="card">
		  <div class="card-body">${app.getDescription()}</div>
		</div>
		
		<hr>
		<h3>Genre</h3>
			<div class="table-responsive">
				  <table class="table">
				  <thead>
			    <tr>
			      <th scope="col">Id</th>
			      <th scope="col">Name</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			    	<td>${app.getGenre().getId()}</td>
			    	<td>${app.getGenre().getName()}</td>
			    </tr>
			  </tbody>
				  </table>
				</div>
		<hr>
		<h3>Developer</h3>
		<div class="table-responsive">
				  <table class="table">
				  <thead>
			    <tr>
			      <th scope="col">Id</th>
			      <th scope="col">Name</th>
			      <th scope="col">Url</th>
			      <th scope="col">Website</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			    	<td>${app.getDeveloper().getId()}</td>
			    	<td>${app.getDeveloper().getName()}</td>
			    	<td>${app.getDeveloper().getUrl()}</td>
			    	<td>${app.getDeveloper().getWebsite()}</td>
			    </tr>
			  </tbody>
				  </table>
				</div>
	</div>
</body>
</html>