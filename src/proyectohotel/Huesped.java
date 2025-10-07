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
public class Huesped {
    
    String urlBase = "jdbc:mysql://localhost:3306/hotel";
    String usuarioBase = "root";
    String contraseñaBase = "cbn2016";
    
    private String nombre;
    private String apellido;
    private int documento;

    public Huesped(String nombre, String apellido, int documento) {
        this.nombre = nombre;
        this.apellido= apellido;
        this.documento = documento;
    }

    public boolean AgregarHuesped(){
        try {
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);


            String sql = "INSERT INTO huesped (nombre, apellido, documento) VALUES (?, ?, ?)";


            PreparedStatement Enviar = conexion.prepareStatement(sql);


            Enviar.setString(1, nombre);
            Enviar.setString(2, apellido);
            Enviar.setString(3, Integer.toString(documento));


            int filasAfectadas = Enviar.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("✅ Registro insertado correctamente en la base de datos");
            }
            conexion.close();
            return true;

        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry") && e.getMessage().contains("huesped.documento")) {
                System.out.println("❌ Esta persona ya se encuentra dentro del hotel");
            } else {
                System.out.println("❌ Error al insertar en la base de datos: " + e.getMessage());
            }
            return false;
        }
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public String getDocumento() {
        return documento;
    }

    public void mostrarHuesped() {
        System.out.println("-------------------------------");
        System.out.println("Nombre       : " + nombre);
        System.out.println("Documento    : " + documento);
        System.out.println("-------------------------------");
    }
}


