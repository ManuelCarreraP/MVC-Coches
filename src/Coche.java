/**
 * Clase que representa un coche con modelo, matrícula y velocidad.
 */
public class Coche {
    String matricula;    // Matrícula del coche.
    String modelo;       // Modelo del coche.
    Integer velocidad;   // Velocidad actual del coche (km/h).

    /**
     * Constructor para crear un nuevo coche.
     * @param modelo El modelo del coche.
     * @param matricula La matrícula del coche.
     * La velocidad inicial del coche será 0.
     */
    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
    }
}