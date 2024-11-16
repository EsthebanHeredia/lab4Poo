/**
 * La interfaz InterfazRadioB define los métodos necesarios para el control de una radio con
 * funcionalidades adicionales como manejo de volumen, cambio de frecuencia, reproducción de música
 * y control de llamadas telefónicas.
 */
public interface InterfazRadioB {

    /**
     * Enciende o apaga la radio.
     */
    void encenderApagar();

    /**
     * Ajusta el volumen de la radio.
     *
     * @param ajuste Valor para ajustar el volumen (positivo para subir, negativo para bajar).
     */
    void cambiarVolumen(int ajuste);

    /**
     * Cambia entre las frecuencias disponibles (AM/FM).
     */
    void cambiarFrecuencia();

    /**
     * Cambia la emisora actual. 
     *
     * @param subir Si es verdadero, cambia a la siguiente emisora; si es falso, cambia a la anterior.
     */
    void cambiarEmisora(boolean subir);

    /**
     * Guarda la emisora actual en una lista de emisoras favoritas.
     */
    void guardarEmisora();

    /**
     * Carga una emisora guardada de la lista de emisoras favoritas.
     *
     * @param posicion Índice de la emisora guardada que se desea cargar.
     */
    void cargarEmisora(int posicion);

    /**
     * Selecciona una lista de reproducción específica para reproducir canciones.
     *
     * @param nombreLista Nombre de la lista de reproducción a seleccionar.
     */
    void seleccionarListaReproduccion(String nombreLista);

    /**
     * Cambia la canción en la lista de reproducción actual.
     *
     * @param siguiente Si es verdadero, cambia a la siguiente canción; si es falso, cambia a la anterior.
     */
    void cambiarCancion(boolean siguiente);

    /**
     * Muestra la información de la canción que se está reproduciendo actualmente.
     */
    void mostrarInformacionCancion();

    /**
     * Conecta o desconecta el teléfono al sistema de la radio.
     */
    void conectarDesconectarTelefono();

    /**
     * Muestra la lista de contactos disponibles del teléfono conectado.
     */
    void mostrarContactos();

    /**
     * Realiza una llamada al contacto especificado.
     *
     * @param contacto Nombre del contacto al que se desea llamar.
     */
    void llamarContacto(String contacto);

    /**
     * Finaliza la llamada telefónica en curso.
     */
    void finalizarLlamada();

    /**
     * Llama al último contacto con el que se tuvo comunicación.
     */
    void llamarUltimoContacto();
}
