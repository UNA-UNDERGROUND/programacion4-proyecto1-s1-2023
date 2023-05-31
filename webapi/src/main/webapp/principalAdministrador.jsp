
<!DOCTYPE html>
<html lang="es" class="h-100">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.82.0">
    <title>Seguros Infinito</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <!-- Icon library -->
    <link rel="stylesheet" href="styles/icons.css">

    <!-- Inicio Style -->
    <link href="styles/inicioStyle.css" rel="stylesheet"></head>
<link href="styles/PrincipalCliente.css" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">

<!-- Encabezado superior -->

<%@ include file="header.jsp" %>
<div class="d-flex justify-content-between">
    <div>
        <h2>-Gestion de Categorias y Coberturas</h2>
        <a href="gestionPolizas.jsp">
            <button class="btn btn-primary custom-button">Categorias y Coberturas</button>
        </a>
    </div>
    <div class="ml-2">
        <h2>-Gestion de Marcas y Modelos:</h2>
        <a href="gestionCarros.jsp">
            <button class="btn btn-primary custom-button mr-2">Marcas y Modelos</button>
        </a>
    </div>
</div>


<form method="post" action="${pageContext.request.contextPath}/RegistroServlet">
    <label for="nombre">Buscar por nombre de usuario:</label>
    <input type="text" name="nombre" id="id">
    <button type="submit">Buscar</button>
</form>
<br>
<table>
    <tr>
        <th>Usuario</th>
        <th>Polizas</th>
        <th>Ver Detalles</th>
    </tr>
    <c:forEach var="poliza" items="${polizas}">
        <tr>
            <td>${usuario.numero}</td>
            <td>${poliza.placa}</td>
            <td><a href="${pageContext.request.contextPath}/DetallePolizaServlet?numero=${poliza.numero}">Ver Detalles</a></td>
        </tr>
    </c:forEach>
</table>
</body>




<!-- pie de pagina -->
<%@ include file="footer.jsp" %>


</html>