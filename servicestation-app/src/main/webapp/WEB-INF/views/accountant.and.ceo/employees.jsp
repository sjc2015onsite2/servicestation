<!-- Page with all orders of customer -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-offset-3 col-sm-6">
	<table class="table table-striped table-hover table-bordered">
  		<tr>
	  		<th width="35%">Name</th>
	  		<th>Position</th>
	  		<th>Yesterday's salary (BYR)</th>
	  		<th>Today's salary (BYR)</th>
  		</tr>
  		<c:forEach var="person" items="${personsData}">
  			<tr class="warning">
	  			<td>${person[0]}</td>
	  			<td>${person[1]}</td>
	  			<td>${person[4]}</td>
	  			<td>${person[2]}</td>
  			</tr>
  		</c:forEach>
  	</table>
</div>
<security:authorize access="hasRole('ROLE_ACCOUNTANT')">
	<div class="col-sm-3">
		<button data-toggle="modal" data-target="#salary-modal" type="button" class="btn btn-warning btn-sm">Change salary</button>
	</div>
</security:authorize>

<div class="modal fade" id="salary-modal">
	<div class="modal-dialog modal-sm">
		<div class="modal-content col-sm-offset-1 col-sm-10">
				<form action="employees" method="POST" class="form-horizontal" role="form">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Change salary</h4>
			</div>

			<div class="modal-body">
					<div class="form-group">
						<label class="text-left">Select employee:</label>
						<select name="personId" class="form-control">
							<c:forEach var="person" items="${personsData}">
								<option value="${person[3]}">${person[0]}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<input name="newsalary" type="text" class="form-control" placeholder="Enter salary">
					</div>
			</div>

			<div class="modal-footer">
				<button type="submit" class="btn btn-warning btn-sm">Change</button>
				<button type="button" class="btn btn-default bnt-sm" data-dismiss="modal">Cancel</button>
			</div>
				</form>
		</div>
	</div>
</div>