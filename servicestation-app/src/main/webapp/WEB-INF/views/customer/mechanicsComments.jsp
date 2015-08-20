<!-- Page for comments about mechanics -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>




      <div class="col-sm-offset-1" >
      <c:forEach var="comment" items="${mechanicsComments}" >
        <br />
        <br />
  	     <blockquote>
          <footer><strong>Station: </strong>"Station 1" --- <strong>Mechanic: </strong>Mechanic 1</footer>
            <p class="text-primary">${comment.comment}</p>
            <footer>Jason Statham  <em>05.08.2015</em></footer>
          </blockquote>
          </c:forEach>
      </div>