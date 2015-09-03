<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="dynamic" method='POST'>
	<div>
		<div class="col-sm-6">
			<div class="col-sm-offset-5 col-sm-2">
				<label class="text-right">STATION</label>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="col-sm-3">
				<label class="text-right">Select affiliate: </label>
			</div>
			<div class="col-sm-4">
				<select name="affilateId" class="form-control">
					<c:forEach var="affiliate" items="${affiliates }">
						<option value="${affiliate.affilateId }">${affiliate.affilateCode }</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-sm-offset-1 col-sm-2">
				<button type="submit" class="btn btn-warning btn-sm">Show</button>
			</div>
		</div>
	</div>
</form>
<div class="col-sm-6">
	<div class="col-sm-offset-2 col-sm-8">
		<br />
		<br />
		<table class="table table-striped table-hover table-bordered">
			
	  		<tr>
		  		<th width="20%">Month</th>
		  		<th class="text-danger">Expenses (BYR)</th>
		  		<th class="text-success">Profit (BYR)</th>
	  		</tr>
	  		<tr class="success">
		  		<td>Current</td>
		  		<td class="text-danger">${currentStationCharges}</td>
		  		<td class="text-success">${currentStationProfit}</td>
	  		</tr>
	  		<c:forEach var="data" items="${stationData}">
		  		<tr class="warning">
			  		<td>${data[0] }</td>
			  		<td class="text-danger">${data[1] }</td>
			  		<td class="text-success">${data[2] }</td>
		  		</tr>
	  		</c:forEach>
	  	</table>
	</div>
</div>

<div class="col-sm-6">
	<div class="col-sm-offset-1 col-sm-8">
		<br />
		<p class="text-center"><strong><em>${affiliateName}</em></strong></p>
		<table class="table table-striped table-hover table-bordered">
	  		<tr>
		  		<th width="20%">Month</th>
		  		<th class="text-danger">Expenses (BYR)</th>
		  		<th class="text-success">Profit (BYR)</th>
	  		</tr>
	  		<tr class="success">
		  		<td>Current</td>
		  		<td class="text-danger">${currentAffiliateCharges}</td>
		  		<td class="text-success">${currentAffiliateProfit}</td>
	  		</tr>
	  		<c:forEach var="data" items="${affiliateData}">
		  		<tr class="warning">
			  		<td>${data[0] }</td>
			  		<td class="text-danger">${data[1] }</td>
			  		<td class="text-success">${data[2] }</td>
		  		</tr>
		  	</c:forEach>
	  	</table>
	</div>
</div>