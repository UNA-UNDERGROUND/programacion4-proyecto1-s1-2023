


<!-- Encabezado superior -->

<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Coberturas</title>
    <!-- Inicio Style -->
    <link href="styles/inicioStyle.css" rel="stylesheet"></head>

<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container">
    <h1 class="text-center mt-4">Seguros Infinito</h1>

    <form>
        <div class="row mb-3">
            <label for="responsabilidad_civil" class="col-sm-4 col-form-label">Responsabilidad Civil:</label>
            <div class="col-sm-8">
                <select class="form-select" id="responsabilidad_civil" name="coberturas[]" multiple>
                    <option value="1">Da&ntilde;o a Personas</option>
                    <option value="2">Da&ntilde;o a Bienes</option>
                    <option value="3">Gastos Legales</option>
                </select>
            </div>
        </div>
        <div class="row mb-3">
            <label for="dano_directo" class="col-sm-4 col-form-label">Da&ntilde;o Directo:</label>
            <div class="col-sm-8">
                <select class="form-select" id="dano_directo" name="coberturas[]" multiple>
                    <option value="4">Da&ntilde;o al auto</option>
                    <option value="5">Robo</option>
                </select>
            </div>
        </div>

        <div class="row mb-3">
            <label for="porcentaje_cobertura" class="col-sm-4 col-form-label">Porcentaje de Cobertura:</label>
            <div class="col-sm-8">
                <select class="form-select" id="porcentaje_cobertura" name="cobertura[]">
                    <option value="">Seleccionar</option>
                    <option value="50">50 por ciento</option>
                    <option value="75">75 por ciento</option>
                    <option value="100">100 por ciento</option>
                </select>
            </div>
        </div>


        <form action="principalCliente.jsp" method="post">

            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-primary col-md-4 offset-md-4" style="background-color: #40E0D0; color: white; padding: 10px; border-radius: 5px; border: none; font-size: 18px; cursor: pointer; margin-top: 20px;">Comprar</button>
            </div>
        </form>

    </form>
</div>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/esm/popper">
</script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"></script>








</body>
</html>