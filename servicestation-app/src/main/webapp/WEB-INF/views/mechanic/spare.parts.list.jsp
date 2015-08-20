<!-- List of spare parts -->


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-10">
<div class="table-responsive col-sm-offset-1 col-sm-10">
    <table class="table table-striped table-hover table-bordered">
        <tr>
        <th width="20%">Number of spare part</th>
        <th>Name of spare part</th>
        <th width="20%">Quantity on stock</th>
        </tr>
        <c:forEach var="part" items="${parts}" >
        <tr class="warning">
        <td>${part.key.partId}</td>
        <td>${part.key.name}</td>
        <td>${part.value}</td>
        </tr>
        </c:forEach>
    </table>
</div>
</div>
<div> 
	<button data-toggle ="modal" data-target="#partsorder-modal" type="submit" class="btn btn-warning">Create order</button>
</div>


<div class="modal fade" id="partsorder-modal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content col-sm-offset-1 col-sm-10">
      <div class="modal-header">
        <button class="close" type="button" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Change station</h4>
      </div>

      <div class="modal-body">
        <form class="form-horizontal" action="../mechanic/spareparts" method='POST' role="form">
        	<div class="col-sm-2">
          		<label class="text-left" >Select stationé:</label>
          	</div>
              <div class="col-sm-10">
                <select name="partId" multiple class="form-control" >
                  <c:forEach var="part" items="${parts}">
                  	<option value="${part.key.partId }">${part.key.name}</option>
                  </c:forEach>
                </select>
                
                <input name="quantity" class="form-control input-sm" type="text" >
              </div>
          <div>
          		<br />
              <button type="submit" class="btn btn-warning btn-sm" >Change</button>
          </div>
        </form>
      </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
      </div>
    </div>
  </div>
</div>
</div>