/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectohotel;

/**
 *
 * @author Levi
 */
public class TipoHabitacion {
    private String nombre;
    private String descripcion;
    private double tarifa;

    public TipoHabitacion(String nombre, String descripcion, double tarifa) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tarifa = tarifa;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getTarifa() { return tarifa; }

    public void mostrarTipo() {
        System.out.println("Tipo: " + nombre + " | Tarifa: $" + tarifa);
        System.out.println("Descripción: " + descripcion);
    }
}

