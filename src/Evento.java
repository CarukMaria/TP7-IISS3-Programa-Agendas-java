import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evento {

    private String nombre;
    private LocalDateTime fecha;
    private String ubicacion;

    public Evento(String nombre, LocalDateTime fecha, String ubicacion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String formatearFecha() {
        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return fecha.format(formato);
    }

    @Override
    public String toString() {
        return nombre + " - " + fecha + " - " + ubicacion;
    }
}