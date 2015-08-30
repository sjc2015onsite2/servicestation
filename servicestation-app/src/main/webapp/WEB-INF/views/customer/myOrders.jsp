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
			<th>Cost (BYR)</th>
			<th>Created date</th>
			<th>Notification</th>
		</tr>
		<c:forEach var="order" items="${allOrders}">
			<c:url value="/user/myorders/${order[7]}" var="myorder" />
			<tr class="warning">
				<td><a href="${myorder}">${order[0]}</a></td>
				<td>${order[1]}</td>
				<td>${order[2]}</td>
				<td>${order[3]}</td>
				<td>${order[4]}</td>
				<td>${order[5]}</td>
				<c:if test="${not empty order[6]}">
					<td><p class="text-center"><span class="glyphicon glyphicon-envelope"></span></p></td>
				</c:if>
				<c:if test="${empty order[6]}">
					<td></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
	
	<div class="col-sm-offset-5">
			<div class="panel-body">
				<ul class="pagination">
	
					<c:if test="${page > 1 }">
						<li><a href="?page=${page - 1}"><span>&laquo;</span></a></li>
					</c:if>
					<c:forEach begin="${startpage}" end="${endpage}" var="p">
						<c:if test="${p == page }">
							<li class="active"><a href="?page=${p}">${p}<span
									class="sr-only">(current)</span></a></li>
						</c:if>
						<c:if test="${p != page }">
							<li><span><a href="?page=${p}">${p}</a></span></li>
						</c:if>
					</c:forEach>
					<c:if test="${(page + 1) <= endpage}">
						<li><a href="?page=${page + 1}"><span>&raquo;</span></a></li>
					</c:if>
				</ul>
			</div>
		</div>
		</div>