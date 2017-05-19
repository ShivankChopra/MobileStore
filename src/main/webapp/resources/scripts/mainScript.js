function addCart(){
	var x = "addCart/" + $("#userId").val();
	$.ajax({
        url : x,
        success : function(data) {
           
        },
	    faliure : function(){alert("cart was not added");}
    });
}

function addToCart(){
	var x = "addToCart/" + $("#userId").val() + "/" + this.id;
	$.ajax({
        url : x,
        success : function(data) {
            alert(data);
        }
    });
}

function removeFromCart(){
	var x = "removeFromCart/" + $("#userId").val() + "/" + this.id;
	var y = this.id;
	$.ajax({
        url : x,
        success : function(data) {
        	//alert(data);
        	$("#" + y + "item").hide();
        }
    });
}

function openCart(){
	var x = "getCart/" + $("#userId").val();
	$.ajax({
        url : x,
        dataType : 'json',
        success : function(cartData) {
            var string = '<ul class = "w3-ul w3-card-4 w3-hoverable">' ;
              // generate html   
            $.each(cartData.cartItems,function(index,value){
            	string += '<li id = "' + value.phone.id + 'item" class = "w3-padding-16">';
            	//string +=  '<div><img src = "<c:url value = "' + value.phone.imgLoc + '"/>" class = "w3-left w3-margin-right" height ="85" width ="90"/>';
            	string +=  '<span class = "w3-xlarge w3-text-blue">' + value.phone.company + '</span><br>';
            	string +=  '<span class = "w3-large w3-text-dark-grey">' + value.phone.model + '</span><br>';
            	string +=  '<span class = "w3-text-dark-grey">Quantity :' + value.quantity + '</span><br>';
            	string +=  '<span class = "w3-text-green">Total Price : Rs ' + value.totalPrice + '</span></div><br><br>';
            	string +=  '<input class = "w3-btn w3-round-xlarge w3-small w3-hover-deep-orange w3-red removeFromCart" id = "' + value.phone.id + '" type = "submit" value = "x Remove" />';
            	string +=  '</li>';
            }); 
            
            string += '</ul><br><br>';
            string += '<h3 class ="w3-text-dark-grey">Grand Total : <span class =w3-text-green>Rs ' + cartData.grandTotal + '</span></h3><br><br><br>';
            string += '<input class = "w3-btn w3-round w3-xlarge w3-hover-light-green w3-teal completeTransaction" type = "submit" value = "Complete Transaction" />';
            $("#container").html(string);
        }// end success
    }); 
}

function completeTransaction(){
	var x = "saveOrder/" + $("#userId").val();
	$.ajax({
        url : x,
        dataType : 'json',
        success : function(order) {
            var string = '<span class = "w3-xlarge w3-text-blue">Your order has been placed</span><br>';
            string += '<span class = "w3-large w3-text-dark-grey">Order Id : ' + order.orderId + '</span><br>';
            string += '<span class = "w3-large w3-text-dark-grey">Order Date : ' + order.orderDate + '</span><br>'
        	string += '<table class = "w3-table w3-border">';
        	string += '<tr>';
        	string +=       '<th>Company</th>';
        	string +=       '<th>Model</th>';
        	string +=       '<th>Quantity</th>';
        	string +=       '<th>Price</th>';
        	string += '</tr>';
              // generate html   
            $.each(order.cart.cartItems,function(index,value){
            	string += '<tr>';
            	string +=       '<td>' + value.phone.company + '</td>';
            	string +=       '<td>' + value.phone.model + '</td>';
            	string +=       '<td>' + value.quantity + '</td>';
            	string +=       '<td>' + value.totalPrice + '</td>';
            	string += '</tr>';
            }); 
            string += '</table>'
            string += '<h3 class ="w3-text-dark-grey">Grand Total : <span class =w3-text-green>Rs ' + order.cart.grandTotal + '</span></h3><br><br>';
            string += '<input class = "w3-btn w3-round w3-large w3-hover-blue w3-indigo continueshopping" type = "submit" value = "Continue shopping" /> ';
            string += '<input class = "w3-btn w3-round w3-large w3-hover-orange w3-red logout" type = "submit" value = "Logout" />';
            $("#container").html(string);
        }// end success
    }); 
}

function getPreviousOrders(){
	var x = "getPreviousOrders/" + $("#userId").val();
	$.ajax({
        url : x,
        dataType : 'json',
        success : function(prevOrders) {
            var string = '<span class = "w3-xlarge w3-text-blue">Purchase history</span><br>';
            $.each(prevOrders , function(index,order){
            
               string += '<span class = "w3-large w3-text-dark-grey">Order Id : ' + order.orderId + '</span><br>';
               string += '<span class = "w3-large w3-text-dark-grey">Order Date : ' + order.orderDate + '</span><br>'
        	   string += '<table class = "w3-table w3-border">';
        	   string += '<tr>';
        	   string +=       '<th>Company</th>';
        	   string +=       '<th>Model</th>';
        	   string +=       '<th>Quantity</th>';
        	   string +=       '<th>Price</th>';
        	   string += '</tr>';
                  // generate html   
               $.each(order.cart.cartItems,function(index,value){
            	   string += '<tr>';
            	   string +=       '<td>' + value.phone.company + '</td>';
            	   string +=       '<td>' + value.phone.model + '</td>';
            	   string +=       '<td>' + value.quantity + '</td>';
            	   string +=       '<td>' + value.totalPrice + '</td>';
                   string += '</tr>';
               }); 
               string += '</table>'
               string += '<h3 class ="w3-text-dark-grey">Grand Total : <span class =w3-text-green>Rs ' + order.cart.grandTotal + '</span></h3><br><br>';
               
            });
            $("#container").html(string);
        }// end success
    }); 
}

function logout(){
	var x = "removecart/" + $("#userId").val();
	$.ajax({
        url : x,
        success : function() {
            window.location = "welcome";
        }// end success
    }); 
}

$(document).ready(function(){
	addCart();
	$(".addToCart").click(addToCart);
	$("#cart").click(openCart);
	$("#prevOrders").click(getPreviousOrders);
	$("#logout").click(logout);
	$("#container").on("click","ul li .removeFromCart" ,removeFromCart);
	$("#container").on("click",".logout" ,logout);
	$("#container").on("click",".continueshopping" ,function(){
		window.location.reload(true);
	});
	$("#container").on("click",".completeTransaction" ,completeTransaction);
	$('#phones').click(function(){
		window.location.reload(true);
	});
});