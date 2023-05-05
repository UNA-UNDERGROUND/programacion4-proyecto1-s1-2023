<%--
  Created by IntelliJ IDEA.
  User: alexr
  Date: 28/4/2023
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Registro</title>

  <!-- Adding Boostrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

  <link href="styles/register.css" rel="stylesheet">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
</head>

<body>
<!-- Registry form body-->
<section class="vh-100">
  <div class="container h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-lg-12 col-xl-11">
        <div class="card text-black" style="border-radius: 25px;">

          <!-- Card style for form -->
          <div class="card-body p-md-5" style="background-color: #c4e4ff;border-radius: inherit;">
            <div class="row justify-content-center">

              <!-- Registry form column -->
              <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Registro</p>
                <h5>Datos del nuevo usuario</h5>

                <form action="register" method="POST" class="form-floating" style="margin: 10px 0px 10px 0px;">
                  <input type="hidden" name="accion" value="Registrarse">
                  <div class="form-floating mb-3">
                    <input name="txtIdentificador" type="text" class="form-control" id="floatingId" placeholder="Identificaci&oacute;n" required>
                    <label for="floatingId">Identificaci&oacute;n</label>
                  </div>
                  <div class="form-floating mb-3">
                    <input name="txtPassword" type="password" class="form-control" id="floatingPassword" placeholder="Password" required>
                    <label for="floatingPassword">Contrase&ntilde;a</label>
                  </div>
                  <div class="form-floating mb-3">
                    <input name="txtEmail"type="email" class="form-control" id="floatingEmail" placeholder="name@example.com" required>
                    <label for="floatingEmail">Correo electr&oacute;nico</label>
                  </div>
                  <div class="form-floating mb-3">
                    <div class="input-group">
                      <span class="input-group-text">Nombre y Apellido</span>
                      <input name="txtName" type="text" aria-label="Nombre" class="form-control">
                      <input name="txtApellido" type="text" aria-label="Apellido" class="form-control">
                    </div>
                  </div>
                  <div class="form-floating mb-3">
                    <div class="input-group mb-3">
                      <span class="input-group-text" id="basic-addon1">+506</span>
                      <input name="txtNumero" type="text" class="form-control" placeholder="N&uacute;mero de tel&eacute;fono" aria-label="PhoneNumber" aria-describedby="basic-addon1">
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
                        <label for="floatingCreditCardNumber">N&uacute;mero de la tarjeta</label>
                        <div class="input-group-append">
                          <span style="justify-content: center;" class="input-group-text text-muted"> <i class="fab fa-cc-visa mx-1"></i> <i class="fab fa-cc-mastercard mx-1"></i> <i class="fab fa-cc-amex mx-1"></i> </span>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-sm-8">
                          <div class="form-group">
                            <label>
                                            <span class="hidden-xs">
                                                <h6>Fecha de vencimiento</h6>
                                            </span>
                            </label>
                            <div class="input-group"><input name="txtFecha" type="datetime-local" placeholder="MM" name="" class="form-control" required /> </div>
                          </div>
                        </div>
                        <div class="col-sm-4">
                          <div class="form-group mb-4">
                            <label data-toggle="tooltip" title="3 dgitos de seguridad al reverso de la tarjeta">
                              <h6>CVV <i class="fa fa-question-circle d-inline"></i></h6>
                            </label>
                            <input name="txtCvv" type="text" required class="form-control" />
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="container-fluid">
                    <div class="row">
                      <div class="btn-group btn-group-toggle" data-toggle="buttons">
                        <input class="btn btn-primary active" type="submit" value="Registrarse">
                        <a class="btn btn-secondary active" href="index.jsp" role="button">Cancelar</a>
                      </div>

                    </div>
                  </div>
                </form>
              </div>

              <!-- Image style column -->
              <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                <div id="carouselOfSuperCars" class="carousel slide" data-bs-ride="carousel">
                  <div class="carousel-inner">
                    <div class="carousel-item " data-bs-interval="100">
                      <img src="https://www.valleychevy.com/wp-content/uploads/2022/01/2022-Stingray.png" class="d-block w-100" alt="superCar1" class="img-fluid" alt="Sample image">
                    </div>
                    <div class="carousel-item" data-bs-interval="100">
                      <img src="https://di-uploads-pod6.dealerinspire.com/mclarenhouston/uploads/2017/04/720s-Azores-hero.png" class="d-block w-100" alt="superCar2" class="img-fluid" alt="Sample image">
                    </div>
                    <div class="carousel-item active" data-bs-interval="100">
                      <img src="https://www.valleychevy.com/wp-content/uploads/2022/01/2022-Camaro.png" class="d-block w-100" alt="superCar3" class="img-fluid" alt="Sample image">
                    </div>
                  </div>
                </div>

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

</body>
</html>