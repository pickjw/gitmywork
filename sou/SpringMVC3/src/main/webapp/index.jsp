<%
  //response.sendRedirect("http://localhost:8090/SpringMVC3/hello.do");
response.sendRedirect(request.getContextPath()+"/hello.do");
%>