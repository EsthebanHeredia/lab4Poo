import java.io.*;
import java.util.*;

public class RadioB implements InterfazRadioB {
    private boolean encendido;
    private int volumen;
    private String frecuencia;
    private double emisoraActual;
    private List<Double> emisorasGuardadas;
    private Map<String, List<Cancion>> listasReproduccion;
    private List<Cancion> listaActual;
    private int indiceCancion;
    private String telefonoConectado;
    private List<String> contactos;
    private String ultimoContactoLlamado;
    private boolean llamadaActiva;

    public RadioB() {
        this.encendido = false;
        this.volumen = 5;
        this.frecuencia = "FM";
        this.emisoraActual = 88.0;
        this.emisorasGuardadas = new ArrayList<>();
        this.listasReproduccion = new HashMap<>();
        this.listaActual = new ArrayList<>();
        this.indiceCancion = 0;
        this.contactos = Arrays.asList("Juan", "Maria", "Pedro");
        this.ultimoContactoLlamado = "";
        this.llamadaActiva = false;
        cargarListasReproduccion();
    }

    private void cargarListasReproduccion() {
        try (BufferedReader br = new BufferedReader(new FileReader("listas_reproduccion.csv"))) {
            String linea;
            br.readLine(); // Saltar encabezado
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombreLista = datos[0];
                Cancion cancion = new Cancion(datos[1], datos[2], datos[3], datos[4]);

                listasReproduccion.computeIfAbsent(nombreLista, k -> new ArrayList<>()).add(cancion);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar listas de reproducción: " + e.getMessage());
        }
    }

    @Override
    public void encenderApagar() {
        encendido = !encendido;
        System.out.println(encendido ? "Radio encendida" : "Radio apagada");
    }

    @Override
    public void cambiarVolumen(int ajuste) {
        if (encendido) {
            volumen = Math.max(0, volumen + ajuste);
            System.out.println("Volumen actual: " + volumen);
        } else {
            System.out.println("La radio está apagada.");
        }
    }

    @Override
    public void cambiarFrecuencia() {
        if (encendido) {
            frecuencia = frecuencia.equals("FM") ? "AM" : "FM";
            System.out.println("Frecuencia actual: " + frecuencia);
        } else {
            System.out.println("La radio está apagada.");
        }
    }

    @Override
    public void cambiarEmisora(boolean subir) {
        if (encendido) {
            emisoraActual += subir ? 0.5 : -0.5;
            System.out.println("Emisora actual: " + emisoraActual);
        } else {
            System.out.println("La radio está apagada.");
        }
    }

    @Override
    public void guardarEmisora() {
        if (encendido && emisorasGuardadas.size() < 50) {
            emisorasGuardadas.add(emisoraActual);
            System.out.println("Emisora guardada: " + emisoraActual);
        } else {
            System.out.println("No se puede guardar la emisora.");
        }
    }


}
