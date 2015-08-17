<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-offset-2 col-sm-5">
	<table class="table table-hover">
         <tr>
             <th width="50%">Name</th>
             <th width="30%">Information</th>
             <th class="text-center">Show comments</th>
         </tr>
         
      <c:forEach var="mechanic" items="${mechanicsList}" >
      <c:url value="/mechanicscomments/${mechanic.id}" var="viewMechanicsCommentsUrl" />
               <tr>
                	<td>${mechanic.name}</td>
                	<td>стаж: 200 лет<p> механик года 2025</td>
                	<td class="text-center"><a href="${viewMechanicsCommentsUrl}">Comments</a></td>
                </tr>
      </c:forEach>
    </table>
</div>