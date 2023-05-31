<%--
  Created by IntelliJ IDEA.
  User: alexr
  Date: 28/4/2023
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es" class="h-100">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Administradores</title>
  <!-- Bootstrap core CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<header>
  <%@ include file="headerLogin.jsp" %>
</header>
<body>
<div class="container">
  <div class="row">
    <div class="col-md-4 offset-md-4">
      <h2>Iniciar sesi&oacute;n como administrador</h2>
      <form  class="form-floating" style="margin: 10px 0px 10px 0px;">
        <div class="form-floating mb-3">
          <input type="cedula" class="form-control" id="floatingInputInvalid" placeholder="401230456" required>
          <label for="floatingInputInvalid">C&eacute;dula</label>
        </div>
        <div class="form-floating">
          <input type="password" class="form-control" id="floatingPassword" placeholder="Password" required>
          <label for="floatingPassword">Contrase&ntilde;a</label>
        </div>
        <br>
        <div class="container-fluid">
          <div class="row">
            <div class="btn-group btn-group-toggle" data-toggle="buttons">
              <input class="btn btn-primary active" type="submit" value="Inicio de sesi&oacute;n">
              <a href="index.jsp" class="btn btn-secondary active" role="button" aria-pressed="true">Regresar a inicio</a>
            </div>
          </div>
        </div>

      </form>
    </div>
  </div>
</div>
</body>
<footer>
  <%@ include file="footer.jsp" %>
</footer>
</html>
