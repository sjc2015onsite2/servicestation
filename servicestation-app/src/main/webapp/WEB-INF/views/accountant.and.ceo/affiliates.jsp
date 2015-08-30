<!-- Page with stationAffiliatesRent -->
<!-- @author Rybakov Sergey -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div class="col-sm-offset-4 col-sm-4">
	<table class="table table-striped table-hover table-bordered">
  		<tr>
	  		<th width="30%">Affiliate</th>
	  		<th>Rent for currentMonth </th>
	  		<th>Rent for today </th>
  		</tr>
  		<c:forEach var="data" items="${affilData}">
  			<tr class="warning">
	  			<td>${data[0]}</td>
	  			<td>${data[1]}</td>
	  			<td>${data[2]}</td>
  			</tr>
  		</c:forEach>
  	</table>
</div>
<security:authorize access="hasRole('ROLE_ACCOUNTANT')">
	<div class="col-sm-4">
		<button data-toggle="modal" data-target="#rent-modal" type="button" class="btn btn-warning btn-sm">Change rent</button>
	</div>
</security:authorize>

<div class="modal fade" id="rent-modal">
	<form action="affiliates" method="POST" class="form-horizontal" role="form">
		<div class="modal-dialog modal-sm">
			<div class="modal-content col-sm-offset-1 col-sm-10">
				<div class="modal-header">
					<button class="close" type="button" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Change rent</h4>
				</div>
				<div class="modal-body">		
					<div class="form-group">
						<label class="text-left">Select affiliate:</label>
						<select name="affiliateId" class="form-control">
							<c:forEach var="i" items="${affilData}">
								<option value="${i[3]}">${i[0]}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label class="text-left">Enter rent:</label>		
						<input name="newrent" type="text" class="form-control" placeholder="Enter rent">
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-warning btn-sm">Change</button>
					<button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button>
				</div>
			</div>
		</div>
	</form>
</div>
