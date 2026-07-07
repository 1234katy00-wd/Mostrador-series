<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Serie</title>
	<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div class="nav">
        <div class="frase">
            <h1>TV Serie</h1>
            <h2>Editar serie</h2>
        </div>
        <div class="botones">
            <a href="/inicio/series">Serie</a>
            <a href="/agregar/serie">Agregar serie</a>
            <a href="/logout">Logout</a>
        </div>
    </div>
	<div class="orden">
		<form:form action="/procesar/editar/serie" method="POST" modelAttribute="serie">
            <input type="hidden" name="_method" value="PUT" />

            <input type="hidden" name="id" value="${serie.id}" />
		
			<div>
				<form:label path="titulo">Título</form:label>
				<form:input type="text" path="titulo" />
				<form:errors class="error" path="titulo" />
			</div>

			<div>
				<form:label path="year">Año:</form:label>
				<form:input type="number" path="year" />
				<form:errors class="error" path="year" />
			</div>

			<div>
				<form:label path="descripcion">Descripción</form:label>
				<form:input type="text" path="descripcion" />
				<form:errors class="error" path="descripcion" />
			</div>

			<div>
				<form:label path="imagen">URL a imagen</form:label>
				<form:input type="text" class="img" path="imagen" />
				<form:errors class="error" path="imagen" />
			</div>

			<div>
				<form:label path="cantidad">Cantidad</form:label>
				<form:input type="number" path="cantidad" step="1"/>
				<form:errors class="error" path="cantidad" />
			</div>

            <div>
				<form:label path="precio">Precio</form:label>
				<form:input type="number" path="precio" />
				<form:errors class="error" path="precio" />
			</div>

            <input type="hidden" name="comprador.id" value="${idUsuario}" /> 
			
			<div class="botones-editar">
			</form:form>
			<input class="btn" type="submit" value="Editar" />  
            
			<form:form action="/eliminar/serie/${serie.id}" method="POST">
			
				<input type="hidden" name="_method" value="DELETE" />
				<input  class="btn-1" type="submit" value="Eliminar" />        
			</form:form>
			</div>
			
        </div>
		
</body>
</html>