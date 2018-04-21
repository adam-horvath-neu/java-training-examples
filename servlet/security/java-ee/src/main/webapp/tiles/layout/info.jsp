
<%@page import="java.util.Collection"%>
<%@page import="java.security.Principal"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<div class="alert alert-info">
	<strong>getAuthType:</strong> ${pageContext.request.authType}
</div>

<div class="alert alert-info">
	<strong>isUserInRole("admin")</strong>
	${pageContext.request.isUserInRole('ADMIN')}
</div>

<div class="alert alert-info">
	<strong>getProtocol()</strong> ${pageContext.request.protocol}
</div>

<div class="alert alert-info">
	<strong>isSecure() </strong>${pageContext.request.secure}
</div>

<div class="alert alert-info">
	<strong>getUserPrincipal().getClass() </strong>${pageContext.request.userPrincipal.getClass()}
</div>

<div class="alert alert-info">
	<strong>getUserPrincipal() </strong>${pageContext.request.userPrincipal}
</div>

<div class="alert alert-info">
	<strong>getUserPrincipal().getName(); </strong>
	<c:if test="${pageContext.request.userPrincipal!=null}">
		${pageContext.request.userPrincipal.name}
	</c:if>

</div>

<div class="alert alert-info">
	<strong>isRequestedSessionIdValid() </strong>${pageContext.request.requestedSessionIdValid}
</div>


<div class="alert alert-info">
	<strong>Roles </strong>
	
	<c:if test="${pageContext.request.userPrincipal!=null}">
		<ul>
		<c:forEach items="${pageContext.request.userPrincipal.roles}" var="role">
		<li>${role} -${role.getRolename()} </li>
		</c:forEach>
		</ul>
	</c:if>

</div>
