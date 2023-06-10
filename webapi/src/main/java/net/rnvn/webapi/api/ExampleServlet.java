package net.rnvn.webapi.api;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import net.rnvn.webapi.auth.AuthenticatedController;

@WebServlet(name = "SumaController", urlPatterns = { "/api/sumar" })
public class ExampleServlet extends AuthenticatedController {

    private class Numeros {
        public int numeroA;
        public int numeroB;
    }

    @SuppressWarnings("unused")
    private class Respuesta {
        public int suma;
        public String identificacion;

        Respuesta(int numeroA, int numeroB, String identificacion) {
            this.suma = numeroA + numeroB;
            this.identificacion = identificacion;
        }
    }

    @Override
    protected void onPost(
            HttpServletRequest req,
            HttpServletResponse resp,
            JsonObject jsonObject,
            DecodedJWT decodedJWT)
            throws jakarta.servlet.ServletException, java.io.IOException {
        Numeros numeros = new Gson().fromJson(jsonObject, Numeros.class);
        if (null != numeros) {
            Respuesta respuesta = new Respuesta(numeros.numeroA, numeros.numeroB, decodedJWT.getSubject());
            writeResponse(resp, respuesta);
        } else {
            writeResponse(resp, HttpServletResponse.SC_BAD_REQUEST);
        }

    }

}
