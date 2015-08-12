<!-- header of customer -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
  	        	<li><a href="<c:url value="/createorder" />" >Creating order</a></li>
            	<li><a href="<c:url value="/stationslist" />" >Stations list</a></li>
            
            	<c:if test="${empty user}">
       	    		<li class="dropdown">
   	        	    	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Create comment <b class="caret"></b></a>
                   		<ul class="dropdown-menu">
                   			<li><a href="<c:url value="/createstationcomment" />" >Create comment about Station</a></li>
                        	<li class="divider"></li>
                	    	<li><a href="<c:url value="/createmechaniccomment" />" >Create comment about Mechanic</a></li>
                   		</ul>
                	</li>
           		</c:if>
           
           		<c:if test="${not empty user}">
 		       		<li class="dropdown">
               	    	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Create comment <b class="caret"></b></a>
                   		<ul class="dropdown-menu">
            	        	<li><a href="<c:url value="/createstationcomment" />" >Create comment about Station</a></li>
                        	<li class="divider"></li>
              	        	<li><a href="<c:url value="/createmechaniccomment" />" >Create comment about Mechanic</a></li>
                    	</ul>
                	</li>
           		</c:if>
           
           		<c:if test="${empty user}">
           			<li><a href="<c:url value="/createmark" />" >Create mark</a></li>
           		</c:if>
          	
     	  		<c:if test="${not empty user}">
          			<li><a href="<c:url value="/createmark" />" >Create mark</a></li>
           		</c:if>
            	
           		<c:if test="${empty user}">
           			<li><a href="<c:url value="/myorders" />" >My orders</a></li>
           		</c:if>
          	</ul>
              
              	<c:if test="${not empty user}">
              		<ul class="nav navbar-nav navbar-right">
                		<form  class="navbar-form navbar-right">
                  			<li><a href="<c:url value="/logout"/>"><button type="button" class="btn btn-default">Logout</button></a></li>
                		</form>
              		</ul>
             	</c:if>
              
				<c:if test="${empty user}">
            		<form action="createorder" method='POST' class="navbar-form navbar-right"> 
                		<div class="form-group has-feedback">
                			<label class="sr-only" for="exampleInputEmail2">Enter user name</label>
                			<input type="email" class="form-control" name="username" id="exampleInputEmail2" placeholder="Enter user name">
              			</div>
              			<div class="form-group has-feedback">
               		 		<label class="sr-only" for="exampleInputPassword2">Enter password</label>
                			<input type="password" class="form-control" name="password" id="exampleInputPassword2" placeholder="Enter password">
              			</div>
              			<button name="submit" type="submit" class="btn btn-success">Sign in</button>
              		</form>
           		</c:if>
           
        </div>
    </div>
</nav>