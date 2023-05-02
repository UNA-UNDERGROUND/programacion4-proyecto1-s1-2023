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

<h3>Lista de categor&iacute;as y coberturas</h3>
<table>
    <tr>
        <th>Categor&iacute;a</th>
        <th>Cobertura</th>
        <th>Costo porcentual del valor asegurado</th>
    </tr>
    <c:forEach var="categoria" items="${categorias}">
        <c:forEach var="cobertura" items="${categoria.coberturas}">
            <tr>
                <c:if test="${cobertura.index == 0}">
                    <td rowspan="${categoria.coberturas.length}">${categoria.descripcion}</td>
                </c:if>
                <td>${cobertura.descripcion}</td>
                <td>${cobertura.costoPorcentual}</td>
            </tr>
        </c:forEach>
    </c:forEach>
</table>
<h3>Agregar nueva categor&iacute;a</h3>
<form method="post" action="${pageContext.request.contextPath}/AgregarCategoriaServlet">
    <label for="descripcionCategoria">Descripci&oacute;n:</label>
    <input type="text" name="descripcionCategoria" id="descripcionCategoria" required>
    <button type="submit">Agregar categor&iacute;a</button>
</form>
<h3>Agregar nueva cobertura</h3>
<form method="post" action="${pageContext.request.contextPath}/AgregarCoberturaServlet">
    <label for="categoria">Categor&iacute;a:</label>
    <select name="categoria" id="categoria">
        <c:forEach var="categoria" items="${categorias}">
            <option value="${categoria.id}">${categoria.descripcion}</option>
        </c:forEach>
    </select>
    <label for="descripcionCobertura">Descripci&oacute;n:</label>
    <input type="text" name="descripcionCobertura" id="descripcionCobertura" required>

    <label for="costoMinimo">Costo m&iacute;nimo:</label>
    <input type="number" name="costoMinimo" id="costoMinimo" required>

    <label for="costoPorcentual">Costo porcentual del valor asegurado:</label>
    <input type="number" name="costoPorcentual" id="costoPorcentual" required>

    <button type="submit">Agregar cobertura</button>
</form>
</body>
</html>