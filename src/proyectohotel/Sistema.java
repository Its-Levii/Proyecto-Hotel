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
import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Sistema {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private Scanner leer = new Scanner(System.in);
    private ArrayList<Habitacion> habitaciones = new ArrayList<>();
    private ArrayList<TipoHabitacion> tiposHabitacion = new ArrayList<>();
    private int contadorHabitaciones = 1;
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private ArrayList<Checkin> checkins = new ArrayList<>();
    private int contadorReservas = 1;
    public Sistema() {
        usuarios.add(new Usuario("admin", "123", "admin"));
    }

    public void iniciar() {
        while (true) {
            System.out.println("    Sistema de Hotel    ");
            System.out.println("Elija una opción: ");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            int opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:  registrarCliente();
                        break;
                case 2: login();
                        break;
                case 3:
                    System.out.println("Saliendo...");
                    return;
                default: System.out.println("Opción inválida");
                    break;
            }
        }
    }

    private void registrarCliente() {
        System.out.print("Ingrese nombre de usuario: ");
        String nombre = leer.nextLine();
        System.out.print("Ingrese contraseña: ");
        String contraseña = leer.nextLine();

        usuarios.add(new Usuario(nombre, contraseña, "cliente"));
        System.out.println("Cliente registrado correctamente!");
    }

    private void login() {
        System.out.print("Usuario: ");
        String nombre = leer.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = leer.nextLine();
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            if (u.getNombre().equals(nombre) && u.getContraseña().equals(contraseña)) {
                if (u.getRol().equals("admin")) {
                    menuAdmin();
                } else {
                    menuCliente(u);
                }
                return;
            }
        }
        System.out.println("Usuario o contraseña incorrectos.");
    }

    private void menuAdmin() {
        while (true) {
            System.out.println("\n      MENÚ ADMIN     ");
            System.out.println("Elija una opción: ");
            System.out.println("1. Gestionar Habitaciones");
            System.out.println("2. Check-in / Check-out");
            System.out.println("3. Reportes");
            System.out.println("4. Cerrar sesión");
            int opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    menuHabitaciones();
                    break;
                case 2:
                    checkInCheckOut();
                    break;
                case 3:
                    menuReportes();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    return;  
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }

    private void menuCliente(Usuario cliente) {
        while (true) {
            System.out.println("\n      MENÚ CLIENTE      ");
            System.out.println("Elija una opción: ");
            System.out.println("1. Hacer Reserva");
            System.out.println("2. Consultar Reservas Activas");
            System.out.println("3. Ver Historial de Estancias");
            System.out.println("4. Cerrar sesión");
            int opcion = leer.nextInt();

            switch (opcion) {
                case 1: hacerReserva(cliente);
                    break;
                case 2: consultarReservasCliente(cliente);
                    break;
                case 3: historialEstanciasCliente(cliente);
                    break;
                case 4: 
                    System.out.println("Saliendo...");
                    return;
                default: 
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }

    private void menuReportes() {
        while (true) {
            System.out.println("\n     REPORTES     ");
            System.out.println("Elija una opción: ");
            System.out.println("1. Reporte Ocupación del Hotel");
            System.out.println("2. Reporte de Reservas por Rango de Fechas");
            System.out.println("3. Reporte de Estadías Activas");
            System.out.println("4. Historial de Estancias por Huésped");
            System.out.println("5. Volver");
            int opcion = leer.nextInt();

            switch (opcion) {
                case 1: listarHabitaciones();
                    break;
                case 2: reporteReservasPorFechas();
                    break;
                case 3: reporteEstadiasActivas();
                    break;
                case 4: 
                    System.out.print("Ingrese documento del huésped: ");
                    String doc = leer.nextLine();
                    leer.nextLine();
                    mostrarHistorialHuesped(doc);
                    break;
                case 5: 
                    return;
                default: 
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }

    private void registrarTipoHabitacion() {
        System.out.println("\n    Registrar nuevo tipo de habitación    ");
        System.out.print("Nombre del tipo: ");
        String nombre = leer.nextLine();
        System.out.print("Descripción: ");
        String descripcion = leer.nextLine();
        System.out.print("Tarifa: ");
        double tarifa = leer.nextDouble();
        leer.nextLine();

        TipoHabitacion tipo = new TipoHabitacion(nombre, descripcion, tarifa);
        tiposHabitacion.add(tipo);

        System.out.println("Tipo de habitación registrado correctamente.");
    }
    private void crearHabitacion() {
        if (tiposHabitacion.isEmpty()) {
            System.out.println("No hay tipos de habitación registrados. Primero registre un tipo.");
            return;
        }

        System.out.println("\n--- Crear nueva habitación ---");
        System.out.println("Seleccione el tipo de habitación:");
        for (int i = 0; i < tiposHabitacion.size(); i++) {
            System.out.println((i + 1) + ". " + tiposHabitacion.get(i).getNombre()
                    + " ($" + tiposHabitacion.get(i).getTarifa() + ")");
        }

        System.out.print("Ingrese la opción: ");
        int opcion = leer.nextInt();
        leer.nextLine();

        if (opcion < 1 || opcion > tiposHabitacion.size()) {
            System.out.println("Opción inválida.");
            return;
        }

        TipoHabitacion tipoSeleccionado = tiposHabitacion.get(opcion - 1);

        Habitacion habitacion = new Habitacion(contadorHabitaciones++, tipoSeleccionado.getNombre(), tipoSeleccionado.getTarifa(), tipoSeleccionado.getDescripcion());
        habitaciones.add(habitacion);
        System.out.println("Habitación creada correctamente:");
        habitacion.mostrarHabitacion();
    }

    
    private void listarHabitaciones() {
        System.out.println("\n    Lista de Habitaciones    ");
        if (habitaciones.isEmpty()) {
            System.out.println("No hay habitaciones registradas.");
        } else {
            for (int i = 0; i < habitaciones.size(); i++) {
                habitaciones.get(i).mostrarHabitacion();
            }
        }
    }
    
    private void menuHabitaciones() {
        while (true) {
            System.out.println("\n    MENÚ DE HABITACIONES    ");
            System.out.println("Elija una opción:");
            System.out.println("1. Registrar tipo de habitación");
            System.out.println("2. Crear habitación");
            System.out.println("3. Listar habitaciones");
            System.out.println("4. Volver al menú principal");
            int opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1: registrarTipoHabitacion(); break;
                case 2: crearHabitacion(); break;
                case 3: listarHabitaciones(); break;
                case 4: return;
                default: System.out.println("Opción inválida."); break;
            }
        }
    }
    
    private void hacerReserva(Usuario cliente) {
        System.out.println("\n    Crear Reserva    ");
        listarHabitaciones();

        System.out.print("Seleccione el ID de la habitación: ");
        int idHab = leer.nextInt();
        leer.nextLine();

        Habitacion habitacion = null;
        for (Habitacion h : habitaciones) {
            if (h.getId() == idHab) {
                habitacion = h;
                break;
            }
        }

        if (habitacion == null) {
            System.out.println("Habitación no encontrada.");
            return;
        }

        if (!habitacion.getEstado().equals("disponible")) {
            System.out.println("La habitación no está disponible.");
            return;
        }

        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.print("Ingrese fecha de entrada (dd/MM/yyyy): ");
            String fEntrada = leer.nextLine();
            Calendar fechaEntrada = Calendar.getInstance();
            fechaEntrada.setTime(date.parse(fEntrada));

            System.out.print("Ingrese fecha de salida (dd/MM/yyyy): ");
            String fSalida = leer.nextLine();
            Calendar fechaSalida = Calendar.getInstance();
            fechaSalida.setTime(date.parse(fSalida));

            if (fechaSalida.before(fechaEntrada)) {
                System.out.println("La fecha de salida no puede ser anterior a la de entrada.");
                return;
            }

            Reserva reserva = new Reserva(contadorReservas++, habitacion, fechaEntrada, fechaSalida, cliente);

            System.out.print("¿Cuántos huéspedes se alojarán?: ");
            int cant = leer.nextInt();
            leer.nextLine();

            for (int i = 1; i <= cant; i++) {
                System.out.println("Ingrese datos del huésped #" + i);
                System.out.print("Nombre: ");
                String nombre = leer.nextLine();
                System.out.print("Documento: ");
                String doc = leer.nextLine();

                Huesped h = new Huesped(i, nombre, doc);
                reserva.agregarHuesped(h);
            }

            habitacion.setEstado("reservada");
            reservas.add(reserva);

            System.out.println("\nReserva creada con éxito:");
            reserva.mostrarReserva();

        } catch (Exception e) {
            System.out.println("Error al ingresar fechas. Use formato dd/MM/yyyy");
        }
    }

    
    
    private void mostrarHistorialHuesped(String documento) {
    System.out.println("\n    Historial de Huésped    ");
    boolean encontrado = false;

    for (int i = 0; i < reservas.size(); i++) {
        Reserva r = reservas.get(i);
        ArrayList<Huesped> listaH = r.getHuespedes();

        for (int j = 0; j < listaH.size(); j++) {
            Huesped h = listaH.get(j);
            if (h.getDocumento().equals(documento)) {
                System.out.println("   Reserva:");
                r.mostrarReserva();
                System.out.println("-------------------");
                encontrado = true;
                break;
            }
        }
    }

    for (int i = 0; i < checkins.size(); i++) {
        Checkin c = checkins.get(i);
        ArrayList<Huesped> listaH = c.getHuespedes();

        for (int j = 0; j < listaH.size(); j++) {
            Huesped h = listaH.get(j);
            if (h.getDocumento().equals(documento)) {
                System.out.println("   Check-In:");
                c.mostrarCheckIn();
                System.out.println("-------------------");
                encontrado = true;
                break;
            }
        }
    }

    if (!encontrado) {
        System.out.println("No se encontraron registros para este huésped.");
    }
}

    private void checkInCheckOut() {
        System.out.println("\n    Check-in / Check-out    ");
        System.out.println("1. Check-in desde reserva");
        System.out.println("2. Check-in presencial");
        System.out.println("3. Check-out");
        System.out.print("Seleccione una opción: ");
        int opcion = leer.nextInt();
        leer.nextLine();
        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nombre del cliente para check-in: ");
                String nombreCliente = leer.nextLine();

                ArrayList<Reserva> reservasCliente = new ArrayList<>();
                for (int i = 0; i < reservas.size(); i++) {
                    Reserva r = reservas.get(i);
                    if (r.getCliente().getNombre().equalsIgnoreCase(nombreCliente) &&
                        r.getHabitacion().getEstado().equals("reservada")) {
                        reservasCliente.add(r);
                    }
                }

                if (reservasCliente.isEmpty()) {
                    System.out.println("No hay reservas disponibles para este cliente.");
                    return;
                }

                System.out.println("Seleccione el ID de la reserva para check-in:");
                for (int i = 0; i < reservasCliente.size(); i++) {
                    reservasCliente.get(i).mostrarReserva();
                }

                int idReserva = leer.nextInt();
                Reserva reservaSeleccionada = null;
                int indexReserva = -1;
                for (int i = 0; i < reservasCliente.size(); i++) {
                    if (reservasCliente.get(i).getId() == idReserva) {
                        reservaSeleccionada = reservasCliente.get(i);
                        for (int j = 0; j < reservas.size(); j++) {
                            if (reservas.get(j).getId() == idReserva) {
                                indexReserva = j;
                                break;
                            }
                        }
                        break;
                    }
                }
                
                if (reservaSeleccionada != null) {
                    Checkin checkin = new Checkin(reservaSeleccionada.getHabitacion(), reservaSeleccionada.getHuespedes(), reservaSeleccionada.getFechaSalida());
                    checkin.registrar();
                    checkins.add(checkin);
                    if (indexReserva != -1) reservas.remove(indexReserva);
                } else {
                    System.out.println("Reserva no encontrada.");
                }
                break;

            case 2:
                listarHabitaciones();
                System.out.print("Seleccione ID de la habitación para check-in: ");
                int idHab = leer.nextInt();
                leer.nextLine();
                Habitacion habitacion = null;
                for (int i = 0; i < habitaciones.size(); i++) {
                    if (habitaciones.get(i).getId() == idHab &&
                        habitaciones.get(i).getEstado().equals("disponible")) {
                        habitacion = habitaciones.get(i);
                        break;
                    }
                }
                
                if (habitacion == null) {
                    System.out.println("Habitación no disponible.");
                    return;
                }

                System.out.print("Ingrese fecha de salida (dd/MM/yyyy): ");
                String fSalida = leer.nextLine();
                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                Calendar fechaSalida = Calendar.getInstance();
                try {
                    fechaSalida.setTime(date.parse(fSalida));
                } catch (Exception e) {
                    System.out.println("Formato de fecha incorrecto.");
                    return;
                }

                System.out.print("¿Cuántos huéspedes se alojarán?: ");
                int cant = leer.nextInt();
                leer.nextLine();

                ArrayList<Huesped> huespedes = new ArrayList<>();
                for (int i = 1; i <= cant; i++) {
                    System.out.println("Ingrese datos del huésped #" + i);
                    System.out.print("Nombre: ");
                    String nombre = leer.nextLine();
                    System.out.print("Documento: ");
                    String doc = leer.nextLine();
                    huespedes.add(new Huesped(i, nombre, doc));
                }

                Checkin checkinPresencial = new Checkin(habitacion, huespedes, fechaSalida);
                checkinPresencial.registrar();
                checkins.add(checkinPresencial);
                break;

            case 3:
                System.out.print("Ingrese ID de la habitación para check-out: ");
                int idCo = leer.nextInt();
                leer.nextLine();

                Checkin checkin = null;
                int indexCheckin = -1;
                for (int i = 0; i < checkins.size(); i++) {
                    if (checkins.get(i).getHabitacion().getId() == idCo) {
                        checkin = checkins.get(i);
                        indexCheckin = i;
                        break;
                    }
                }

                if (checkin != null) {
                    checkin.getHabitacion().setEstado("disponible");
                    checkins.remove(indexCheckin);
                    System.out.println("Check-out realizado correctamente.");
                } else {
                    System.out.println("No se encontró check-in con esa habitación.");
                }
                break;

            default:
                System.out.println("Opción inválida.");
                break;
        }
    }
    
    private void reporteEstadiasActivas() {
        System.out.println("\n    HUÉSPEDES ACTUALES EN EL HOTEL    ");
        boolean hayHuespedes = false;

        for (int i = 0; i < checkins.size(); i++) {
            Checkin c = checkins.get(i);
            Habitacion h = c.getHabitacion();
            if (h.getEstado().equalsIgnoreCase("ocupada")) {
                System.out.println("Habitación: " + h.getTipo() + " (ID #" + h.getId() + ")");
                System.out.println("Huéspedes:");
                ArrayList<Huesped> listaH = c.getHuespedes();
                for (int j = 0; j < listaH.size(); j++) {
                    listaH.get(j).mostrarHuesped();
                }
                System.out.println("---------------------------------");
                hayHuespedes = true;
            }
        }

        if (!hayHuespedes) {
            System.out.println("Actualmente no hay huéspedes en el hotel.");
        }
    }
    
    // Estos son los metodos que nos hacen falta para funcionalidades y comprobaciones
    private void consultarReservasCliente(Usuario cliente) { System.out.println("Consultando reservas de " + cliente.getNombre()); }
    private void historialEstanciasCliente(Usuario cliente) { System.out.println("Historial de estancias de " + cliente.getNombre()); }
    private void reporteReservasPorFechas() { System.out.println("Reporte de reservas por fechas..."); }
    
}

