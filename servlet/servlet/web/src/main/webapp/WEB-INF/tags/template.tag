<%@ tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>
<%@attribute name="customHead" fragment="true"%>
<%@attribute name="title" fragment="true"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title><jsp:invoke fragment="title" /></title>

<link rel="stylesheet"
	href="http://cdn.ckeditor.com/4.5.7/standard-all/contents.css?t=G14D" />
<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<link href="<c:url value="/resources/css/blog.css"/>" rel="stylesheet">

<script src="<c:url value="/resources/js/jquery.js"/>"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

<jsp:invoke fragment="customHead" />

</head>

<body>

	<jsp:include page="/include/menu.jspf"></jsp:include>

	<div class="container">

		<div class="blog-header">
			<h1 class="blog-title">
				<jsp:invoke fragment="header" />
			</h1>

		</div>

		<div class="row">

			<div class="col-sm-12 blog-main">

				<div class="blog-post">
					<jsp:doBody />

				</div>
			</div>

			
			
		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<footer class="blog-footer">
		<p>
			Blog template built for <a href="http://getbootstrap.com">Bootstrap</a>
			by <a href="https://twitter.com/mdo">@mdo</a>.
		</p>
		<p>
			<a href="#">Back to top</a>
		</p>
	</footer>
</body>

</html>

