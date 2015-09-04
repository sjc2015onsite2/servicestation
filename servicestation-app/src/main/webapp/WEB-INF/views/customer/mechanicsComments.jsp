<!-- Page for comments about mechanics -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3 class="text-center">Comments about ${mechanicName}</h3>
<div class="col-sm-offset-3 col-sm-6" >
	<c:forEach var="comment" items="${comments}" >
    	<br />
        <br />
  	    <blockquote>
        	<footer><strong>Author: </strong>"${comment.key.author.name}"</footer>
        	<p class="text-primary">${comment.key.comment}</p>
            <footer><em>${comment.value}</em></footer>
        </blockquote>
	</c:forEach>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
</div>