package Modulos;

import Cliente.*;

/**
 * Este módulo del subsistema realiza el estudio del historial crediticio del cliente.
 * En un sistema real, esta clase consultaría una central de riesgo crediticio.
 *
 * @author Andrés Cerdas Padilla, 20231020053
 * @author Ana Karina Roa Mora, 20232020118
 */
public class Estudiocredito {

    /**
     * Verifica el historial crediticio del cliente para ver si tiene reportes negativos.
     * Esta es otra operación específica dentro del subsistema.
     *
     * @param cliente El objeto cliente cuyo historial crediticio se va a verificar.
     * @return true si el cliente no tiene reportes negativos, false en caso contrario.
     */
    public boolean historialcredito(cliente cliente) {
        System.out.println("Verificando el historial crediticio...");
        // Simulación: Si el nombre del cliente contiene "Malo", se considera reportado.
        if (cliente.getNom().contains("Malo")) {
            System.out.println("El cliente TIENE reportes negativos.\n");
            return false;
        } else {
            System.out.println("El cliente NO tiene reportes negativos.\n");
            return true;
        }
    }
}