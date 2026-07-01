import java.time.LocalDate;
import java.time.LocalDateTime;

public class AgendaIntegrationTest {

    public static void main(String[] args) {

        Agenda agenda = new Agenda();

        agenda.agregarEvento(
                new Evento("Reunion",
                        LocalDateTime.now().plusDays(2),
                        "Zoom")
        );

        System.out.println("TEST INTEGRACION");

        System.out.println(
                agenda.eventosProximos(LocalDate.now())
        );
    }
}