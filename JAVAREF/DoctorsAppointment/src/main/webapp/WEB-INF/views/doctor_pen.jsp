<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
 
 <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>  -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css">

<link
	rel="https://cdnjs.datatables/1.12.1/css/dataTables.bootstrap4.min.css">

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"
	rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

<script
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>

<script
	src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
	<c:if test="${msg eq 201}">
		<div class="alert alert-success">
			<script>
				Swal.fire({
					title : 'Failed!',
					text : 'prescription is already addded !!',
					icon : 'Failed',
					confirmButtonText : 'OK'
				})
			</script>
		</div>
	</c:if>
	<c:if test="${msg eq 200}">
		<div class="alert alert-success">
			<script>
				Swal.fire({
					title : 'success!',
					text : 'prescription addded successfully !!',
					icon : 'Success',
					confirmButtonText : 'OK'
				})
			</script>
		</div>
	</c:if>


	<div class="container mt-3">

		<p class="bg-warning  text-center text-danger h2">Doctors
			Pescription</p>


	</div>
	<div class="container mt-3">
		<div class="row">
			<table class="table table-striped table-hover text-center"
				id="patientTable" style="display: none;">
				<thead>
					<tr>
						<th>Patient Name</th>
						<th>Phone Number</th>
						<th>Date Of Appointment</th>
					</tr>
				</thead>
				<tbody id="patientInformation">
					<!-- Data rows will be dynamically added here -->
				</tbody>
			</table>
		</div>
	</div>


	<div class="container">

		<!-- <p class="text-left text-primary">Prescription Details</p> -->
		<div class="w-100 p-2 h-50" style="background-color: #eee">
			<form action="./save" id="myForm" method="post">
				<%-- <input type="hidden" value="${getData.phoneNo }" name="phoneNo" > --%>
				<div class="row">
					<div class="col-md-6 offset-md-3">
						<label class="text-primary">Select Doctor Name</label> <select
							onchange="getPatient()" id="doctorId" name="doctorId"
							class="form-control" required="required">
							<option value="0">--select--</option>
							<c:forEach items="${doctorList}" var="doctors">
								<option value="${doctors.doctor_id}"
									<c:if test="${prescriptionDto.doctorId eq doctors.doctor_id}">selected="selected"</c:if>>${doctors.doctor_Name}</option>

							</c:forEach>

						</select>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6 offset-md-3">
						<label class="text-primary">Select Patient</label> <select
							onchange="getPatientInformation()" id="patientId"
							name="patientId" class="form-control" required="required">
							<option value="0">--select--</option>
							<c:forEach items="${patientDetails}" var="patient">
								<option value="${patient.doctor_Appointment_id}" >${patient.patient_Name}</option>

							</c:forEach>

						</select>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6 offset-md-3">
						<label class="text-primary">Select Disease</label> <select
							onchange="getMedicines()" id="diseaseId" name="diseaseId"
							class="form-control" required="required">
							<option value="0">--select--</option>
							<c:forEach items="${diseaseList}" var="disease">
								<option value="${disease.disease_id}"
									<c:if test="${prescriptionDto.diseaseId eq disease.disease_id}">selected="selected"</c:if>>${disease.disease_Name}</option>

							</c:forEach>

						</select>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6 offset-md-3">
						<label class="text-primary">Select Medicine</label> <select
							id="medicineId" name="medicineId" class="form-control" required="required">
						</select>
					</div>

				</div>
				<div class="row">
					<div class="col-md-6 offset-md-3">
						<label class="text-primary"> prescription Details</label>
						<textarea id="prescription" name="prescription"
							class="form-control" required="required">${prescriptionDto.prescription}</textarea>

					</div>
				</div>
				<div class="container text-center mt-2">

					<input type="submit" class="btn btn-success" />

				</div>
			</form>
		</div>



	</div>
	<table class="table table-stripped" border="1">
		<thead>
			<tr>
				<th>SlNo#</th>
				<th>Date Of Appointment</th>
				<th>Doctor Name</th>
				<th>Patient Name</th>
				<th>Disease Name</th>
				<th>Medicine Name</th>
				<th>Appointment Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${prescriptionDetails}" var="data"
				varStatus="count">
				<tr>
					<td>${count.count}</td>
					<td>${data.doctor_Appointment.date_Of_appointment}</td>
					<td>${data.doctor_Appointment.doctorMaster.doctor_Name}</td>
					<td>${data.doctor_Appointment.patient_Name}</td>
					<td>${data.diseaseMaster.disease_Name}</td>
					<td>${data.medicineMaster.medicine_Name}</td>
					<td>${data.doctor_Appointment.patient_Status}</td>
					<c:if test="${data.doctor_Appointment.patient_Status ne A}">
						<td><a
							href="pdfExporter?pId=${data.doctor_Appointment.doctor_Appointment_id}"><i
								class="fa fa-file-pdf"></i></a></td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
<script type="text/javascript">
	function getMedicines() {
		var diseaseId = $("#diseaseId").val();
		$.ajax({
			type : "GET",
			url : "./getMedicines",
			data : "diseaseId=" + diseaseId,
			success : function(response) {
				$('#medicineId').html(response);
			}
		});

	}

	function getPatient() {
		/* var doctorId = $("#doctorId").val();
		$.ajax({
			type : "GET",
			url : "./getPatientDetails",
			data : "doctorId=" + doctorId,
			success : function(response) {
				//let data=json
				let data = JSON.stringify(response);
				$('#patientId').html(response);
				//jadi html pathaucha tahale resp lekhiba jaha asiba seia debo
			}
		}); */
		document.getElementById("myForm").submit();

	}

	function getPatientInformation() {
		var patientId = $("#patientId").val();
		document.getElementById("patientTable").style.display = "table";
		$.ajax({
			type : "GET",
			url : "./getPatientInformation",
			data : {
				doctorsAppointmentId : patientId
			},
			success : function(response) {
				$('#patientInformation').html(response);
				// Show patient table if response is not empty

			}
		});
	}
</script>
</html>