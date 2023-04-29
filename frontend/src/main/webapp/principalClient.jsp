<%--
  Created by IntelliJ IDEA.
  User: alexr
  Date: 28/4/2023
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
<div>
    <div class="text-right">
        <h2>Actualizar Registro</h2>  <a href="ActualizarRegistro.jsp">
        <button class="btn btn-primary custom-button">Cambiar registro</button>

    </a>
        <div class="button-row">
            <h2>Agregar Poliza</h2>
            <a href="poliza.jsp">
                <button class="plus-button">
                    <span class="plus-icon">+</span>
                </button>
            </a>
        </div>


    </div>

</div>


<form method="post" action="${pageContext.request.contextPath}/ListarPolizasServlet">
    <label for="placa">Buscar por numero de placa:</label>
    <input type="text" name="placa" id="placa">
    <button type="submit">Buscar</button>
</form>
<br>
<table>
    <tr>
        <th>Numero de Poliza</th>
        <th>Numero de Placa</th>
        <th>Fecha de Inicio</th>
        <th>Fecha de Vencimiento</th>
        <th>Ver Detalles</th>
    </tr>
    <c:forEach var="poliza" items="${polizas}">
        <tr>
            <td>${poliza.numero}</td>
            <td>${poliza.placa}</td>
            <td>${poliza.fechaInicio}</td>
            <td>${poliza.fechaVencimiento}</td>
            <td><a href="${pageContext.request.contextPath}/DetallePolizaServlet?numero=${poliza.numero}">Ver Detalles</a></td>
        </tr>
    </c:forEach>
</table>
</body>




<!-- pie de pagina -->
<%@ include file="footer.jsp" %>


</html>
