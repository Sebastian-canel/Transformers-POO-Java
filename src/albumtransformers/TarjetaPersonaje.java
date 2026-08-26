
package albumtransformers;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class TarjetaPersonaje extends JPanel {

    private Personaje personaje;
    private AlbumPersonajes ventanaPrincipal;
    private JButton btnBoton;

    public TarjetaPersonaje(Personaje personaje, Color colorBorde, AlbumPersonajes ventanaPrincipal) {
        this.personaje = personaje;
        this.ventanaPrincipal = ventanaPrincipal;

        setLayout(new BorderLayout(1, 1));
        setBackground(new Color(30, 35, 45));
        setBorder(BorderFactory.createLineBorder(colorBorde, 1));

        // Nombre
        JLabel lblNombre = new JLabel(personaje.getNombre(), SwingConstants.CENTER);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 11));
        lblNombre.setForeground(Color.WHITE);
        add(lblNombre, BorderLayout.NORTH);

        // Imagen central
        JLabel lblImagen = new JLabel();
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        
        URL ruta = getClass().getResource(personaje.getRutaImagen());
        if (ruta != null) {
            ImageIcon img = new ImageIcon(ruta);
            Image imgEscalada = img.getImage().getScaledInstance(75, 45, Image.SCALE_SMOOTH);
            lblImagen.setIcon(new ImageIcon(imgEscalada));
        } else {
            lblImagen.setText("[" + personaje.getNombre() + "]");
            lblImagen.setFont(new Font("Arial", Font.PLAIN, 9));
            lblImagen.setForeground(Color.GRAY);
        }
        add(lblImagen, BorderLayout.CENTER);

        // Panel con los datos
        JPanel panelDatos = new JPanel(new GridLayout(4, 1, 0, 0));
        panelDatos.setOpaque(false);

        panelDatos.add(crearLabelInfo("HP: " + personaje.getSalud()));
        panelDatos.add(crearLabelInfo("Ataque: " + personaje.getDanio()));

        if (personaje instanceof Jugador) {
            Jugador j = (Jugador) personaje;
            panelDatos.add(crearLabelInfo("Rol: " + j.getRolCombate()));
            btnBoton = new JButton("Seleccionar");
        } else {
            Enemigo e = (Enemigo) personaje;
            panelDatos.add(crearLabelInfo("Amenaza: " + e.getNivelAmenaza()));
            btnBoton = new JButton("Atacar");
        }

        btnBoton.setFont(new Font("Arial", Font.BOLD, 10));
        btnBoton.setBackground(colorBorde);
        btnBoton.setForeground(Color.BLACK);
        btnBoton.setMargin(new Insets(2, 2, 2, 2));
        
        btnBoton.addActionListener(e -> {
            ventanaPrincipal.procesarSeleccion(personaje);
        });

        panelDatos.add(btnBoton);
        add(panelDatos, BorderLayout.SOUTH);
    }

    private JLabel crearLabelInfo(String texto) {
        JLabel lbl = new JLabel(texto, SwingConstants.CENTER);
        lbl.setFont(new Font("Arial", Font.PLAIN, 9));
        lbl.setForeground(new Color(200, 205, 215));
        return lbl;
    }
}
