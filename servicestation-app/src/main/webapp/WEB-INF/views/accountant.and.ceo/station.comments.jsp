<!-- Page for comments about station -->
<!-- @author Rybakov Sergey -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      
<div class="col-sm-offset-2 col-sm-6" >
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
	<br/>
	<br/>
	<br/>
</div>