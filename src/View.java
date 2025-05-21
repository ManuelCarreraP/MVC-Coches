import java.util.Scanner;
import java.util.ArrayList;

/**
 * Clase que maneja la interacción con el usuario (patrón MVC).
 */
public class View {
    static Scanner sc = new Scanner(System.in); // Scanner para entrada de usuario.

    /**
     * Muestra la velocidad actual de un coche.
     * @param matricula Matrícula del coche.
     * @param v Velocidad en km/h.
     */
    public static void muestraVelocidad(String matricula, Integer v) {
        System.out.println(matricula + ": " + v + " km/h");
    }

    /**
     * Muestra la lista de coches en el parking.
     * @param coches Lista de coches a mostrar.
     * Si la lista está vacía, muestra un mensaje indicándolo.
     */
    public static void mostrarCoches(ArrayList<Coche> coches) {
        if (coches.isEmpty()) {
            System.out.println("No hay coches en el parking.");
        } else {
            System.out.println("Coches en el parking:");
            for (Coche coche : coches) {
                System.out.println("Matrícula: " + coche.matricula +
                        " | Modelo: " + coche.modelo +
                        " | Velocidad: " + coche.velocidad + " km/h");
            }
        }
    }

    /**
     * Muestra un mensaje al usuario.
     * @param mensaje Mensaje a mostrar.
     */
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Solicita un dato al usuario.
     * @param mensaje Mensaje que se muestra al solicitar el dato.
     * @return El dato introducido por el usuario.
     */
    public static String pedirDato(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    /**
     * Menú principal de la aplicación con opciones para gestionar coches.
     * - Opción 1: Crear un coche.
     * - Opción 2: Cambiar velocidad de un coche.
     * - Opción 3: Mostrar todos los coches.
     * - Opción 0: Salir del programa.
     */
    public static void menu() {
        while (true) {
            System.out.println("-----MENU-----");
            System.out.println("1- Crear coche");
            System.out.println("2- Cambiar velocidad");
            System.out.println("3- Mostrar todos los coches");
            System.out.println("0 - Salir");

            String input = sc.nextLine();

            switch (input) {
                case "1":
                    String modelo = pedirDato("Introduce el modelo: ");
                    String matricula = pedirDato("Introduce la matrícula: ");
                    Controller.crearCoche(modelo, matricula);
                    mostrarMensaje("Coche creado correctamente.");
                    break;
                case "2":
                    matricula = pedirDato("Introduce la matrícula del coche: ");
                    String velocidadInput = pedirDato("Introduce la nueva velocidad: ");
                    try {
                        int velocidad = Integer.parseInt(velocidadInput);
                        int nuevaVelocidad = Controller.cambiarVelocidad(matricula, velocidad);
                        if (nuevaVelocidad != -1) {
                            muestraVelocidad(matricula, nuevaVelocidad);
                        } else {
                            mostrarMensaje("Coche no encontrado.");
                        }
                    } catch (NumberFormatException e) {
                        mostrarMensaje("Velocidad inválida.");
                    }
                    break;
                case "3":
                    mostrarCoches(Controller.obtenerCoches());
                    break;
                case "0":
                    return;
                default:
                    mostrarMensaje("Opción no válida.");
            }
        }
    }
}