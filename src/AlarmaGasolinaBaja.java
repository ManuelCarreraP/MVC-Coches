/**
 * Observador que muestra una alarma cuando la gasolina baja de 10 litros.
 */
public class AlarmaGasolinaBaja implements GasolinaObserver {
    /**
     * Método llamado cuando la gasolina cambia.
     * Muestra una alerta si la gasolina es menor que 10 litros.
     * @param matricula Matrícula del coche.
     * @param nuevaGasolina Nueva cantidad de gasolina.
     */
    @Override
    public void actualizar(String matricula, int nuevaGasolina) {
        if (nuevaGasolina < 10) {
            View.mostrarMensaje("Alerta: Repostar - El coche '" + matricula + "' tiene menos de 10 litros de gasolina. (Gasolina: " + nuevaGasolina + " litros)");
        }
    }
}
