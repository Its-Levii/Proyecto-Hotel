/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectohotel;

/**
 *
 * @author Levi
 */
public class Huesped {
    private int id;
    private String nombre;
    private String documento;

    public Huesped(int id, String nombre, String documento) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void mostrarHuesped() {
        System.out.println("-------------------------------");
        System.out.println("Huésped ID   : " + id);
        System.out.println("Nombre       : " + nombre);
        System.out.println("Documento    : " + documento);
        System.out.println("-------------------------------");
    }
}


