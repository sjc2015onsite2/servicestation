<!-- Page for form of create order -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<security:authorize access="hasRole('ROLE_USER')">
<c:url value="createorder/user" var="action" />
</security:authorize>

<security:authorize access="isAnonymous()">
<c:url value="createorder" var="action" />
</security:authorize>

<form:form action="${action}" class="form-horizontal" role="form"  method="POST">

            <div class="form-group has-default">
              <label class="control-label col-sm-4" for="id1">Select station:</label>
              <div class="col-sm-4">
                <select multiple class="form-control" name="stationId">
                <c:forEach var="station" items="${stations}" >
                  <option value="${station.stationId}">${station.name}</option>
                  </c:forEach>
                </select>
              </div>
            </div>
            
            <security:authorize access="hasRole('ROLE_USER')">
            	<div class="form-group has-default">
              		<label class="control-label col-sm-4" for="id1">Problem:</label>
              		<div class="col-sm-4">
                		<textarea name="problem" class="form-control" rows="6"></textarea>
                		<p></p>
               	 		<button type="submit"  class="btn btn-success">Create</button>
              		</div>
            	</div>
            </security:authorize>
            
            <security:authorize access="isAnonymous()">
            	<div class="form-group has-default">
              		<label class="control-label col-sm-4" for="id1">Problem:</label>
              		<div class="col-sm-4">
                		<textarea name="problem" class="form-control" rows="6"></textarea>
              		</div>
            	</div>
           
            	<div class="form-group has-default">
             	 	<label class="control-label col-sm-4" for="id1">How to contact with you?</label>
             	 	<div class="col-sm-4">
              	  		<textarea name="contacts" class="form-control" rows="2" placeholder="Enter phone number or email"></textarea>
              	  		<p></p>
               	 		<button type="submit"  class="btn btn-success">Create</button>
            	  	</div>
           		 </div>
            </security:authorize>
</form:form>
