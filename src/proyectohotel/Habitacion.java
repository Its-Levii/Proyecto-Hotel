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

/**
 *
 * @author Levi
 */
public class Habitacion {
    
    String urlBase = "jdbc:mysql://localhost:3306/hotel";
    String usuarioBase = "root";
    String contraseñaBase = "cbn2016";    
    
    private int tipo;
    private String estado;
    
    public Habitacion(){}
    
    public Habitacion(int tipo) {
        this.tipo = tipo;
        this.estado = "disponible";
    }

    public boolean AgregarHabitaciones() {
        try {
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);


            String sql = "INSERT INTO habitacion (id_tipoHabitacion, estado) VALUES (?, ?)";


            PreparedStatement Enviar = conexion.prepareStatement(sql);


            Enviar.setString(1, Integer.toString(tipo));
            Enviar.setString(2, estado);


            int filasAfectadas = Enviar.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("✅ Registro insertado correctamente en la base de datos");
            }
            conexion.close();
            return true;

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar en la base de datos: " + e.getMessage());
            return false;
        }
    }
    public ArrayList<String[]> mostrarHabitaciones(){
        ArrayList<String[]> lista = new ArrayList<>();
        try{
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);
            
            String sql = "select id_habitacion, nombre, descripcion, tarifa, estado from habitacion left join tipohabitacion on tipohabitacion.id_tipoHabitacion = habitacion.id_tipoHabitacion;";
            
            PreparedStatement Recibir = conexion.prepareStatement(sql);
            ResultSet resultado = Recibir.executeQuery();
            
            
            while (resultado.next()) {
            String[] fila = new String[5];
            fila[0] = resultado.getString("id_habitacion");
            fila[1] = resultado.getString("nombre");
            fila[2] = resultado.getString("descripcion");
            fila[3] = resultado.getString("tarifa");
            fila[4] = resultado.getString("estado");

            lista.add(fila);
            }

            return lista;
        } catch (Exception e) {
            System.out.println("Error al mostrar habitaciones: " + e.getMessage());
            return null;
        }
    }
    
        public boolean ModificarEstadoHabitacion(String estado, int habitacionSeleccionada) {
        try {
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);


            String sql = "UPDATE habitacion SET estado = ? WHERE id_habitacion = ?";


            PreparedStatement Enviar = conexion.prepareStatement(sql);


            Enviar.setString(1, estado);
            Enviar.setString(2, Integer.toString(habitacionSeleccionada));


            int filasAfectadas = Enviar.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("✅ habitacion Modificada correctamente en la base de datos");
            }
            conexion.close();
            return true;

        } catch (SQLException e) {
            System.out.println("❌ Error al modificar en la base de datos: " + e.getMessage());
            return false;
        }
    }
}

