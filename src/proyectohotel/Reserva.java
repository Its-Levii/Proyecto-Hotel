/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectohotel;
/**
 *
 * @author Levi
 */
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Reserva {
    private int id;
    private Habitacion habitacion;
    private ArrayList<Huesped> huespedes;
    private Calendar fechaEntrada;
    private Calendar fechaSalida;
    private Usuario cliente;
    
    private static SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(int id, Habitacion habitacion, Calendar fechaEntrada, Calendar fechaSalida, Usuario cliente) {
        this.id = id;
        this.habitacion = habitacion;
        this.huespedes = new ArrayList<>();
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cliente = cliente;
    }
    public int getId(){return id;}
    public Habitacion getHabitacion() { return habitacion; }
    public ArrayList<Huesped> getHuespedes() { return huespedes; }
    public Calendar getFechaEntrada() { return fechaEntrada; }
    public Calendar getFechaSalida() { return fechaSalida; }
    public Usuario getCliente() {
        return cliente;
    }

    public void agregarHuesped(Huesped h) {
        huespedes.add(h);
    }

    public void mostrarReserva() {
        System.out.println("=================================");
        System.out.println("          RESERVA #" + id);
        System.out.println("=================================");

        System.out.println("Habitación reservada:");
        habitacion.mostrarHabitacion();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Estancia:");
        System.out.println("  Desde : " + sdf.format(fechaEntrada.getTime()));
        System.out.println("  Hasta : " + sdf.format(fechaSalida.getTime()));

        System.out.println("Huéspedes:");
        for (int i = 0; i < huespedes.size(); i++) {
            huespedes.get(i).mostrarHuesped();
        }
        System.out.println("=================================");
    }
}


