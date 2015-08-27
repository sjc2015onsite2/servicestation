<!-- Page with all orders of customer -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-offset-2 col-sm-6">
	<table class="table table-striped table-hover table-bordered">
  		<tr>
	  		<th width="35%">Name</th>
	  		<th>Position</th>
	  		<th>Salary</th>
  		</tr>
  		<c:forEach var="person" items="${employees}">
  			<tr class="warning">
	  			<td>${person.name}</td>
	  			<td>${person.role}</td>
	  			<td>${person.salary.value}</td>
  			</tr>
  		</c:forEach>
  	</table>
</div>