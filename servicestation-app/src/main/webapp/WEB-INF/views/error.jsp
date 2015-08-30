<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />

<title><tiles:insertAttribute name="title" ignore="true" /></title>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap/bootstrap.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap/bootstrap-theme.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/mark.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/footer.css"/>" />

<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<script src="<c:url value="/resources/js/jquery.js" />"></script>
<script src="<c:url value="/resources/js/json2.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script src="<c:url value="/resources/js/main.js" />"></script>
</head>
<body>
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
	<br />
	<div class="col-sm-offset-3 col-sm-6">
		<div class="row" style="padding-left: 10%; padding-right: 10%;">
			<div class="panel panel-danger">
				<div class="panel-body">
					<div class="col-sm-10">Произошла ошибка!</div>
					<div>
						<button type="button" class="btn btn-info btn-sm" onclick="window.history.back();">Back</button>
					</div>
				</div>
				<div class="panel-footer">
					<div>
						Что-то пошло не так :(
						<p>Мы уже работаем над этим.
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>