package Dao;

import Utilidades.Conexioninstituto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class daoProfesor {
    
    public static void insertarprofesor (String identificacion,String nombre,String apellido, String especialidad) throws SQLException, ClassNotFoundException{
    Connection conexion=Conexioninstituto.conexioninstituto();
    Statement sentencia=conexion.createStatement();
    String consultaSQL = "insert into profesor (identificacion,nombre,apellido, especialidad) values ";
    consultaSQL += "('" + identificacion + "','" + nombre + "','" + apellido + "', '" + especialidad + "')";
    int filas=sentencia.executeUpdate(consultaSQL);
    System.out.println("Numero de filas insertadas: "+filas);
    sentencia.close();
    Conexioninstituto.cerrarConexion();
}
    
    public static void actualizarprofesor(String identificacion,String nombre,String apellido, String especialidad) throws ClassNotFoundException, SQLException{
       
        Connection conexion=Conexioninstituto.conexioninstituto();
        String sql="update profesor set nombre=? and apellido=? and especialidad=? where identificacion=?";
        PreparedStatement actualizar=conexion.prepareStatement(sql);
        actualizar.setString(1, identificacion);
        actualizar.setString(2, nombre);
        actualizar.setString(3, apellido);
        actualizar.setString(4, especialidad);
        int filas=actualizar.executeUpdate(sql);
        System.out.println("N filas afectadas "+filas);
        actualizar.close();
        conexion.close();
       
   }
    
    public static ResultSet listarprofesor(String identificacion,String nombre,String apellido, String especialidad) throws ClassNotFoundException, SQLException{
    
      Connection conexion=Conexioninstituto.conexioninstituto();
      Statement sentencia = conexion.createStatement();
      String consultaSQL = "select identificacion,nombre,apellido, especialidad from profesor";
      ResultSet lista_profesor=sentencia.executeQuery(consultaSQL);
      Conexioninstituto.cerrarConexion();
      return lista_profesor;
    
}
    
      public static void borrarprofesor(String identificacion,String nombre,String apellido, String especialidad) throws ClassNotFoundException, SQLException{
    
      Connection conexion=Conexioninstituto.conexioninstituto();
      Statement sentencia = conexion.createStatement();
      String consultaSQL = "delete from profesor where identificacion=?";
      PreparedStatement borrar=conexion.prepareStatement(consultaSQL);
      borrar.setString(1, identificacion);
      borrar.setString(2, nombre);
      borrar.setString(3, apellido);
      borrar.setString(4, especialidad);
      int filas=borrar.executeUpdate(consultaSQL);
      System.out.println("N filas borradas "+filas);
      sentencia.close();
      Conexioninstituto.cerrarConexion();
      
}

    public static ResultSet verProfesor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}



