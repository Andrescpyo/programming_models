package Facade;

/**
 * La clase FacadePrestamo actúa como una fachada para el subsistema de verificación de préstamos.
 * Simplifica la interacción del cliente con los módulos complejos de verificación.
 * Proporciona un único punto de entrada para determinar si un cliente es elegible para un préstamo
 * y gestiona el estado de los préstamos activos.
 *
 * @author Andrés Cerdas Padilla, 20231020053
 * @author Ana Karina Roa Mora, 20232020118
 */
import Modulos.*;
import Cliente.*;

public class FacadePrestamo {

    private EntidadBancaria entidadBancaria;
    private Estudiocredito estudioCredito;
    private Solicitudprestamo solicitudPrestamo;

    public FacadePrestamo() {
        this.entidadBancaria = new EntidadBancaria();
        this.estudioCredito = new Estudiocredito();
        this.solicitudPrestamo = new Solicitudprestamo();
    }

    /**
     * Verifica si un cliente cumple con todos los requisitos para un préstamo.
     * Esta es la interfaz simplificada que la clase cliente utiliza.
     * Internamente, coordina las verificaciones con los diferentes módulos del subsistema.
     *
     * @param cliente El objeto cliente que se va a evaluar para el préstamo.
     * @return true si el cliente cumple con todos los requisitos, false en caso contrario.
     */
    public boolean verificarPrestamo(cliente cliente) {
        boolean tieneFondos = this.entidadBancaria.Tienefondos(cliente);
        boolean historialOk = this.estudioCredito.historialcredito(cliente);
        boolean sinPrestamo = this.solicitudPrestamo.poseeprestamo(cliente);

        if (tieneFondos && historialOk && sinPrestamo) {
            System.out.println("\nSe le otorgo el prestamo a " + cliente.getNom());
            this.solicitudPrestamo.otorgarPrestamo(cliente); // La fachada gestiona el otorgamiento
            return true;
        } else {
            System.out.println("\nNo Se le otorgo el prestamo a " + cliente.getNom());
            return false;
        }
    }
}