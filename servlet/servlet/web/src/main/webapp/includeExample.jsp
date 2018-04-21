<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>

<template:template>
	<jsp:attribute name="title">
     Include
    </jsp:attribute>
	<jsp:attribute name="customHead">
     
    </jsp:attribute>
	<jsp:attribute name="header">
 	 Include
    </jsp:attribute>
	<jsp:body>
	<div class="panel panel-default">
    	<div class="panel-heading">Include Servlet</div>
    	<div class="panel-body">
			<jsp:include page="WriterServlet"></jsp:include>
		</div>
	</div>
	<div class="panel panel-default">
    	<div class="panel-heading">Include redirect.jspf</div>
    	<div class="panel-body">
			<%@ include file="/include/redirect.jspf"%>
		</div>
	</div>
	<div class="panel panel-default">
    	<div class="panel-heading">Include forward.jspf</div>
    	<div class="panel-body">
	<jsp:include page="/include/forward.jspf"></jsp:include>
		</div>
	</div>
	<div class="panel panel-default">
    	<div class="panel-heading">Include with param</div>
    	<div class="panel-body">
	<jsp:include page="/include/includeWithParam.jspf">
				<jsp:param value="Hello" name="message" />
	</jsp:include>
	<jsp:include page="/include/includeWithParam.jspf">
				<jsp:param value="Hello2" name="message" />
	</jsp:include>
	<jsp:include page="/include/includeWithParam.jspf">
				<jsp:param value="Hello3" name="message" />
	</jsp:include>
	</div>
	</div>
</jsp:body>
</template:template>
