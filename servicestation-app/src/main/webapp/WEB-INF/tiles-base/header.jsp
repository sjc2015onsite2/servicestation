<!-- header of customer -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" style="margin-left: 15px;">Site-Agregator.com</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">

				<security:authorize access="isAnonymous()">
					<li><a href="<c:url value="/createorder" />"><spring:message code="customer.header.createorder"/></a></li>
					<li><a href="<c:url value="/stationslist" />"><spring:message code="customer.header.stationslist"/></a></li>
					<li data-toggle="modal" data-target="#authorization-modal"
						class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><spring:message code="customer.header.createcomment"/><b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#"><spring:message code="customer.header.stationcomment"/></a></li>
							<li class="divider"></li>
							<li><a href="#"><spring:message code="customer.header.mechaniccomment"/></a></li>
						</ul></li>
					<li data-toggle="modal" data-target="#authorization-modal"><a
						href="#"><spring:message code="customer.header.createmark"/></a></li>
				</security:authorize>



				<security:authorize access="hasRole('ROLE_USER')">
					<li><a href="<c:url value="/createorder" />"><spring:message code="customer.header.createorder"/></a></li>
					<li><a href="<c:url value="/stationslist" />"><spring:message code="customer.header.stationslist"/></a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><spring:message code="customer.header.createcomment"/> <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="<c:url value="/user/createstationcomment" />"><spring:message code="customer.header.stationcomment"/></a></li>
							<li class="divider"></li>
							<li><a href="<c:url value="/user/createmechaniccomment" />"><spring:message code="customer.header.mechaniccomment"/></a></li>
						</ul></li>
					<li><a href="<c:url value="/user/createmark" />"><spring:message code="customer.header.createmark"/></a></li>
					<li><a href="<c:url value="/user/myorders" />"><spring:message code="customer.header.myorders"/></a></li>
				</security:authorize>

				<security:authorize access="hasRole('ROLE_MECHANIC')">
					<li><a href="<c:url value="/mechanic/freeorders" />"><spring:message code="mechanic.header.freeorders"/></a></li>
					<li><a href="<c:url value="/mechanic/myorders" />"><spring:message code="mechanic.header.myorders"/></a></li>
					<li><a href="<c:url value="/mechanic/spareparts" />"><spring:message code="mechanic.header.spareparts"/></a></li>
					<li><a href="<c:url value="/mechanic/partsorders" />"><spring:message code="mechanic.header.partsorders"/></a></li>
					<li><a href="<c:url value="/mechanic/notificationslog" />"><spring:message code="mechanic.header.notifications"/></a></li>
				</security:authorize>

				<security:authorize access="hasRole('ROLE_ACCOUNTANT')">
					<li><a href="<c:url value="/accountant/station" />"><spring:message code="accountant.header.mystation"/></a></li>
					<li><a href="<c:url value="/accountant/affiliatesdata" />"><spring:message code="accountant.header.dynamics"/></a></li>
					<li><a href="<c:url value="/accountant/affiliates" />"><spring:message code="accountant.header.affiliates"/></a></li>
					<li><a href="<c:url value="/accountant/employees" />"><spring:message code="accountant.header.employees"/></a></li>
					<li><a href="<c:url value="/accountant/orders" />"><spring:message code="accountant.header.orders"/></a></li>
				</security:authorize>


			</ul>

			

			<security:authorize access="isAnonymous()">
				<form class="navbar-form navbar-right">
					<button name="submit" type="submit" class="btn btn-success"
						data-toggle="modal" data-target="#authorization-modal"><spring:message code="header.signin"/></button>
				</form>
			</security:authorize>

			<security:authorize access="hasRole('ROLE_USER')">
				<form class="navbar-form navbar-right">
					<a href="<c:url value="/j_spring_security_logout"/>"><button
							type="button" class="btn btn-default"><spring:message code="header.logout"/></button></a>
				</form>
			</security:authorize>

			<security:authorize access="hasRole('ROLE_MECHANIC')">
				<form class="navbar-form navbar-right">
					<a href="<c:url value="/j_spring_security_logout"/>"><button
							type="button" class="btn btn-default"><spring:message code="header.logout"/></button></a>
				</form>
			</security:authorize>

			<security:authorize access="hasRole('ROLE_ACCOUNTANT')">
				<form class="navbar-form navbar-right">
					<a href="<c:url value="/j_spring_security_logout"/>"><button
							type="button" class="btn btn-default"><spring:message code="header.logout"/></button></a>
				</form>
			</security:authorize>

		</div>

	</div>
</nav>


<!-- Authorization-modal  -->

<div class="modal fade" id="authorization-modal">
	<div class="modal-dialog modal-sm">
		<div class="modal-content col-sm-offset-4 col-sm-6">

			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"><spring:message code="header.authorization"/></h4>
			</div>

			<div class="modal-body">
				<form class="form-horizontal" action="j_spring_security_check"
					method='POST' role="form">
					<div class="form-group has-feedback">
						<input type="text" class="form-control" name="username"
							id="exampleInputEmail2" placeholder="Enter user name">
					</div>
					<div class="form-group has-feedback">
						<input type="password" class="form-control" name="password"
							id="exampleInputPassword2" placeholder="Enter password">
					</div>
					<div class="col-sm-offset-8 col-sm-10">
						<button type="submit" class="btn btn-success"><spring:message code="header.signin"/></button>
					</div>
				</form>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal"><spring:message code="header.cancel"/></button>
			</div>

		</div>
	</div>
</div>