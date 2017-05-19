<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
         <title>Added new account</title>
         <link rel = "stylesheet" type = text/css href = "<c:url value="resources/styles/w3.css" />" >
    </head>
    
    <body class = "w3-card-8">
         <div id = "header" class = "w3-card-8 w3-text-indigo w3-padding-8">
            <h1><img src = "<c:url value = "resources/images/mobile.gif" />" style = "float : left;" height = "60" width = "60" />Mobile Store</h1>
         </div>
         
         <div id = "container" class = "w3-container w3-padding-4">
            <h1 class = "w3-text-indigo w3-padding-4">Welcome ${username}</h1> <br>
            <table class = "w3-table w3-border">
            <tr>
                <th class = "w3-text-blue"> Name </th>
                <td> ${name} </td>
            </tr>
            <tr>
                <th class = "w3-text-blue"> Email </th>
                <td> ${email} </td>
            </tr>
            <tr>
                <th class = "w3-text-blue"> Phone </th>
                <td> ${phone} </td>
            </tr>
            <tr>
                <th class = "w3-text-blue"> DOB </th>
                <td> ${dob} </td>
            </tr>
            </table>  <br><br>       
            <a href = "welcome" class = "w3-btn w3-indigo w3-large w3-hover-blue w3-round">Back to login</a>
         </div>
         
         <div id = "footer" class = "w3-container w3-text-dark-grey">
	        <h3> Developed by Shivank Chopra </h3>
	     </div>
    </body>
</html>