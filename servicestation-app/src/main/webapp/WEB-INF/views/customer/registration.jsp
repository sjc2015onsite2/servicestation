<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form action="newcustomer" comandName="siteUser" method="POST" role="form">
	<div class="col-sm-offset-5 col-sm-2">
		<div class="modal-header">
	    	<h4 class="modal-title">Registration</h4>
		</div>
	    <div class="form-group has-feedback">
	  		<label>Name</label>
			<input type="text" class="form-control" name="name" placeholder="Enter user name">
			<sf:errors name="name" cssClass="error"/>
		</div>
	  	<div class="form-group">
	    	<label>Login</label>
	    	<input type="text" class="form-control" name="login" placeholder="Enter login">
	    	<sf:errors name="login" cssClass="error"/>
	  	</div>
	  	<div class="form-group">
	    	<label>Password</label>
	    	<input type="password" class="form-control" name="password" placeholder="Enter password">
		    <sf:errors name="password" cssClass="error"/>
	  	</div>
	  	<div class="form-group">
	    	<label>Repeat password</label>
	    	<input type="password" class="form-control" placeholder="Repeat password">
	  	</div>
	  
	  	<div class="modal-footer">
	    	<button type="submit" class="btn btn-info" >Sing up</button>
	    </div>
	</div>
</form:form>
