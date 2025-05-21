import java.util.ArrayList;

/**
 * Clase intermediaria entre la vista y el modelo (patrón MVC).
 */
public class Controller {

    /**
     * Crea un nuevo coche y lo añade al modelo.
     * @param modelo Modelo del coche.
     * @param matricula Matrícula del coche.
     * @return El coche creado.
     */
    public static Coche crearCoche(String modelo, String matricula) {
        return Model.crearCoche(modelo, matricula);
    }

    /**
     * Cambia la velocidad de un coche existente.
     * @param matricula Matrícula del coche a modificar.
     * @param velocidad Nueva velocidad (km/h).
     * @return La nueva velocidad si el coche existe, -1 si no se encuentra.
     */
    public static int cambiarVelocidad(String matricula, int velocidad) {
        return Model.cambiarVelocidad(matricula, velocidad);
    }

    /**
     * Obtiene la lista de todos los coches almacenados.
     * @return ArrayList con todos los coches.
     */
    public static ArrayList<Coche> obtenerCoches() {
        return Model.obtenerCoches();
    }
}
