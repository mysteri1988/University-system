<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
					<th>Student</th>
				</tr>
				<c:forEach var="tempStudent" items="${STUDENT_LIST}">
					<c:url var="tempLink" value="Students">
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>
					<tr>
						<td><a href="${tempLink}">${tempStudent.firstName}
								${tempStudent.surname}</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<p>
		<a href="/com.foxminded/">Back to the main page</a>
	</p>
</body>
</html>
