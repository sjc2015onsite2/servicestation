<!-- Page with all orders of customer -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-offset-3 col-sm-4">
	<table class="table table-striped table-hover table-bordered">
  		<tr>
	  		<th width="20%">Affiliate</th>
	  		<th>Rent </th>
  		</tr>
  		<c:forEach var="i" items="${affilData }">
  			<tr class="warning">
	  			<td>${i[0] }</td>
	  			<td>${i[1] }</td>
  			</tr>
  		</c:forEach>
  	</table>
</div>