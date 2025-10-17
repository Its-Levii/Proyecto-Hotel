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
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Levi
 */
public class TipoHabitacion {
    String urlBase = "jdbc:mysql://localhost:3306/hotel";
    String usuarioBase = "root";
    String contraseñaBase = "cbn2016";
    
    
    private String nombre;
    private String descripcion;
    private String tarifa;
    
    public TipoHabitacion(){
        
    }
    public TipoHabitacion(String nombre, String descripcion, String tarifa) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tarifa = tarifa;
    }
    
    public boolean insertarTipo() {
        try {
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);


            String sql = "INSERT INTO tipohabitacion (nombre, descripcion, tarifa) VALUES (?, ?, ?)";


            PreparedStatement Enviar = conexion.prepareStatement(sql);


            Enviar.setString(1, nombre);
            Enviar.setString(2, descripcion);
            Enviar.setString(3, tarifa);


            int filasAfectadas = Enviar.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Registro insertado correctamente en la base de datos");
                JOptionPane.showMessageDialog(null, "✅ Habitacion insertada correctamente.");
            }
            conexion.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar en la base de datos: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "❌ Error al Agregar habitacion");
            return false;
        }
    }
    
    public ArrayList<String[]> mostrarTipoHabitaciones(){
        ArrayList<String[]> lista = new ArrayList<>();
        try{
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);
            
            String sql = "SELECT * FROM tipohabitacion";
            
            PreparedStatement Recibir = conexion.prepareStatement(sql);
            ResultSet resultado = Recibir.executeQuery();
            
            
            while (resultado.next()) {
            String[] fila = new String[4];
            fila[0] = resultado.getString("id_tipoHabitacion");
            fila[1] = resultado.getString("nombre");
            fila[2] = resultado.getString("descripcion");
            fila[3] = resultado.getString("tarifa");

            lista.add(fila);
            }

            

            return lista;
        } catch (Exception e) {
            System.out.println("Error al mostrar habitaciones: " + e.getMessage());
            return null;
        }
    }
}

