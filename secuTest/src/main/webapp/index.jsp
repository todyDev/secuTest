<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>INDEX</title>
</head>
<body>
<h1>Hello, World!</h1>
      <p><a href='<c:url value="/user/page"/>'>user</a></p>
      <p><a href='<c:url value="/admin/page"/>'>admin</a></p>
      <p><a href='<c:url value="/page"/>'>guest</a></p>
      <br><br>
      <sec:authorize access="isAuthenticated()">
      <p><a href='<c:url value="/logout"/>'>logout</a></p>
      </sec:authorize>
</body>
</html>