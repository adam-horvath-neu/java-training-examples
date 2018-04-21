<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>

<template:template>
	<jsp:attribute name="title">Home</jsp:attribute>
	<jsp:attribute name="customHead"></jsp:attribute>
	<jsp:attribute name="header">Home</jsp:attribute>
	<jsp:body>
	<div class="list-group"> 
		<a class="list-group-item" href="WriterServlet">WriterServlet</a>
		<a class="list-group-item" href="ForwardToPageServlet">ForwardToPageServlet</a>
		<a class="list-group-item" href="ForwardServlet">ForwardServlet</a>
		<a class="list-group-item" href="IncludePageServlet">IncludePageServlet</a>
		<a class="list-group-item" href="IncludeServlet">IncludeServlet</a>
		<a class="list-group-item" href="RediectToPageServlet">RediectToPageServlet</a>
		<a class="list-group-item" href="RediectServlet">RediectServlet</a>
	</div>	 

</jsp:body>
</template:template>
