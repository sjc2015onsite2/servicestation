<!-- Page for form of create mark -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


 

<form class="form-horizontal" role="form">
              <label class="control-label col-sm-4" for="id1">Select station:</label>
              <div class="col-sm-4">
                <select multiple class="form-control" id="id1">
                  <c:forEach var="station" items="${stations}" >
                  	<option>${station.getName()}</option>
                  </c:forEach>
                </select>
              </div>

</form>

	<section class="sect">
		<article class="art">
			<h3 class="text-left">Create mark</h3>
			<br />
			<span class="text-left"	 id="stars"></span>
		</article>
		<form oninput="out.value=(pct.value), outp.value=pct.value+'%', outclass.value=''+stars.className">
				<h2><output id="out" for="pct">0</output></h2>
				<input type="range"  min="0" max="5" value="0" id="pct" name="pct"/>
				<output id="outclass"></output>
		</form>
		<br />
				<button type="submit"  class="btn btn-success">Create</button>
	</section>
