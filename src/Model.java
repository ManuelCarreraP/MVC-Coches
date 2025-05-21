import java.util.ArrayList;

/**
 * Clase que gestiona la lógica de negocio y los datos (patrón MVC).
 */
public class Model {
    public static ArrayList<Coche> parking = new ArrayList<>(); // Almacén de coches.

    /**
     * Crea un coche y lo añade al parking.
     * @param modelo Modelo del coche.
     * @param matricula Matrícula del coche.
     * @return El coche creado.
     */
    public static Coche crearCoche(String modelo, String matricula) {
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca un coche por su matrícula.
     * @param matricula Matrícula a buscar.
     * @return El coche si existe, null si no se encuentra.
     */
    public static Coche getCoche(String matricula) {
        for (Coche e : parking) {
            if (e.matricula.equals(matricula)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Cambia la velocidad de un coche existente.
     * @param matricula Matrícula del coche.
     * @param vel Nueva velocidad (km/h).
     * @return La nueva velocidad si el coche existe, -1 si no se encuentra.
     */
    public static int cambiarVelocidad(String matricula, int vel) {
        Coche c = getCoche(matricula);
        if (c != null) {
            c.velocidad = vel;
            return c.velocidad;
        }
        return -1;
    }

    /**
     * Devuelve una copia de la lista de coches en el parking.
     * @return ArrayList con todos los coches.
     */
    public static ArrayList<Coche> obtenerCoches() {
        return parking;
    }
}