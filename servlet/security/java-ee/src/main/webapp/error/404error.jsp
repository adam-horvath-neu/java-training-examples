<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<tiles:insertDefinition name="defaultLayout">
	<tiles:putAttribute name="header">404</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div class="alert alert-danger">
			<strong>Hiba!</strong> Nincs ilyen oldal!
		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>
</html>