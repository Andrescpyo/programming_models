package Estados;

import Interfaces.Estado_ascensor;

/**
 * La clase Enservicio es un "Estado Concreto" en el patrón State.
 * Implementa la interfaz Estado_ascensor y proporciona la implementación
 * específica para el comportamiento cuando el ascensor está en servicio.
 */
public class Enservicio implements Estado_ascensor {

    /**
     * Devuelve el nombre descriptivo de este estado concreto.
     * @return Una cadena que describe el estado "En Servicio".
     */
    @Override
    public String getNombreEstado() {
        return "Ascensor en servicio";
    }
}