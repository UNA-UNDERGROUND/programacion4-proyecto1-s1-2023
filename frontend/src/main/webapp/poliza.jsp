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

<!-- Inicio Style -->
<link href="styles/poliza.css" rel="stylesheet"></head>


<!-- Encabezado superior -->

<%@ include file="header.jsp" %>

<section class="vh-100">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">

            <div class="card text-black" style="border-radius: 25px;">
                <div class="card-body p-md-5" style="background-color: #c4e4ff; border-radius: inherit;">
                    <div class="row justify-content-center">
                        <div class="col-md-12">

                            <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Registro de P&oacute;liza</p>

                            <form class="form-floating" action="polizaCobertura.jsp" method="post">

                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="placa" name="placa" required>
                                    <label for="placa">Numero de placa:</label>
                                </div>

                                <div class="form-floating mb-3">
                                    <select class="form-control" id="marcaModelo" name="marcaModelo" required>
                                        <option value="">Seleccionar</option>
                                        <option value="Toyota">Toyota</option>
                                        <option value="Nissan">Nissan</option>
                                        <option value="Honda">Honda</option>
                                        <option value="Mazda">Mazda</option>
                                    </select>
                                    <label for="marcaModelo">Marca-Modelo:</label>
                                </div>

                                <div class="form-floating mb-3">
                                    <select class="form-control" id="ano" name="ano" required>
                                        <option value="">Seleccionar</option>
                                        <option value="2014">2014</option>
                                        <option value="2015">2015</option>
                                        <option value="2016">2016</option>
                                        <option value="2017">2017</option>
                                        <option value="2018">2018</option>
                                        <option value="2019">2019</option>
                                        <option value="2020">2020</option>
                                        <option value="2021">2021</option>
                                        <option value="2022">2022</option>
                                        <option value="2023">2023</option>
                                    </select>
                                    <label for="ano">A&ntilde;o:</label>
                                </div>

                                <div class="form-floating mb-3">
                                    <input type="number" class="form-control" id="valorAsegurado" name="valorAsegurado" required>
                                    <label for="valorAsegurado">Valor asegurado:</label>
                                </div>

                                <div class="mb-3">
                                    <label for="plazoPago" class="form-label">Plazos de pago:</label>
                                    <div class="d-flex align-items-center justify-content-center">
                                        <div class="form-check me-3">
                                            <input type="radio" class="form-check-input" name="plazoPago" value="Trimestral" id="trimestral">
                                            <label class="form-check-label" for="trimestral">Trimestral</label>
                                        </div>
                                        <div class="form-check me-3">
                                            <input type="radio" class="form-check-input" name="plazoPago" value="Semestral" id="semestral">
                                            <label class="form-check-label" for="semestral">Semestral</label>
                                        </div>
                                        <div class="form-check">
                                            <input type="radio" class="form-check-input" name="plazoPago" value="Anual" id="anual">
                                            <label class="form-check-label" for="anual">Anual</label>
                                        </div>
                                    </div>
                                </div>
                                        <div class="d-flex justify-content-center">
                                            <input href='polizaCobertura.jsp' class="btn btn-primary btn-lg active" type="submit" value="Siguiente (Coberturas)">
                                        </div>
                                    <button type="button" class="btn btn-primary" style="background-color: grey; color: white; padding: 5px 10px; border-radius: 5px; border: none; font-size: 14px; cursor: pointer; margin-top: 20px; margin-left: 10px;" onclick="window.location.href='principalCliente.jsp'">Cancelar</button>
                                </form>
                             </div>
                        </div>
                     </div>
                 </div>
             </div>
         </div>
    </div>
</section>
</html>