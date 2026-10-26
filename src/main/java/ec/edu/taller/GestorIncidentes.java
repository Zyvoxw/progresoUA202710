package ec.edu.taller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class GestorIncidentes {

    private Queue<IncidenteSeguridad> colaIncidentes;
    private int capacidadMaxima;

    public GestorIncidentes(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.colaIncidentes = new PriorityQueue<>(
                Comparator.comparingInt(incidente -> incidente.getPrioridad())
        );
    }

    public boolean registrarIncidente(IncidenteSeguridad incidente) {

        if (incidente == null) {
            return false;
        }

        if (incidente.getCodigo() == null ||
                incidente.getCodigo().trim().isEmpty()) {
            return false;
        }

        if (existeIncidente(incidente.getCodigo())) {
            return false;
        }

        if (colaIncidentes.size() >= capacidadMaxima) {
            return false;
        }

        return colaIncidentes.offer(incidente);
    }

    public boolean existeIncidente(String codigo) {

        if (codigo == null || codigo.trim().isEmpty()) {
            return false;
        }

        for (IncidenteSeguridad incidente : colaIncidentes) {
            if (incidente.getCodigo().equals(codigo)) {
                return true;
            }
        }

        return false;
    }

    public IncidenteSeguridad consultarSiguienteIncidente() {

        return colaIncidentes.peek();
    }

    public IncidenteSeguridad atenderSiguienteIncidente() {

        IncidenteSeguridad incidente = colaIncidentes.poll();

        if (incidente != null) {
            incidente.setEstado("ATENDIDO");
        }

        return incidente;
    }

    public int contarIncidentesPendientes() {

        return colaIncidentes.size();
    }

    public int consultarEspaciosDisponibles() {

        return capacidadMaxima - colaIncidentes.size();
    }

    public List<IncidenteSeguridad> listarIncidentes() {

        List<IncidenteSeguridad> lista =
                new ArrayList<>(colaIncidentes);
        lista.sort(Comparator.comparingInt(incidente -> incidente.getPrioridad()));

        return lista;
    }
}