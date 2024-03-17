<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div align=center>

		<div>
			<label for="">Amount:</label> <input type="text" name="amount"
				id="amount">
		</div>
		<div>
			
			<button onclick="payment()" id="rzp-button1">Pay</button>
		</div>
	</div>
</body>

<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script>
	function payment() {
		let amount = document.getElementById("amount").value;
		alert(amount);
		$.ajax({
			url : "form/razorePayment",
			data : JSON.stringify({
				amount : amount
			}),
			contentType : 'application/json',
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				console.log(response);
				if (response.status == "created") {
					let option = {
						key : 'rzp_test_MYgD2ZIiqsJiru',
						amount : response.amount,
						currency : 'INR',
						name : "CSM Technology",
						description : "Test Transaction",
						order_id : response.id,
						handler : function(response) {
							console.log(response);
							console.log("Payment Successful");
						},
						"prefill" : {
							"name" : "",
							"email" : "",
							"contact" : ""
						},
						"notes" : {
							"address" : "CSM Technology"
						},
						"theme" : {
							"color" : "#3399cc"
						},
					};
					let rzp = new Razorpay(option);
					rzp.on('payment.failed', function(response) {
						alert(response.error.code);
						alert(response.error.description);
						alert(response.error.source);
						alert(response.error.step);
						alert(response.error.reason);
						alert(response.error.metadata.order_id);
						alert(response.error.metadata.payment_id);
						alert("Payment Failed");
					});
					rzp.open();
				}
			},
			error : function(error) {
				console.log("Something went wrong");
			}
		})

	}
	/* var options = {
	
		"key" : "rzp_test_MYgD2ZIiqsJiru", // Enter the Key ID generated from the Dashboard
		"amount" : amount*100, // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
		"currency" : "INR",
		"name" : "CSM Technology",
		"description" : "Test Transaction",
		"image": "C:\\Users\\ritesh.parida\\Downloads\\download.png", */
	/* "order_id": "1",*///This is a sample Order ID. Pass the `id` obtained in the response of Step 1
	/* "handler" : function(response) {
		alert(response.razorpay_payment_id);
		alert(response.razorpay_order_id);
		alert(response.razorpay_signature);
		console.log(response);
	},
	"prefill" : {
		"name" : "",
		"email" : "",
		"contact" : ""
	},
	"notes" : {
		"address" : "CSM Technology"
	},
	"theme" : {
		"color" : "#3399cc"
	}
	};
	var rzp1 = new Razorpay(options);
	rzp1.on('payment.failed', function(response) {
	alert(response.error.code);
	alert(response.error.description);
	alert(response.error.source);
	alert(response.error.step);
	alert(response.error.reason);
	alert(response.error.metadata.order_id);
	alert(response.error.metadata.payment_id);
	}); 
	document.getElementById('rzp-button1').onclick = function(e) { 
	 rzp1.open();
	e.preventDefault(); 
	}  */
</script>
</html> --%>