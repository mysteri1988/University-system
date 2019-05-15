<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student card</title>
</head>
<body>
  <div>
    <h2>Student personal card</h2>
  </div>
  <div>  
      <label for="firstName">Firstname:</label><b>${STUDENT.firstName}</b><br>
      <label for="lastName">Lastname:</label><b>${STUDENT.surname}</b><br>
      <label for="age">Age:</label><b>${STUDENT.age}</b><br>
      <label for="group">Group:</label><b>${GROUP.name}</b>
  </div>
</body>
</html>
