public class Cancion {
    private String nombre;
    private String autor;
    private String genero;
    private String duracion;

    public Cancion(String nombre, String autor, String genero, String duracion) {
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public String getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return "Canción: " + nombre + " | Autor: " + autor + " | Género: " + genero + " | Duración: " + duracion;
    }
}
