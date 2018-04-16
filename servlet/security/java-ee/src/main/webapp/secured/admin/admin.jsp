<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<tiles:insertDefinition name="defaultLayout">
	<tiles:putAttribute name="header">Admin</tiles:putAttribute>
	<tiles:putAttribute name="body">
		Admin content

	</tiles:putAttribute>
</tiles:insertDefinition>

</html>