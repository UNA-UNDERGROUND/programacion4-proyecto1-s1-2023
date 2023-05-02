<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Administrador-Gestión de Marcas y Modelos</title>
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <!-- Icon library -->
    <link rel="stylesheet" href="styles/icons.css">

    <!-- Inicio Style -->
    <link href="styles/inicioStyle.css" rel="stylesheet">
</head>
<body>

<!-- Encabezado superior -->
<%@ include file="header.jsp" %>

<h2>Gestion de Marcas y Modelos</h2>

<!-- Formulario para agregar una marca -->
<h3>Agregar nueva marca</h3>
<form method="post" action="${pageContext.request.contextPath}/AgregarMarcaServlet">
    <label for="nombreMarca">Nombre de la marca:</label>
    <input type="text" name="nombreMarca" id="nombreMarca" required>
    <button type="submit">Agregar marca</button>
</form>

<hr>

<!-- Tabla de marcas existentes -->
<h3>Lista de marcas</h3>
<table>
    <tr>
        <th>Nombre de la marca</th>
        <th>Acciones</th>
    </tr>
    <c:forEach var="marca" items="${marcas}">
        <tr>
            <td>${marca.nombre}</td>
            <td>
                <a href="${pageContext.request.contextPath}/EditarMarcaServlet?id=${marca.id}">Editar</a> |
                <a href="${pageContext.request.contextPath}/EliminarMarcaServlet?id=${marca.id}">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
</table>

<hr>

<!-- Formulario para agregar un modelo -->
<h3>Agregar nuevo modelo</h3>
<form method="post" action="${pageContext.request.contextPath}/AgregarModeloServlet" enctype="multipart/form-data">
    <label for="nombreModelo">Nombre del modelo:</label>
    <input type="text" name="nombreModelo" id="nombreModelo" required>

    <label for="marca">Marca:</label>
    <select name="marca" id="marca">
        <c:forEach var="marca" items="${marcas}">
            <option value="${marca.id}">${marca.nombre}</option>
        </c:forEach>
    </select>

    <label for="imagenModelo">Imagen del modelo:</label>
    <input type="file" name="imagenModelo" id="imagenModelo" accept="image/*" required>

    <button type="submit">Agregar modelo</button>
</form>

<hr>

<!-- Tabla de modelos existentes -->
<h3>Lista de modelos</h3>


<table>
    <tr>
        <th>Nombre del modelo</th>
        <th>Marca</th>
        <th>Imagen del modelo</th>
        <th>Acciones</th>
    </tr>
    <c:forEach var="modelo" items="${modelos}">
        <tr>
            <td>${modelo.nombre}</td>
            <td>${modelo.marca.nombre}</td>
            <td><img src="${pageContext.request.contextPath}/${modelo.imagen}" alt="Imagen del modelo"></td>
            <td>
                <a href="${pageContext.request.contextPath}/EditarModeloServlet?id=${modelo.id}">Editar</a> |
                <a href="${pageContext.request.contextPath}/EliminarModeloServlet?id=${modelo.id}">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
</table>
<h3>Agregar nuevo modelo</h3>
<form method="post" action="${pageContext.request.contextPath}/AgregarModeloServlet" enctype="multipart/form-data">
    <label for="nombreModelo">Nombre del modelo:</label>
    <input type="text" name="nombreModelo" id="nombreModelo" required>

    <label for="marca">Marca:</label>
    <select name="marca" id="marca">
        <c:forEach var="marca" items="${marcas}">
            <option value="${marca.id}">${marca.nombre}</option>
        </c:forEach>
    </select>

    <label for="imagenModelo">Imagen del modelo:</label>
    <input type="file" name="imagenModelo" id="imagenModelo" accept="image/*" required>

    <button type="submit">Agregar modelo</button>
</form>
