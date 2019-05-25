<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of groups</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
  <div id="wrapper">
    <div id="header">
      <h2>University</h2>
    </div>
  </div>
  <div id="container">
    <div id="content">
      <table>
        <tr>
          <th>Groups</th>
        </tr>
        <c:forEach var="group" items="${group_list}">
          <c:url var="groupLink" value="group">
            <c:param name="id" value="${group.id}" />
          </c:url>
          <tr>
            <td><a href="${groupLink}">${group.name}
                </a></td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </div>
  <p>
    <a href="./university">Back to the main page</a>
  </p>
</body>
</html>