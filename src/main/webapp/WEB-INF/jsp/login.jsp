<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="mistags" prefix="dad" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<tiles:insertDefinition name="banner.login" />

<form action = "Control" method = "post">

	<input type="hidden" name="IDACCION" value="LOGIN">
	Usuario: <input type="text" name="USERNAME">
	Contrasena: <input type="text" name="PASS">
	<input type="submit" value="Entrar">


</form>














</body>
</html>