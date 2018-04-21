<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="custom" uri="WEB-INF/customTag.tld"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags"%>

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
	
	<div class="panel panel-default">
		<div class="panel-heading">Custom tag</div>
		<div class="panel-body">
		<custom:hello />
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">Custom tag with attribute</div>
		<div class="panel-body">
	<custom:helloAttr text="Hello" />
	</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">Custom jsp tag</div>
		<div class="panel-body">
	<tags:customJSPTag />
	</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">Custom jsp tag with attribute</div>
		<div class="panel-body">
	<tags:customJSPTagWithAttribute text="Hello Attribute" /> <br>
	<tags:customJSPTagWithAttribute text="Hello Attribute" />
	</div>
	</div>
</jsp:body>
</template:template>