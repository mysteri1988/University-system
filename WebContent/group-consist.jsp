<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of students</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
  <div id="wrapper">
    <div id="header">
      <h2>University</h2>
      <h3>${group.name}</h3>
    </div>
  </div>
  <div id="container">
    <div id="content">
      <table>
        <tr>
          <th>Student</th>
        </tr>
        <c:forEach var="student" items="${student_list}">
          <c:url var="studentLink" value="studentcard">
            <c:param name="id" value="${student.id}" />
          </c:url>
          <tr>
            <td><a href="${studentLink}">${student.firstName}
                ${student.surname}</a></td>
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
