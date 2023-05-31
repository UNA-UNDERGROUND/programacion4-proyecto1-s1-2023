package net.rnvn.webapi.api;

import com.google.gson.Gson;

import jakarta.servlet.annotation.WebServlet;
import net.rnvn.webapi.auth.AuthenticatedController;

@WebServlet(name = "SumaController", urlPatterns = { "/api/sumar" })
public class ExampleServlet extends AuthenticatedController {

    private class Numeros {
        public int numeroA;
        public int numeroB;
    }

    private class Respuesta {
        public int suma;
        public String identificacion;
    }

    @Override
    protected void onPost(
            jakarta.servlet.http.HttpServletRequest req,
            jakarta.servlet.http.HttpServletResponse resp,
            com.auth0.jwt.interfaces.DecodedJWT decodedJWT)
            throws jakarta.servlet.ServletException, java.io.IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        try (
                java.io.BufferedReader reader = req.getReader();) {
            // numeroA, numeroB
            // { "numeroA": 1, "numeroB": 2 }

            Gson gson = new Gson();
            Numeros numeros = gson.fromJson(reader, Numeros.class);
            if (null != numeros) {
                Respuesta respuesta = new Respuesta();
                respuesta.suma = numeros.numeroA + numeros.numeroB;
                respuesta.identificacion = decodedJWT.getSubject();
                resp.setStatus(jakarta.servlet.http.HttpServletResponse.SC_OK);
                resp.getWriter().write(gson.toJson(respuesta));
            } else {
                resp.setStatus(jakarta.servlet.http.HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().write("{}");
            }
        }

    }

}
