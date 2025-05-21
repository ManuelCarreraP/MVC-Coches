public class Coche {
    String matricula;    // Almacena la matrícula del coche.
    String modelo;       // Almacena el modelo del coche.
    Integer velocidad;   // Almacena la velocidad actual del coche (inicializada en 0).

    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0; // Constructor: inicializa el coche con modelo, matrícula y velocidad 0.
    }
}
