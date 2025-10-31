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
import javax.swing.JOptionPane;

/**
 *
 * @author Levi
 */
public class Usuario {
    Conexion conexion = new Conexion();
    String urlBase = conexion.urlBase;
    String usuarioBase = conexion.usuarioBase;
    String contraseñaBase = conexion.contraseñaBase;
        
    private String nombre;
    private String apellido;
    private String genero;
    private String correo;
    private String contraseña;
    private String fechaNacimiento;
    private String departamento;
    private String ciudad;
    private String rol;

        public Usuario(){
            
        }
    public Usuario(String nombre, String apellido, String genero,String correo, String contraseña, String fechaNacimiento, String departamento, String ciudad, String rol) {
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
        try {
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);
            System.out.println("Conectado exitosamente.");
            conexion.close();
            
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
    public boolean Registrar(){
        try {
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);

            String sql = "call registrarUsuarios(?, ?, ?, ?, ?, ?, ?, ?, ?)";


            PreparedStatement Enviar = conexion.prepareStatement(sql);


            Enviar.setString(1, nombre);
            Enviar.setString(2, apellido);
            Enviar.setString(3, genero);
            Enviar.setString(4, correo);
            Enviar.setString(5, contraseña);
            Enviar.setString(6, fechaNacimiento);
            Enviar.setString(7, departamento);
            Enviar.setString(8, ciudad);
            Enviar.setString(9, rol);


            int filasAfectadas = Enviar.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Registro insertado correctamente en la base de datos");
                JOptionPane.showMessageDialog(null, "Registro insertado correctamente.");
            }
            conexion.close();
            return true;

        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry") && e.getMessage().contains("usuario.correo")) {
                JOptionPane.showMessageDialog(null, "Este correo ya esta registrado");
            } else {
                System.out.println("Error al insertar en la base de datos: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Error al registrarse");
            }
            return false;
        }
    }
    
    public String IniciarSesion(String correo, String contraseña){
        try{
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);
            
            String sql = "call iniciarSesion(?, ?)";
            
            PreparedStatement Recibir = conexion.prepareStatement(sql);
            
            Recibir.setString(1, correo);
            Recibir.setString(2, contraseña);

            ResultSet resultado = Recibir.executeQuery();

            if (resultado.next()){
                return resultado.getString("id_usuario");   
            }
            else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error al validar login: " + e.getMessage());
            return null;
        }
    }
     public String[] datosUsuario(int id){
        try{
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);
            
            String sql = "call datosUsuario(?)";
            
            PreparedStatement Recibir = conexion.prepareStatement(sql);
            
            Recibir.setString(1, Integer.toString(id));
            
            
            ResultSet resultado = Recibir.executeQuery();
            if (resultado.next()){
                String[] Datos = new String[10];
                Datos[0] = resultado.getString("id_usuario");
                Datos[1] = resultado.getString("nombre");
                Datos[2] = resultado.getString("apellido");
                Datos[3] = resultado.getString("genero");
                Datos[4] = resultado.getString("correo");
                Datos[5] = resultado.getString("contrasena");
                Datos[6] = resultado.getString("fecha_nacimiento");
                Datos[7] = resultado.getString("departamento");
                Datos[8] = resultado.getString("ciudad");
                Datos[9] = resultado.getString("rol");
                return Datos;   
            }
            else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error al buscar Usuario: " + e.getMessage());
            return null;
        }
    }
    }

