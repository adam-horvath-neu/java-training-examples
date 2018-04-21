<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>

<template:template>
	<jsp:attribute name="title">
     Target
    </jsp:attribute>
	<jsp:attribute name="customHead">
     
    </jsp:attribute>
	<jsp:attribute name="header">
    Target 
    </jsp:attribute>
	<jsp:body>
	<form class="form-horizontal" action="AdditionServlet">
	<div class="panel panel-default">
		<div class="panel-heading">From example</div>
		<div class="panel-body">
			<div class="form-group">
				<label class="control-label col-sm-2" for="text">res:</label> 
				<div class="col-sm-10">
				<input type="number" readonly="readonly" value="${requestScope.ret}">
			</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="text">a:</label>
				<div class="col-sm-10">
				 <input type="number" name="a">
				 </div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="text">b:</label>
				<div class="col-sm-10">
				 <input type="number" name="b">
				 </div>
			</div>
		</div>
		<div class="panel-footer">
			<input type="submit" value="Add" >
		</div>
	</div>
</form>

<form class="form-horizontal" action="AdditionServlet" method="post">
	<div class="panel panel-default">
		<div class="panel-heading">From example post</div>
		<div class="panel-body">
			<div class="form-group">
				<label class="control-label col-sm-2" for="text">res:</label> 
				<div class="col-sm-10">
				<input type="number" readonly="readonly" value="${requestScope.ret}">
			</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="text">a:</label>
				<div class="col-sm-10">
				 <input type="number" name="a">
				 </div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="text">b:</label>
				<div class="col-sm-10">
				 <input type="number" name="b">
				 </div>
			</div>
		</div>
		<div class="panel-footer">
			<input type="submit" value="Add" >
		</div>
	</div>
</form>
	
</jsp:body>
</template:template>

