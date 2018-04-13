// Wait until the DOM become ready
$(document).ready(function() {
	
	// Show/Hide example (navigation bar)
	$(".nav-item").click(function() {
		var id = $(this).attr('id')
		$("." + id).show();
		$(".contents .content:not(." + id + ")").hide();
	})
	
	// Add/Remove class example (select)
	$(".element").click(function() {
		var actualElement = $(this);
		if (actualElement.hasClass("selected")) {
			actualElement.removeClass("selected");
		} else {
			actualElement.addClass("selected");
		}
	});
	
	//Add/Remove attribute to element
	var contacts = $("#contacts #username, #contacts #password");
	var save = $("#contacts #save");
	contacts.blur(function() {
		var enable = true;
		contacts.each(function() {
			if (!$(this).val().trim()) {
				enable = false;
			} 
		});
		
		if (enable) {
			save.prop('disabled', false);
		} else {
			save.prop('disabled', true);
		}
	});
	
	save.click(function() {
		console.log("clicket");
		$.ajax({
			url : 'LoginServlet',
			type: "POST",
			data: {
				username: $("#contacts #username").val(),
				password: $("#contacts #password").val()
			},
			success : function(data) {
				console.log(data);
				var result = $.parseJSON(data);
				if (result.success) {
					$("#contacts #message").html("Successful login!").removeClass("failed").addClass("success");
				} else {
					$("#contacts #message").html("Invalid username/password!").removeClass("success").addClass("failed");
				}
			}
		});
	})
});