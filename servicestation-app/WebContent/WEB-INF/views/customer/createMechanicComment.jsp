<!-- Page for form of create comment about mechanic -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<form class="form-horizontal" role="form">
            <div class="form-group has-default">
              <label class="control-label col-sm-4" for="id1">Select mechanic:</label>
              <div class="col-sm-4">
                <select multiple class="form-control" id="id1">
                  <option>Mechanic 1</option>
                  <option>Mechanic 2</option>
                  <option>Mechanic 3</option>
                  <option>Mechanic 4</option>
                  <option>Mechanic 5</option>
                  <option>Mechanic 6</option>
                  <option>Mechanic 7</option>
                  <option>Mechanic 8</option>
                  <option>Mechanic 9</option>
                  <option>Mechanic 10</option>
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