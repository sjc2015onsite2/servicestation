<!-- Page for form of create mark -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<form:form action="createmark" method="POST" class="form-horizontal" role="form" oninput="out.value=(pct.value), outp.value=pct.value+'%', outclass.value=''+stars.className">
              
              <div class="form-group has-default">
              <label class="control-label col-sm-4" for="id1">Select station:</label>
              <div class="col-sm-4">
                <select name="stationId" multiple class="form-control" id="id1">
                <c:forEach var="station" items="${stations}" >
                  <option value="${station.stationId }">${station.name}</option>
                </c:forEach>
                </select>
              </div>
            </div>


<div>
	<section class="sect">
		<article class="art">
			<h3 class="text-left"><spring:message code="customer.createmark.createmark"/></h3>
			<span class="text-left"	 id="stars"></span>
		</article>
		<h2><output id="out" for="pct">0</output></h2>
			<input type="range"  min="0" max="5" value="0" id="pct" name="markValue"/>
			<output id="outclass"></output>
			<br />
			<button type="submit"  class="btn btn-success"><spring:message code="customer.createmark.create"/></button>
	</section>
</div>
</form:form>