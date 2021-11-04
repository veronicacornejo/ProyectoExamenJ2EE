/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
/*import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
*/
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Verito
 */
public class LoginController extends HttpServlet {
    
    String valorSesion, valorContexto;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }

    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Validación del usuario:
        response.setContentType("text/HTML");
        PrintWriter out = response.getWriter();
        ServletConfig sConfig = getServletConfig();
        String usu = sConfig.getInitParameter("username");
        String pas = sConfig.getInitParameter("password");
        String usuf = request.getParameter("usuario");
        String pasf = request.getParameter("password");

        //para redireccionar a la pagina correspondiente
        if (usu.equals(usuf) && pas.equals(pasf)) {
            //creando la cookie en el navegador
            Cookie galletita = new Cookie("id", usuf);
            galletita.setMaxAge(60 * 10);//10 minutos
            response.addCookie(galletita);
            //guardando el nombre de usuario como atributo de la sesión
            HttpSession session = request.getSession();
            if (valorSesion == null) {
                session.setAttribute("username", usu);
            }
            /**
             * ******************************************
             */
            response.setContentType("text/html;charset=UTF-8");
            //response.getWriter().append("Served at: ").append(request.getContextPath());

            /**
             * *******************************************
             */
            response.sendRedirect("formulario.jsp");
        } else {
            ServletContext contexto = request.getSession().getServletContext();
            if (valorContexto == null) {
                contexto.setAttribute("log", "no");
            }
            response.sendRedirect("index.jsp?val=no");
        }
        //processRequest(request, response);
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
