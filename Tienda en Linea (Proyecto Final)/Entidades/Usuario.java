package entidades;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//Cliente
public class Usuario
{
  PreparedStatement psStatement;
  //Atributos
  // int iUsuarioId;
  // String sNombre = "";
  // String sApellido = "";
  // String sPassword = "";
  // boolean bIsAdmin = false;

  //Constructor
  // public Usuario(int usuarioId, String nombre, String apellido, String psswrd, boolean isAdmin)
  // {
  //   iUsuarioId = usuarioId;
  //   sNombre = nombre;
  //   sApellido = apellido;
  //   sPassword = psswrd;
  //   bIsAdmin = isAdmin;
  // }

  // public void setUsuarioID(int usuarioId) {
  //   iUsuarioId = usuarioId;
  // }
  //
  // public void setNombre(String nombre) {
  //   sNombre = nombre;
  // }
  //
  // public void setApellido(String apellido) {
  //   sApellido = apellido;
  // }
  //
  // public void setPassword(String psswrd) {
  //   sPassword = psswrd;
  // }
  //
  // public void setIsAdmin(boolean bIs) {
  //   bIsAdmin = bIs;
  // }
  //
  // public int getUsuarioId() {
  //   return iUsuarioId;
  // }
  //
  // public String getNombre() {
  //   return sNombre;
  // }
  //
  // public String getApellido() {
  //   return sApellido;
  // }
  //
  // public String getPassword() {
  //   return sPassword;
  // }
  //
  // public boolean isAdmin() {
  //   return bIsAdmin;
  // }

  public void agregar(int usuarioId, String nombre, String apellido, String psswrd, boolean admin, Connection con) {
    try {
      String query = "INSERT INTO Usuario (UsuarioID, Nombre, Apellido, Pass, Admin) VALUES (?,?,?,?,?)";
      psStatement = con.prepareStatement(query);
      psStatement.setInt(1, usuarioId);
      psStatement.setString(2, nombre);
      psStatement.setString(3, apellido);
      psStatement.setString(4, psswrd);
      psStatement.setBoolean(5, admin);
      psStatement.execute();
    }catch(SQLException e){};
  }

  public int validar(String user, String password, Connection con) {
     try {
        String query = "SELECT UsuarioID FROM usuario WHERE UsuarioID = ? and Pass = ?";
        psStatement = con.prepareStatement(query);
        psStatement.setString(1, user);
        psStatement.setString(2, password);

        ResultSet rs = psStatement.executeQuery();
        if (rs.next()) { ///Va al primer registro si lo hay
           int ncuenta = rs.getInt ("UsuarioID");
           rs.close();
           return( ncuenta );
        }
     } catch (SQLException e) {}
     return 0;
  }
}
