package Dao;

import Utilidades.Conexioninstituto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class daoAlumno {
    
    public static void insertaralumno (String expediente,String nombre,String apellido, String estudios) throws SQLException, ClassNotFoundException{
    Connection conexion=Conexioninstituto.conexioninstituto();
    Statement sentencia=conexion.createStatement();
    String consultaSQL = "insert into profesor (identificacion,nombre,apellido, especialidad) values ";
    consultaSQL += "('" + expediente + "','" + nombre + "','" + apellido + "', '" + estudios + "')";
    int filas=sentencia.executeUpdate(consultaSQL);
    System.out.println("Numero de filas insertadas: "+filas);
    sentencia.close();
    Conexioninstituto.cerrarConexion();
}
    
    public static void actualizaralumno(String expediente,String nombre,String apellido, String estudios) throws ClassNotFoundException, SQLException{
       
        Connection conexion=Conexioninstituto.conexioninstituto();
        String sql="update alumno set nombre=? and apellido=? and estudios=? where expediente=?";
        PreparedStatement actualizar=conexion.prepareStatement(sql);
        actualizar.setString(1, expediente);
        actualizar.setString(2, nombre);
        actualizar.setString(3, apellido);
        actualizar.setString(4, estudios);
        int filas=actualizar.executeUpdate(sql);
        System.out.println("N filas afectadas "+filas);
        actualizar.close();
        conexion.close();
       
   }
    
    public static ResultSet listaralumno(String expediente,String nombre,String apellido, String estudios) throws ClassNotFoundException, SQLException{
    
      Connection conexion=Conexioninstituto.conexioninstituto();
      Statement sentencia = conexion.createStatement();
      String consultaSQL = "select expediente,nombre,apellido, estudios from alumno";
      ResultSet lista_alumno=sentencia.executeQuery(consultaSQL);
      Conexioninstituto.cerrarConexion();
      return lista_alumno;
    
}
    
      public static void borraralumno(String expediente,String nombre,String apellido, String estudios) throws ClassNotFoundException, SQLException{
    
      Connection conexion=Conexioninstituto.conexioninstituto();
      Statement sentencia = conexion.createStatement();
      String consultaSQL = "delete from alumno where expediente=?";
      PreparedStatement borrar=conexion.prepareStatement(consultaSQL);
      borrar.setString(1, expediente);
      borrar.setString(2, nombre);
      borrar.setString(3, apellido);
      borrar.setString(4, estudios);
      int filas=borrar.executeUpdate(consultaSQL);
      System.out.println("N filas borradas "+filas);
      sentencia.close();
      Conexioninstituto.cerrarConexion();
      
}

    public static ResultSet verAlumno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


