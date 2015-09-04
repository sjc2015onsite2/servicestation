<!-- Page for comments about mechanics -->
<!-- @author Rybakov Sergey -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<div class="col-sm-offset-1 col-sm-6" >
		<h4>Comments about ${mechanicName}</h4>
		<c:forEach var="comment" items="${comments}" >
	    	<br />
	        <br />
	  	    <blockquote>
	        	<footer><strong>Author: </strong>${comment.key.author.name}</footer>
	            <p class="text-primary">${comment.key.comment}</p>
	            <footer><em>${comment.value}</em></footer>
	        </blockquote>
		</c:forEach>
		<br/>
		<br/>
		<br/>
		<br/>
	</div>
	<form action="../ceo/mechanicscomments" method="POST">
		<div class="col-sm-4">
			<div class="col-sm-5">
				<select name="mechanicId" class="form-control">
					<c:forEach var="mechanic" items="${mechanics}">
				  		<option value="${mechanic.id}">${mechanic.name}</option>
					</c:forEach>
				</select>	
			</div>
			<button type="submit" class="btn btn-warning btn-sm">Show</button>
		</div>
	</form>
</div>