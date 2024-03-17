<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="https://cdnjs.datatables/1.12.1/css/dataTables.bootstrap4.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>  
<script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>
</head>
<body>
<div class="container">
<div>
					<ul class="nav nav-tabs btn-succcess">
  						<li class="nav-item">
   					    <a class="nav-link active" aria-current="page" href="./housing">Add</a>
 						</li>
  						<li class="nav-item">
                        <a class="nav-link" href="./showAllBooking">View</a>
                        </li>
                     </ul> 
			  </div>
	<h2 class="display-4 text-danger" align="center">Registration Details</h2>
    <div class="container mt-5" >
		<table class="table table-stripped" id="BookingTable" border="1">
			<thead>
				<tr>
					<th>Sl#</th>
					<th>Name</th>
					<th>Email</th>
					<th>Mobile No</th>
					<th>Age</th>
					<th>Document</th>
					<th>Housing Project</th>
					<th>Property Type</th>
					<th>Action</th>
				</tr>					
			</thead>
			<tbody>
				
				
				<c:forEach items="${allBookingList}" var="housing" varStatus="count">
				<tr>
					<td>${count.count}</td>
					<td>${housing.applicantName}</td>
					<td>${housing.email}</td>
					<td>${housing.mobileNo}</td>
					<td>${housing.age}</td>
					<td>${housing.idProof}</td>
					<td>${housing.housingProperty.housingProject.hpName}</td>
					<td>${housing.housingProperty.hName}</td>
					<td><a onclick="return confirm('Are you want to delete your Details');" href="./deleteBooking?hdId=${housing.hdId}" class="btn btn-danger">Delete</a></td>
					
				</tr>
				</c:forEach>
				
			</tbody>
		    </table>
			
		</div>
	</div> 

</body>
<script type="text/javascript">
$(document).ready(function (){
	$('#BookingTable').DataTable();
});
</script>
</html>