
package albumtransformers;

public class Jugador extends Personaje {

    private String rolCombate;

    public Jugador(String nombre, int salud, int danio, String habilidadEspecial, String rutaImagen, String rolCombate) {
        super(nombre, salud, danio, habilidadEspecial, rutaImagen);
        this.rolCombate = rolCombate;
    }

    public String getRolCombate() {
        return rolCombate;
    }

    @Override
    public String getBando() {
        return "Autobot";
    }
}
