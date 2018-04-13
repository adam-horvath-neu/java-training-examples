$(document).ready(function() {
	var inputs = $("#login-form #username, #login-form #password");
	inputs.change(function() {
		var enabled = true;
		inputs.each(function(index, value) {
			if (!$(value).val()) {
				enabled = false;
			}
		});
		var loginButton = $("#login-form #login");
		if (enabled) {
			loginButton.prop('disabled', false);
		} else {
			loginButton.prop('disabled', true);
		}
		
		loginButton.click(function() {
			$.ajax({
				url: "LoginServlet",
				type: "POST",
				data: {
					username: $(inputs[0]).val(),
					password: $(inputs[1]).val()
				},
				success: function(data) {
					var result = $.parseJSON(data);
					if (result.success) {
						$("#login-form #message").html("Successful login!").removeClass("failed").addClass("success");
					} else {
						$("#login-form #message").html("Invalid username/password!").removeClass("success").addClass("failed");
					}
				}
			});
		});
	});
});