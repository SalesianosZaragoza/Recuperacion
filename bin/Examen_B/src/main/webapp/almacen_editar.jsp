<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="es.salesianos.model.Almacen" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Editar Almacen</title>
</head>
<body>
	<div class="container-fluid">
		<div class="m-4">
			<nav class="navbar navbar-light bg-light justify-content-between">
			  	<a class="navbar-brand">Editar Almacen</a>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item p-1">
						<a href='/listadoAlmacenes' class="btn btn-primary" role="button" aria-disabled="true">Volver</a>
					</li>
				</ul>
			</nav>
		</div>
		<div class="p-4">
			<p>Modifica los campos que necesites a continuación.</p>
			<% Almacen almacen = (Almacen)request.getAttribute("almacen"); %>
			<form action="editarAlmacen" method="post">
				<div class="form-group">
					<label for="id">id</label>
					<input id="id" type="text" name="id" value="<%=almacen.getId()%>" readonly>
				</div>
				<div class="form-group">
					<label for="name">Nombre</label>
					<input id="nombre" type="text" name="nombre" value="<%=almacen.getName()%>">
				</div>
				<div class="form-group">
					<label for="oldNew">Tipo</label>
					<input id="oldNew" type="text" name="oldNew" value="<%=(almacen.isOld()) ? "old" : "new"%>" readonly>
				</div>
	 			<button type="submit" class="btn btn-primary">Actualizar</button>
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>