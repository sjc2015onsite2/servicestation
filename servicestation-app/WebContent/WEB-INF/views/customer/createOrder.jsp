<!-- Page for form of create order -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

                  
<form class="form-horizontal" role="form">
            <div class="form-group has-default">
              <label class="control-label col-sm-4" for="id1">Select station:</label>
              <div class="col-sm-4">
                <select multiple class="form-control" id="id1">
                <c:forEach var="station" items="${stations}" >
                  <option>${station.getName()}</option>
                  </c:forEach>
                </select>
              </div>
            </div>
         

            <div class="form-group has-default">
              <label class="control-label col-sm-4" for="id1">Problem:</label>
              <div class="col-sm-4">
                <textarea class="form-control" rows="6"></textarea>
              </div>
            </div>
            
            <div class="form-group has-default">
              <label class="control-label col-sm-4" for="id1">How to contact with you?</label>
              <div class="col-sm-4">
                <textarea class="form-control" rows="2" placeholder="Enter phone number or email"></textarea>
                <p></p>
                <button type="submit"  class="btn btn-success">Create</button>
              </div>
            </div>
</form>