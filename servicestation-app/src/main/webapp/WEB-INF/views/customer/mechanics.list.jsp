<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-offset-3 col-sm-6">
	<h3>"${stationName}"</h3>
	<br/>
	<table class="table table-hover">
         <tr>
             <th width="50%">Name</th>
             <th width="30%">Information</th>
             <th class="text-center">Show comments</th>
         </tr>
         
      <c:forEach var="mechanic" items="${mechanicsList}" >
      <c:url value="/mechanicscomments/${mechanic.id}" var="viewMechanicsCommentsUrl" />
               <tr>
                	<td><br/>${mechanic.name}</td>
                	<td><br/>${machanic.info}</td>
                	<td class="text-center"><a href="${viewMechanicsCommentsUrl}"><br/><button type="button" class="btn btn-info btn-sm">Comments</button></a></td>
                </tr>
      </c:forEach>
    </table>
</div>