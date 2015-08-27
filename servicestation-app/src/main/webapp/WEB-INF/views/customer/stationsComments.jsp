<!-- Page for comments about mechanics -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


      
<div class="col-sm-offset-1" >
	<c:forEach var="comment" items="${comments}" >
        <br />
        <br />
  	    <blockquote>
        	<footer><strong>Station: </strong>"Station 1"</footer>
            <p class="text-primary">${comment.key.comment}</p>
            <footer>${comment.key.author.name}<em> ${comment.value}</em></footer>
        </blockquote>
	</c:forEach>
</div>