<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/31
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form action="${pageContext.request.contextPath}/registerServlet">
    username:<input type="text"name="username"/> <br>
  password:  <input type="password" name="password"/><br>
    email:<input type="email" name="email"/><br>
    <input type="submit" value="注册"/>




</form>



</body>
<head>
    <title>Title</title>

</head>
</html>
