<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags"%>
<template:template>
  
	<jsp:attribute name="title">
     Error
    </jsp:attribute>
	<jsp:attribute name="customHead">
     
    </jsp:attribute>
	<jsp:attribute name="header">
 	 Error
    </jsp:attribute>
	<jsp:body>

<div class="row">
			<div class="col-sm-11">
				<div class="row">
					<div class="" style="margin: 0 auto; word-break: break-word;">
						<div class="alert alert-danger" role="alert">
							<h2>
								<span class="glyphicon glyphicon-exclamation-sign"
									aria-hidden="true"></span>
								 <c:out value="Hiba történt:" />
								 ${pageContext.exception.message}
								
							</h2>
						</div>
					</div>
				</div>
			</div>
</div>

	<div class="row">
					<div class="" style="width: margin: 0 auto;">
						<div class="">
							<ul class="nav nav-tabs">
								<li><a data-toggle="tab"
							style="color: white; background-color: #048AB4;" href="#details"> <c:out
									value="Részletek" />
								</a></li>
								
							</ul>

							<div class="tab-content col-sm-11">
								<div id="details" class="tab-pane fade ">
									<p>
									
									<c:forEach var="stackTraceElem"
									items="${pageContext.exception.stackTrace}">
<c:out value="${stackTraceElem}" />
									<br />
</c:forEach>
									</p>
								</div>
								</div>
								</div>
								</div>
								</div>
								
</jsp:body>
</template:template>