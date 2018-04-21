<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<% 
		ArrayList<Date> arrayList = new ArrayList<Date>();
		arrayList.add(new Date(112, 10, 1));
		arrayList.add(new Date());
		arrayList.add(new Date());
		arrayList.add(new Date());
		arrayList.add(new Date(2012, 10, 1));
		pageContext.setAttribute("list", arrayList);
		
	%>


<template:template>
	<jsp:attribute name="title">
     Forward
    </jsp:attribute>
	<jsp:attribute name="customHead">
     
    </jsp:attribute>
	<jsp:attribute name="header">
 	 Forward
    </jsp:attribute>
	<jsp:body>
	<div class="panel panel-default">
		<div class="panel-heading">Import to variable</div>
		<div class="panel-body">
	
	<c:import url="/include/includeWithParam.jspf" var="jspPage"
					scope="page">
		<c:param value="Hello" name="message"></c:param>
	</c:import>

	<c:out value="${jspPage}" ></c:out>
	</div>
	</div>

	<div class="panel panel-default">
		<div class="panel-heading">forEach fix</div>
		<div class="panel-body">
			<div class="list-group">
	<c:forEach var="i" begin="1" end="5">
   <div class="list-group-item"> <c:out value="${i}" /> </div>
		
	</c:forEach>
	</div>
	</div>
	</div>
	
	<div class="panel panel-default">
		<div class="panel-heading">Other example</div>
		<div class="panel-body">
		
	<jsp:useBean id="date" class="java.util.Date"></jsp:useBean>
	
	<div class="list-group">
	<c:forEach var="var" items="${list}">
	 <div class="list-group-item">
  		Date: <c:out value="${date}" /> <br>
  		var: <c:out value="${var}" /> <br>
	
	Date formatted: 
	<fmt:formatDate pattern="yyyy.MM.dd HH:mm:ss.SS" value="${date}" />
	 <br>
		<c:choose>
			<c:when test="${var <date}">
				<font color="red"> var formatted: 
				<fmt:formatDate pattern="yyyy.MM.dd HH:mm:ss.SS" value="${var}" />
				</font>
			</c:when>
			<c:when test="${var >date}">
				<font color="green"> var formatted: 
				<fmt:formatDate pattern="yyyy.MM.dd HH:mm:ss.SS" value="${var}" />
				</font>
			</c:when>
			<c:otherwise>
      			var formatted: 
      			<fmt:formatDate pattern="yyyy.MM.dd HH:mm:ss.SS" value="${var}" />
			</c:otherwise>
		</c:choose>
 		<br>
		<fmt:formatDate pattern="yyyy.MM.dd" value="${var}"
								var="currentFormattedDate" />

		<fmt:formatDate pattern="yyyy.MM.dd" value="${date}"
								var="formattedDate" />


		<c:if test="${formattedDate eq currentFormattedDate}">
			<font color="blue">${date} </font>
		</c:if>

		</div>
	</c:forEach>
	</div>
	</div>
	</div>
</jsp:body>
</template:template>
