package Controlador;

import Modelo.Persona;
import Modelo.PersonaDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    Persona p=new Persona();
    PersonaDAO dao=new PersonaDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
        switch (accion) {
            case "Listar":
                List<Persona>lista=dao.listar();
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "Nuevo":                
                request.getRequestDispatcher("add.jsp").forward(request, response);
                break;
            case "Guardar":   
                String nom=request.getParameter("txtNom");
                String dni=request.getParameter("txtDni");
                p.setNom(nom);
                p.setDni(dni);
                dao.agregar(p);
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                break;
            case "Editar": 
                int ide=Integer.parseInt(request.getParameter("id"));
                Persona res=dao.listarId(ide);
                request.setAttribute("dato",res);
                request.getRequestDispatcher("edit.jsp").forward(request, response);
                break;
            case "Actualizar":   
                int id=Integer.parseInt(request.getParameter("id"));
                String nom1=request.getParameter("txtNom");
                String dni1=request.getParameter("txtDni");
                p.setId(id);
                p.setNom(nom1);
                p.setDni(dni1);
                dao.update(p);
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                break;
            case "Delete":      
                int idd= Integer.parseInt(request.getParameter("id"));
                dao.delete(idd);
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);;
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
