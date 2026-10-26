package ec.edu.taller;

public class Ventana {

    private GestorIncidentes gestor;

    public Ventana() {
        gestor = new GestorIncidentes(10);

        gestor.registrarIncidente(new IncidenteSeguridad(
                "INC-001", "PHISHING", "Correo sospechoso", 5));

        gestor.registrarIncidente(new IncidenteSeguridad(
                "INC-002", "MALWARE", "Archivo malicioso", 1));

        gestor.registrarIncidente(new IncidenteSeguridad(
                "INC-003", "ACCESO_NO_AUTORIZADO", "Intento de acceso", 3));

        gestor.registrarIncidente(new IncidenteSeguridad(
                "INC-004", "FUGA_DATOS", "Posible fuga de datos", 2));

        gestor.registrarIncidente(new IncidenteSeguridad(
                "INC-005", "OTRO", "Actividad sospechosa", 4));

        gestor.registrarIncidente(new IncidenteSeguridad(
                "INC-006", "PHISHING", "Enlace sospechoso", 3));

        gestor.registrarIncidente(new IncidenteSeguridad(
                "INC-007", "MALWARE", "Programa malicioso", 2));

        gestor.registrarIncidente(new IncidenteSeguridad(
                "INC-008", "ACCESO_NO_AUTORIZADO", "Inicio de sesión sospechoso", 1));
    }
}
