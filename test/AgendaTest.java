import java.time.LocalDateTime;

public class AgendaTest {

    public static void main(String[] args) {

        Agenda agenda = new Agenda();

        Evento e = new Evento(
                "Parcial",
                LocalDateTime.now(),
                "Facultad"
        );

        agenda.agregarEvento(e);

        System.out.println("TEST UNITARIO");
        System.out.println(agenda.buscarPorNombre("Parcial"));
    }
}