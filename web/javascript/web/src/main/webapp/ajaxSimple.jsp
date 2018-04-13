<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

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
			var xhr = new XMLHttpRequest();

			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					var data = xhr.responseText;
					document.getElementById("result").innerHTML = data;
				}
			}

			xhr.open('GET', 'HelloWorldAjaxServlet', true);
			xhr.send(null);
		}

		function getMesseageByPost() {
			var xhr = new XMLHttpRequest();

			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					var data = xhr.responseText;
					document.getElementById("result").innerHTML = data;
				}
			}

			xhr.open('POST', 'HelloWorldAjaxServlet', true);
			xhr.send(null);
		}

		function getMesseageByGETWithParam() {
			var xhr = new XMLHttpRequest();

			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					var data = xhr.responseText;
					document.getElementById("result").innerHTML = data;
				}
			}
			var val = document.getElementById("message").value;
			xhr.open('GET', 'HelloWorldAjaxServletWithParam?message=' + val,
					true);
			xhr.send(null);
		}
		function getMesseageByPostWithParam() {
			var xhr = new XMLHttpRequest();

			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					var data = xhr.responseText;
					document.getElementById("result").innerHTML = data;
				}
			}

			var val = document.getElementById("message").value;
			xhr.open('POST', 'HelloWorldAjaxServletWithParam?message=' + val,
					true);

			xhr.send(null);
		}
	</script>
</body>
</html>