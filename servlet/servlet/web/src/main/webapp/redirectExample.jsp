<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>

<template:template>
	<jsp:attribute name="title">
     Redirect
    </jsp:attribute>
	<jsp:attribute name="customHead">
     
    </jsp:attribute>
	<jsp:attribute name="header">
    Redirect 
    </jsp:attribute>
	<jsp:body>
		<form action="RedirectByParam">
			<div class="list-group">
				<button type="submit" class="list-group-item" name="page" value="WriterServlet">WriterServlet</button>
				<button type="submit" class="list-group-item" name="page" value="ForwardToPageServlet">ForwardToPageServlet</button>
				<button type="submit" class="list-group-item" name="page" value="ForwardServlet">ForwardServlet</button>
				<button type="submit" class="list-group-item" name="page" value="IncludePageServlet">IncludePageServlet</button>
				<button type="submit" class="list-group-item" name="page" value="IncludeServlet">IncludeServlet</button>
				<button type="submit" class="list-group-item" name="page" value="RediectToPageServlet">RediectToPageServlet</button>
				<button type="submit" class="list-group-item" name="page" value="RediectServlet">RediectServlet</button>
			</div>
		</form>
</jsp:body>
</template:template>
