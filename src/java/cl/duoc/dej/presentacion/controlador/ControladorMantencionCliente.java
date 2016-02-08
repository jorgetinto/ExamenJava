package cl.duoc.dej.presentacion.controlador;

import cl.duoc.dej.datos.beans.Atencion;
import cl.duoc.dej.negocio.LogicaServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo Galleguillos - Cristian Mardones - Jorge Pino
 */
public class ControladorMantencionCliente extends HttpServlet {
    @EJB
    private LogicaServiceLocal logicaService;
    
    
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
        PrintWriter out = response.getWriter();
        
        String accion = request.getParameter("accion");
        int rut = Integer.parseInt(request.getParameter("rut"));
        int nroAtencion = Integer.parseInt(request.getParameter("nroAtencion"));
        if (accion.equalsIgnoreCase("eliminar")) {
            
            try {
                logicaService.eliminarAtencion(nroAtencion);
                List<Atencion> atenciones = logicaService.buscarAtencionesPorRut(rut);
                request.setAttribute("atenciones", atenciones);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/VerMisNumeros.jsp");
                rd.forward(request, response);
            } catch (ServletException | IOException e) {
                System.out.println("ERROR: "+e.getMessage());
            } 
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        processRequest(request, response);
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
