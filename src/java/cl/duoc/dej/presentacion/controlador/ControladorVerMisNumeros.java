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
public class ControladorVerMisNumeros extends HttpServlet {
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
        ControladorAtencion c = new ControladorAtencion();
        boolean bandera = false;
        String rut = request.getParameter("txtRut");
             
        if (!c.validarRut(rut)) {
            request.setAttribute("mensaje", "(*)Debe ingresar un rut válido");
            bandera = true;            
        }
        
        if (!bandera) {

            int rutInt = Integer.parseInt(rut);
            List<Atencion> lAtenciones = logicaService.buscarAtencionesPorRut(rutInt);

            if (!lAtenciones.isEmpty()) {
                request.setAttribute("atenciones", lAtenciones);
            } else {
                request.setAttribute("mensajeRegistro", " No se encontraron registros");
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/VerMisNumeros.jsp");
            rd.forward(request, response);

        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/VerMisNumeros.jsp");
            rd.forward(request, response);        
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
