package Estados;

import Interfaces.Estado_ascensor;

/**
 * La clase Mantenimiento es otro "Estado Concreto" en el patrón State.
 * Implementa la interfaz Estado_ascensor y define el comportamiento
 * cuando el ascensor está en mantenimiento.
 */
public class Mantenimiento implements Estado_ascensor {

    /**
     * Devuelve el nombre descriptivo de este estado concreto.
     * @return Una cadena que describe el estado "Mantenimiento".
     */
    @Override
    public String getNombreEstado() {
        return "Ascensor en mantenimiento - Solicitar servicio";
    }
}