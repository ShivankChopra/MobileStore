<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html>
  <head>
     <title>MobileStore</title>
     <link rel = "stylesheet" type = text/css href = "<c:url value="resources/styles/w3.css" />" >
	 <style>
	     #imgs div{
	        display : inline-block ;
	        display : none;
          }
         .error {
            color:red;
          }
         .valid {
            color:green;
          }
          
	 </style>
  </head>
  
  <body class = "w3-card-8">
      <div id = "header" class = "w3-container w3-text-indigo w3-padding-8">
            <h1><img src = "<c:url value = "resources/images/mobile.gif" />" style = "float : left;" height = "60" width = "60" />Mobile Store</h1>
            <div id = "intro" class = "w3-container w3-text-dark-grey w3-animate-bottom " style = "float : left; ">
		       <p>Hey there fellas!! Welcome to mobile store. Here you can buy high end<br> mobile phones from
                          companies like Nokia , Samsung , Motorolla , LG , etc at amazing prices!<br>	All you need to start
                          is creating a free account from below link .<br> Happy shopping :-)	
		       </p>
		   </div>
            <div id = "loginForm" class = "w3-container w3-animate-right" style = "max-width:200px ; float:right;" align = "left">
                   <h3 class = "w3-text-indigo w3-padding-2">Sign in :</h3>
                   <form id = "login" action = "login" method = post>
                       <label class = "w3-label w3-text-blue" > User Name : </label>  <input class = "w3-input w3-animate-input" type = "text" id = "username" name = "username" />
                       <label class = "w3-label w3-text-blue" > Password : </label>  <input class = "w3-input w3-animate-input" type = "password" name = "password" /><br/>
                       <input class = "w3-btn w3-small w3-hover-blue w3-indigo" type = "submit" value = "sign in" />
                   </form>
            </div>
      </div>	
	  <!-- ---------------------------------------------------------------------------------------------- -->
	  <div id = "content" align = "center">
		   
	       <div id = "imgs" class ="w3-padding-24">
					     <div class = "w3-card-4 "> <img style = "display : inline-block ;" class = "mySlides w3-animate-right" src ="<c:url value="resources/images/nokia_N8.jpg" />" alt ="nokia_N8"	height ="200" width ="300" /> </div>
						 <div class = "w3-card-4 "> <img class = "mySlides w3-animate-right" src ="<c:url value="resources/images/nokia_N9.jpg" />" alt ="nokia_N9"	height ="200" width ="300" /> </div>
						 <div class = "w3-card-4 "> <img class = "mySlides w3-animate-right" src ="<c:url value="resources/images/nokia_lumia530.jpg" />" alt ="nokia_lumia530"	height ="200" width ="300" /> </div>
						 <div class = "w3-card-4 "> <img class = "mySlides w3-animate-right" src ="<c:url value="resources/images/nokia_3110c.jpg" />"	height ="200" width ="300" /> </div>
						 <div class = "w3-card-4 "> <img class = "mySlides w3-animate-right" src ="<c:url value="resources/images/samsung_E5.jpg" />"	height ="200" width ="300" /> </div>
						 <div class = "w3-card-4 "> <img class = "mySlides w3-animate-right" src ="<c:url value="resources/images/samsung_guru.jpg" />" alt ="samsung_guru"	height ="200" width ="300" /> </div>
						 <div class = "w3-card-4 "> <img class = "mySlides w3-animate-right" src ="<c:url value="resources/images/samsung_galaxyS6.jpg" />" alt ="samsung_galaxyS6"	height ="200" width ="300" /> </div>
		   </div>
		   <div><button id = "signup" type = "button" class = "w3-btn w3-indigo w3-large w3-hover-blue w3-round">Sign up</button></div>
		   
		   <div id = "signupForm" class = "w3-card-8 w3-animate-top" style = "max-width:700px ;" align = "left">
					      <h1 class = "w3-text-indigo w3-padding-8"> Please provide following details : </h1>
	                      <form id = "signUp" action = "addNewCustomer">
	                            <label class = "w3-label w3-text-blue" > User name : </label>  <input class = "w3-input w3-animate-input" type = "text" id ="userName" name = "userName" /><br/><br/>
	                            <label class = "w3-label w3-text-blue" > First name : </label>  <input class = "w3-input w3-animate-input" type = "text"id = "firstName" name = "firstName" /><br/><br/>
		                        <label class = "w3-label w3-text-blue" > Last name : </label>  <input class = "w3-input w3-animate-input" type = "text" id = "lastName" name = "lastName" /><br/><br/>
		                        <label class = "w3-label w3-text-blue" > Email id : </label>  <input class = "w3-input w3-animate-input" type = "text" id = "email" name = "email" /><br/><br/>
		                        <label class = "w3-label w3-text-blue" > Phone number : </label>  <input class = "w3-input w3-animate-input" type = "text" id ="phone" name = "phone" /><br/><br/>
		                        <label class = "w3-label w3-text-blue" > Date of Birth : </label>  <input class = "w3-input w3-animate-input" type = "date" id ="DoB" name = "DoB" /><br/><br/>
		                        <label class = "w3-label w3-text-blue" > New password : </label>  <input class = "w3-input w3-animate-input" type = "password"id ="password"  name = "password" /><br/><br/>
		                        <label class = "w3-label w3-text-blue" > Confirm password : </label>  <input class = "w3-input w3-animate-input" type = "password" id ="cnfrm_pswrd" name = "cnfrm_pswrd" /><br/><br/>
						  
		                        <input class = "w3-btn w3-large w3-hover-blue w3-indigo" type = "submit" value = "Submit" /> 
	                       </form>
	       </div> 
		   
	  </div>
     <!-- --------------------------------------------------------------------------------------------------------- -->
	  <div id = "footer" class = "w3-container w3-text-dark-grey">
	        <h3> Developed by Shivank Chopra </h3>
	  </div>
	  <!---------------- include js scriprts  ----------------------------->
	  <script src = "<c:url value="resources/scripts/jquery.js" />" ></script>
	  <script src = "<c:url value="resources/scripts/jqueryValidate.js" />" ></script>
	  <script src = "<c:url value="resources/scripts/script2.js" />" ></script>
  </body>
</html>