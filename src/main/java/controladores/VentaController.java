/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import com.beans.ListaProductosSessionLocal;
import com.model.Producto;
import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;
import com.beans.ListaVentaSessionLocal;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Verito
 */
public class VentaController extends HttpServlet {
    String varContexto;
    @EJB
    private ListaProductosSessionLocal ejbProductosLocal;
    @EJB
    private ListaVentaSessionLocal ejbVentasLocal;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VentaController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VentaController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VentaController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VentaController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        //processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String fecha = request.getParameter("fechaS");
        int nit = Integer.parseInt(request.getParameter("nit"));
        String apellido = request.getParameter("cliente");
        List<Producto> prod= new LinkedList();
        prod = ejbProductosLocal.obtenerProductosL();
        String prods= ejbProductosLocal.obtenerProductosV();
        int tot = ejbProductosLocal.sumarProductos();
        ejbVentasLocal.agregarVenta(nit, apellido, prod, fecha, prods, tot);
        String val=ejbVentasLocal.obtenerVentasSP();//obtenerVentas();
        ServletContext contexto = request.getSession().getServletContext();
	if(varContexto == null){
            contexto.setAttribute("listaV", val);
        }else{
            varContexto = (String)contexto.getAttribute("listaV");
            contexto.setAttribute("listaV", val);
		
        }
        ejbProductosLocal.vaciarProductos();
        
        response.sendRedirect("formulario.jsp");
        
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
