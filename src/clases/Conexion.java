
package clases;
import java.sql.*;
public class Conexion {
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    public Conexion (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
            System.out.println("Conectado BD");
        } catch (Exception e) {
            System.out.println("Error al conectar BD");
        }
    }
    public int Reusuario(String nombre, String usuario, String edad, String correo){
        int res=0;
        try {
            ps=cn.prepareStatement("insert into usuarios(nombre,usuario,edad,correo)values(?,?,?,?)"); 
            ps.setString(1, nombre);
            ps.setString(2, usuario);
            ps.setString(3, edad);
            ps.setString(4, correo);
            res=ps.executeUpdate();
            System.out.println("Usuario registrado correctamente");
        } catch (Exception e) {
            System.out.println("Error al registrar");
        }
        return res;
    }  
    
    public int Acusuario(String nombre, String usuario, String edad, String correo, String id){
        int res=0;
        try {
            ps=cn.prepareStatement(" update usuarios set nombre=?, usuario=?, edad=?, correo=? where id_usuari=?"); 
            ps.setString(1, nombre);
            ps.setString(2, usuario);
            ps.setString(3, edad);
            ps.setString(4, correo);
            ps.setString(5, id);
            res=ps.executeUpdate();
            System.out.println(" Datos de Usuario modificado correctamente");
        } catch (Exception e) {
            System.out.println("Error al modificar datos de Usuario");
        }
        return res;
    }
    
    public int Elusuario(String id){
        int res=0;
        try {
            ps=cn.prepareStatement(" delete from usuarios where id_usuari=? ");
            ps.setString(1, id);
            res=ps.executeUpdate();
            System.out.println(" Datos de Usuario eliminados correctamente");
        } catch (Exception e) {
            System.out.println(" Error al eliminar Datos de Usuario");
        }
        return res;
    }
}
