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
<!-- ------------------------------------------------------------------------------------------- -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	
	<div class="container">
		
		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#home">Add</a></li>
			<li><a data-toggle="tab" href="#menu1">View</a></li>

		</ul>

		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">

				<div class="container">
				<p align="right">
				<span class="text-danger">*</span> indicates mandatory fields
				</p>
					<form action="./saveDetails" method="post" enctype="multipart/form-data" onsubmit="return housingFormValidation()">


						<h3 align="center">Property Pre-Booking Form</h3>
						<div class="row">
							<div class="form-group col-md-4">
								<label>Housing Project :<span
						class="text-danger">*</span></label> <select
									onchange="project_property()" id="projectId" name="hpName"
									class="form-control">
									<option value="0">-select-</option>
									<c:forEach items="${allProjectList}" var="projects">
										<option value='${projects.hpId}'>${projects.hpName}</option>
									</c:forEach>
								</select>
								<span id="projectIdEr" class="text-danger font-weight-bold"></span>
							</div>
							<div class="form-group col-md-4">
								<label>Property Type:<span
						class="text-danger">*</span></label> <select
									onchange="property_cost()" id="propertyId" name="hName"
									class="form-control" >
									<option value="0">-select-</option>

								</select>
							</div>
							<div class="form-group col-md-4">
								<label>Property Cost:<span
						class="text-danger">*</span></label> <input disabled="disabled"
									type="text" name="propertyCost" id="costId"
									class="form-control">
							</div>
						</div>
						<div class="container"
							style="margin-top: 25px; border: 1px solid black;">
								<h4>Applicant Details</h4>
							<div class="row">
								<div class="form-group col-md-4">
									<label>Applicant Name :<span
						class="text-danger">*</span></label> <input type="text"
										name="applicantName" id="applicantName" class="form-control">
									<span id="applicantNameEr" class="text-danger font-weight-bold"></span>
								</div>
								<div class="form-group col-md-4">
									<label>Email :<span
						class="text-danger">*</span></label> <input type="text" name="email"
										id="email" class="form-control"> <span id="emailEr"
										class="text-danger font-weight-bold"></span>
								</div>
								<div class="form-group col-md-4">
									<label>Mobile No:<span
						class="text-danger">*</span></label> <input type="number" name="mobileNo"
										id="mobileNo" class="form-control" onclick="validate()"> <span
										id="mobileNoEr" class="text-danger font-weight-bold"></span>
								</div>
							</div>

							<div class="row">

								<div class="form-group col-md-4">
									<label>Date of Birth:<span
						class="text-danger">*</span></label> <input type="Date" name="dob"
										id="dob" class="form-control"> <span id="dobEr"
										class="text-danger font-weight-bold"></span>
								</div>
								<div class="form-group col-md-4">
									<label>Gender :<span
						class="text-danger">*</span></label> <br> <input type="radio"
										name="gender" id="gentype" value="Female">Female <input
										type="radio" name="gender" id="gentype" value="Male"
										checked="checked">Male <span id="fatherNameEr"
										class="text-danger font-weight-bold"></span>
								</div>
								<div class="form-group col-md-4">
									<label>Upload Id Proof :<span
						class="text-danger">*</span></label> <input type="file"
										name="idProof" id="imageId" class="form-control">
								</div>
							</div>
							<div align="center">
								<input type="submit" value="Submit" class="btn btn-success">&nbsp;&nbsp;<input
									type="submit" value="Reset" class="btn btn-danger">
							</div>
						</div>

					</form>



				</div>
			</div>
			<div id="menu1" class="tab-pane fade">
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
			</div>

		</div>
	
</body>

<script type="text/javascript">
	function project_property() {
		var project = $("#projectId").val();
		$.ajax({
			type : "GET",
			url : "./getPropertyByProjectId",
			data : "pId=" + project,
			success : function(response) {
				$('#propertyId').html(response);
			}
		});

	}
	function property_cost() {
		var property = $("#propertyId").val();
		$.ajax({
			type : "GET",
			url : "./getCostByPropertyId",
			data : "cId=" + property,
			success : function(response) {
				$('#costId').val(response);
			}
		});

	}

	 function housingFormValidation() {

		
		var vcustomerName = document.getElementById("applicantName").value;
		var vemail = document.getElementById("email").value;
		var vmobileNo = document.getElementById("mobileNo").value;
		var vdob = document.getElementById("dob").value;
		

	    var applicantCheck = /^[A-Za-z. ]{3,}$/;
        var emailCheck = /^[A-Za-z]{3,}[0-9]{2,6}@[A-Za-z]{3,}[.]{1}[A-Za-z.]{2,6}$/ ;
        var mobileCheck = /^[6789][0-9]{9}$/ ;
        var dobCheck = /^\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/ ;
        

	    if(applicantCheck.test(vcustomerName)){
			document.getElementById("applicantNameEr").innerHTML = " ";
			}
		else{
			document.getElementById("applicantNameEr").innerHTML = " ** Applicant name must contains 3 character and only alphabets ";
			return false;
			} 
	    if(emailCheck.test(vemail)){
			document.getElementById("emailEr").innerHTML = " ";
			}
		else{
			document.getElementById("emailEr").innerHTML = " ** Please provide valid email ";
			return false;
			} 
	    if(mobileCheck.test(vmobileNo)){
			document.getElementById("mobileNoEr").innerHTML = " ";
			}
		else{
			document.getElementById("mobileNoEr").innerHTML = " ** Please provide valid mobileNo and ist should be indian standard ";
			return false;
			} 
	    
	    if(dobCheck.test(vdob)){
			document.getElementById("dobEr").innerHTML = " ";
			}
		else{
			document.getElementById("dobEr").innerHTML = " ** age must be greater than 18 ";
			return false;
			} 
	  
	    
	}
 
	/* function validate() {    
        var a = document.getElementById("mobileNo").value;    
        if (a == "Ex: 08018070777") {    
            alert("Mobile no Should Not be Blank");    
            document.getElementById("mobileNo").focus();    
            return false;    
        }    
        if (isNaN(a)) {    
            alert("Enter the valid Mobile Number(Like : 08018070777)");    
            document.getElementById("mobileNo").focus();    
            return false;    
        }    
        if (a.length < 11) {    
            alert(" Your Mobile Number must 11 Integers(Like :08018070777)");    
            document.getElementById("mobileNo").focus();   
            return false;    
        }    
    } */

    function validateProject(){
    	var vprojectId = document.getElementById("projectId").value;
    	if(vprojectId==0){
			alert("please select atleast one project");
    	    return false;
    	}
    	}

    function validateProperty(){
    	var vpropertyId = document.getElementById("propertyId").value;
    	if(vpropertyId==0){
			alert("please select atleast one property");
    	    return false;
    	} 
    	}
</script>

<script type="text/javascript">
$(document).ready(function (){
	$('#BookingTable').DataTable();
});
</script>
</html>