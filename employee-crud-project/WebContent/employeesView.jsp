<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
	<head>
	
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Servlet, JSP, JDBC and MVC Example</title>
		
		<!-- css file -->
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/employee.css">
		
		<!-- js and angular file -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
		<script src="js/employee.js"></script>
		
		
		<script >
			<!-- angular script -->
			<!-- bu method sayesinde update e tıklanılınca veriler textview lere gelir güncellenmek için -->
			var app = angular.module('employeeApp', []);

			app.controller('employeeCtrl', function($scope)
				{
					$scope.getEmployeeDetails=function(employeeId)
					{
						var employeeDetails='';
						$.ajax
						(
							{
								url : '/employee-crud-project/get',
								type : 'POST',
								data : {"employeeId" : employeeId},
								async : false,
								success : function(data, textStatus, jqXHR)
								{
									employeeDetails = data;
									console.log('EmployeeDetails ==>' + JSON.parse(employeeDetails));
								},
								error : function(jqXHR, textStatus, error)
								{
									employeeDetails = '';
									console.log('Error in getting employee details from server ==>' + error)
								}
							}	
						);

						$scope.employee = JSON.parse(employeeDetails);
						console.log('Employee Details ==>' + $scope.employee);

						return $scope.employee;
					}
	
				});

			<!-- Select All Employees Button -->
			<!-- en baştaki checkbox a tıklayınca hepsi seçili hale gelir bu js method sayesinde -->
			$(document).ready(function()
			{
				var checkbox = $('table tbody input[type="checkbox"]');
				$("#selectAll").click(function()
				{
					if(this.checked)
					{
						checkbox.each(function()
						{
							this.checked = true;
						});
					}
					else
					{
						checkbox.each(function()
						{
							this.checked = false;
						});
							
					}
				});
			
			<!-- kullanıcı delete butonuna tıkladığında bu method çalıştırılacak -->
			$('#deleteBtn').click
			( 
				function()
				{
					//javascript array
			  		var deletedEmployees = [];
			  		
			  		$("input:checkbox[class='employeeCheckBox']:checked").each(function()
					{    
			  			deletedEmployees.push($(this).val());    		
			  		});
			  		
			  		deletedEmployees = deletedEmployees.join(",");
			  		var employeeIds = deletedEmployees.toString();			//employeeIds = '3,4,56...'  		
			  		
			  		$.ajax(
	  				{
	  					
	  					url : '/employee-crud-project/delete',
	  					async : false,
	  					type : "POST",
	  					data : {"employeeIds" : employeeIds},
	  					success : function(data, textStatus, jqXHR) 
	  					{
	  						if(data != "")
		  						{
		  						response = data;
		  						} 				 
	  						else
		  						{
		  						 response = '';
		  						}	  						
	  						window.location.href = '/employee-crud-project/';
	  					},
	  					error : function(jqXHR, textStatus, errorThrown) 
	  					{
	  						console.log("something went wrong==>", errorThrown);
	  						response = '';
	  						alert('exception, errorThrown==>' + errorThrown);
	  					}
	  				});
				}
			);


			
		}); 
				
		</script>
	
	</head>
	
	<body ng-app="employeeApp" ng-controller="employeeCtrl">
	
		<div class="container">
			<div class="table-wrapper">
			
				<div class="table-title">
					<div class="row">
					
						<div class="col-sm-6">
							<h2>
								 <b>Manage Employees</b>
							</h2>
						</div>
						<div class="col-sm-6">
							<a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal">
								<i class="material-icons">&#xE147;</i> 
								<span>Add New Employee</span>
							</a> 
							<a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal">
								<i class="material-icons">&#xE15C;</i> 
								<span>Delete</span>
							</a>
						</div>
						
					</div>
				</div>
				
				
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>
								<span class="custom-checkbox"> 
									<input type="checkbox" id="selectAll"> 
									<label for="selectAll"></label>
								</span>
							</th>
							<th>Name</th>
							<th>Email</th>
							<th>Phone</th>
							<th>Actions</th>
						</tr>
					</thead>
					
					<tbody>
										
						<c:forEach var="employee" items="${employees}"> 
							<tr>
								<td>
									<span class="custom-checkbox"> 
										<input type="checkbox" class="employeeCheckBox" id="${employee.id}" value="${employee.id}">
										<label for="checkbox"></label>
									</span>
								</td>
								
								<td>${employee.name}</td>
								<td>${employee.email}</td>
								<td>${employee.phone}</td>
													
								<td>
									<a href="#editEmployeeModal" class="edit" data-toggle="modal">
										<i class="material-icons" ng-click="getEmployeeDetails('${employee.id}')" 
										   data-toggle="tooltip" title="Edit">&#xE254;</i>
									</a> 
										<a href="#deleteEmployeeModal" class="delete" data-toggle="modal">
										<i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i>
									</a>
								</td>
								
							</tr>									
						</c:forEach>
						
					</tbody>
					
				</table>
				
				<div class="clearfix">
				
					<div class="hint-text">
						Showing <b>5</b> out of <b>25</b> entries
					</div>
					
					<ul class="pagination">
						<li class="page-item disabled"><a href="#">Previous</a></li>
						<li class="page-item"><a href="#" class="page-link">1</a></li>
						<li class="page-item"><a href="#" class="page-link">2</a></li>
						<li class="page-item active"><a href="#" class="page-link">3</a></li>
						<li class="page-item"><a href="#" class="page-link">4</a></li>
						<li class="page-item"><a href="#" class="page-link">5</a></li>
						<li class="page-item"><a href="#" class="page-link">Next</a></li>
					</ul>
					
				</div>
				
			</div>
		</div>
		
		<!-- Add Modal HTML -->
		<jsp:include page="addEmployeeView.jsp"></jsp:include>
		
		<!-- Edit Modal HTML -->
		<jsp:include page="updateEmployeeView.jsp"></jsp:include>
		
		<!-- Delete Modal HTML -->
		<jsp:include page="deleteEmployeeView.jsp"></jsp:include>
		
	</body>
	
</html>