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
<div class="col-sm-4">
	<button data-toggle="modal" data-target="#rent-modal" type="button" class="btn btn-warning btn-sm">Change rent</button>
</div>

<div class="modal fade" id="rent-modal">
	<div class="modal-dialog modal-sm">
		<div class="modal-content col-sm-offset-1 col-sm-10">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Change rent</h4>
			</div>

			<div class="modal-body">
				<form action="../accountant/affiliates" method="POST" class="form-horizontal" role="form">
					<div class="col-sm-2">
						<label class="text-left">Select affiliate:</label>
					</div>
					<div class="col-sm-10">
						<select name="affiliateId" class="form-control">
							<c:forEach var="i" items="${affilData }">
								<option value="${i[2]}">${i[0]}</option>
							</c:forEach>
						</select>
						<input name="newrent" type="text" class="form-control"
							placeholder="Enter rent">
					</div>
					<div>
						<br />
						<button type="submit" class="btn btn-warning btn-sm">Change</button>
					</div>
				</form>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>
