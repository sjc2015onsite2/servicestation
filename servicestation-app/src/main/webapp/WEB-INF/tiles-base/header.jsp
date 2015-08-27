<!-- header of customer -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
                	<li><a href="<c:url value="/accountant/affiliatesdata" />" >Dynamic</a></li>
                	<li><a href="<c:url value="/accountant/affiliates" />" >Affiliate list</a></li>
                	<li><a href="<c:url value="/accountant/employees" />" >Employees list</a></li>
                	<li><a href="<c:url value="/accountant/orders" />" >Orders</a></li>
            	</security:authorize>
            	
            	<security:authorize access="hasRole('ROLE_CEO')">
           			<li><a href="<c:url value="/ceo/station" />" >My station</a></li>
                	<li><a href="<c:url value="/ceo/affiliatesdata" />" >Dynamic</a></li>
                	<li><a href="<c:url value="/ceo/affiliates" />" >Affiliate list</a></li>
                	<li><a href="<c:url value="/ceo/employees" />" >Employees list</a></li>
                	<li><a href="<c:url value="/ceo/orders" />" >Orders</a></li>
                	<li class="dropdown">
               	    	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Comments <b class="caret"></b></a>
                   		<ul class="dropdown-menu">
            	        	<li><a href="<c:url value="/ceo/stationcomments" />" >Comments about Station</a></li>
                        	<li class="divider"></li>
              	        	<li><a href="<c:url value="/ceo/mechanicscomments" />" >Comments about Mechanics</a></li>
                    	</ul>
                	</li>
                	<li><a href="<c:url value="/ceo/notificationslog" />" >Notification log</a></li>
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
           	
           	<security:authorize access="hasRole('ROLE_CEO')">
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