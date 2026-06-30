import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Agenda {

    private List<Evento> eventos;

    public Agenda() {
        eventos = new ArrayList<>();
    }

    public void agregarEvento(Evento e) {
        eventos.add(e);
    }

    public Optional<Evento> buscarPorNombre(String nombre) {

        return eventos.stream()
                .filter(e -> e.nombre().equalsIgnoreCase(nombre))
                .findFirst();
    }

    public List<Evento> eventosProximos(LocalDate hoy) {

        return eventos.stream()
                .filter(e ->
                        !e.fecha().toLocalDate().isBefore(hoy))
                .toList();
    }

    public Optional<String> tiempoHastaEvento(String nombre) {

        Optional<Evento> evento =
                buscarPorNombre(nombre);

        return evento.map(e -> {

            LocalDate fechaEvento =
                    e.fecha().toLocalDate();

            LocalDate hoy =
                    LocalDate.now();

            Period periodo =
                    Period.between(hoy, fechaEvento);

            if (fechaEvento.isAfter(hoy)) {
                return "Falta "
                        + periodo.getYears() + " años, "
                        + periodo.getMonths() + " meses y "
                        + periodo.getDays() + " días";
            }

            if (fechaEvento.isBefore(hoy)) {

                Period pasado =
                        Period.between(fechaEvento, hoy);

                return "Evento pasado hace "
                        + pasado.getYears() + " años, "
                        + pasado.getMonths() + " meses y "
                        + pasado.getDays() + " días";
            }

            return "El evento es hoy";
        });
    }
}