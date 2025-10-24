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
import java.time.LocalDate;
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
    private int id_usuario;
    private String fecha_registro;
    private static SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    
     public Reserva(){}
    public Reserva(int documento, int id_habitacion, String fechaEntrada, String fechaSalida, int id_usuario) {
        this.documento = documento;
        this.id_habitacion = id_habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.Estado_Reserva = "Pendiente";
        this.id_usuario = id_usuario;
        this.fecha_registro = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
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


            String sql = "INSERT INTO reserva (documento_huesped, id_habitacion, fecha_entrada, fecha_salida, estado, fecha_registro, id_usuario) VALUES (?, ?, ?, ? , ?, ?, ?)";


            PreparedStatement Enviar = conexion.prepareStatement(sql);


            Enviar.setString(1, Integer.toString(documento));
            Enviar.setString(2, Integer.toString(id_habitacion));
            Enviar.setString(3, fechaEntrada);
            Enviar.setString(4, fechaSalida);
            Enviar.setString(5, Estado_Reserva);
            Enviar.setString(6, fecha_registro);
            Enviar.setString(7, Integer.toString(id_usuario));


            int filasAfectadas = Enviar.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Reserva insertada correctamente en la base de datos");
            }
            conexion.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar en la base de datos: " + e.getMessage());
            return false;
        }
    }
    public String [] DatosReserva(int documento){
        try{
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);
            
            String sql = "SELECT * FROM reserva WHERE documento_huesped = ? And estado = 'Pendiente'";
            
            PreparedStatement Recibir = conexion.prepareStatement(sql);
            
            Recibir.setString(1, Integer.toString(documento));
            
            
            ResultSet resultado = Recibir.executeQuery();
            if (resultado.next()){
                String[] Datos = new String[8];
                Datos[0] = resultado.getString("id_reserva");
                Datos[1] = resultado.getString("documento_huesped");
                Datos[2] = resultado.getString("id_habitacion");
                Datos[3] = resultado.getString("fecha_entrada");
                Datos[4] = resultado.getString("fecha_salida");
                Datos[5] = resultado.getString("estado");
                Datos[6] = resultado.getString("id_usuario");
                Datos[7] = resultado.getString("fecha_registro");
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
                System.out.println("reserva Modificada correctamente en la base de datos");
            }
            conexion.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al modificar en la base de datos: " + e.getMessage());
            return false;
        }
    }
    public ArrayList<String[]> ReservasDeUsuario(int id){
        ArrayList<String[]> lista = new ArrayList<>();
        try{
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);
            if(id != 0){
            String sql = "SELECT id_reserva, documento_huesped, nombre, apellido, id_habitacion, fecha_entrada, fecha_salida, estado, fecha_registro, id_usuario FROM reserva left join huesped on reserva.documento_huesped = huesped.documento WHERE id_usuario = ?";
            
            PreparedStatement Recibir = conexion.prepareStatement(sql);
            
            Recibir.setString(1, Integer.toString(id));
            
            
            ResultSet resultado = Recibir.executeQuery();
            while (resultado.next()) {
                String[] Datos = new String[10];
                Datos[0] = resultado.getString("id_reserva");
                Datos[1] = resultado.getString("documento_huesped");
                Datos[2] = resultado.getString("nombre");
                Datos[3] = resultado.getString("apellido");
                Datos[4] = resultado.getString("id_habitacion");
                Datos[5] = resultado.getString("fecha_entrada");
                Datos[6] = resultado.getString("fecha_salida");
                Datos[7] = resultado.getString("estado");
                Datos[8] = resultado.getString("fecha_registro");
                Datos[9] = resultado.getString("id_usuario");
                
                lista.add(Datos);
            }
            return lista;
            }
            
            else{
            String sql = "SELECT id_reserva, documento_huesped, nombre, apellido, id_habitacion, fecha_entrada, fecha_salida, estado, fecha_registro, id_usuario FROM reserva left join huesped on reserva.documento_huesped = huesped.documento";
            
            PreparedStatement Recibir = conexion.prepareStatement(sql);

            ResultSet resultado = Recibir.executeQuery();
            while (resultado.next()) {
                String[] Datos = new String[10];
                Datos[0] = resultado.getString("id_reserva");
                Datos[1] = resultado.getString("documento_huesped");
                Datos[2] = resultado.getString("nombre");
                Datos[3] = resultado.getString("apellido");
                Datos[4] = resultado.getString("id_habitacion");
                Datos[5] = resultado.getString("fecha_entrada");
                Datos[6] = resultado.getString("fecha_salida");
                Datos[7] = resultado.getString("estado");
                Datos[8] = resultado.getString("fecha_registro");
                Datos[9] = resultado.getString("id_usuario");
                
                lista.add(Datos);
            }
            return lista;
            }
            
        } catch (Exception e) {
            System.out.println("Error al buscar reserva: " + e.getMessage());
            return null;
        }
    }
    
     //Esta parte es para actualizar las reservas y habitaciones :)
    
    public boolean ModificarReservas(){
        try{
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);
            
            String sql = "SELECT * FROM reserva";
            PreparedStatement Recibir = conexion.prepareStatement(sql);
            ResultSet resultado = Recibir.executeQuery();
            
            LocalDate fechaHuesped = null, fechaActual = null;
            
            while (resultado.next()) {
                int documento = resultado.getInt("documento_huesped");
                String fecha = resultado.getString("fecha_entrada");
                String estado = resultado.getString("estado");
                System.out.println(documento);
                try {
                String fechaActualString = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                fechaActual = LocalDate.parse(fechaActualString);
                System.out.println(fechaActualString);

                String fechaString = resultado.getString("fecha_salida");
                fechaHuesped = LocalDate.parse(fechaString);
                System.out.println("Fecha convertida: " + fechaHuesped);

                } catch (Exception e) {
                    System.out.println("Error al convertir la fecha: " + e.getMessage());
                }
                if(fechaHuesped.isBefore(fechaActual) && estado.equals("Pendiente")){
                    ModificarEstadoReserva("Expirada", documento);
                }
            }
            return true;   
        } catch (Exception e) {
            System.out.println("Error al modificar reserva: " + e.getMessage());
            return false;
        }
    }
}


