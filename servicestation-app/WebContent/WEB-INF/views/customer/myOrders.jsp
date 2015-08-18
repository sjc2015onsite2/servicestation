<!-- Page with all orders of customer -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-offset-1 col-sm-10">
	<table class="table table-striped table-hover table-bordered">
  		<tr><th>Problem</th><th>Status</th><th>Station</th><th>Mechanic</th><th>price</th><th>Date</th></tr>
  		<c:forEach var="order" items="${orders}" >
  			<tr class="warning"><td>problem 1</td><td>Working</td><td>StationName</td><td>Mechanic</td><td>price</td><td>date of registration</td></tr>
  		</c:forEach>
  	</table>
</div>