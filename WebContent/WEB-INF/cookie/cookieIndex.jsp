<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String message = (String) request.getAttribute("message"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookieIndex</title>
</head>
<body>
<p><%= message %></p>
<form action="CookieServlet" method="post" >
  <p>Name: <input type="text" name="name" size="10" /></p>
  <p>Pass: <input type="password" name="pass" size="10" /></p>
  <p><input type="submit" value="Login" /></p>
</form>
</body>
</html>