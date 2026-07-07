<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio Series</title>
	<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div class="nav-1">
        <div class="frase">
            <h1>TV Serie</h1>
            <h2>Bienvenido de vuelta : <b>${usuarioEnSesion}</b></h2>
        </div>
        <div class="botones">
            <a href="/inicio/series">Serie</a>
            <a href="/agregar/serie">Agregar serie</a>
            <a href="/logout">Logout</a>
        </div>
    </div>
    <div id="contenedor-series">
	<div class="tarjetas">
    <c:forEach var="serie" items="${listaSeries}">

		<div class="gris">
            <div class="contenedor-imagen">
                <a href ="/detalle/serie/${serie.id}"><img src="${serie.imagen}" class="imagen" alt="imagen de serie" /></a>
            </div>
            <div class="contenido-tarjeta">
                <div>
                    <h3>${serie.titulo}</h3>
                    <p>Año: <b>${serie.year}</b></p>
                    <p>Precio: <b>${serie.precio}</b></p>
                </div>
                <a href="/editar/serie/${serie.id}"><img src="/img/lapiz.png" alt="editar"/></a>
            </div>
            
            
		</div>
    </c:forEach>
    </div>
    </div>
		
</body>
</html>