<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<jsp:include page="header.jsp"></jsp:include>
<script src="resources/datatable/js/jquery.dataTables.js"></script>
<link href="resources/datatable/css/jquery.dataTables_themeroller.css"
	rel="stylesheet">
<style>


.demoHeaders {
	margin-top: 2em;
}

a{
	padding: .4em 1em .4em 20px;
	text-decoration: none;
	position: relative;
}

a span.ui-icon {
	margin: 0 5px 0 0;
	position: absolute;
	left: .2em;
	top: 50%;
	margin-top: -8px;
}

#icons {
	margin: 0;
	padding: 0;
}

#icons li {
	margin: 2px;
	position: relative;
	padding: 4px 0;
	cursor: pointer;
	float: left;
	list-style: none;
}

#icons span.ui-icon {
	float: left;
	margin: 0 4px;
}

.fakewindowcontain .ui-widget-overlay {
	position: absolute;
}

select {
	width: 200px;
}
</style>
<script>
	function create() {
		table = $('#example').dataTable({
			"bJQueryUI" : true,
			"ajax" : "DataServlet?op=get",

			"columns" : [ {
				"data" : "id"
			}, {
				"data" : "name"
			}, {
				"data" : "role"
			}, {
				"data" : "date"
			}

			]
		});

		$('#example tbody tr').click(function() {
			console.log(this);
			if ($(this).hasClass('selected')) {
				$(this).removeClass('selected');
			} else {
				table.$('tr.selected').removeClass('selected');
				$(this).addClass('selected');
			}
		});

	}

	$(document).ready(function() {
		create();

		$("#dialog").dialog({
			autoOpen : false,
			width : 400,
			buttons : [ {
				text : "Save",
				click : function() {
					$.ajax({
						url : 'DataServlet',
						data : {
							op : 'add',
							name : $('#name').val(),
							role : $('#role').val(),
							date : $('#date').val(),
						},
						success : function(data) {
							$("#dialog").dialog("close");
							$('#example').dataTable().fnDestroy();
							create();
						},
						dataType : "html"
					});

				}
			}, {
				text : "Cancel",
				click : function() {
					$(this).dialog("close");
				}
			} ]
		});

		$("#dialog-link").click(function(event) {
			$("#dialog").dialog("open");
			$("#date").datepicker({
				dateFormat : "yy.mm.dd"
			});
			event.preventDefault();
		});

		$("#delete").click(function(event) {

			var id = $($('#example tr.selected td')[0]).html();

			$.ajax({
				url : 'DataServlet',
				data : {
					op : 'del',
					id : id,

				},
				success : function(data) {
					$("#udialog").dialog("close");
					$('#example').dataTable().fnDestroy();
					create();
				},
				dataType : "html"
			});

		});

		
		
		$("#udialog").dialog({
			autoOpen : false,
			width : 400,
			buttons : [ {
				text : "Update",
				click : function() {
					$.ajax({
						url : 'DataServlet',
						data : {
							op : 'update',
							id : $('#id').val(),
							name : $('#uname').val(),
							role : $('#urole').val(),
							date : $('#udate').val(),
						},
						success : function(data) {
							$("#udialog").dialog("close");
							$('#example').dataTable().fnDestroy();
							create();
						},
						dataType : "html"
					});

				}
			}, {
				text : "Cancel",
				click : function() {
					$(this).dialog("close");
				}
			} ]
		});

		
		$("#update").click(function(event) {
			$("#udialog").dialog("open");
			var cells = $('#example tr.selected td');
			var id = $(cells[0]).html();
			var name = $(cells[1]).html();
			var role = $(cells[2]).html();
			var date = $(cells[3]).html();
			 var pdate  =new Date(date);
			$('#uname').val(name);
			$('#urole').val(role);
			$('#udate').val(pdate.getFullYear() +'.'+ pdate.getMonth() + '.' + pdate.getDate()   );
			$('#id').val(id);
			
			$("#udate").datepicker({
				dateFormat : "yy.mm.dd"
			});
			
// 			$("#udate").datepicker( "setDate", $('#udate').val(date) );
			event.preventDefault();
		});

	});
</script>

</head>
<body>
	<table>

		<tr>
			<td valign="top"><jsp:include page="menu.jsp"></jsp:include></td>
			<td>
				<table>
					<tr>
						<td colspan="3"><table id="example" class="display"
								cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>ID</th>
										<th>Name</th>
										<th>Role</th>
										<th>Date</th>

									</tr>
								</thead>


							</table></td>
					</tr>
					<tr>
						<td><a href="#" id="dialog-link"
							class="ui-state-default ui-corner-all"><span
								class="ui-icon ui-icon-newwin"></span>Add</a>
						<td><td>
						<a href="#" id="delete"
							class="ui-state-default ui-corner-all"><span
								class="ui-icon ui-icon-newwin"></span>Delete</a><td>
						<td><a href="#" id="update"
							class="ui-state-default ui-corner-all"><span
								class="ui-icon ui-icon-newwin"></span>Update</a>
						<td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<div id="dialog" title="Dialog Title">
		<table>

			<tr>
				<td>Name</td>
				<td><input id="name" type="text"></td>
			</tr>
			<tr>
				<td>Role</td>
				<td><input id="role" type="text"></td>
			</tr>
			<tr>
				<td>Date</td>
				<td><input id="date" type="text"></td>
			</tr>

		</table>

	</div>

	<div id="udialog" title="Dialog Title">
		<table>
<input id="id" type="hidden">
			<tr>
				<td>Name</td>
				<td><input id="uname" type="text"></td>
			</tr>
			<tr>
				<td>Role</td>
				<td><input id="urole" type="text"></td>
			</tr>
			<tr>
				<td>Date</td>
				<td><input id="udate" type="text"></td>
			</tr>

		</table>

	</div>

</body>
</html>
