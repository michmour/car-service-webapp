$( document ).ready(function() {

	// GET REQUEST
	$("#getUsers").click(function(event){
		event.preventDefault();
		ajaxGet();
	});


	// DO GET
	function ajaxGet(){
		$.ajax({
			type : "GET",
			url : '/admin/search/users',
			success: function(result){
//				if(result.status == "Done"){
					//$('#getResultDiv ul').empty();
				//	var custList = "";
				//	$.each(result.data, function(i, customer){
				//		var customer = "- Customer with Id = " + i + ", firstname = " + customer.name + ", lastName = " + customer.surname + "<br>";
					//	$('#getResultDiv .list-group').append(customer)
			        });
					console.log("Success: ", result);
//				}else{
//					$("#getResultDiv").html("<strong>Error</strong>");
//					console.log("Fail: ", result);
//				}
			},
			error : function(e) {
				$("#getResultDiv").html("<strong>Error</strong>");
				console.log("ERROR: ", e);
			}
		});
	}
})