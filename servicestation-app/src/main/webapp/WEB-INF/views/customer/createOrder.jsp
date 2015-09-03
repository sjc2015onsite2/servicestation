<!-- Page for form of create order -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<security:authorize access="hasRole('ROLE_USER')">
	<c:url value="createorder/user" var="action" />
</security:authorize>

<security:authorize access="isAnonymous()">
	<c:url value="createorder" var="action" />
</security:authorize>

<form:form action="${action}" commandName="order" class="form-horizontal" role="form"  method="POST">

	<div class="col-sm-offset-4 col-sm-4">
		<div class="form-group has-default">
    		<label class="control-label" for="id1"><spring:message code="customer.createorder.selectstation"/></label>
        	<select multiple class="form-control" name="stationId">
            	<c:forEach var="station" items="${stations}" >
                	<option value="${station.stationId}">${station.name}</option>
                </c:forEach>
            </select>
		</div>
	</div>
            
    <security:authorize access="hasRole('ROLE_USER')">
	    <div class="col-sm-offset-4 col-sm-4">
	    	<div class="form-group has-default">
	        	<form:label path="problemDescription" class="control-label" for="id1"><spring:message code="customer.createorder.problem"/></form:label>
	            <form:textarea path="problemDescription" class="form-control" rows="6"></form:textarea>
	            <p class="text-danger"><form:errors class="text-danger" path="problemDescription" cssClass="error"/></p>
	            <br />
	            <button type="submit"  class="btn btn-success"><spring:message code="customer.createorder.create"/></button>
	            <br />
       	 		<br />
       	 		<br />
       	 		<br />
	        </div>
        </div>
    </security:authorize>
            
    <security:authorize access="isAnonymous()">
    	<div class="col-sm-offset-4 col-sm-4">
       		<div class="form-group has-feedback">
       			<form:label path="problemDescription" class="control-label" for="id1"><spring:message code="customer.createorder.problem"/></form:label>
           		<form:textarea path="problemDescription" class="form-control" rows="6"></form:textarea>
           		<p class="text-danger"><form:errors class="text-danger" path="problemDescription" cssClass="error"/></p>
       		</div>
           
       	 	<div class="form-group has-feedback">
       	 		<form:label path="contactData" class="control-label" for="id1"><spring:message code="customer.createorder.contacts"/></form:label>
       	  		<form:input path="contactData" class="form-control" type="text"/>
       	  		<p class="text-danger"><form:errors class="text-danger" path="contactData" cssClass="error"/></p>
       	  		<br />
       	 		<button type="submit"  class="btn btn-success"><spring:message code="customer.createorder.create"/></button>
       	 		<br />
       	 		<br />
       	 		<br />
       	 		<br />
       	  	</div>
       	</div>
	</security:authorize>
</form:form>
