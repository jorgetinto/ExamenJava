package cl.duoc.dej.presentacion.controlador;

import cl.duoc.dej.datos.beans.Atencion;
import cl.duoc.dej.datos.beans.Cliente;
import cl.duoc.dej.datos.beans.Modulo;
import cl.duoc.dej.datos.beans.Servicio;
import cl.duoc.dej.negocio.LogicaServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
public class ControladorAtencion extends HttpServlet {
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
        int nroModulo;
        int cargaModulo;
        int tiempoEspera;
        boolean bandera = false;
        String rut = request.getParameter("txtRut");
        String nombre = request.getParameter("txtNombre");
        int tipoServicio = Integer.parseInt(request.getParameter("servicios"));
        String comentario = request.getParameter("txtComentario");
        
        //Valida que ingrese el rut y que sea numérico
        if (!validarRut(rut)) {
            request.setAttribute("mensaje", "(*)Debe ingresar un rut válido");
            bandera = true;
        }
        
        //Valida que ingrese un nombre
        if (nombre.trim().length() == 0) {
            request.setAttribute("mensaje", "(*)No debe dejar campos vacios");
            bandera = true;
        }
        
        //Valida que seleccione un servicio
        if (tipoServicio == 0) {
            request.setAttribute("mensaje", "(*)Debe selecionar un servicio");
            bandera = true;
        }
        
        //Si el servicio es Otro y no ingresa comentarios vuelve a solicitar que ingrese los datos
        if (tipoServicio == 4 && comentario.trim().length()==0) {
            request.setAttribute("mensaje", "(*)Si selecciona Otro debe ingresar un comentario");
            bandera = true;
        }
        
        if (!bandera) {

            //Si no es Cliente se le asigna el modulo 1, el nro de atención y se le indica el tiempo de espera estimado.
            try {
                int rutInt = Integer.parseInt(rut);
                Cliente valCliente = logicaService.validarCliente(rutInt);
                if (valCliente == null) {
                    nroModulo = logicaService.nroModuloNoCliente();
                    cargaModulo = logicaService.cargaModulo(nroModulo);
                    tiempoEspera = logicaService.tiempoEsperaNoCliente();

                    Cliente cliente = new Cliente();
                    cliente.setRut(rutInt);
                    cliente.setNombre(nombre);

                    Servicio servicio = logicaService.tipoServicio(tipoServicio);

                    Modulo modulo = new Modulo();
                    modulo.setNroModulo(nroModulo);
                    modulo.setCargaActual(cargaModulo);

                    Atencion atencion = new Atencion();
                    atencion.setRut(cliente.getRut());
                    atencion.setServicio(servicio);
                    atencion.setNroModulo(modulo.getNroModulo());
                    atencion.setTiempoEspera(tiempoEspera);
                    atencion.setComentario(comentario);
                    atencion.setFechaCreacion(new Date());
                    
                    if (logicaService.validarServicio(atencion)) {
                        request.setAttribute("mensaje", "(*)No puede elegir el mismo servicio en un dia");
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/Atencion.jsp");
                        rd.forward(request, response);                        
                    }else{
                        try {
                            logicaService.agregarAtencion(atencion);
                            logicaService.actualizarModulo(modulo);
                        } catch (Exception e) {
                            System.out.println("ERROR: " + e.getMessage());
                        }
                        request.setAttribute("atencion", atencion);
                        request.setAttribute("cliente", cliente);
                        request.setAttribute("modulo", modulo);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/Resultado.jsp");
                        rd.forward(request, response);
                    }               
                } else {

                    nroModulo = logicaService.nroModuloCliente();
                    cargaModulo = logicaService.cargaModulo(nroModulo);
                    tiempoEspera = logicaService.tiempoEsperaCliente();

                    Cliente cliente = new Cliente();
                    cliente.setRut(rutInt);
                    cliente.setNombre(nombre);

                    Servicio servicio = logicaService.tipoServicio(tipoServicio);

                    Modulo modulo = new Modulo();
                    modulo.setNroModulo(nroModulo);
                    modulo.setCargaActual(cargaModulo);

                    Atencion atencion = new Atencion();
                    atencion.setRut(cliente.getRut());
                    atencion.setServicio(servicio);
                    atencion.setNroModulo(modulo.getNroModulo());
                    atencion.setTiempoEspera(tiempoEspera);
                    atencion.setComentario(comentario);
                    atencion.setFechaCreacion(new Date());
                    
                    if (logicaService.validarServicio(atencion)) {
                        request.setAttribute("mensaje", "(*)No puede elegir el mismo servicio en un dia");
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/Atencion.jsp");
                        rd.forward(request, response);
                    }else{
                        try {
                            logicaService.agregarAtencion(atencion);
                            logicaService.actualizarModulo(modulo);
                        } catch (Exception e) {
                            System.out.println("ERROR: " + e.getMessage());
                        }
                        request.setAttribute("atencion", atencion);
                        request.setAttribute("cliente", cliente);
                        request.setAttribute("modulo", modulo);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/Resultado.jsp");
                        rd.forward(request, response);
                    }
                }

            } finally {
                out.close();
            }
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Atencion.jsp");
            rd.forward(request, response);
        }
    }
    
    protected boolean validarRut(String strRut) {

        try {
            int num;
            num = Integer.parseInt(strRut);
            return true;
        } catch (Exception e) {
            return false;
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
