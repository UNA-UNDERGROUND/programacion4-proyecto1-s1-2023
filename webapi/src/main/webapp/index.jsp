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

    <!-- registro Style -->

    <link href="styles/registro.css" rel="stylesheet">

    <!-- Inicio Style -->
    <link href="styles/inicioStyle.css" rel="stylesheet"></head>


<!-- Encabezado superior -->

<header><%@include file="headerLogin.jsp"%></header>

<main class="flex-shrink-0" style="padding: 30px;">
    <div class="container">
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <h2>Iniciar sesi&oacute;n</h2>
                <form  class="form-floating" style="margin: 10px 0px 10px 0px;" method = "GET" action="login" >
                    <div class="form-floating mb-3">
                        <input type="cedula" class="form-control" id="floatingInputInvalid" name="username" placeholder="401230456" required>
                        <label for="floatingInputInvalid">C&eacute;dula</label>
                    </div>
                    <div class="form-floating">
                        <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password" required>
                        <label for="floatingPassword">Contrase&ntilde;a</label>
                    </div>

                    <br>
                    <div class="container-fluid">
                        <div class="row">
                            <div class="btn-group btn-group-toggle" data-toggle="buttons">
                                <input class="btn btn-primary btn-lg active" type="submit" value="Inicio de sesi&oacute;n">
                            </div>
                        </div>
                    </div>

                </form>
                <div class="container-fluid">
                    <p> &#191;No tienes una cuenta? <a href="register.jsp">Reg&iacute;strate aqu&iacute;</a></p>
                    <p> &#191;Eres administrador? <a href="loginAdmin.jsp">Iniciar como administrador</a></p>
                </div>
            </div>
        </div>
    </div>
</main>
<%@include file="footer.jsp"%>
</html>
