/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectohotel;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Levi
 */
public class Usuario {
    private String nombre;
    private String apellido;
    private String genero;
    private String correo;
    private String contraseña;
    
    private static SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
    private Calendar fechaNacimiento = Calendar.getInstance();
 
    private String departamento;
    private String ciudad;
    private String rol;

    public Usuario(String nombre, String apellido, String genero,String correo, String contraseña, Calendar fechaNacimiento, String departamento, String ciudad, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.correo = correo;
        this.contraseña = contraseña;
        this.fechaNacimiento = fechaNacimiento;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.rol = rol;
    }
    
    public void Conexion(){
        String url = "jdbc:mysql://localhost:3306/hotel"; // cambia por tu BD
        String usuario = "root"; // o el tuyo
        String contraseña = "cbn2016";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("✅ Conectado exitosamente.");
            conexion.close();
            
        } catch (SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    public void Registrar(){
        String urlBase = "jdbc:mysql://localhost:3306/hotel"; // cambia por tu BD
        String usuarioBase = "root"; // o el tuyo
        String contraseñaBase = "cbn2016";
        try {
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);

            // SQL con parámetros
            String sql = "INSERT INTO usuario (nombre, apellido, genero, correo, contrasena, fecha_nacimiento, departamento, ciudad) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            // PreparedStatement para insertar
            PreparedStatement ps = conexion.prepareStatement(sql);

            // Datos a insertar
            ps.setString(1, "Juan Pérez");
            ps.setString(2, "juan@gmail.com");

            // Ejecutar
            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("✅ Registro insertado correctamente.");
            }

            conexion.close();

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar: " + e.getMessage());
        }
    }
}

