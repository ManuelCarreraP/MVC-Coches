import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un coche con modelo, matrícula y velocidad.
 * Ahora implementa funcionalidad Observable para notificar cambios en la gasolina.
 */
public class Coche {
    public int gasolina; // Litros de gasolina.
    String matricula;    // Matrícula del coche.
    String modelo;       // Modelo del coche.
    Integer velocidad;   // Velocidad actual del coche (km/h).
    private List<GasolinaObserver> observadores = new ArrayList<>();

    /**
     * Constructor para crear un nuevo coche.
     * @param modelo El modelo del coche.
     * @param matricula La matrícula del coche.
     * La velocidad inicial del coche será 0 y la gasolina también.
     */
    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
        this.gasolina = 0;
    }

    /**
     * Establece la cantidad de gasolina y notifica a los observadores si hay cambio.
     * @param gasolina Nueva cantidad de gasolina.
     */
    public void setGasolina(int gasolina) {
        if (this.gasolina != gasolina) {
            this.gasolina = gasolina;
            notificarObservadores();
        }
    }

    /**
     * Añade un observador a la lista.
     * @param observador Observador a añadir.
     */
    public void añadirObservador(GasolinaObserver observador) {
        observadores.add(observador);
    }

    /**
     * Notifica a todos los observadores sobre el cambio en la gasolina.
     */
    private void notificarObservadores() {
        for (GasolinaObserver observador : observadores) {
            observador.actualizar(matricula, gasolina);
        }
    }
}