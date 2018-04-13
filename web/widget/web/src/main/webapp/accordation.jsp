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
			<tr> <td>
				<div id="accordion">
					<h3 id="1">Section 1</h3>
					<div>
							</div>
					<h3>Section 2</h3>
					<div>
						</div>
					<h3>Section 3</h3>
					<div>
						
					</div>
					<h3>Section 4</h3>
					<div>
								</div>
				</div> <script>
					$(function() {
						
						     $( "#accordion" ).accordion({
						        collapsible: true,
						        active : false,
						        activate: function (e, ui) {
							  $.get('ContentServlet?id='+ui.newHeader.attr('id'), function (data) {
							     $(ui.newHeader[0]).next().html(data);
							     $( "#accordion" ).accordion( "refresh" );
						          });
						        }
						     });
						
					});
				</script>
				</td>
				<td>
				<div id="accordion2">
					
								
				</div> <script>
				
					$(function() {
						$.ajax({
							url : 'ContentServlet',
							data : {
								list : true
							},
							success : function(data) {
								$.each(data, function(i, val) {
									$("#accordion2").append('<h3 id="'+val.id+'">'+val.title+'</h3><div></div>');
								});
								
								   $( "#accordion2" ).accordion({
								        collapsible: true,
								        active : false,
								        activate: function (e, ui) {
									  $.get('ContentServlet?id='+ui.newHeader.attr('id'), function (data) {
									     $(ui.newHeader[0]).next().html(data);
									     $( "#accordion2" ).accordion( "refresh" );
								          });
								        }
								     });
							},
							dataType : "json"
						});
						  
						
					});
				</script>
				</td>
				
					<td>
				<div id="accordion3">
					
								
				</div> <script>
				
					$(function() {
						$.ajax({
							url : 'ContentServlet',
							data : {
								list : true
							},
							success : function(data) {
								$.each(data, function(i, val) {
									$("#accordion3").append('<h3 id="'+val.id+'">'+val.title+'</h3><div></div>');
								});
								   $( "#accordion3" ).accordion({
								        collapsible: true,
								        active : false,
								        activate: function (e, ui) {
									  $.get('ContentServlet?html='+ui.newHeader.attr('id')+'.html', function (data) {
									     $(ui.newHeader[0]).next().html(data);
									     $( "#accordion3" ).accordion( "refresh" );
								          }).error(function(){
								        	  $(ui.newHeader[0]).next().html('Content not found!');  
								        	  $( "#accordion3" ).accordion( "refresh" );
								          });
								        }
								     });
							},
							dataType : "json"
						});
						  
						
					});
				</script>
				</td>
				
				
					<td>
				<div id="accordion4">
								<h3>
									<a href="content/A.html"></a>Section 1
								</h3>
								<div></div>
								<h3>
									<a href="content/B.html"></a>Section 2
								</h3>
								<div></div>
					</div> 
					<script>
				
					$(function() {
						
					   $( "#accordion4" ).accordion({
					        collapsible: true,
					        active : false,
					        activate: function (e, ui) {
					        	 var url = $(ui.newHeader[0]).children('a').attr('href');
						  $.get(url, function (data) {
						     $(ui.newHeader[0]).next().html(data);
						     $( "#accordion4" ).accordion( "refresh" );
					          }).error(function(){
					        	  $(ui.newHeader[0]).next().html('Content not found!');  
					        	  $( "#accordion4" ).accordion( "refresh" );
					          });
					        }
				
							
						});
						  
						
					});
				</script>
				</td>
				</tr>
				</table>
			</td>
		</tr>
	</table>


</body>
</html>
