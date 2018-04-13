<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<table>

		<tr>
			<td valign="top"><jsp:include page="menu.jsp"></jsp:include></td>
			<td>
				<table>
					<tr>
						<td><input id="autocomplete"> <script>
							$(function() {
								$("#autocomplete").autocomplete({
									source : "AutocompleteServlet",
									minLength : 2
								});
							});
						</script></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>


</body>
</html>
