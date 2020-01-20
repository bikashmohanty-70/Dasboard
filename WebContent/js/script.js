
//Date Picker Bootstarp
$(document).ready(function () {
	var loading = true;
	$('#validationCustom03').datepicker({
		uiLibrary: 'bootstrap'
	});

	// Enable Disable Submit BUttons
	//*********************************
	$('.form-group input').on('keyup', function() {
		let empty = false;

		$('.form-group input').each(function() {
			if ($(this).val().length == 0) {
				empty = true;
			}
		});

		if (empty)
			$('.actions input').attr('disabled', 'disabled');
//		else if(loading==false)
//			$('.actions input').attr('disabled', 'disabled');
		else
			$('.actions input').attr('disabled', false);
	});


	/************************************************************************/
	//Validation Uniqueness
	/************************************************************************/

	$('#validationCustom04, #confirm_password').on('keyup', function () {
		if ($('#validationCustom04').val() == $('#confirm_password').val()) {
			$('#passwordErrorSection').html('Matching').css('color', 'green');
		} else{
			$('#passwordErrorSection').html('Password Mismatch').css('color', 'red');
			$('#confirm_password').css({"box-shadow": "0 0 5px red"});
			loading = false;
		}

	});
	
	
	$('#validationCustom10').blur(function(){
		var myEmail = $('#validationCustom10').val();
		
		$.ajax({
			type: 'post',
			data: {emailId:myEmail},
			url: 'Uniqueness',
			success: function(response){
				$('#emailErrorSection').text(response);
				loading = false;
			},
			error: function(XMLHttpRequest, textStatus, errorThrown){
				$('#emailErrorSection').text("");
				loading = true;
			}
		});
	});
	

//	$("#validationCustom10").blur(function(){
//		let mailId = $('#validationCustom10').val();
//		$.post('Registration', {emailId:mailId}, function(responseText){
//			$('#emailErrorSection').text(responseText).css("color","red")
////			$('#validationCustom10').focus()
////			loading = false;
//		});
//	});

//	let usernameError = true;
//	let emailError = true;
//	let contactError = true;

	//this will stop the submit of the form but allow the native HTML5 validation (which is what i believe you are after)
//	$("form").on('submit',function(e){
//	    e.preventDefault();
//	    //ajax code here
//	});
	
	
	
//	$("#validationCustom10").blur(function(){
//	validateMail();
//	});
////	$().blur(function(){

////	});
//	function validateMail(){
////	$("#validationCustom10").blur(function(){
//	let mailId = $("#validationCustom10").val();
//	$.ajax({
//	url: 'Registration',
//	method: 'post',
//	data: {emailId:mailId},
//	success: function(response) {
////	$("#emailErrorSection").text(response);
//	if(response == "EXISTS"){
//	$("#emailErrorSection").text("This Mail is already Registered");
////	$("#enableOnInput").attr("disabled", true);
//	$("#enableOnInput").on('click', function(){
//	alert("Nope");
//	$("#validationCustom10").focus();
//	});
////	$("#validationCustom10").focus();
//	console.log(response);
//	}
//	else{
////	$("#validationCustom10").blur();
//	$("#emailErrorSection").html("");
//	}
//	}	
//	})
////	});
//	}


//	function email_validation(){
//	let emailID = $('#validationCustom10').val();

//	}


	$("#validationCustomUsername").blur(function(){
		let uname = $('#validationCustomUsername').val();
		$.post('Uniqueness', {userName:uname}, function(responseText){
			$('#usernameErrorSection').text(responseText).css("color","blue")
//			loading = false;
		});
	});
//
	$("#validationCustom06").blur(function(){

		let contact = $('#validationCustom06').val();
		$.post('Uniqueness', {number:contact}, function(responseText){
			$('#contactErrorSection').text(responseText).css("color","red")
//			loading = false;
		});

	});
	
//	
//	$('#history').click(function(){
//		$.get('fetchUserDetails',)
//	});
	
});



//$('#vicky').ready(function(){
//alert("Heklo");
//});

//Form validation
//(function() {
//	'use strict';
//	window.addEventListener('load', function() {
//		// Fetch all the forms we want to apply custom Bootstrap validation styles to
//		var forms = document.getElementsByClassName('needs-validation');
//		// Loop over them and prevent submission
//		var validation = Array.prototype.filter.call(forms, function(form) {
//			form.addEventListener('submit', function(event) {
//				if (form.checkValidity() === false) {
//					event.preventDefault();
//					event.stopPropagation();
//				}
////				if(loading == false){
////					event.preventDefault();
////					event.stopPropagation();
////				}
//				form.classList.add('was-validated');
//			}, false);
//		});
//	}, false);
//})();






function hideDiv(){
	document.getElementById("passwordErrorSection").innerHTML = "";
	document.getElementById("confirm_password").style.boxShadow = "";
}

function disabaleButton(){
	document.getElementById('enableOnInput').disabled = true;
}






//jQuery.validator.setDefaults({
//debug: true,
//success: "valid"
//});
//$( "#myform" ).validate({
//rules: {
//password: "required",
//password_again: {
//equalTo: "#password"
//}
//}
//});
/*******************************************************************************************/
//active and inactive menu
//$('.nav-pills').on('click','a',function(){
//$('.nav-pills .active').removeClass("active");
//$(this).addClass("active");
//})
