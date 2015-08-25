<!-- Page with all orders of customer -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-offset-1 col-sm-10">
	<table class="table table-striped table-hover table-bordered">
  		<tr>
	  		<th width="35%">Problem</th>
	  		<th>Status</th>
	  		<th>Station</th>
	  		<th>Mechanic</th>
	  		<th>price</th>
	  		<th>Date</th>
	  		<th>Notification</th>
  		</tr>
  		<c:forEach var="order" items="${orders}" >
  			<c:url value="/user/myorders/${order.key.orderId}" var="myorder" />
  			<tr class="warning">
  			<td><a href="${myorder}">${order.key.problemDescription}</a></td>
  			<td>Working</td>
  			<td>${order.value.name}</td>
  			<td>Mechanic</td>
  			<td>000000000</td>
  			<td>date of registration</td>
  			<td>
  				<c:if test="${not empty order.key.notification }">
  					<span class="glyphicon glyphicon-envelope"></span>
  				</c:if>
  			</td>
  			</tr>
  		</c:forEach>
  	</table>
</div>