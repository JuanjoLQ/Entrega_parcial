<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="mistags" prefix="dad" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<dad:lugar nombre="login"/>

	
<form action = "Control" method = "post">

	<input type="hidden" name="IDACCION" value="LOGIN">
	Usuario: <input type="text" name="USERNAME">
	Contraseña: <input type="text" name="PASS">
	<input type="submit" value="Entrar">


</form>












</body>
</html>