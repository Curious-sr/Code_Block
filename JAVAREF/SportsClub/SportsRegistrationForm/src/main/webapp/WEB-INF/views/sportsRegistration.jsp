<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<link
        href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css"
        rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js">
        </script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="https://cdnjs.datatables/1.12.1/css/dataTables.bootstrap4.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script> 
<script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">	
	
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
					<form action="./saveRegistrationDetails" method="post" enctype="multipart/form-data" onsubmit="return AdmissionFormValidation()">

						<input type="hidden" name="registrationId" id="registrationId" value="${regdd.registrationId}">
						<marquee bgcolor="lightblue" class="display-3">Sports Club Registration Form</marquee>
						<div class="row">
							<div class="form-group col-md-4 offset-md-2">
								<label>Club Name :<span
						class="text-danger">*</span></label>
						 <select onchange="club_sport()" id="clubId" name="clubName"
									class="form-control" onclick="validateCollege()">
									<option value="0">-select-</option>
									<c:forEach items="${ListClub}" var="club">
										
										<option value='${club.clubId}'>${club.clubName}</option>
									</c:forEach>
								</select>
								<span id="clubIdEr" class="text-danger font-weight-bold"></span>
							</div>
							<div class="form-group col-md-4">
								<label>Sports Name :<span
						class="text-danger">*</span></label> <select
									 id="sportsId" name="sportsName"
									class="form-control" onclick="validateBranch()" >
									<option value="0" >-select-</option>
								</select>
							</div>
						</div>
						<div class="container"
							style="margin-top: 25px; border: 1px solid black;">
								<h4>Applicant Details</h4>
							<div class="row">
								<div class="form-group col-md-4">
									<label>Applicant Name :<span
						class="text-danger">*</span></label> <input type="text"
										name="applicantName" id="applicantName" class="form-control" value="${regdd.applicantName}">
									<span id="applicantNameEr" class="text-danger font-weight-bold"></span>
								</div>
								<div class="form-group col-md-4">
									<label>Email :<span
						class="text-danger">*</span></label> <input type="text" name="emailId"
										id="email" class="form-control" value="${regdd.emailId}"> <span id="emailEr"
										class="text-danger font-weight-bold"></span>
								</div>
								<div class="form-group col-md-4">
									<label>Mobile No:<span
						class="text-danger">*</span></label> <input type="number" name="mobileNo"
										id="mobileNo" class="form-control" value="${regdd.mobileNo}" onclick="validate()"> <span
										id="mobileNoEr" class="text-danger font-weight-bold"></span>
								</div>
							</div>

							<div class="row">

								<div class="form-group col-md-4">
									<label>Date of Birth:<span
						class="text-danger">*</span></label> <input type="Date" name="dob"
										id="dob" class="form-control"  value="<f:formatDate pattern="yyyy-MM-dd" type="date" value="${regdd.dob}"/>"> <span id="dobEr"
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
									<label>Upload Photo :<span
						class="text-danger">*</span></label> <input type="file"
										name="imagePath" id="imageId" class="form-control">
								</div>
							</div>
							<div align="center">
								<input type="submit" <c:choose><c:when test="${regd eq null }"> value="Submit" </c:when><c:otherwise>value="Update"</c:otherwise></c:choose> class="btn btn-success">&nbsp;&nbsp;<input
									type="submit" value="Reset" class="btn btn-danger">
									<a href="./Registration/export/excel" class="btn btn-dark">Download excel</a>
							</div>
						</div>

					</form>



				</div>
			</div>
			<div id="menu1" class="tab-pane fade">
				<h2 class="display-4 text-danger" align="center">Registration Details</h2>
				<form action="./search">
				<div class="container mt-5" style="margin-top: 25px; border: 1px solid black;">
				<h5>Filter</h5>
					<div class="form-group col-md-4 offset-md-2">
								<label>Club Name :</label> 
								<select id="cId" name="cName"
									class="form-control" >
									<option value="0">-select-</option>
									<c:forEach items="${ListClub}" var="club">
										<option value='${club.clubId}'>${club.clubName}</option>
									</c:forEach>
								</select>&nbsp;&nbsp;<input type="submit" value="Search">
						
					</div>		
				
				</div>
				</form>
    			<div class="container mt-5" >
			<table class="table table-stripped" id="RegistrationTable" border="1">
			<thead>
				<tr>
					<th>Sl#</th>
					<th>Name</th>
					<th>Email</th>
					<th>Mobile No</th>
					<th>Image</th>
					<th>Club Name</th>
					<th>Sports Name</th>
					<th>Fees</th>
					<th>Action</th>
				</tr>					
			</thead>
			<tbody>
				
				
				<c:forEach items="${allRegistrationList}" var="register" varStatus="count">
				<tr>
					<td>${count.count}</td>
					<td>${register.applicantName}</td>
					<td>${register.emailId}</td>
					<td>${register.mobileNo}</td>
					<td>${register.imagePath}</td>
					<td>${register.club.clubName}</td>
					<td>${register.sports.sportsName}</td>
					<td>${register.sports.fees}</td>
					<td><a href="./updateRegistration?registrationId=${register.registrationId}" class="btn btn-warning">Update</a>&nbsp;&nbsp;<a href="./deleteRegistration?registrationId=${register.registrationId }" class="btn btn-danger">Delete</a></td>
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

function club_sport() {
	var club = $("#clubId").val();
	alert(club)
	$.ajax({
		type : "GET",
		url : "./getSportsByClubId",
		data : "clubId=" + club,
		success : function(response) {
			$('#sportsId').html(response);
		}
	});

}
${regdd}


 function AdmissionFormValidation() {

		
		var vApplicantName = document.getElementById("applicantName").value;
		var vemail = document.getElementById("email").value;
		var vmobileNo = document.getElementById("mobileNo").value;
		var vdob = document.getElementById("dob").value;
		

	    var applicantCheck = /^[A-Za-z. ]{3,}$/;
        var emailCheck = /^[a-z0-9]{3,}@[a-z]{3,}[.]{1}[a-z.]{2,6}$/;
        var mobileCheck = /^[6789][0-9]{9}$/ ;
        var dobCheck = /^\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/ ;
        

	    if(applicantCheck.test(vApplicantName)){
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
	
	/* function validateCollege(){
    	var vCollege = document.getElementById("collegeId").value;
    	if(vCollege==0){
			alert("please select atleast one project");
    	    return false;
    	}
    	}

    function validateBranch(){
    	var vBranch = document.getElementById("branchId").value;
    	if(vBranch==0){
			alert("please select atleast one property");
    	    return false;
    	} 
    	} */
</script>

<script>
$( function() {
    $( "#dob" ).datepicker();
  } );
  </script>
</html>