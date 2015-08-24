<!-- List of spare parts -->


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-10">
<div class="table-responsive col-sm-offset-1 col-sm-10">
    <table class="table table-striped table-hover table-bordered">
        <tr>
        <th width="10%">Order ID</th>
        <th>Name of spare part</th>
        <th width="20%">Quantity</th>
        <th>Status</th>
        <th>Date</th>
        </tr>
        <c:forEach var="order" items="${partsorders }">
        <tr class="warning">
        <td>${order.partOrderId }</td>
        <td></td>
        <td>${order.parts. }</td>
        <td></td>
        <td></td>
        </tr>
        </c:forEach>
    </table>
</div>
</div>
