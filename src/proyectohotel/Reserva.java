/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectohotel;
/**
 *
 * @author Levi
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Reserva {
    String urlBase = "jdbc:mysql://localhost:3306/hotel";
    String usuarioBase = "root";
    String contraseñaBase = "cbn2016";
    
    private int documento;
    private int id_habitacion;
    private String fechaEntrada;
    private String fechaSalida;
    private String Estado_Reserva;
    
    private static SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    
     public Reserva(){}
    public Reserva(int documento, int id_habitacion, String fechaEntrada, String fechaSalida) {
        this.documento = documento;
        this.id_habitacion = id_habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.Estado_Reserva = "Pendiente";
    }
    public boolean buscarreserva(int documento, String estado){
        try{
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);
            
            String sql = "SELECT * FROM reserva WHERE documento_huesped = ? AND estado = ?";
            
            PreparedStatement Recibir = conexion.prepareStatement(sql);
            
            Recibir.setString(1, Integer.toString(documento));
            Recibir.setString(2, estado);

            ResultSet resultado = Recibir.executeQuery();
            if (resultado.next()){
                System.out.println(resultado.getString("documento_huesped"));
                System.out.println(resultado.getString("estado"));
                return true;   
            }
            else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al buscar reserva: " + e.getMessage());
            return false;
        }
    }
    public boolean Reservar(){
        try {
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);


            String sql = "INSERT INTO reserva (documento_huesped, id_habitacion, fecha_entrada, fecha_salida, estado) VALUES (?, ?, ?, ? , ?)";


            PreparedStatement Enviar = conexion.prepareStatement(sql);


            Enviar.setString(1, Integer.toString(documento));
            Enviar.setString(2, Integer.toString(id_habitacion));
            Enviar.setString(3, fechaEntrada);
            Enviar.setString(4, fechaSalida);
            Enviar.setString(5, Estado_Reserva);


            int filasAfectadas = Enviar.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("✅ Reserva insertada correctamente en la base de datos");
            }
            conexion.close();
            return true;

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar en la base de datos: " + e.getMessage());
            return false;
        }
    }
    public String [] DatosReserva(int documento){
        try{
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);
            
            String sql = "SELECT * FROM reserva WHERE documento_huesped = ?";
            
            PreparedStatement Recibir = conexion.prepareStatement(sql);
            
            Recibir.setString(1, Integer.toString(documento));
            
            
            ResultSet resultado = Recibir.executeQuery();
            if (resultado.next()){
                String[] Datos = new String[6];
                Datos[0] = resultado.getString("id_reserva");
                Datos[1] = resultado.getString("documento_huesped");
                Datos[2] = resultado.getString("id_habitacion");
                Datos[3] = resultado.getString("fecha_entrada");
                Datos[4] = resultado.getString("fecha_salida");
                Datos[5] = resultado.getString("estado");
                System.out.println(resultado.getString("documento_huesped"));
                return Datos;   
            }
            else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error al buscar huesped: " + e.getMessage());
            return null;
        }
    }
    public boolean ModificarEstadoReserva(String estado, int documento) {
        try {
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);


            String sql = "UPDATE reserva SET estado = ? WHERE documento_huesped = ?";


            PreparedStatement Enviar = conexion.prepareStatement(sql);


            Enviar.setString(1, estado);
            Enviar.setString(2, Integer.toString(documento));


            int filasAfectadas = Enviar.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("✅ reserva Modificada correctamente en la base de datos");
            }
            conexion.close();
            return true;

        } catch (SQLException e) {
            System.out.println("❌ Error al modificar en la base de datos: " + e.getMessage());
            return false;
        }
    }
}


