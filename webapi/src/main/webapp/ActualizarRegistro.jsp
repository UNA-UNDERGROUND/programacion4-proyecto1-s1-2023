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

<!-- Encabezado superior -->

<!-- Inicio Style -->
<link href="styles/inicioStyle.css" rel="stylesheet"></head>
<!-- Encabezado superior -->

<body class="text-center d-flex flex-column h-100" style="background-color: #c4e4ff;">
<header style="background-color: #0a4275; color: white; padding: 10px;">
    <%@include file="header.jsp"%>
</header>


<main>
    <form action="updateCLiente" method="update" class="form-floating">
        <div class="form-floating mb-3">
            <div class="input-group">
                <span class="input-group-text">Nombre y Apellido</span>
                <input name="txtName" type="text" aria-label="Nombre" class="form-control" readonly>
                <input name="txtApellido" type="text" aria-label="Apellido" class="form-control" readonly>
            </div>
        </div>
        <div class="form-floating mb-3">
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">+506</span>
                <input name="txtNumero" type="text" class="form-control" placeholder="Numero de telefono" aria-label="PhoneNumber" aria-describedby="basic-addon1">
            </div>
        </div>
        
        <!-- Credit card form content -->
        <div class="tab-content">
            <!-- credit card info-->
            <div id="credit-card" class="tab-pane fade show active pt-3">
                <h5>Datos de pago</h5>
                <div class="form-floating mb-3">
                    <input name="txtPropietario" type="text" class="form-control" id="floatingCreditCardOwner" placeholder="Card Owner Name" required>
                    <label for="floatingCreditCardOwner">Nombre propietario de la tarjeta</label>
                </div>
                <div class="form-floating mb-3">
                    <input name="txtNumeroTarjeta" type="text" class="form-control" id="floatingCreditCardNumber" placeholder="Card Owner Number" required>
                    <label for="floatingCreditCardNumber">Numero de la tarjeta</label>
        
                </div>
                <div class="row">
                    <div class="col-sm-8">
                        <div class="form-group">
                            <label>
                                <span class="hidden-xs">
                                    <h6>Fecha de vencimiento</h6>
                                </span>
                            </label>
                            <div class="input-group">
                                <input type="datetime-local" placeholder="yyyy-MM-dd" name="txtFecha" class="form-control" required>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group mb-4">
                            <label data-toggle="tooltip" title="Three-digits code on the back of your card">CVV
                                <i class="fa fa-question-circle"></i>
                            </label>
                            <input type="text" required class="form-control" name="txtCVV">
                        </div>
                    </div>
                </div>
                <div class="card-footer">
                    <button type="button" class="subscribe btn btn-primary btn-block shadow-sm" onclick="window.location.href = 'poliza.jsp'"> Continuar </button>
                </div>
            </div>
        </div>
    </form>
</main>


</body>
</html>