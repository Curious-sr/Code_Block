<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css">
<link
	rel="https://cdnjs.datatables/1.12.1/css/dataTables.bootstrap4.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>
<!-- ------------------------------------------------------------------------------------------- -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body style="background-color:white;">

	<div class="container mt-5">

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
					<form action="./saveDetails" method="post"
						enctype="multipart/form-data" onsubmit="return FormValidation()">


						<h3 class="display-4 text-danger" align="center">Library
							Registration Form</h3>
						<div class="text-center">
							<c:if test="${not empty Msg}">
								<span class="text-danger" id="emsg"><strong>Error!</strong>${Msg}</span>
							</c:if>


						</div>
						<div class="row">
							<div class="form-group col-md-4">
								<label>Library Name :<span class="text-danger">*</span></label>
								<select onchange="library_subscription()" id="libraryId"
									name="lName" class="form-control">
									<option value="0">-select-</option>
									<c:forEach items="${allLibraryList}" var="library">
										<option value='${library.libraryId}'>${library.libraryName}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-4">
								<label>Subscription Type:<span class="text-danger">*</span></label>
								<select onchange="subscription_cost()" id="subscriptionId"
									name="sName" class="form-control">
									<option value="0">-select-</option>

								</select>
							</div>
							<div class="form-group col-md-4">
								<label>Subscription Fees:<span class="text-danger">*</span></label>
								<input disabled="disabled" type="text" name="subscriptionCost"
									id="costId" class="form-control">
							</div>
						</div>
						<div class="container"
							style="margin-top: 25px; border: 1px solid black;">
							<h4 align="left">Applicant Details</h4>
							<div class="row">
								<div class="form-group col-md-4">
									<label>Applicant Name :<span class="text-danger">*</span></label>
									<input type="text" name="applicantName" id="applicantName"
										class="form-control"> <span id="applicantNameEr"
										class="text-danger font-weight-bold"></span>
								</div>
								<div class="form-group col-md-4">
									<label>Email :<span class="text-danger">*</span></label> <input
										type="text" name="email" id="email" class="form-control">
									<span id="emailEr" class="text-danger font-weight-bold"></span>
								</div>
								<div class="form-group col-md-4">
									<label>Mobile No:<span class="text-danger">*</span></label> <input
										type="number" name="mobileNo" id="mobileNo"
										class="form-control"> <span id="mobileNoEr"
										class="text-danger font-weight-bold"></span>
								</div>
							</div>

							<div class="row">

								<div class="form-group col-md-4">
									<label>Date of Birth:<span class="text-danger">*</span></label>
									<input type="Date" name="dob" id="dob" class="form-control">
									<span id="dobEr" class="text-danger font-weight-bold"></span>
								</div>
								<div class="form-group col-md-4">
									<label>Gender :<span class="text-danger">*</span></label> <br>
									<input type="radio" name="gender" id="gentype" value="Female">Female
									<input type="radio" name="gender" id="gentype" value="Male"
										checked="checked">Male <span id="fatherNameEr"
										class="text-danger font-weight-bold"></span>
								</div>
								<div class="form-group col-md-4">
									<label>Upload Id Proof :<span class="text-danger">*</span></label>
									<input type="file" name="idProof" id="imageId"
										class="form-control">
								</div>
							</div>
							<div align="center">
								<input type="submit" value="Submit" class="btn btn-success mt-4 mb-4">&nbsp;&nbsp;<input
									type="submit" value="Reset" class="btn btn-danger mt-4 mb-4">
							</div>
						</div>

					</form>



				</div>
			</div>
			<div id="menu1" class="tab-pane fade">
				<h2 class="display-4 text-danger" align="center" id="h3">Registration
					Details</h2>
				<div class="container mt-5">
					<form action="./search">
						<fieldset>
							<legend>Filter:</legend>

							<div class="row">
								<div class="form-group col-md-4">
									<label>Library Name :<span class="text-danger">*</span></label>
									<select name="lName" class="form-control">
										<option value="0">-select-</option>
										<c:forEach items="${allLibraryList}" var="library">
											<option value='${library.libraryId}'>${library.libraryName}</option>
										</c:forEach>
									</select>
								</div>

								<div class="form-group col-md-4">
									<label>Subscription Type :<span class="text-danger">*</span></label>
									<select name="sName" class="form-control">
										<option value="0">-select-</option>
										<c:forEach items="${subscriptionList}" var="subscription">
											<option value='${subscription.subscriptionId}'>${subscription.subscriptionType}</option>
										</c:forEach>
									</select>
								</div>
								<div>

									<button style="margin-top: 15px;" type="submit"
										class="btn btn-lg btn-success btn-submit">
										<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
										Search
									</button>
								</div>
							</div>
						</fieldset>


					</form>

					<table class="table table-stripped" id="BookingTable" border="1">
						<thead>
							<tr>
								<th>Sl#</th>
								<th>Name</th>
								<th>Email</th>
								<th>Mobile No</th>
								<th>Gender</th>
								<th>Age</th>
								<th>Document</th>
								<th>Library Name</th>
								<th>Subscription Type</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>


							<c:forEach items="${allBookingList}" var="library"
								varStatus="count">
								<tr>
									<td>${count.count}</td>
									<td>${library.applicantName}</td>
									<td>${library.email}</td>
									<td>${library.mobileNo}</td>
									<td>${library.gender}</td>
									<td>${library.age}</td>
									<td>${library.idProof}</td>
									<td>${library.subscription.library.libraryName}</td>
									<td>${library.subscription.subscriptionType}</td>
									<td><a ><i class="fas fa-trash text-danger" style="font-size: 20px"></i></a>&nbsp;&nbsp;
					                <a ><i class="fas fa-sharp fa-pen-nib" style="font-size: 20px"></i></a></td>
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
	function library_subscription() {
		var library = $("#libraryId").val();
		alert(library);
		$.ajax({
			type : "GET",
			url : "./getsubscriptionByLibraryId",
			data : "sId=" + library,
			success : function(response) {
				$('#subscriptionId').html(response);
			}
		});

	}
	function subscription_cost() {
		var subscription = $("#subscriptionId").val();
		$.ajax({
			type : "GET",
			url : "./getCostBySubscriptionId",
			data : "fId=" + subscription,
			success : function(response) {
				$('#costId').val(response);
			}
		});

	}

	function FormValidation() {

		var vcustomerName = document.getElementById("applicantName").value;
		var vemail = document.getElementById("email").value;
		var vmobileNo = document.getElementById("mobileNo").value;
		var vdob = document.getElementById("dob").value;

		var applicantCheck = /^[A-Za-z. ]{3,}$/;
		var emailCheck = /^[A-Za-z0-9]{3,}@[A-Za-z]{3,}[.]{1}[A-Za-z.]{2,6}$/;
		var mobileCheck = /^[6789][0-9]{9}$/;
		var dobCheck = /^\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/

		if (applicantCheck.test(vcustomerName)) {
			document.getElementById("applicantNameEr").innerHTML = " ";
		} else {
			document.getElementById("applicantNameEr").innerHTML = " ** Applicant name must contains 3 character and only alphabets ";
			return false;
		}
		if (emailCheck.test(vemail)) {
			document.getElementById("emailEr").innerHTML = " ";
		} else {
			document.getElementById("emailEr").innerHTML = " ** Please provide valid email ";
			return false;
		}
		if (mobileCheck.test(vmobileNo)) {
			document.getElementById("mobileNoEr").innerHTML = " ";
		} else {
			document.getElementById("mobileNoEr").innerHTML = " ** Please provide valid mobileNo and ist should be indian standard ";
			return false;
		}

		if (dobCheck.test(vdob)) {
			document.getElementById("dobEr").innerHTML = " ";
		} else {
			document.getElementById("dobEr").innerHTML = " ** age must be greater than 18 ";
			return false;
		}
	}
</script>
<script>
	$(document).ready(function() {
		$('#BookingTable').DataTable();
		$('#h3').select2();
	});
</script>
</html>