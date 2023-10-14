package Controlador;

import Modelo.Mascota;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Calculos;
import Modelo.DatosMascotas;
import javax.servlet.RequestDispatcher;

@WebServlet(urlPatterns = {"/RegistroMascotas"})
public class RegistroMascotas extends HttpServlet {

    private List<Mascota> mascotas = new ArrayList<>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistroMascotas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistroMascotas at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String raza = request.getParameter("raza");
        String color = request.getParameter("color");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String tipo = request.getParameter("tipo");
        boolean toxoplasmosis = request.getParameter("toxoplasmosis") != null;
        String nivelEntrenamientoStr = request.getParameter("nivelEntrenamiento");
        int nivelEntrenamiento = 0;

        if (nivelEntrenamientoStr != null && !nivelEntrenamientoStr.isEmpty()) {
            nivelEntrenamiento = Integer.parseInt(nivelEntrenamientoStr);
        }

        Mascota nuevaMascota = new Mascota(nombre, raza, color, edad, tipo, toxoplasmosis, nivelEntrenamiento);
        mascotas.add(nuevaMascota);

        DatosMascotas datos = new DatosMascotas();
        double promEdad = datos.getPromedioEdad(mascotas);
        int cantCaninos = datos.getcantCaninos(mascotas);
        int cantFelinos = datos.getCantFelinos(mascotas);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style2.css\">");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Datos de Mascotas</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Datos de Mascotas Registradas</h1>");

        out.println("<div class='mascotascontenedor'>");
        int contador = 0;
        out.println("<p>La cantidad de caninos almacenados es de: " + cantCaninos + "</p>");
        out.println("<p>La cantidad de felinos almacenada es de: " + cantFelinos + "</p>");
        out.println("<p>El promedio de edad de todos los animales es de: " + promEdad + "</p>");
        out.println("</div>");

        out.println("<div class='mascotas'>");
        for (Mascota mascota : mascotas) {
            out.println("<p>Nombre: " + mascota.getNombre() + "</p>");
            out.println("<p>Raza: " + mascota.getRaza() + "</p>");
            out.println("<p>Color: " + mascota.getColor() + "</p>");
            out.println("<p>Edad: " + mascota.getEdad() + "</p>");
            out.println("<p>Tipo: " + mascota.getTipo() + "</p>");

            if ("felino".equals(mascota.getTipo())) {
                out.println("<p>¿Tiene toxoplasmosis? " + (mascota.tieneToxoplasmosis() ? "Sí" : "No") + "</p>");
            }

            if ("canino".equals(mascota.getTipo())) {
                String nivelEntrenamientoParam = request.getParameter("nivelEntrenamiento");
                if (nivelEntrenamientoParam != null && !nivelEntrenamientoParam.isEmpty()) {
                    nivelEntrenamiento = Integer.parseInt(nivelEntrenamientoParam);
                    out.println("<p>Nivel de Entrenamiento: " + nivelEntrenamiento + "</p>");
                }

                out.println("<input type=\"submit\" value=\"Eliminar\">");
                out.println("</form>");

                out.println("<hr>");
            }
            out.println("<a href=\"index.html\">Registrar una nueva mascota</a>");
            out.println("</div>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
