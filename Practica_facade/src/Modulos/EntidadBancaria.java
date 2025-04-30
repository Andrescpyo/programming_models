package Modulos;

import Cliente.*;

/**
 * Este módulo del subsistema se encarga de verificar si el cliente tiene fondos suficientes.
 * En un sistema real, esta clase se comunicaría con la base de datos de cuentas bancarias.
 *
 * @author Andrés Cerdas Padilla, 20231020053
 * @author Ana Karina Roa Mora, 20232020118
 */
public class EntidadBancaria {

    /**
     * Verifica si la cuenta del cliente tiene fondos suficientes para el préstamo.
     * Esta es una operación específica dentro del subsistema.
     *
     * @param cliente El objeto cliente cuya cuenta se va a verificar.
     * @return true si el cliente tiene fondos suficientes, false en caso contrario.
     */
    public boolean Tienefondos(cliente cliente) {
        System.out.println("Verificando si la cuenta tiene fondos...");
        // Simulación: Si el nombre del cliente contiene "SinFondos", se deniega.
        if (cliente.getNom().contains("SinFondos")) {
            System.out.println("La cuenta NO tiene fondos suficientes.\n");
            return false;
        } else {
            System.out.println("La cuenta tiene fondos suficientes.\n");
            return true;
        }
    }
}