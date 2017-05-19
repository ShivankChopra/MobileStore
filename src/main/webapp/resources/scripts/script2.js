
var currentIndex = 0 ;
var items = $("#imgs div");
var noItems = items.length;
var flag = false;
// display image at current index in items
function cyclePhotos(){
	var item = $("#imgs div").eq(currentIndex);
	items.hide();
	item.css("display","inline-block");
}

$(document).ready(function(){
	$("#signupForm").hide();
	
	$('#signup').click(function(){
		
		if(flag == true){
			$("#signupForm").hide();
			flag = false;
        }
		else{
			flag = true;
			$("#signupForm").show();
		}	
		return false;
	});
	var autoSlide = setInterval(function(){
		currentIndex += 1;
		if(currentIndex > noItems - 1 ){
			currentIndex = 0 ;
		}
		cyclePhotos();
	} , 3000); // end set interval
	
	$("#signUp").validate({
        rules: {
        	userName : "required",
            firstName: "required",
            lastName: "required",
            email: {
                required: true,
                email: true
            },
            phone : {
            	required : true,
            	minlength : 10,
            	maxlength : 10,
            	digits : true
            },
            DoB : {
            	required : true,
            	date : true
            },
            password: {
                required: true,
                minlength: 8
            },
            cnfrm_pswrd : {
            	equalTo: "#password"
            }
        },
        messages: {
        	userName: "Please enter your firstname",
            firstName: "Please enter your firstname",
            lastName: "Please enter your lastname",
            email: {
            	required : "Please enter your email address",
            	email : "Please enter a valid email address"
            },
            phone : {
            	required : "Please enter your phone number",
            	minlength : "must be 10 digits long",
            	maxlength : "must be 10 digits long",
            	digits : true
            },
            DoB : {
            	required : "Please enter your D.O.B",
            	date : "not a valid date"
            },
            password: {
                required: "Please provide a password",
                minlength: "Password must have at least 8 characters"
            },
            cnfrm_Pswrd: {
                equalTo : "Passwords do not match"
            }
            
        },
        submitHandler: function(form) {
            form.submit();
        }
    });  
	
	$("#login").validate({
        rules: {
        	username : "required",
            password: {
                required: true,
                minlength: 8
            }    
        },
        messages: {
        	username: "Please enter your firstname",
            password: {
                required: "Please provide a password",
                minlength: "Password must have at least 8 characters"
            }
        },
        submitHandler: function(form) {
            form.submit();
        }
    });  

});