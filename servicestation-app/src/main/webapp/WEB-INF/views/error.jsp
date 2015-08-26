<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap/bootstrap.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap/bootstrap-theme.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/mark.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/footer.css"/>" />
	
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
 	
 	<script src="<c:url value="/resources/js/jquery.js" />"></script>
 	<script src="<c:url value="/resources/js/json2.js" />"></script>
 	<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
	<script src="<c:url value="/resources/js/main.js" />"></script>
</head>
<body>
	<div class="container-fluid">
		<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
	
    	<div class="navbar-header">
        	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            	<span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Site-Agregator.com</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        	<ul class="nav navbar-nav">
        	
        		<security:authorize access="isAnonymous()">
  	        		<li><a href="<c:url value="/createorder" />" >Creating order</a></li>
            		<li><a href="<c:url value="/stationslist" />" >Stations list</a></li>
            		<li data-toggle ="modal" data-target="#authorization-modal" class="dropdown">
   	        	    	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Create comment <b class="caret"></b></a>
                   		<ul class="dropdown-menu">
                   			<li><a href="#">Create comment about Station</a></li>
                        	<li class="divider"></li>
                	    	<li><a href="#">Create comment about Mechanic</a></li>
                   		</ul>
                	</li>
                	<li data-toggle ="modal" data-target="#authorization-modal"><a href="#" >Create mark</a></li>
            	</security:authorize>
            	
            	
            
            	<security:authorize access="hasRole('ROLE_USER')">
  	        		<li><a href="<c:url value="/createorder" />" >Creating order</a></li>
            		<li><a href="<c:url value="/stationslist" />" >Stations list</a></li>
 		       		<li class="dropdown">
               	    	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Create comment <b class="caret"></b></a>
                   		<ul class="dropdown-menu">
            	        	<li><a href="<c:url value="/user/createstationcomment" />" >Create comment about Station</a></li>
                        	<li class="divider"></li>
              	        	<li><a href="<c:url value="/user/createmechaniccomment" />" >Create comment about Mechanic</a></li>
                    	</ul>
                	</li>
          			<li><a href="<c:url value="/user/createmark" />" >Create mark</a></li>
           			<li><a href="<c:url value="/user/myorders" />" >My orders</a></li>
           		</security:authorize>
           		
           		<security:authorize access="hasRole('ROLE_MECHANIC')">
           			<li><a href="<c:url value="/mechanic/freeorders" />" >Free orders</a></li>
                	<li><a href="<c:url value="/mechanic/myorders" />" >My orders</a></li>
                	<li><a href="<c:url value="/mechanic/spareparts" />" >Spare parts list</a></li>
                	<li><a href="<c:url value="/mechanic/partsorders" />" >My orders of parts</a></li>
                	<li><a href="<c:url value="/mechanic/notificationslog" />" >Notification log</a></li>
            	</security:authorize>
            	
            	<security:authorize access="hasRole('ROLE_ACCOUNTANT')">
           			<li><a href="<c:url value="/accountant/station" />" >My station</a></li>
                	<li><a href="<c:url value="/accountant/dynamic" />" >Dynamic</a></li>
                	<li><a href="<c:url value="/accountant/affiliates" />" >Affiliate list</a></li>
                	<li><a href="<c:url value="/accountant/employees" />" >Employees list</a></li>
                	<li><a href="<c:url value="/accountant/orders" />" >Orders</a></li>
            	</security:authorize>
            	
          	</ul>  
          	
          	<security:authorize access="isAnonymous()">
            	<form class="navbar-form navbar-right"> 
            		<button name="submit" type="submit" class="btn btn-success" data-toggle ="modal" data-target="#authorization-modal">Sign in</button>
            	</form>
            </security:authorize>   
            
            <security:authorize access="hasRole('ROLE_USER')">
            	<form class="navbar-form navbar-right">
               		<a href="<c:url value="/j_spring_security_logout"/>"><button type="button" class="btn btn-default">Logout</button></a>
               	</form>
           	</security:authorize>
           	
           	<security:authorize access="hasRole('ROLE_MECHANIC')">
           		<form class="navbar-form navbar-right">
              		<a href="<c:url value="/j_spring_security_logout"/>"><button type="button" class="btn btn-default">Logout</button></a>
               	</form>
           	</security:authorize>
            	
            <security:authorize access="hasRole('ROLE_ACCOUNTANT')">
            	<form class="navbar-form navbar-right">
                  	<a href="<c:url value="/j_spring_security_logout"/>"><button type="button" class="btn btn-default">Logout</button></a>
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
        		<h4 class="modal-title">Authorization</h4>
      		</div>

      		<div class="modal-body">
        		<form class="form-horizontal"  action="j_spring_security_check" method='POST' role="form">
          			<div class="form-group has-feedback">
                		<input type="text" class="form-control" name="username" id="exampleInputEmail2" placeholder="Enter user name">
          			</div>
          			<div class="form-group has-feedback">
                		<input type="password" class="form-control" name="password" id="exampleInputPassword2" placeholder="Enter password">
          			</div>
          			<div class="col-sm-offset-8 col-sm-10">
              			<button type="submit" class="btn btn-success" >Sing in</button>
          			</div>
        		</form>
      		</div>

      		<div class="modal-footer">
        		<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
      		</div>
      		
    	</div>
  	</div>
</div>			
	</div>
	
		<div class="row" >
				<div class="panel panel-danger">
  <div class="panel-body">
    Произошла ошибка!
  </div>
  <div class="panel-footer">Что-то пошло не так :(
  <p>Мы уже работаем над этим.</div>
</div>
		</div>

	<div class="container-fluid">
		<div id="footer">
	<p class="text-muted"> &copy; SJC-2015 </p>
</div>
	</div>
	
	<script src="<c:url value="/resources/js/mark.js" />"></script>
</body>
</html>