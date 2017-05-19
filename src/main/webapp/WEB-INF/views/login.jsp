<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
         <title>Welcome ${username}</title>
         <link rel = "stylesheet" type = text/css href = "<c:url value="resources/styles/w3.css" />" >
    </head>
    
    <body class = "w3-card-8">
         <div id = "header" class = "w3-card-8 w3-text-indigo w3-white" style = "top : 0px; z-index-99 ; position : fixed; width : 100%;">
            <h1><img src = "<c:url value = "resources/images/mobile.gif" />" style = "float : left;" height = "60" width = "60" />Mobile Store</h1>
            <div class = "w3-btn-group" align = "center">
                 <input class = "w3-btn w3-large w3-hover-blue w3-white" id = "phones" type = "submit" value = "Phones"/>
                 <input class = "w3-btn w3-large w3-hover-blue w3-white" id = "cart" type = "submit" value = "Cart"/>
                 <input class = "w3-btn w3-large w3-hover-blue w3-white" id = "prevOrders" type = "submit" value = "Purchase history"/>
                 <input class = "w3-btn w3-large w3-hover-blue w3-white" type = "submit" id = "logout" value = "Log Out"/>
            </div>
         </div>
         
         <div id = "container" class = "w3-container w3-padding-4" style = "margin-top:150px; margin-bottom:150px;">
            <h4 class = "w3-text-indigo ">Welcome ${username}</h4> <br>
            <ul class = "w3-ul w3-card-4 w3-hoverable">
              <c:forEach var = "phn" items = "${phoneList}">
                   <li id = "phones" class = "w3-padding-16">
                     <div> <img src = "<c:url value = "${phn.imgLoc}"/>" class = "w3-left w3-margin-right" height ="85" width ="90"/>
                      <span class = "w3-xlarge w3-text-blue">${phn.company}</span><br>
                      <span class = "w3-text-dark-grey">${phn.model}</span><br>
                      <span class = "w3-text-green">Rs ${phn.price}</span> </div><br>
                      <input class = "w3-btn w3-small w3-hover-blue w3-indigo addToCart" id = "${phn.id}" type = "submit" value = "add to cart" />
                   </li>
              </c:forEach>
            </ul>
         </div>
                          
         <div id = "footer" class = "w3-card w3-dark-grey"style = "bottom : 0px; z-index-99 ; position : fixed; width : 100%;">
	        <h3> Developed by Shivank Chopra </h3>
	     </div>
	     <!-- hidden fields -->
	     <input type = "hidden" id = "userId" name = "userId" value = "${userID}" >
	     <!---------------- include js scriprts  ----------------------------->
	     <script src = "<c:url value="resources/scripts/jquery.js" />" ></script>
	     <script src = "<c:url value="resources/scripts/mainScript.js" />" ></script>
    </body>
</html>