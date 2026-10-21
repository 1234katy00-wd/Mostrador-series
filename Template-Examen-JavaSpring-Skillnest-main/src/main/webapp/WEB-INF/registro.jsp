<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
	<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div class="nav">
        <div class="frase">
            <h1>TV Series</h1>
            <h2>Registro</h2>
        </div>
        <div class="botones">
            <a href="/login">Login</a>
            <a href="/registro">Registro</a>
        </div>
    </div>
	<div class="orden">
		<form:form action="/procesa/registro" method="POST" modelAttribute="usuario">
		
			<div>
				<form:label path="nombre">Nombre:</form:label>
				<form:input type="text" path="nombre" />
				<form:errors class="error" path="nombre" />
			</div>

			<div>
				<form:label path="apellido">Apellido:</form:label>
				<form:input type="text" path="apellido" />
				<form:errors class="error" path="apellido" />
			</div>

			<div>
				<form:label path="correo">Correo Electrónico:</form:label>
				<form:input type="text" path="correo" />
				<form:errors class="error" path="correo" />
			</div>

			<div>
				<form:label path="password">Contraseña:</form:label>
				<form:input type="password" path="password" />
				<form:errors class="error" path="password" />
			</div>

			<div>
				<form:label path="confirmarPassword">Confirmar Contraseña:</form:label>
				<form:input type="password" path="confirmarPassword" />
				<form:errors class="error" path="confirmarPassword" />
			</div>

			<div class="caja-btn">
				<input class="btn" type="submit" value="Registrarse" />
			</div>
        </div>
		</form:form>
		
</body>
</html>