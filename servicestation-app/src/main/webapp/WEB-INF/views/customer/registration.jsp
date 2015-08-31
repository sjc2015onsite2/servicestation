<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<form:form action="newcustomer" commandName="siteUser" method="POST">
	<div class="col-sm-offset-5 col-sm-2">
		<div class="modal-header">
	    	<h4 class="modal-title">Registration</h4>
		</div>
	    <div class="form-group has-feedback">
	  		<form:label path="name">Name</form:label>
			<form:input type="text" class="form-control" path="name" placeholder="Enter user name"/>
			<p class="text-danger"><form:errors class="text-danger" path="name" cssClass="error"/></p>
		</div>
	  	<div class="form-group">
	    	<form:label path="login">Login</form:label>
	    	<form:input type="text" class="form-control" path="login" placeholder="Enter login"/>
	    	<p class="text-danger"><form:errors class="text-danger" path="login" cssClass="error"/></p>
	  	</div>
	  	<div class="form-group">
	    	<form:label path="password">Password</form:label>
	    	<form:input type="password" class="form-control" path="password" placeholder="Enter password"/>
		    <p class="text-danger"><form:errors class="text-danger" path="password" cssClass="error"/></p>
	  	</div>
	  
	  	<div class="modal-footer">
	    	<button type="submit" class="btn btn-info" >Sing up</button>
	    	<br/>
	    	<br/>
	    	<br/>
	    	<br/>
	    	<br/>
	    </div>
	</div>
</form:form>
