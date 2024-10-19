<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
            <title>Insert title here</title>
        </head>

        <body>
            <div style="width:700px ; border:5px solid black;">
                <div style="width:100%; margin-top: 30px; height: 100px;">
                    <div style="float:left; width:20%; margin-left: 20px;">
                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQrEmHEW9bS7CkrUbzw6bfWlCXHcQy9nfVmkHGxbF5ys1BU8oLi71rBE42LCtfZctAHFbo&usqp=CAU"
                            alt="imgae" height="110px">
                    </div>
                    <div style="float:left; width:65%;">
                        <div style="font-size: 30px;"><b>Patient's Medical History</b></div>
                        <div style="margin-top: 20px;">NAME - ${patient.patientName}</div>
                        <div style="margin-top: 10px;">AGE -${patient.age} <span style="margin-left: 80px;"> GENDER -
                                ${patient.gender}</span></div>
                    </div>
                </div>
                <div style="margin-top: 30px; margin-bottom: 20px; margin-left: 20px; margin-right: 20px;">
                    <c:if test="${patient.presciptionList.size() eq 0}">
                        <h2 style="border: 2px groove threedface;
                        padding: 1em; margin-bottom: 40px; text-align: center;">No Record Found</h2>
                    </c:if>
                    <c:forEach items="${patient.presciptionList}" var="pres">
                        <section  style="border: 2px groove threedface;
                        padding: 1em;">
                            <h2 style="float: left;
                            margin: -1.7em 0 0;
                            padding: 0 .5em;
                            background: #fff;
                            font-size: 1em;
                            font-weight: normal;">
                                ${pres.dateOfVisit}
                            </h2>
                            <div style="font-size: 20px; margin-bottom: 10px;"><b>Diesase name </b> - &nbsp &nbsp
                                ${pres.diseaseMaster.diseaseName}</div>
                            <div style="font-size: 20px;"><b>Prescription Details</b> - &nbsp &nbsp ${pres.prescriptionDetails}</div>
                          </section>
                        
                        <div style="margin-bottom: 20px;"></div>
                    </c:forEach>
                    
                </div>

                <div style="text-align: center;" ><p>/**/  END OF REPORT /**/</p></div>
            </div>
        </body>

        </html>