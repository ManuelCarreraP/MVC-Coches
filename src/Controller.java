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

    /*
     * Avanza un coche en un determinado número de metros.
     * @return true si el coche puede avanzar, false si no se encuentra.
     */
    public static boolean avanzar(String matricula, int metros) {
        return Model.avanzar(matricula, metros);
    }

    /*
     * Pone gasolina a un coche.
     * @return true si el coche existe, false si no se encuentra.
     */

    public static boolean ponerGasolina(String matricula, double litros) {
        return Model.ponerGasolina(matricula, litros);
    }
}
