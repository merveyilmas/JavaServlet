<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

				
	<!-- Edit Modal HTML -->
		<div id="editEmployeeModal" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					
					<form action="/employee-crud-project/update">
						<div class="modal-header">
							<h4 class="modal-title">Edit Employee</h4>
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						</div>
						
						<div class="modal-body">
							<div class="form-group">
								<label>Name</label> 
								<input type="text" ng-model="employee.name" name="name" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Email</label> 
								<input type="email" ng-model="employee.email" name="email" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Phone</label> 
								<input type="text" ng-model="employee.phone" name="phone" class="form-control" required>
							</div>
						</div>
						<div class="modal-footer">
							<input type="hidden" name="id" value="{{employee.id}}"/> 
							<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel"> 
							<input type="submit" class="btn btn-info" value="Save">
						</div>
					</form>
				</div>
			</div>
		</div>
		
	