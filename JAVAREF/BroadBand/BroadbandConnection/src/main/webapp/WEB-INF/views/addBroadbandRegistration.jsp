<%--
  Created by IntelliJ IDEA.
  User: sambit.pradhan
  Date: 9/10/2022
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" >
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <title>Broadband Registration</title>
</head>
<body style="margin: 2rem;">
<style>
    a{
        cursor: pointer;
    }
</style>
<h3 style="color: green">Broadband Connection Form</h3>
<div class="card text-center" style="margin-right: 5rem; margin-left: 5rem;">
    <div class="card-header">
        <ul class="nav nav-tabs card-header-tabs">
            <li class="nav-item"><a class="nav-link active" id="addId" onclick="openAdd()">Add</a></li>
            <li class="nav-item"><a class="nav-link" id="viewId" onclick="openView()">View</a></li>
        </ul>
    </div>

    <div class="card-body">
        <div id="add">
            <form action="/addBroadbandRegistration" method="post" id="addBroadbandRegistrationForm" enctype="multipart/form-data">
                <h3 class="card-title">Applicant Details</h3>
                <div class="form">
                    <div class="row g-3 m-4">


                        <c:choose>
                            <c:when test = "${registrationDetails ne null}">
                                <div class="col-md-4 control-label">
                                    <label for="providerId" class="form-label control-label">Service Provider Name</label>
                                    <select class="form-control form-control" name="providerId" id="providerId" >
                                        <option value="Select" hidden>Select</option>
                                        <c:forEach items="${providerMasterList}" var="providerMaster" varStatus="coount">
                                            <c:if test="${providerMaster.providerId eq registrationDetails.providerMaster.providerId}">
                                                <option value="${providerMaster.providerId}" selected>${providerMaster.providerName}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                            </c:when>

                            <c:otherwise>
                                <div class="col-md-4 control-label">
                                    <label for="providerId" class="form-label control-label">Service Provider Name</label>
                                    <select class="form-control form-control" name="providerId" id="providerId" >
                                        <option value="Select" hidden>Select</option>
                                        <c:forEach items="${providerMasterList}" var="providerMaster" varStatus="coount">
                                            <option value="${providerMaster.providerId}">${providerMaster.providerName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </c:otherwise>
                        </c:choose>


                        <div class="col-md-4 control-label">
                            <label for="connectionSpeed" class="form-label control-label">Connection Speed</label>
                            <select class="form-control form-control" name="connectionSpeed" id="connectionSpeed">
                                <option value="Select" hidden>Select</option>
                                <option value="50">50</option>
                                <option value="100">100</option>
                                <option value="200">200</option>
                                <option value="300">300</option>
                            </select>
                        </div>

                    </div>

                    <div class="card">
                        <h5 class="card-header control-label">Applicant Details</h5>
                        <div class="card-body">
                            <div class="hold">
                                <div class="row g-3 mb-4">
                                    <div class="col-md-4 control-label">
                                        <label for="name" class="form-label control-label">Name</label>
                                        <input type="text" name="applicantName" class="form-control" id="name" required value="${registrationDetails.applicantName}" placeholder="Enter Your Name"/>

                                    </div>
                                    <div class="col-md-4 control-label">
                                        <label for="email" class="form-label"><span class="">Email</span> </label>
                                        <input type="email" name="mailId" class="form-control" id="email" required value="${registrationDetails.mailId}" placeholder="Enter Email"/>
                                    </div>

                                    <div class="col-md-4 control-label">
                                        <label for="mobile" class="form-label control-label">Mobile</label>
                                        <input type="text" name="mobileNumber" class="form-control" id="mobile" required value="${registrationDetails.mobileNumber}" placeholder="Enter Mobile"/>
                                    </div>

                                </div>

                                <div class="row g-3">

                                    <div class="col-md-4 control-label">
                                        <label for="dob" class="form-label control-label">Date of Birth</label>
                                        <input type="date" name="dateOfBirth" class="form-control datepicker minimumSize" id="dob" required value="${registrationDetails.dateOfBirth}"/>
                                    </div>

                                    <div class="col-md-4 control-label">
                                        <label for="gender" class="form-label control-label">Gender</label>
                                        <div class="row g-2" style="margin-left: 10rem;">
                                            <div class="col-md-4">
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="gender" id="exampleRadios1" value="Male" checked>
                                                    <label class="form-check-label" for="exampleRadios1"> Male </label>
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="gender" id="exampleRadios2" value="FeMale">
                                                    <label class="form-check-label" for="exampleRadios2">FeMale </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-md-4 control-label" style="margin-top: 2rem;">
                                        <div class="form-group">
                                            <label for="idProof">Upload id-proof</label>
                                            <input type="file" class="form-control-file" name="idProof" id="idProof">
                                        </div>
                                    </div>
                                </div>

                                <input type="hidden" value="${registrationDetails.registrationId}" name="regId">

                                <div class="btnhold mt-3">
                                    <button type="button" class="btn btn-outline-primary mr-3" onclick="validateForm()">Submit</button>
                                    <button type="reset" class="btn btn-outline-secondary">Reset</button>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>



        <div id="view">
            <h3 class="card-title">Registration Details</h3>
            <table class="table table-bordered" id="dataTable">
                <thead>
                <tr>
                    <th>S.No</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Mobile</th>
                    <th>Age</th>
                    <th>Document</th>
                    <th>Provider</th>
                    <th>Speed</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${registrationDetailsList}" var="registrationDetails" varStatus="count">
                    <tr>
                        <td>${count.count}</td>
                        <td>${registrationDetails.applicantName}</td>
                        <td>${registrationDetails.mailId}</td>
                        <td>${registrationDetails.mobileNumber}</td>
                        <td>${registrationDetails.age}</td>
                        <td><a href="/downloadFile/${registrationDetails.registrationId}">${registrationDetails.imageName}</a></td>
                        <td>${registrationDetails.providerMaster.providerName}</td>
                        <td>${registrationDetails.connectionMaster.connectionSpeed}</td>
                        <td>
                            <a href = "/editBroadbandRegistration/${registrationDetails.registrationId}"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pen" viewBox="0 0 16 16"><path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/></svg></a>
<%--                            |--%>
<%--                            <a href = "/delete/${registrationDetails.registrationId}"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16"><path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/><path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/></svg></a>--%>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>

<script>


    $(document).ready(function (){
        $('#add').show();
        $('#view').hide();
    });

    function openAdd(){
        $('#view').hide();
        $('#add').show();

        $('#addId').addClass("active");
        $('#viewId').removeClass("active");
    }
    function openView(){
        $('#view').show();
        $('#add').hide();

        $('#addId').removeClass("active");
        $('#viewId').addClass("active");
    }


    function validateForm(){

        let serviceProvider = $("#providerId").val();
        let speed = $("#connectionSpeed").val();
        let name = $('#name').val();
        let email = $('#email').val();
        let phone = $('#mobile').val();
        let dob = $('#dob').val();

        let nameRegx = /^[a-zA-Z ]+$/;
        let emailRegx = /^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/;
        let phoneRegx = /^[0-9]{10}$/;

        let today = new Date();

        if (serviceProvider == "Select"){
            alert("Please select service provider");
            return false;
        }
        if (speed == "Select"){
            alert("Please select connection speed");
            return false;
        }

        if (name == null || name == "") {
            alert("Name must be filled out");
            $('#name').focus();
            $('#name').css('border-color', 'red');
            $('#name').attr('placeholder', 'Please enter name');
            return false;
        } else if (!nameRegx.test(name)) {
            alert("Name must be alphabets");
            $('#name').focus();
            $('#name').css('border-color', 'red');
            $('#name').attr('placeholder', 'Please enter valid name');
            return false;
        } else if (name.length<3 || name.length > 30){
            alert("Name must be between 3 and 30 characters");
            $('#name').focus();
            $('#name').css('border-color', 'red');
            $('#name').attr('placeholder', 'Name should be between 3 to 30 characters');
        } else {
            $('#name').css('border-color', 'green');
            $('#name').attr('placeholder', '');

            if (email == null || email == "") {
                alert("Email must be filled out");
                $('#email').focus();
                $('#email').css('border-color', 'red');
                $('#email').attr('placeholder', 'Please enter email');
                return false;
            } else if (!emailRegx.test(email)) {
                alert("Email must be valid");
                $('#email').focus();
                $('#email').css('border-color', 'red');
                $('#email').attr('placeholder', 'Please enter valid email');
                return false;
            } else {
                $('#email').css('border-color', 'green');
                $('#email').attr('placeholder', '');

                if (phone == null || phone == "") {
                    alert("Phone must be filled out");
                    $('#mobile').focus();
                    $('#mobile').css('border-color', 'red');
                    $('#mobile').attr('placeholder', 'Please enter phone');
                    return false;
                } else if (!phoneRegx.test(phone)) {
                    alert("Phone must be valid");
                    $('#mobile').focus();
                    $('#mobile').css('border-color', 'red');
                    $('#mobile').attr('placeholder', 'Please enter valid phone');
                    return false;
                } else {
                    $('#mobile').css('border-color', 'green');
                    $('#mobile').attr('placeholder', '');

                    if (dob == null || dob == "") {
                        alert("Date of birth must be filled out");
                        $('#dob').focus();
                        $('#dob').css('border-color', 'red');
                        $('#dob').attr('placeholder', 'Please enter date of birth');
                        return false;
                    }else if (Date.parse(dob) > Date.parse(today)) {
                        alert("Date of birth must be less than today");
                        $('#dob').focus();
                        $('#dob').css('border-color', 'red');
                        $('#dob').attr('placeholder', 'Please enter valid date of birth');
                        return false;
                    } else {
                        console.log("Inside DOB Pass.");
                        $('#dob').css('border-color', 'green');
                        $('#dob').attr('placeholder', '');

                        let confirm = window.confirm("Are you sure!! You want to submit?");
                        if (confirm == true) {
                            console.log("Inside Confirm Pass.");
                            $('#addBroadbandRegistrationForm').submit();
                        } else {
                            alert("Failed to Submit Form!");
                            Bootstrap.alert("Failed to Submit Form!");
                        }
                    }
                }
            }
        }
    }



</script>
</html>
