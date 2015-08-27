<!-- Page for form of create comment about mechanic -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
<form:form action="createmechaniccomment" method='POST' class="form-horizontal" role="form">
            <div class="form-group has-default">
              <label class="control-label col-sm-4" for="id1"><spring:message code="customer.mechaniccomment.selectmechanic"/></label>
              <div class="col-sm-4">
                <select name="mechanicId" multiple class="form-control" id="id1">
                <c:forEach var="mechanic" items="${mechanics}" >
                  <option value="${mechanic.id }">${mechanic.name}</option>
                </c:forEach>
                </select>
              </div>
            </div>
            
            <div class="form-group has-default">
              <label class="control-label col-sm-4" for="id1"><spring:message code="customer.mechaniccomment.comment"/></label>
              <div class="col-sm-4">
                <textarea name="comment" class="form-control" rows="6"></textarea>
              </div>
            </div>

            <div class="radio col-sm-offset-4">
  				<label>
          			<input name="notvisible" type="radio"id="optionsRadios1" value="no" checked>
          				<spring:message code="customer.mechaniccomment.visibletoall"/>       		
          		</label>
			</div>
			<div class="radio col-sm-offset-4">
  				<label>
          			<input name="notvisible" type="radio" id="optionsRadios2" value="yes">
          				<spring:message code="customer.mechaniccomment.visibletoceo"/>
        		</label>
			</div>
			
			<div class="col-sm-offset-4">
			<br />
                <button type="submit"  class="btn btn-success"><spring:message code="customer.mechaniccomment.create"/></button>
            </div>
</form:form>