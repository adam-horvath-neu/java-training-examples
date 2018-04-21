<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<tiles:insertAttribute name="head" />
</head>
<body>


	<tiles:insertAttribute name="menu" />
	<div class="container">

		<div class="blog-header">
			<h1 class="blog-title">
				<tiles:insertAttribute name="header" />
			</h1>

		</div>

		<div class="row">

			<div class="col-sm-6 blog-main">

				<div class="blog-post">

					<tiles:insertAttribute name="body" />
				</div>
			</div>
 
			<div class="col-sm-5 col-sm-offset-1 blog-sidebar">
				<div class="sidebar-module sidebar-module-inset">
					<h4>Info</h4>
					<tiles:insertAttribute name="info" />
				</div>
				
				
			</div>
			<!-- /.blog-sidebar -->

		</div>
		<!-- /.row -->

	</div>
	<footer class="blog-footer"> <tiles:insertAttribute
		name="footer" />
	</div>
	</footer>
</body>

</html>
