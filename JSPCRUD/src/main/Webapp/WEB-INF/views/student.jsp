<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <title>Add Student</title>
</head>
<body>

    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <a class="navbar-brand" href="#">Add Student</a>
          <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Student List</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>

    <h1 class="text-center">Add Student</h1>


    <form action="/addStudent" method="post" id="addStudentForm">
        <div style="width:600px;height:500px;margin-left:550px;">
        <div class="mb-3">
            <label for="Name" class="form-label">Enter Student Name</label>
            <input type="text" class="form-control" name="student_name" id="Name" autocomplete="off" >
          </div>
        <div class="mb-3">
          <label for="Email" class="form-label">Enter Student Email</label>
          <input type="email" class="form-control" name="student_email" id="Email" autocomplete="off" >
        </div>
        <div class="mb-3">
          <label for="phoneNo" class="form-label">PhoneNo</label>
          <input type="number" class="form-control" name="student_phone" id="phoneNo" autocomplete="off">
        </div>
       
        <button type="submit" class="btn btn-primary">Submit</button>
        <button type="reset" class="btn btn-secondary">Reset</button>
        </div>
      </form>







</body>
</html>