<!-- Header of mechanic -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-default navbar-top" role="navigation">
  	<div class="container-fluid">
    	<div class="navbar-header">
      		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            	<span class="sr-only">Toggle navigation</span>
			    <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
          	</button>
      		<a class="navbar-brand" href="#">Crazy mechanic</a>
    	</div>

    	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      		<ul class="nav navbar-nav">
                <li><a href="<c:url value="/stationId/mechanic/freeorders" />" >Free orders</a></li>
                <li><a href="<c:url value="/stationId/mechanic/myorders" />" >My orders</a></li>
                <li><a href="<c:url value="/stationId/mechanic/sparepartslist" />" >Spare parts list</a></li>
                <li><a href="<c:url value="/stationId/mechanic/notificationslog" />" >Notification log</a></li>
      		</ul>
      		<ul class="nav navbar-nav navbar-right">
                <form class="navbar-form navbar-right">
                	<li><button type="button" class="btn btn-default">Logout</button></li>
                </form>
            </ul>
    	</div>

  	</div>
</nav>