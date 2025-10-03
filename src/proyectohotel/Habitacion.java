/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectohotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Levi
 */
public class Habitacion {
    
    String urlBase = "jdbc:mysql://localhost:3306/hotel";
    String usuarioBase = "root";
    String contraseñaBase = "cbn2016";    
    
    private int id;
    private String tipo;
    private String estado;

    public Habitacion(int id, String tipo, double tarifa, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.estado = "disponible";
    }

    public boolean AgregarHabitaciones() {
        try {
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);


            String sql = "INSERT INTO habitacion (tipo, estado) VALUES (?, ?)";


            PreparedStatement Enviar = conexion.prepareStatement(sql);


            Enviar.setString(1, tipo);
            Enviar.setString(2, estado);


            int filasAfectadas = Enviar.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("✅ Registro insertado correctamente en la base de datos");
                JOptionPane.showMessageDialog(null, "✅ Habitacion insertada correctamente.");
            }
            conexion.close();
            return true;

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar en la base de datos: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "❌ Error al Agregar habitacion");
            return false;
        }
    }
    public void mostrarHabitacion() {
        System.out.println("=================================");
        System.out.println(" Habitación #" + id);
        System.out.println(" Tipo        : " + tipo);
        System.out.println(" Descripción : " + descripcion);
        System.out.println(" Tarifa      : $" + tarifa);
        System.out.println(" Estado      : " + estado);
        System.out.println("=================================");
    }

    

    public int getId() { return id; }
    public String getTipo() { return tipo; }
    public String getDescripcion() { return descripcion; }
    public double getTarifa() { return tarifa; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}

