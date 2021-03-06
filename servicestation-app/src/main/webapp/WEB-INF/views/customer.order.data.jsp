<!-- Page for data about order of customer -->


<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<div class="col-sm-12">
		<div class="col-sm-6">
			<h4 class="text-center">Order ${customerOrderDto.orderId}</h4>	
		</div>
		<security:authorize access="hasRole('ROLE_USER')">
			<c:if test="${change eq true }">
				<div>
					<button data-toggle="modal" data-target="#change-modal"
						type="button" class="btn btn-warning col-sm-offset-3">Change station</button>
				</div>
			</c:if>
		</security:authorize>
	</div>

	<security:authorize access="hasRole('ROLE_USER')">
		<div class="col-sm-offset-1 col-sm-10">
			<br /> 
			<br />
			<div class="col-sm-3">
				<p class="text-left">
					<strong>Station: </strong>
				</p>
			</div>
			<div class="col-sm-9">
				<p class="text-left">
					<em>${customerOrderDto.stationName}</em>
				</p>
			</div>
		</div>

		<div class="col-sm-offset-1 col-sm-10">
			<div class="col-sm-3">
				<p class="text-left">
					<strong>Mechanic: </strong>
				</p>
			</div>
			<div class="col-sm-9">
				<p class="text-left">
					<em>${customerOrderDto.mechanicName }</em>
				</p>
			</div>
		</div>
	</security:authorize>

	<security:authorize access="hasRole('ROLE_MECHANIC')">
		<c:if test="${not empty contactData}">
			<div class="col-sm-offset-1 col-sm-10">
				<br /> 
				<br />
				<div class="col-sm-3">
					<p class="text-left">
						<strong>Phone number of customer: </strong>
					</p>
				</div>
				<div class="col-sm-9">
					<p class="text-left">
						<em>${contactData}</em>
					</p>
				</div>
			</div>
		</c:if>
	</security:authorize>


	<div class="col-sm-offset-1 col-sm-10">
		<br />
		<div class="col-sm-3">
			<p class="text-left">
				<strong>Description of the problem: </strong>
			</p>
		</div>
		<div class="col-sm-9">
			<p class="text-left">
				<em>${customerOrderDto.problemDescription}</em>
			</p>
		</div>
	</div>

	<div class="col-sm-offset-1 col-sm-10">
		<br />
		<div class="col-sm-3">
			<p class="text-left">
				<strong>Status: </strong>
			</p>
		</div>
		<security:authorize access="hasRole('ROLE_USER')">
			<div class="col-sm-9">
				<p class="text-left">
					<em>${customerOrderDto.orderStatus}</em>
				</p>
			</div>
		</security:authorize>

		<security:authorize access="hasRole('ROLE_MECHANIC')">
			<div class="col-sm-1">
				<p class="text-left">
					<em>${customerOrderDto.orderStatus}</em>
				</p>
			</div>
			<div class="col-sm-2">
				<button data-toggle="modal" data-target="#changestatus-modal" type="submit" class="btn btn-warning btn-sm">Change status</button>
			</div>
			<div class="col-sm-4"></div>
		</security:authorize>
	</div>

	<div class="col-sm-offset-1 col-sm-10">
		<br /> 
		<br />
		<div class="col-sm-3">
			<p class="text-left">
				<strong>Works: </strong>
			</p>
		</div>
		<div class="col-sm-5">
			<ol>
				<c:forEach var="service" items="${services}">
					<li>${service[0]} x${service[1]} (${service[2]} BYR)</li>
				</c:forEach>
			</ol>
		</div>
		<security:authorize access="hasRole('ROLE_MECHANIC')">
			<div class="col-sm-3">
				<button data-toggle="modal" data-target="#addwork-modal" type="submit" class="btn btn-warning btn-sm">Add work</button>
			</div>
		</security:authorize>
	</div>
	
	<div class="col-sm-offset-1 col-sm-10">
		<br /> <br />
		<div class="col-sm-3">
			<p class="text-left">
				<strong>Parts: </strong>
			</p>
		</div>
		<div class="col-sm-5">
			<ol>
				<c:forEach var="part" items="${parts}">
					<li>${part[0]} x${part[1]}</li>
				</c:forEach>
			</ol>
		</div>
		<security:authorize access="hasRole('ROLE_MECHANIC')">
			<div class="col-sm-4">
				<button data-toggle="modal" data-target="#addpart-modal" type="submit" class="btn btn-warning btn-sm">Add part</button>
			</div>
		</security:authorize>
	</div>
 
	<div class="col-sm-offset-1 col-sm-10">
		<br /> <br />
		<div class="col-sm-3">
			<p class="text-left">
				<strong>Cost: </strong>
			</p>
		</div>
			<div class="col-sm-9">
				<p class="text-left">
					<em>${customerOrderDto.orderCost}</em> BYR
				</p>
			</div>
	</div>

	<div class="col-sm-offset-1 col-sm-10">
		<br />
		<div class="col-sm-3">
			<p class="text-left">
				<strong>CompletedDate: </strong>
			</p>
		</div>
		<security:authorize access="hasRole('ROLE_USER')">
			<div class="col-sm-9">
				<p class="text-left">
					<em>${customerOrderDto.completedDate }</em>
				</p>
			</div>
		</security:authorize>
		
		<security:authorize access="hasRole('ROLE_MECHANIC')">

			<c:if test="${not empty  customerOrderDto.completedDate }">
				<div class="col-sm-1">
					<p class="text-left">
						<em>${customerOrderDto.completedDate }</em>
					</p>
				</div>
			</c:if>
			
			<c:if test="${empty customerOrderDto.completedDate }">
				<form action="../myorders/completedate" method='POST'>
					<div class="col-sm-2">
						<input name="completedate" type="text" class="form-control input-sm" placeholder="Enter date">
					</div>
					<div class="col-sm-4">
						<input name="orderId" value="${customerOrderDto.orderId }" hidden="true" placeholder="mm.dd.yyyy">
						<button type="submit" class="btn btn-warning btn-sm">Save</button>
					</div>
				</form>
			</c:if>
		</security:authorize>
	</div>

	<div class="col-sm-offset-1 col-sm-10">
		<br />
		<div class="col-sm-3">
			<p class="text-left">
				<strong>CreatedDate: </strong>
			</p>
		</div>
		<div class="col-sm-9">
			<p class="text-left">
				<em>${customerOrderDto.createdDate}</em>
			</p>
		</div>
		<br />
	<br />
	<br />
	<br />
	<br />
	</div>

<c:if test="${empty contactData}">
	<div class="col-sm-offset-1 col-sm-10">
		<br /> <br />
		<div class="col-sm-3">
			<p class="text-left">
				<strong>Notification: </strong>
			</p>
		</div>
		<security:authorize access="hasRole('ROLE_USER')">
			<div class="col-sm-9">
				<p class="text-left">
					<em>${customerOrderDto.notificationMessage}</em>
				</p>
			</div>
		</security:authorize>
		<security:authorize access="hasRole('ROLE_MECHANIC')">
			<c:if test="${not empty customerOrderDto.notificationMessage}">
				<div class="col-sm-9">
					<p class="text-left">
						<em>${customerOrderDto.notificationMessage}</em>
					</p>
				</div>
			</c:if>
			<c:if test="${empty customerOrderDto.notificationMessage}">
				<form action="../myorders/nitification" method='POST'>
					<div class="col-sm-5">
						<textarea name="notification" class="form-control" rows="2"></textarea>
					</div>
					<div class="col-sm-4"></div>
					<input name="orderId" value="${customerOrderDto.orderId }" hidden="true">
					<button type="submit" class="btn btn-warning btn-sm">Save</button>
				</form>
			</c:if>
		</security:authorize>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	</div>
</c:if>



<div class="modal fade" id="addpart-modal">
	<div class="modal-dialog modal-sm">
		<div class="modal-content col-sm-offset-1 col-sm-10">
				<form class="form-horizontal" action="../myorders/addparts" method='POST' role="form">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Add part</h4>
			</div>

			<div class="modal-body">
					<div class="form-group has-feedback">
						<label class="text-left">Select part:</label>
						<select name="partId" multiple class="form-control">
							<c:forEach var="part" items="${allparts}">
								<option value="${part[0]}">${part[1]}</option>
							</c:forEach>
						</select> 
					</div>
					<input name="orderId" value="${customerOrderDto.orderId }" hidden="true">
					<div class="form-group has-feedback">
						<label class="text-left">Enter quantity:</label>
						<input name="quantity" type="text" class="form-control" placeholder="Enter quantity">
					</div>
			</div>

			<div class="modal-footer">
				<button type="submit" class="btn btn-warning btn-sm">Add</button>
				<button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button>
			</div>
				</form>
		</div>
	</div>
</div>



<div class="modal fade" id="addwork-modal">
	<div class="modal-dialog modal-sm">
		<div class="modal-content col-sm-offset-1 col-sm-10">
				<form class="form-horizontal" action="../myorders/addworks" method='POST' role="form">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Add work</h4>
			</div>

			<div class="modal-body">
					<div class="form-group has-feedback">
						<label class="text-left">Select work:</label>
						<select name="workId" multiple class="form-control">
							<c:forEach var="work" items="${allworks}">
								<option value="${work[0]}">${work[1]}</option>
							</c:forEach>
						</select> <input name="orderId" value="${customerOrderDto.orderId }" hidden="true">
					</div>
			</div>

			<div class="modal-footer">
				<button type="submit" class="btn btn-warning btn-sm">Add</button>
				<button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button>
			</div>
				</form>
		</div>
	</div>
</div>


<div class="modal fade" id="changestatus-modal">
	<div class="modal-dialog modal-sm">
		<div class="modal-content col-sm-offset-3 col-sm-6">
				<form class="form-horizontal" action="../myorders/changestatus" method='POST' role="form">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Change status</h4>
			</div>

			<div class="modal-body">
					<div class="form-group has-feedback">
						<label class="text-left">Select status�:</label>
						<select name="newstatus" class="form-control">
							<c:forEach var="status" items="${statuses}">
								<option>${status}</option>
							</c:forEach>
						</select> 
						<input name="orderId" value="${customerOrderDto.orderId }" hidden="true">
					</div>
			</div>

			<div class="modal-footer">
				<button type="submit" class="btn btn-warning btn-sm">Change</button>
				<button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button>
			</div>
				</form>
		</div>
	</div>
</div>

<div class="modal fade" id="change-modal">
	<div class="modal-dialog modal-sm">
		<div class="modal-content col-sm-offset-1 col-sm-10">
		<form class="form-horizontal" action="../../user/myorders/changestation" method='POST' role="form">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Change station</h4>
			</div>

			<div class="modal-body">
					<div class="form-group has-feedback">
						<label class="text-left">Select station�:</label>
						<select name="stationId" multiple class="form-control">
							<c:forEach var="station" items="${stationsDto.stationsIdAndNames}">
								<option value="${station.key }">${station.value}</option>
							</c:forEach>
						</select> <input name="orderId" value="${customerOrderDto.orderId }" hidden="true">
					</div>
			</div>

			<div class="modal-footer">
				<button type="submit" class="btn btn-warning btn-sm">Change</button>
				<button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button>
			</div>
		</form>
		</div>
	</div>
</div>
