package net.rnvn.webapi.util;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// esta clase esta pensada para que todo controlador que desee realizar solicitudes rest
// mediante JSON herede de ella (sin autenticacion)
public class RestController extends HttpServlet {

    // abstract methods [onGet, onPost]

    protected void onGet(
            HttpServletRequest req,
            HttpServletResponse resp,
            JsonObject jsonObject)
            throws ServletException, IOException {
        writeResponse(resp, HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    protected void onPost(
            HttpServletRequest req,
            HttpServletResponse resp,
            JsonObject jsonObject)
            throws ServletException, IOException {
        writeResponse(resp, HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    protected void onPut(
            HttpServletRequest req,
            HttpServletResponse resp,
            JsonObject jsonObject)
            throws ServletException, IOException {
        writeResponse(resp, HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    protected void onDelete(
            HttpServletRequest req,
            HttpServletResponse resp,
            JsonObject jsonObject)
            throws ServletException, IOException {
        writeResponse(resp, HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        parseRequest(req, resp, (request, response, jsonObject) -> {
            try {
                onGet(request, response, jsonObject);
            } catch (Exception e) {
                System.err.println(this.getClass().getName() + ": " + e.getMessage());
                writeResponse(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        });
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        parseRequest(req, resp, (request, response, jsonObject) -> {
            try {
                onPost(request, response, jsonObject);
            } catch (Exception e) {
                System.err.println(this.getClass().getName() + ": " + e.getMessage());
                writeResponse(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        });
    }

    @Override
    protected void doPut(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        parseRequest(req, resp, (request, response, jsonObject) -> {
            try {
                onPut(request, response, jsonObject);
            } catch (Exception e) {
                System.err.println(this.getClass().getName() + ": " + e.getMessage());
                writeResponse(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        });
    }

    @Override
    protected void doDelete(
            HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        parseRequest(req, resp, (request, response, jsonObject) -> {
            try {
                onDelete(request, response, jsonObject);
            } catch (Exception e) {
                System.err.println(this.getClass().getName() + ": " + e.getMessage());
                writeResponse(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        });
    }

    private void parseRequest(
            HttpServletRequest req,
            HttpServletResponse resp,
            // callback(request, response, jsonObject)
            HTTPCallback callback)
            throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        // verificamos si el request contiene un body
        if (req.getContentLength() > 0) {
            try (
                    java.io.BufferedReader reader = req.getReader();) {
                // el tipo de dato que se espera es un json
                if (req.getContentType().equals("application/json")) {
                    // el request contiene un body, por lo tanto el jsonObject no es null
                    JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
                    if (null != callback) {
                        callback.handleRequest(req, resp, jsonObject);
                        return;
                    }
                }
            } catch (Exception e) {
                System.err.println(this.getClass().getName() + ": " + e.getMessage());
            }
        } else {
            // el request no contiene un body, por lo tanto el jsonObject es null
            if (null != callback) {
                callback.handleRequest(req, resp, null);
                return;
            }
        }
        writeResponse(resp, HttpServletResponse.SC_BAD_REQUEST);
    }

    // este metodo simplifica la implementacion de la interfaz funcional
    protected void writeResponse(
            HttpServletResponse resp,
            Object jsonObject)
            throws IOException {
        writeResponse(resp, jsonObject, HttpServletResponse.SC_OK);
    }

    protected void writeResponse(
            HttpServletResponse resp,
            int HTTPStatus) {
        try {
            writeResponse(resp, null, HTTPStatus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void writeResponse(
            HttpServletResponse resp,
            Object jsonObject,
            int HTTPStatus)
            throws IOException {
        resp.setStatus(HTTPStatus);
        if (null != jsonObject) {
            resp.setContentType("application/json");
            resp.getWriter().write(new Gson().toJson(jsonObject));
        }
    }

    @FunctionalInterface
    public interface HTTPCallback {
        public void handleRequest(HttpServletRequest t, HttpServletResponse u, JsonObject v);
    }
}
