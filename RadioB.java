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

        @Override
    public void cargarEmisora(int posicion) {
        if (encendido && posicion >= 0 && posicion < emisorasGuardadas.size()) {
            emisoraActual = emisorasGuardadas.get(posicion);
            System.out.println("Cargando emisora: " + emisoraActual);
        } else {
            System.out.println("Índice de emisora inválido.");
        }
    }

    @Override
    public void seleccionarListaReproduccion(String nombreLista) {
        if (encendido && listasReproduccion.containsKey(nombreLista)) {
            listaActual = listasReproduccion.get(nombreLista);
            indiceCancion = 0;
            System.out.println("Lista seleccionada: " + nombreLista);
        } else {
            System.out.println("Lista no disponible.");
        }
    }

    @Override
    public void cambiarCancion(boolean siguiente) {
        if (encendido && !listaActual.isEmpty()) {
            indiceCancion = siguiente ? (indiceCancion + 1) % listaActual.size() : (indiceCancion - 1 + listaActual.size()) % listaActual.size();
            mostrarInformacionCancion();
        } else {
            System.out.println("No hay canciones disponibles.");
        }
    }

    @Override
    public void mostrarInformacionCancion() {
        if (!listaActual.isEmpty()) {
            Cancion cancionActual = listaActual.get(indiceCancion);
            System.out.println("Reproduciendo: " + cancionActual);
        }
    }

    @Override
    public void conectarDesconectarTelefono() {
        if (encendido) {
            telefonoConectado = telefonoConectado == null ? "Teléfono genérico" : null;
            System.out.println(telefonoConectado == null ? "Teléfono desconectado." : "Teléfono conectado.");
        }
    }

    @Override
    public void mostrarContactos() {
        if (encendido) {
            System.out.println("Contactos disponibles: " + contactos);
        }
    }

    @Override
    public void llamarContacto(String contacto) {
        if (encendido && contactos.contains(contacto)) {
            ultimoContactoLlamado = contacto;
            llamadaActiva = true;
            System.out.println("Llamando a: " + contacto);
        }
    }

    @Override
    public void finalizarLlamada() {
        if (encendido) {
            if (llamadaActiva) {
                llamadaActiva = false;
                System.out.println("Llamada finalizada.");
            } else {
                System.out.println("No hay llamadas activas.");
            }
        }
    }

    @Override
    public void llamarUltimoContacto() {
        if (encendido && !ultimoContactoLlamado.isEmpty()) {
            llamadaActiva = true;
            System.out.println("Llamando al último contacto: " + ultimoContactoLlamado);
        }
    }

}
