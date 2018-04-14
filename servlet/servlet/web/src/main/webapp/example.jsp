sss
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="content">
	<div class="panel panel-default">
		<div class="panel-heading">Use bean</div>
		<div class="panel-body">


			<jsp:useBean id="date" class="java.util.Date"></jsp:useBean>

			Time:
			<jsp:getProperty property="time" name="date" />
			<br>

			<jsp:useBean id="formatter" class="java.text.SimpleDateFormat"></jsp:useBean>
			Formated date: ${formatter.format(date)}
		</div>
	</div>


	<div class="panel panel-default">
		<div class="panel-heading">Mixed</div>
		<div class="panel-body">


			<%
				SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy.MM.dd");
				pageContext.setAttribute("formatter2", formatter2);
			%>

			<c:out value="${formatter2.format(date)}" />
			<br>
			<%
 			out.print(formatter2.format(date));
			 %>
			<br>
			<c:out value="${formatter2.format(date)}" />
		</div>
	</div>


	<div class="panel panel-default">
		<div class="panel-heading">Custom bean</div>
		<div class="panel-body"><jsp:useBean id="bean"
				class="hu.neuron.java.bean.Bean">
				<jsp:setProperty property="date" name="bean" value="${date}" />
				<jsp:setProperty property="text" name="bean" value="${formatter2.format(date)}" />
			</jsp:useBean>
			date:
			<jsp:getProperty property="date" name="bean" />
			<br> text:
			<jsp:getProperty property="text" name="bean" />
		</div>
	</div>
</c:set>
<template:template>
	<jsp:attribute name="customHead">
     
    </jsp:attribute>
	<jsp:attribute name="header">
        <h1 class="page-header"> Example </h1>
    </jsp:attribute>


	<jsp:body>
	${content}
	</jsp:body>
</template:template>
