<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<tiles:insertDefinition name="defaultLayout">
	<tiles:putAttribute name="header">Sikeres kijelentkezés!</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div></div>
	</tiles:putAttribute>
</tiles:insertDefinition>