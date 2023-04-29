<%--
  Created by IntelliJ IDEA.
  User: alexr
  Date: 28/4/2023
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="styles/inicioStyle.css" rel="stylesheet"><head>
    <!-- Encabezado superior -->

<body class="text-center d-flex flex-column h-100" style="background-color: #c4e4ff;">
<header style="background-color: #0a4275; color: white; padding: 10px;">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <img src="images/logo.jpg" alt="Seguros Infinito" style="height: 30px;">
                <span style="font-style: italic;">Seguros Infinito</span>
            </div>
            <div class="col-md-6">
                <span style="font-size: 18px;">Ll&aacute;manos: +506 5467 0937</span>
            </div>
            <div class="col-md-3 d-flex">
<%--                <div class="mr-auto">--%>
<%--                    <a href="inicio.jsp" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">logout</a>--%>
<%--                    <a href="about_us.jsp" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">conozcanos</a>--%>
<%--                </div>--%>

                <div class="btn-group btn-group-toggle" data-toggle="buttons">
                    <a href="inicio.jsp" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">logout</a>
                    <a href="about_us.jsp" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">conozcanos</a>
                </div>
            </div>
        </div>
    </div>
</header>
</body>
