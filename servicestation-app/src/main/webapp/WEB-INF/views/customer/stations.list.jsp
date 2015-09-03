<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-offset-2 col-sm-8">
	<table class="table table-hover">
         <tr>
             <th width="30%">Station</th>
             <th width="20%">Information</th>
             <th class="text-center">Show comments</th>
             <th class="text-center">Show mechanics</th>
             <th class="text-center">Mark</th>
         </tr>
             <c:forEach var="station" items="${stations}" >
               <c:url value="/stationscomments/${station.stationId}" var="viewStationsCommentsUrl" />
               <c:url value="/mechanicslist/${station.stationId}" var="viewMechanicsListUrl" />
               <tr>
                	<td><br/>${station.name}</td>
                	<td>${station.info}</td>
                	<td class="text-center"><a href="${viewStationsCommentsUrl}"><br/><button type="button" class="btn btn-info btn-sm">Comments</button></a></td>
                	<td class="text-center"><a href="${viewMechanicsListUrl}"><br/><button type="button" class="btn btn-info btn-sm">Mechanics</button></a></td>
                	<td class="text-center text-warning"><h2>${stationMarks.get(station.stationId)}</h2></td>
                </tr>
             </c:forEach>
    </table>
</div>