<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags"%>

<c:set var="content">
	<table>
		<tr>
			<th>Expression</th>
			<th>Value</th>
		</tr>
		<tr>
			<td>request.getAttribute("requestValue")</td>
			<td><%=request.getAttribute("requestValue")%></td>
		</tr>
		<tr>
			<td>$ {requestScope.requestValue}</td>
			<td>${requestScope.requestValue}</td>
		</tr>
		<tr>
			<td>session.getAttribute("sessionValue")</td>
			<td><%=session.getAttribute("sessionValue")%></td>
		</tr>
		<tr>
			<td>$ {sessionScope.sessionValue}</td>
			<td>${sessionScope.sessionValue}</td>
		</tr>
		<tr>
			<td>config.getServletContext().getAttribute("contextValue")</td>
			<td><%=config.getServletContext().getAttribute("contextValue")%></td>
		</tr>
		<tr>
			<td>$ {applicationScope.contextValue}</td>
			<td>${applicationScope.contextValue}</td>
		</tr>
	</table>
</c:set>
<template:template>

	<jsp:attribute name="title">
     Result
    </jsp:attribute>
	<jsp:attribute name="customHead">
     
    </jsp:attribute>
	<jsp:attribute name="header">
 	 Result
    </jsp:attribute>
	<jsp:body>
	${content}
</jsp:body>
</template:template>