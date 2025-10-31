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

/**
 *
 * @author Levi
 */
public class Huesped {
    Conexion conexion = new Conexion();
    String urlBase = conexion.urlBase;
    String usuarioBase = conexion.usuarioBase;
    String contraseñaBase = conexion.contraseñaBase;
    
    private String nombre;
    private String apellido;
    private int documento;
    
    public Huesped(){}
    public Huesped(String nombre, String apellido, int documento) {
        this.nombre = nombre;
        this.apellido= apellido;
        this.documento = documento;
    }

    public String AgregarHuesped(){
        try {
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);


            String sql = "call agregarHuesped(?, ?, ?)";


            PreparedStatement Enviar = conexion.prepareStatement(sql);


            Enviar.setString(1, nombre);
            Enviar.setString(2, apellido);
            Enviar.setString(3, Integer.toString(documento));


            int filasAfectadas = Enviar.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Registro insertado correctamente en la base de datos");
            }
            conexion.close();
            return Integer.toString(documento);

        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry") && e.getMessage().contains("huesped.documento")) {
                System.out.println("Esta persona ya se encuentra registrada en la base de datos");
                return Integer.toString(documento);
            } else {
                System.out.println("Error al insertar en la base de datos: " + e.getMessage());
            }
            return null;
        }
    }
    
    public String[] datosHuesped(int documento){
        try{
            Connection conexion = DriverManager.getConnection(urlBase, usuarioBase, contraseñaBase);
            
            String sql = "call verHuesped(?)";
            
            PreparedStatement Recibir = conexion.prepareStatement(sql);
            
            Recibir.setString(1, Integer.toString(documento));
            
            
            ResultSet resultado = Recibir.executeQuery();
            if (resultado.next()){
                String[] Datos = new String[3];
                Datos[0] = resultado.getString("nombre");
                Datos[1] = resultado.getString("apellido");
                Datos[2] = resultado.getString("documento");
                System.out.println(resultado.getString("documento"));
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
}


