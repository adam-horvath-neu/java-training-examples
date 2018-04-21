<%@page language="java"  contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

    <div class="blog-masthead">
      <div class="container">
        <nav class="blog-nav">
         
            <a class="blog-nav-item ${(fn:endsWith(pageContext.request.servletPath,'/index.jsp') ? 'active' :'') } " href="<c:url value="/index.jsp"/>" >Index</a>
            <a class="blog-nav-item ${(fn:endsWith(pageContext.request.servletPath,'/admin.jsp') ? 'active' :'') } " href="<c:url value="/secured/admin/admin.jsp"/>" >Admin</a>
          	<a class="blog-nav-item ${(fn:endsWith(pageContext.request.servletPath,'/manager.jsp') ? 'active' :'') } " href="<c:url value="/secured/manager/manager.jsp"/>" >Manager</a>
	        <a class="blog-nav-item ${(fn:endsWith(pageContext.request.servletPath,'/user.jsp') ? 'active' :'') } " href="<c:url value="/secured/user.jsp"/>" >User</a>
	        <a class="blog-nav-item ${(fn:endsWith(pageContext.request.servletPath,'/SecuredServlet') ? 'active' :'') } " href="<c:url value="/SecuredServlet"/>" >SecuredServlet</a>
	        <a class="blog-nav-item ${(fn:endsWith(pageContext.request.servletPath,'/SecuredSecuredServlet') ? 'active' :'') } " href="<c:url value="/SecuredSecuredServlet"/>" >SecuredSecuredServlet</a>
	     	<a class="blog-nav-item ${(fn:endsWith(pageContext.request.servletPath,'/LogOutServlet') ? 'active' :'') } " href="<c:url value="/LogOutServlet"/>" >LogOut</a>
			<div class="dropdown pull-right">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					Login <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><div class="form-horizontal" style="width: 300px; ">
							<div class="form-group">
								<label class="control-label col-sm-4" for="username">Login</label>
								<div class="col-sm-8">
									<input type="text" id="username">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4" for="password">Password</label>
								<div class="col-sm-8">
									<input type="password" id="password">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="button" class="btn btn-default"  id="login_button">Login</button>
								</div>
							</div>
						</div></li>
				</ul>
			</div>
		</nav>
      </div>
    </div>
  <script>
	$('#login_button').click(function() {

		$.ajax({
			url : "<c:url value="/LoginServlet"/>",
			data : {
				"username" : $('#username').val(),
				"password" : $('#password').val()
			}
		}).done(function(re) {
			if (re == 'OK') {
				alert('Hello!');
			} else {
				alert("Bad Credentials!");
			}
		}).fail(function() {
			alert("Error!");
		})

	});
</script>

