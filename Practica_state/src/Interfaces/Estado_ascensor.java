package Interfaces;

/**
 * La interfaz Estado_ascensor es la "Interfaz de Estado" (State Interface)
 * en el patrón State.
 * Declara las operaciones que todos los objetos de estado concreto deben implementar.
 * El Contexto (Ascensor) usa esta interfaz para delegar su comportamiento
 * sin conocer la implementación específica de los estados concretos.
 */
public interface Estado_ascensor {
    /**
     * Obtiene el nombre descriptivo del estado actual.
     * En un diseño más complejo, aquí habría métodos para las acciones
     * que el ascensor puede realizar (ej. `pedir`, `mover`, `detener`, `entrarMantenimiento`),
     * y cada estado concreto implementaría esos métodos de manera diferente.
     * @return El nombre del estado.
     */
    String getNombreEstado();
}