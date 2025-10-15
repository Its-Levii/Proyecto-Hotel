/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectohotel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
/**
 *
 * @author Levi
 */
public class Checkin {
    
    String urlBase = "jdbc:mysql://localhost:3306/hotel";
    String usuarioBase = "root";
    String contraseñaBase = "cbn2016";
    
    private int documento;
    private int id_habitacion;
    private String fechaEntrada;
    private String fechaSalida;

    private static SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    public Checkin(){}
    public Checkin(int documento, int id_habitacion) {
        this.documento = documento;
        this.id_habitacion = id_habitacion;
        this.fechaEntrada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        this.fechaSalida = null;
    }
    

    public boolean BuscarHuesped(int documento){
        try{
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);
            
            String sql = "SELECT * FROM checkin_checkout WHERE documento = ? AND fecha_Salida is null";
            
            PreparedStatement Recibir = conexion.prepareStatement(sql);
            
            Recibir.setString(1, Integer.toString(documento));

            ResultSet resultado = Recibir.executeQuery();
            if (resultado.next()){
                System.out.println(resultado.getString("documento"));
                System.out.println(resultado.getString("fecha_Salida"));
                return true;   
            }
            else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al buscar huesped: " + e.getMessage());
            return false;
        }
    }
    
    public boolean hacerCheck_in() {
        try {
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);


            String sql = "INSERT INTO checkin_checkout (documento, id_habitacion, fecha_Entrada, fecha_Salida) VALUES (?, ?, ?, ?)";


            PreparedStatement Enviar = conexion.prepareStatement(sql);


            Enviar.setString(1, Integer.toString(documento));
            Enviar.setString(2, Integer.toString(id_habitacion));
            Enviar.setString(3, fechaEntrada);
            Enviar.setString(4, fechaSalida);


            int filasAfectadas = Enviar.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("✅ huesped ingresado correctamente en la base de datos");
            }
            conexion.close();
            return true;

        } catch (SQLException e) {
            System.out.println("❌ Error al ingresar en la base de datos: " + e.getMessage());
            return false;
        }
    }

    public boolean hacerCheck_Out(int documento) {
        fechaSalida = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        try {
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);


            String sql = "UPDATE checkin_checkout SET fecha_Salida = ? WHERE documento = ? AND fecha_Salida is null";


            PreparedStatement Enviar = conexion.prepareStatement(sql);


            Enviar.setString(1, fechaSalida);
            Enviar.setString(2, Integer.toString(documento));


            int filasAfectadas = Enviar.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("✅ fecha de salida modificada correctamente en la base de datos");
            }
            conexion.close();
            return true;

        } catch (SQLException e) {
            System.out.println("❌ Error al modificar en la base de datos: " + e.getMessage());
            return false;
        }
    }
    public String[] DatosCheck(int documento){
        try{
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);
            
            String sql = "SELECT * FROM checkin_checkout WHERE documento = ?";
            
            PreparedStatement Recibir = conexion.prepareStatement(sql);
            
            Recibir.setString(1, Integer.toString(documento));

            ResultSet resultado = Recibir.executeQuery();
            if (resultado.next()){
                String[] Datos = new String[5];
                Datos[0] = resultado.getString("id_checkin");
                Datos[1] = resultado.getString("documento");
                Datos[2] = resultado.getString("id_habitacion");
                Datos[3] = resultado.getString("fecha_Entrada");
                Datos[4] = resultado.getString("fecha_Salida");
                System.out.println(resultado.getString("documento"));
                System.out.println(resultado.getString("fecha_Salida"));
                return Datos;   
            }
            else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error al buscar CheckIn: " + e.getMessage());
            return null;
        }
    }
}


