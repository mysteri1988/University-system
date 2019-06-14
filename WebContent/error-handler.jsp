<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
</head>

<body>
  <c:set var="statusCode" value="${code}" />
  <c:choose>
    <c:when test="${statusCode==404}">
      <p style="text-align:center;font-size:20px">PAGE NOT FOUND<p>
      <h3>Error Details</h3>
      <strong>Status Code</strong>: ${code} <br>
      <strong>Requested URI</strong>: ${requesturi} <br>
    </c:when>
    <c:when test="${statusCode==400}">
      <h3>Error Details</h3>
      <strong>Status Code</strong>: ${code} <br>
      <strong>Requested URI</strong>: ${requesturi} <br>
      <strong>Error message</strong>: ${errormessage} <br>
    </c:when>
    <c:otherwise>
      <h3>Exception Details</h3>
      <ul>
        <li>Servlet Name: ${servletname}</li>
        <li>Exception Name: ${exception}</li>
        <li>Requested URI: ${requesturi}</li>
      </ul>
    </c:otherwise>
  </c:choose>
  <br>
  <a href="./university">Home Page</a>
</body>
</html>
