<%--
  Created by IntelliJ IDEA.
  User: alexr
  Date: 28/4/2023
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Nosotros</title>

  <!-- Bootstrap core CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

  <!-- About  Style -->
  <link href="styles/about_us.css" rel="stylesheet"></head>
</head>


<!-- Encabezado superior -->
<header><%@include file="header.jsp"%></header>

<body>
<div class="container">
  <h1>Bienvenido a AutoSeguro</h1>
  <p>
    La empresa AutoSeguro se dedica a la venta en línea de seguros para automóviles, brindando a sus clientes una plataforma fácil de usar y eficiente para cotizar y comprar pólizas de seguro para sus vehículos. Los clientes pueden revisar en cualquier momento el estado de sus pólizas, ofreciendo una experiencia de usuario óptima.
  </p>
  <p>
    Para utilizar los servicios de AutoSeguro, los clientes deben identificarse y registrarse en el sistema. Una vez registrados, pueden acceder a las diferentes opciones de seguros disponibles para sus automóviles y seleccionar la cobertura que mejor se ajuste a sus necesidades.
  </p>
  <p>
    Cada categoría de cobertura cuenta con una identificación autogenerada y una descripción, mientras que cada cobertura específica también tiene una identificación autogenerada, una descripción y un costo asociado. El costo se determina mediante el mayor valor entre un costo mínimo establecido y un costo porcentual del valor asegurado.
  </p>
  <p>
    La plataforma de AutoSeguro se ha diseñado pensando en la comodidad y facilidad de uso para sus clientes y administradores, permitiendo así un acceso rápido y eficiente a la información relevante sobre seguros de automóviles. Con AutoSeguro, los clientes pueden encontrar y comprar el seguro adecuado para sus vehículos en línea, y el administrador puede mantener y actualizar fácilmente la base de datos de marcas, modelos y coberturas disponibles.
  </p>
</div>
</body>
<footer><%@include file="footer.jsp"%></footer>
</html>
