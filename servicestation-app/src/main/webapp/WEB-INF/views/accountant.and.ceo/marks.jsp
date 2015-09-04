<!-- Page for comments about station -->
<!-- @author Rybakov Sergey -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      
<div class="col-sm-offset-2 col-sm-6" >
	<c:forEach var="mark" items="${marksanddate}" >
        <br />
  	    <blockquote>
        	<footer><strong>Author: </strong>${mark.key.author.name}</footer>
        	<br />
            <p class="text-warning">${mark.key.mark}</p>
            <footer><em>${mark.value}</em></footer>
        </blockquote>
	</c:forEach>
	<br/>
	<br/>
	<br/>
	<br/>
</div>
<div>
	<br />
	<br />
	<h1 class="text-info"><strong>${mark}</strong></h1>
</div>