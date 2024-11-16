import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase principal que simula el funcionamiento de una radio con diversas funcionalidades.
 * Permite encender la radio, cambiar volumen, frecuencia, emisora, reproducir canciones,
 * manejar llamadas telefónicas y más. Utiliza un menú interactivo para realizar las operaciones.
 */
public class Main {

    /**
     * Método principal que ejecuta el menú interactivo y controla la ejecución de las opciones seleccionadas por el usuario.
     * @param args Argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        RadioB radio = new RadioB(); 
        int opcion = -1; // Inicializar la variable opcion

        do {
            limpiarPantalla();

            // Mostrar el menú principal
            System.out.println("\n---- Menú Principal ----");
            System.out.println("1. Encender/Apagar Radio");
            System.out.println("2. Cambiar Volumen");
            System.out.println("3. Cambiar Frecuencia (AM/FM)");
            System.out.println("4. Cambiar Emisora");
            System.out.println("5. Guardar Emisora");
            System.out.println("6. Cargar Emisora Guardada");
            System.out.println("7. Seleccionar Lista de Reproducción");
            System.out.println("8. Cambiar Canción");
            System.out.println("9. Mostrar Información de Canción");
            System.out.println("10. Conectar/Desconectar Teléfono");
            System.out.println("11. Mostrar Contactos");
            System.out.println("12. Llamar a Contacto");
            System.out.println("13. Finalizar Llamada");
            System.out.println("14. Llamar al Último Contacto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt(); 
                scanner.nextLine(); // Limpiar el buffer de entrada

                // Ejecutar la acción correspondiente a la opción seleccionada
                switch (opcion) {
                    case 1 -> radio.encenderApagar(); // Encender o apagar la radio
                    case 2 -> {
                        System.out.print("Ingrese el cambio de volumen (+/-) valor de cambio deseado: ");
                        int cambio = scanner.nextInt(); // Leer el cambio de volumen
                        scanner.nextLine(); // Limpiar el buffer de entrada
                        radio.cambiarVolumen(cambio); // Cambiar el volumen de la radio
                    }
                    case 3 -> radio.cambiarFrecuencia(); // Cambiar la frecuencia de la radio
                    case 4 -> {
                        System.out.print("¿Subir o bajar emisora? (true/false): ");
                        boolean subir = scanner.nextBoolean(); // Leer si se debe subir o bajar la emisora
                        scanner.nextLine(); // Limpiar el buffer de entrada
                        radio.cambiarEmisora(subir); // Cambiar la emisora de la radio
                    }
                    case 5 -> radio.guardarEmisora(); // Guardar la emisora actual
                    case 6 -> {
                        System.out.print("Ingrese el índice de la emisora guardada: ");
                        int indice = scanner.nextInt(); // Leer el índice de la emisora guardada
                        scanner.nextLine(); // Limpiar el buffer de entrada
                        radio.cargarEmisora(indice); // Cargar la emisora guardada
                    }
                    case 7 -> {
                        System.out.print("Ingrese el nombre de la lista de reproducción: ");
                        String nombreLista = scanner.nextLine(); // Leer el nombre de la lista de reproducción
                        radio.seleccionarListaReproduccion(nombreLista); // Seleccionar la lista de reproducción
                    }
                    case 8 -> {
                        System.out.print("¿Siguiente canción? (true/false): ");
                        boolean siguiente = scanner.nextBoolean(); // Leer si se debe cambiar a la siguiente canción
                        scanner.nextLine(); // Limpiar el buffer de entrada
                        radio.cambiarCancion(siguiente); // Cambiar la canción
                    }
                    case 9 -> radio.mostrarInformacionCancion(); // Mostrar información de la canción actual
                    case 10 -> radio.conectarDesconectarTelefono(); // Conectar o desconectar el teléfono
                    case 11 -> radio.mostrarContactos(); // Mostrar los contactos del teléfono
                    case 12 -> {
                        System.out.print("Ingrese el nombre del contacto a llamar: ");
                        String contacto = scanner.nextLine(); // Leer el nombre del contacto a llamar
                        radio.llamarContacto(contacto); // Llamar al contacto
                    }
                    case 13 -> radio.finalizarLlamada(); // Finalizar la llamada actual
                    case 14 -> radio.llamarUltimoContacto(); // Llamar al último contacto
                    case 0 -> System.out.println("Saliendo del sistema..."); // Salir del sistema
                    default -> System.out.println("Opción inválida. Intente de nuevo."); // Manejar opción inválida
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número."); // Manejar entrada inválida
                scanner.nextLine(); // Limpiar el buffer de entrada
            }

            // Pausa para que el usuario presione Enter antes de limpiar la pantalla
            System.out.println("Presione Enter para continuar...");
            scanner.nextLine();

        } while (opcion != 0); // Repetir hasta que el usuario seleccione la opción de salir

        scanner.close(); // Cerrar el scanner
    }

    /**
     * Método que limpia la pantalla de la consola dependiendo del sistema operativo.
     * En sistemas Windows se usa "cmd", en otros sistemas se usa el comando "clear".
     */
    private static void limpiarPantalla() {
        try {
            // Limpiar pantalla en Windows
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Limpiar pantalla en otros sistemas operativos
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("No se pudo limpiar la consola."); // Manejar error al limpiar la pantalla
        }
    }
}
