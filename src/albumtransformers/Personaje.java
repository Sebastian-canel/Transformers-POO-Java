
package albumtransformers;

public abstract class Personaje {

    protected String nombre;
    protected int salud;
    protected int danio;
    protected String habilidadEspecial;
    protected String rutaImagen;

    public Personaje(String nombre, int salud, int danio, String habilidadEspecial, String rutaImagen) {
        this.nombre = nombre;
        this.salud = salud;
        this.danio = danio;
        this.habilidadEspecial = habilidadEspecial;
        this.rutaImagen = rutaImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getDanio() {
        return danio;
    }

    public String getHabilidadEspecial() {
        return habilidadEspecial;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    // Método abstracto lo usamos obligatoriamente para las hijas
    public abstract String getBando();
}