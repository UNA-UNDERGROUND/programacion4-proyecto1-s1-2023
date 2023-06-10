package net.rnvn.webapi.api;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.rnvn.webapi.util.RestController;

@WebServlet(name = "MultiplicacionController", urlPatterns = { "/api/multiplicar" })
public class MulController extends RestController {

    private class Numeros {
        public int numeroA;
        public int numeroB;
    }

    private class Respuesta {
        @SuppressWarnings("unused")
        public int resultado;

        public Respuesta(int numeroA, int numeroB) {
            this.resultado = numeroA * numeroB;
        }
    }

    @Override
    protected void onPost(
            HttpServletRequest req,
            HttpServletResponse resp,
            com.google.gson.JsonObject jsonObject)
            throws ServletException, java.io.IOException {
        Numeros numeros = new Gson().fromJson(jsonObject, Numeros.class);
        if (null != numeros) {
            Respuesta respuesta = new Respuesta(numeros.numeroA, numeros.numeroB);
            writeResponse(resp, respuesta);
        } else {
            writeResponse(resp, HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
