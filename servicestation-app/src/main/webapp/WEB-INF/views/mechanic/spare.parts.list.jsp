<!-- List of spare parts -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="table-responsive col-sm-offset-2 col-sm-8">
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
    <button type="submit" class="btn btn-success">Create order</button>
</div>