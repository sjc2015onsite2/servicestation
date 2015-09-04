<!-- footer of all pages -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/footer.css"/>" />



<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
	<div class="container-fluid">

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        	<ul class="nav navbar-nav">
        	<p class="navbar-text"> &copy; SJC-2015 |</p>
				<c:set var="currentLocale">${pageContext.response.locale}</c:set>
				<c:set var="localeCode" value="${fn:toUpperCase(currentLocale)}" />
	
				<c:set var="availLanguages" value="EN,RU" />
				<c:if test="${!fn:contains(availLanguages, localeCode)}">
				  <c:set var="localeCode" value="EN" />
				</c:if>
	
			 	<c:forEach var="lang" items="${availLanguages}">
			 	    <c:set var="langHTML" value="${lang}" />
				 	<c:if test="${lang eq localeCode}">
					  <c:set var="langHTML" value="<b><u>${lang}</u></b>" />
					</c:if>
			    	<li><a href="${currentPage}?lang=${lang}">${langHTML}</a></li>	
				</c:forEach>
        		
          	</ul>  
        </div>
    </div>
</nav>

