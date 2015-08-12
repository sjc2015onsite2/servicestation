<!-- Page for form of create comment about station -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<form class="form-horizontal" role="form">
            <div class="form-group has-default">
              <label class="control-label col-sm-4" for="id1">Select station:</label>
              <div class="col-sm-4">
                <select multiple class="form-control" id="id1">
                  <option>Station 1</option>
                  <option>Station 2</option>
                  <option>Station 3</option>
                  <option>Station 4</option>
                  <option>Station 5</option>
                  <option>Station 6</option>
                  <option>Station 7</option>
                  <option>Station 8</option>
                  <option>Station 9</option>
                  <option>Station 10</option>
                </select>
              </div>
            </div>

            <div class="form-group has-default">
              <label class="control-label col-sm-4" for="id1">Comment:</label>
              <div class="col-sm-4">
                <textarea class="form-control" rows="6"></textarea>
                <p></p>
                <button type="submit"  class="btn btn-success">Create</button>
              </div>
            </div>
</form>