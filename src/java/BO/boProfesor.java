
package BO;

import Dao.daoProfesor;
import entidades.profesor;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class boProfesor {
    
    public static void  procesarInsertarPeticionprofesor (HttpServletRequest request,HttpServletResponse response)throws ClassNotFoundException, SQLException, IOException{
    profesor profesor=new profesor();
    profesor.setidentificacion(request.getParameter("identificacion"));
    profesor.setNombre(request.getParameter("nombre"));
    profesor.setApellido(request.getParameter("apellido"));
    profesor.setEspecialidad(request.getParameter("especialidad"));
        daoProfesor.insertarprofesor(profesor.getIdentificacion(), profesor.getNombre(), profesor.getApellido(), profesor.getEspecialidad());
    response.sendRedirect("/instituto/SinsertarProfesor");
}


    public static void procesarPeticionInsertarProfesor(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
