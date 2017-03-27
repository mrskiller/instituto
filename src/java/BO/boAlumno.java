
package BO;

import Dao.daoAlumno;
import entidades.alumno;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class boAlumno {
    
    public static void  procesarInsertarPeticionalumno (HttpServletRequest request,HttpServletResponse response)throws ClassNotFoundException, SQLException, IOException{
    alumno alumno=new alumno();
    alumno.setExpediente(request.getParameter("expediente"));
    alumno.setNombre(request.getParameter("nombre"));
    alumno.setApellido(request.getParameter("apellido"));
    alumno.setEstudios(request.getParameter("estudios"));
    daoAlumno.insertaralumno(alumno.getExpediente(),alumno.getNombre(),alumno.getApellido(), alumno.getEstudios());
    response.sendRedirect("/instituto/SmostrarAlumno");
    
}
    public static void procesarUpdateAlumno(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException{
    alumno alumno=new alumno();
    alumno.setExpediente(request.getParameter("expediente"));
    alumno.setNombre(request.getParameter("nombre"));
    alumno.setApellido(request.getParameter("apellido"));
    alumno.setEstudios(request.getParameter("estudios"));
    daoAlumno.insertaralumno(alumno.getExpediente(),alumno.getNombre(),alumno.getApellido(), alumno.getEstudios());
    }

    public static void procesarPeticionInsertarAlumno(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
    
