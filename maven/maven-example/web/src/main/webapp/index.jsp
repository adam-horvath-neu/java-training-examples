<%@page import="hu.neuron.java.service2.Service2"%>
<%@page import="hu.neuron.java.service1.Service1"%>
<html>
<body>
<h2>Service1 : <%=new Service1().hello() %></h2>
<h2>Service2 : <%=new Service2().hello() %></h2>
</body>
</html>
