<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1 id="result"></h1>

	<ul>
		<li>
			<button type="button" onclick="getMesseageByGET()">getMesseageByGET</button>
		</li>
		<li><button type="button" onclick="getMesseageByPost()">getMesseageByPost</button>
		</li>
		<li><input type="text" id="message"></li>
		<li><button type="button" onclick="getMesseageByGETWithParam()">getMesseageByGETWithParam</button>
		</li>
		<li><button type="button" onclick="getMesseageByPostWithParam()">getMesseageByPostWithParam</button>
		</li>
	</ul>
	<script>
		function getMesseageByGET() {
			$.get("HelloWorldAjaxServlet", function(data) {
				$("#result").html(data);
			});

		}

		function getMesseageByPost() {
			$.post("HelloWorldAjaxServlet", function(data) {
				$("#result").html(data);
			});
		}

		function getMesseageByGETWithParam() {
			$.get('HelloWorldAjaxServletWithParam?message='+ $("#message").val(), 
				function(data) {
				$("#result").html(data);
			}).done(function() {
				alert("second success");
			}).fail(function() {
				alert("error");
			}).always(function() {
				alert("finished");
			});

		}
		
		function getMesseageByPostWithParam() {
			$.ajax({
				url : 'HelloWorldAjaxServletWithParam',
				data : {
					message : $("#message").val()
				},
				success : function(data) {
					$("#result").html(data);
				},
				dataType : "html"
			});
		}
	</script>
</body>
</html>