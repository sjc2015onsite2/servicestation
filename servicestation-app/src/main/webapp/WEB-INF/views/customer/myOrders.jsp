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
		</tr>
		<c:forEach var="order" items="${orders}">
			<c:url value="/user/myorders/${order.key.orderId}" var="myorder" />
			<tr class="warning">
				<td><a href="${myorder}">${order.key.problemDescription}</a></td>
				<td>Working</td>
				<td>${order.value.name}</td>
				<td>Mechanic</td>
				<td>000000000</td>
				<td>date of registration</td>
			</tr>
		</c:forEach>
	</table>

	<div class="panel panel-default">
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