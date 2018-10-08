<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

<title>LOGIN</title>
</head>
<body>
       <br><br>
       <div class="container col-4">
           <form class="px-4 py-3" action='<c:url value='/secu/login'/>' method="post">
               <div class="form-group">
                   <label>ID</label>
                   <input type="text" class="form-control" name="loginId" placeholder="example">
               </div>
               <div class="form-group">
                   <label>Password</label>
                   <input type="password" class="form-control" name="loginPwd" placeholder="password">
               </div>
               <c:if test="${fail }">
               	<div class="form-group">
               		<p style="color:red">실패: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }</p>
               	</div>
               </c:if>
               
               <div class="form-check">
                   <label class="form-check-label">
                   <input type="checkbox" class="form-check-input">
                   Remember me
                   </label>
               </div>
               <button type="submit" class="btn btn-primary">Sign in</button>
           </form>
           <div class="dropdown-divider"></div>
           <a class="dropdown-item" href="#">New around here? Sign up</a>
           <a class="dropdown-item" href="#">Forgot password?</a>
           <a class="dropdown-item" href='<c:url value="/"/>'>back</a>
       </div>
</body>
</html>