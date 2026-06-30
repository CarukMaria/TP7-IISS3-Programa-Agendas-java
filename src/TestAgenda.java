import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestAgenda {

    public static void main(String[] args) {

        Agenda agenda = new Agenda();

        agenda.agregarEvento(
                new Evento(
                        "Parcial POO",
                        LocalDateTime.now().plusDays(10),
                        "Facultad"));

        agenda.agregarEvento(
                new Evento(
                        "Cumpleaños",
                        LocalDateTime.now().plusDays(30),
                        "Casa"));

        agenda.agregarEvento(
                new Evento(
                        "Concierto",
                        LocalDateTime.now().minusDays(15),
                        "Teatro"));

        agenda.agregarEvento(
                new Evento(
                        "Reunión",
                        LocalDateTime.now().plusDays(2),
                        "Zoom"));

        System.out.println("=== Buscar existente ===");

        agenda.buscarPorNombre("Parcial POO")
                .ifPresent(System.out::println);

        System.out.println();

        System.out.println("=== Buscar inexistente ===");

        System.out.println(
                agenda.buscarPorNombre("Evento X")
                        .orElse(null));

        System.out.println();

        System.out.println("=== Eventos próximos ===");

        agenda.eventosProximos(LocalDate.now())
                .forEach(System.out::println);

        System.out.println();

        System.out.println(
                agenda.tiempoHastaEvento("Parcial POO")
                        .orElse("No encontrado"));

        System.out.println(
                agenda.tiempoHastaEvento("Concierto")
                        .orElse("No encontrado"));

        System.out.println();

        Evento evento =
                agenda.buscarPorNombre("Cumpleaños")
                        .orElseThrow();

        System.out.println(evento);
        System.out.println(evento.formatearFecha());

        // No compila:
        // evento.fecha = LocalDateTime.now();
    }
}