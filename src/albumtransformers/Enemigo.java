
package albumtransformers;

public class Enemigo extends Personaje {

    private String nivelAmenaza;

    public Enemigo(String nombre, int salud, int danio, String habilidadEspecial, String rutaImagen, String nivelAmenaza) {
        super(nombre, salud, danio, habilidadEspecial, rutaImagen);
        this.nivelAmenaza = nivelAmenaza;
    }

    public String getNivelAmenaza() {
        return nivelAmenaza;
    }

    @Override
    public String getBando() {
        return "Decepticon";
    }
}
