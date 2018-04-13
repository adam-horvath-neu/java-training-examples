<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<body>
	<h2>Hello World!</h2>

	<ul>
		<li><a href="ajaxSimple.jsp">ajaxSimple.jsp</a></li>
		<li><a href="ajaxjQuery.jsp">ajaxjQuery.jsp</a></li>
		<li><a href="ajaxjQueryJSON.jsp">ajaxjQueryJSON.jsp</a></li>
		<li><a href="ajaxjQueryXML.jsp">ajaxjQueryXML.jsp</a></li>
	</ul>

	<table>
		<tr>
			<td colspan="4"><input id="res" readonly="readonly" type="text"></td>
		</tr>
		<tr>
			<td><input id="in" type="text"></td>
			<td><button type="button" id="add">+</button></td>
			<td><button type="button" id="minus">-</button></td>
			<td><button type="button" id="div">/</button></td>
			<td><button type="button" id="multiply">*</button></td>
		</tr>
	</table>

	<script type="text/javascript">
		var add = function add(result, a) {
			return result + a;
		};

		var minus = function minus(result, a) {
			return result - a;
		};

		var div = function div(result, a) {
			return result / a;
		};

		var multiply = function multiply(result, a) {
			return result * a;
		};

		$(document).ready(function() {
			var calculator = {
				result : new Number(1),
				a : undefined,
				operator : undefined,
				doOperator : function() {
					this.result = this.operator(this.result, this.a);
				}
			};

			$("#res").val(calculator.result);

			$("#add").click(function() {
				calculator.a = $("#in").val();
				calculator.operator = div;
				calculator.doOperator();
				$("#res").val(calculator.result);
			});

		});
	</script>


</body>
</html>
