/**
 * La clase Cancion representa una canción con atributos como nombre, autor, género y duración.
 */
public class Cancion {
    private String nombre;
    private String autor;
    private String genero;
    private String duracion;

    /**
     * Constructor para crear una instancia de la clase Cancion.
     *
     * @param nombre   Nombre de la canción.
     * @param autor    Autor de la canción.
     * @param genero   Género musical de la canción.
     * @param duracion Duración de la canción en formato de texto (ejemplo: "3:45").
     */
    public Cancion(String nombre, String autor, String genero, String duracion) {
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
        this.duracion = duracion;
    }

    /**
     * Obtiene el nombre de la canción.
     *
     * @return Nombre de la canción.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el autor de la canción.
     *
     * @return Autor de la canción.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Obtiene el género musical de la canción.
     *
     * @return Género de la canción.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Obtiene la duración de la canción.
     *
     * @return Duración de la canción.
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     * Devuelve una representación en formato de cadena de texto de la canción.
     *
     * @return Cadena de texto con los detalles de la canción, incluyendo nombre, autor, género y duración.
     */
    @Override
    public String toString() {
        return "Canción: " + nombre + " | Autor: " + autor + " | Género: " + genero + " | Duración: " + duracion;
    }
}
