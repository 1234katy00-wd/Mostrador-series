<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalle Series</title>
	<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div class="nav-1">
        <div class="frase">
            <h1>TV Serie</h1>
            <h2>${serie.titulo}</h2>
        </div>
        <div class="botones">
            <a href="/inicio/series">Serie</a>
            <a href="/agregar/serie">Agregar serie</a>
            <a href="/logout">Logout</a>
        </div>
    </div>
    <div class="detalle">
        <div class="imagen-detalle">
                <img src="${serie.imagen}" class="imagen-1" alt="imagen de serie" />
            </div>
            <div class="contenedor-detalle">
                <p>Usuario que publicó esta serie: <b>${serie.comprador.nombre}</b></p>
                <p>Descripción: <b>${serie.descripcion}</b></p>
                <p>Precio: <b>${serie.precio}</b></p>
                <p>Cantidad: <b>${serie.cantidad}</b></p>
            </div>   
    </div>
		
</body>
</html>