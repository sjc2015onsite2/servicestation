<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="stationdata" method='POST'>
	<div class="col-sm-9">
		<div class="col-sm-8">
			<div>
				<div class="col-sm-offset-6">		
					<strong class="text-success">Profit for the last month: ${lustMonthProfit} (BYR)</strong>
				</div>
			</div>
			<div>
				<div class="col-sm-offset-6">
					<br />
					<strong class="text-danger">Expenses for the last month: ${lustMonthExpenses} (BYR)</strong>
				</div>
			</div>
		</div>
		<div class="col-sm-4">
			<div>
				<div class="col-sm-offset-1">		
					<strong class="text-success">Profit for the current month: ${currentMonthProfit} (BYR)</strong>
				</div>
			</div>
			<div>
				<div class="col-sm-offset-1">
					<br />
					<strong class="text-danger">Expenses for the current month: ${currentMonthExpenses} (BYR)</strong>
				</div>
			</div>
		</div>
	</div>

	<div class="col-sm-offset-2 col-sm-8">
		<br />
		<br />
		<br />
		<div class="col-sm-2">
			<strong class="text-right">Enter startDate: </strong>
		</div>
		<div class="col-sm-3">
			<input name="startdate" type="text" class="form-control input-sm" placeholder="dd.MM.yyyy">
		</div>
		<div class="col-sm-2">
		</div>
		<div class="col-sm-2">
			<strong class="text-right">Enter finishDate: </strong>
		</div>
		<div class="col-sm-3">
			<input name="finishdate" type="text" class="form-control input-sm" placeholder="dd.MM.yyyy">
		</div>
	</div>
	<div>
		<div class="col-sm-offset-5 col-sm-3">
			<br />
			<br />
			<button type="submit" class="btn btn-warning btn-sm">Show profit and expenses</button>
		</div>
		<div class="col-sm-4"></div>
	</div>
</form>
<div>
	<div class="col-sm-offset-2 col-sm-4">
		<br />
		<br />
		
		<strong class="text-success">Profit: ${profit} (BYR)</strong>
	</div>
	<div class="col-sm-offset-6 col-sm-6"></div>
</div>
<div>
	<div class="col-sm-offset-2 col-sm-4">
		<br />
		<strong class="text-danger">Expenses: ${expenses} (BYR)</strong>
	</div>
</div>