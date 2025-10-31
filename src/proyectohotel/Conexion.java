/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectohotel;

/**
 *
 * @author DaBoyLoper
 */
public class Conexion {
    String urlBase = "jdbc:mysql://localhost:3306/hotel";
    String usuarioBase = "root";
    String contraseñaBase = "2206";
    
    public void Conexion(){}

    public String getUrlBase() {
        return urlBase;
    }
    
    public String getUsuarioBase() {
        return usuarioBase;
    }
    
    public String getContraseñaBase() {
        return contraseñaBase;
    }
    
    
}
