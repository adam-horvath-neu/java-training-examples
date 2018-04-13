<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/training.css">
</head>
<body>
	<!-- Javascript sources -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="resources/js/training.js"></script>
	<!-- Javascript sources END -->

	<!-- Show/Hide example (navigation bar) -->
	<div class="navigation">
		<div id="item-1" class="nav-item">Item1</div>
		<div id="item-2" class="nav-item">Item2</div>
		<div id="item-3" class="nav-item">Item3</div>
	</div>
	<div class="contents">
		<div id="item-1-content" class="item-1 content">
			Add/remove class to element example.<br>
			<!-- 		Add/Remove class example (select) -->
			<div class="element">Element1</div>
			<div class="element">Element2</div>
			<div class="element">Element2</div>
		</div>
		<div id="item-2-content" class="item-2 content" style="display: none">
			Add/remove attribute to element example.<br>
			<!-- 		Add/Remove class example (select) -->
			<form id="contacts">
				<div id="message"></div>
				<div>
					<label for="username">Username:</label> <input id="username" name="username">
				</div>
				<div>
					<label for="password">Password:</label> <input id="password" name="password" type="password">
				</div>
				<div>
					<button id="save" disabled type="button">Save</button>
				</div>
			</form>
		</div>
		<div id="item-3-content" class="item-3 content" style="display: none">
			JQuery ajax example <br>
		</div>
	</div>
</body>
</html>