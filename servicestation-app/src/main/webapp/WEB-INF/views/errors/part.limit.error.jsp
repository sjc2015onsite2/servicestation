<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<div class="col-sm-offset-3 col-sm-6">
		<div class="row" style="padding-left: 10%; padding-right: 10%;">
			<div class="panel panel-danger">
				<div class="panel-body">
					<div class="col-sm-10">Произошла ошибка!</div>
					<div>
						<button type="button" class="btn btn-info btn-sm" onclick="window.history.back();">Back</button>
					</div>
				</div>
				<div class="panel-footer">
					<div>
						Нет необходимого количества запчастей на складе.
					</div>
				</div>
			</div>
		</div>
	</div>
