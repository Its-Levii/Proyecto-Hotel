/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectohotel;

/**
 *
 * @author Levi
 */
public class Habitacion {
    private int id;
    private String tipo;
    private String descripcion;
    private double tarifa;
    private String estado;

    public Habitacion(int id, String tipo, double tarifa, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.tarifa = tarifa;
        this.estado = "disponible";
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

