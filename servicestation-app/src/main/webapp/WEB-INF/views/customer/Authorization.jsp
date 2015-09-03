<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<h4 class="text-center">Authorization</h4>

<div class="col-sm-offset-4 col-sm-4">
<c:if test="${not empty error}">
	<div class="danger">
		<p class="alert alert-danger">
		Your login attempt was not successful, try again.
 		Check entered data.
		</p>
	</div>
</c:if>
</div>

<form action="../j_spring_security_check" method="POST">
	<div class="col-sm-offset-5 col-sm-2">
	  	<div class="form-group">
	    	<label>Login</label>
	    	<input type="text" class="form-control" name="username" placeholder="Enter login"/>
	  	</div>
	  	<div class="form-group">
	    	<label>Password</label>
	    	<input type="password" class="form-control" name="password" placeholder="Enter password"/>
	  	</div>
	  
	  	<div class="modal-footer">
	    	<button type="submit" class="btn btn-success" >Sing in</button>
	    	<br/>
	    	<br/>
	    	<br/>
	    	<br/>
	    	<br/>
	    </div>
	</div>
</form>
