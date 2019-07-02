<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add student</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>
<body>
  <div id="wrapper">
    <div id="header">
      <h2>University</h2>
    </div>
  </div>
  <div id="container">
    <h3>Add Student</h3>
    <form action="students" method="POST">
      <input type="hidden" />
      <table>
        <tbody>
          <tr>
            <td><label>First name:</label></td>
            <td><input type="text" name="firstName" /></td>
          </tr>
          <tr>
            <td><label>Last name:</label></td>
            <td><input type="text" name="surname" /></td>
          </tr>
          <tr>
            <td><label>Age:</label></td>
            <td><input type="number" name="age" min="18" max="70" /></td>
          </tr>
          <tr>
            <td><label>Group name</label></td>
            <td><select name="groupId">
                <c:forEach items="${group_list}" var="group">
                  <option value="${group.id}">${group.name}</option>
                </c:forEach>
            </select></td>
          </tr>
          <tr>
            <td><label></label></td>
            <td><input type="submit" value="Save" class="save" /></td>
          </tr>
        </tbody>
      </table>
    </form>
    <div style="clear: both;"></div>
    <p>
      <a href="./students">Back to list of students</a>
    </p>
  </div>
</body>
</html>
