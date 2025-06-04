/**
 * Interfaz para los observadores que monitorean cambios en los coches.
 */
public interface GasolinaObserver {
    /**
     * Método llamado cuando la gasolina de un coche cambia.
     * @param matricula Matrícula del coche.
     * @param nuevaGasolina Nueva cantidad de gasolina.
     */
    void actualizar(String matricula, int nuevaGasolina);
}