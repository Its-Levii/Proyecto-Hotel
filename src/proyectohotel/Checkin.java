/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectohotel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
/**
 *
 * @author Levi
 */
public class Checkin {
    
    private Habitacion habitacion;
    private ArrayList<Huesped> huespedes;
    private Calendar fechaEntrada;
    private Calendar fechaSalida;

    private static SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

    public Checkin(Habitacion habitacion, ArrayList<Huesped> huespedes, Calendar fechaSalida) {
        this.habitacion = habitacion;
        this.huespedes = huespedes;
        this.fechaEntrada = Calendar.getInstance();
        this.fechaSalida = fechaSalida;
    }
    
    public Habitacion getHabitacion() { return habitacion; }
    public ArrayList<Huesped> getHuespedes() { return huespedes; }
    public Calendar getFechaEntrada() { return fechaEntrada; }
    public Calendar getFechaSalida() { return fechaSalida; }


    public void registrar() {
        habitacion.setEstado("Ocupada");
        System.out.println("Check-In realizado");
        mostrarCheckIn();
    }

    public void mostrarCheckIn() {
        System.out.println("Check-In Habitación: " + habitacion.getTipo());
        System.out.println("Huéspedes: ");
        for (int i = 0; i < huespedes.size(); i++) {
            huespedes.get(i).mostrarHuesped();
        }
        System.out.println("Entrada: " + date.format(fechaEntrada.getTime()));
        System.out.println("Salida: " + date.format(fechaSalida.getTime()));
    }
}


