<%--
  Created by IntelliJ IDEA.
  User: alexr
  Date: 28/4/2023
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Icon library -->
<link rel="stylesheet" href="styles/icons.css">

<footer class="text-center text-white" style="background-color: #0a4275; position: fixed; bottom: 0; width: 100%; height: fit-content;">

  <script>
    function redirectTo(url) {
      window.open(url, '_blank');
    }
  </script>



  <div class="container p-2">
    <button class="fa fa-facebook" onclick="redirectTo('https://www.facebook.com')"></button>
    <button class="fa fa-twitter" onclick="redirectTo('https://www.twitter.com')"></button>
    <button class="fa fa-google" onclick="redirectTo('https://www.google.com')"></button>
    <button class="fa fa-linkedin" onclick="redirectTo('https://www.linkedin.com')"></button>
    <button class="fa fa-youtube" onclick="redirectTo('https://www.youtube.com')"></button>

  </div>

  <!-- Grid container -->
  <div class="container p-1">
    <!-- Section: CTA -->
    <section class="">
      <p class="d-flex justify-content-center align-items-center">
        <span class="me-3">Total Soft Inc.</span>
        <span class="me-3">@2023 Tof, Inc</span>
      </p>
    </section>
    <!-- Section: CTA -->
  </div>
  <!-- Grid container -->
</footer>
