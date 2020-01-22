<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add student</title>
<link type="text/css" rel="stylesheet"
  href="${pageContext.request.contextPath}/resources/css/style.css" />
<link type="text/css" rel="stylesheet"
  href="${pageContext.request.contextPath}/resources/css/add-student-style.css" />
</head>
<body>
  <div id="wrapper">
    <div id="header">
      <h2>University</h2>
    </div>
  </div>
  <div id="container">
    <h3>Add Student</h3>
    <form:form action="addstudent" method="POST"
      modelAttribute="student">
      <form:hidden path="id" />
      <table>
        <tbody>
          <tr>
            <td><label>First name:</label></td>
            <td><form:input path="firstName" /></td>
            <td><form:errors path="firstName" cssClass="error" /></td>
          </tr>
          <tr>
            <td><label>Last name:</label></td>
            <td><form:input path="surname" /></td>
            <td><form:errors path="surname" cssClass="error" /></td>
          </tr>
          <tr>
            <td><label>Age:</label></td>
            <td><form:input path="age" type="number" min="18"
                max="70" /></td>
          </tr>
          <tr>
            <td><label>Group name</label></td>
            <td><form:select path="group">
                <form:options items="${group_list}" itemValue="id"
                  itemLabel="name" />
              </form:select></td>
          </tr>
          <tr>
            <td><label></label></td>
            <td><input type="submit" value="Save" class="save" /></td>
          </tr>
        </tbody>
      </table>
    </form:form>
    <div style="clear: both;"></div>
    <p>
      <a href="./students">Back to list of students</a>
    </p>
  </div>
</body>
</html>
