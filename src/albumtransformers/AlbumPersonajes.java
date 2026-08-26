
package albumtransformers;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class AlbumPersonajes extends JFrame {

    private ArrayList<Jugador> listaAutobots;
    private ArrayList<Enemigo> listaDecepticons;
    
    private Jugador autobotSeleccionado = null;
    private JTextArea consola;

    public AlbumPersonajes() {
        setTitle("Proyecto Transformers - Álbum y Batallas");
        setSize(1100, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); // Fijo para garantizar visualización perfecta

        cargarDatos();
        crearComponentes();
    }

    private void cargarDatos() {
        listaAutobots = new ArrayList<>();
        listaDecepticons = new ArrayList<>();

        // Autobots
        listaAutobots.add(new Jugador("Optimus Prime", 100, 95, "Peterbilt", "/imagenes/optimus.png", "Líder Supremo"));
        listaAutobots.add(new Jugador("Bumblebee", 75, 70, "Camaro", "/imagenes/bumblebee.png", "Explorador"));
        listaAutobots.add(new Jugador("Ironhide", 88, 90, "GMC TopKick", "/imagenes/ironhide.png", "Armas"));
        listaAutobots.add(new Jugador("Ratchet", 80, 65, "Hummer H2", "/imagenes/ratchet.png", "Médico"));
        listaAutobots.add(new Jugador("Jazz", 70, 78, "Solstice", "/imagenes/jazz.png", "2do Al Mando"));

        // Decepticons
        listaDecepticons.add(new Enemigo("Megatron", 100, 98, "Jet", "/imagenes/megatron.png", "Omega"));
        listaDecepticons.add(new Enemigo("Starscream", 72, 75, "F-22 Raptor", "/imagenes/starscream.png", "Alta"));
        listaDecepticons.add(new Enemigo("Barricade", 75, 72, "Mustang", "/imagenes/barricade.png", "Media"));
        listaDecepticons.add(new Enemigo("Blackout", 90, 85, "MH-53", "/imagenes/blackout.png", "Alta"));
        listaDecepticons.add(new Enemigo("Brawl", 95, 88, "M1 Abrams", "/imagenes/brawl.png", "Alta"));
    }

    private void crearComponentes() {
        JPanel contenedor = new JPanel();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
        contenedor.setBackground(new Color(18, 22, 28));
        contenedor.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));

        // Boton CPU arriba
        JButton btnCpu = new JButton("Batalla Aleatoria contra CPU");
        btnCpu.setFont(new Font("Arial", Font.BOLD, 11));
        btnCpu.setBackground(Color.ORANGE);
        btnCpu.addActionListener(e -> peleaCPU());
        
        JPanel panelCpu = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelCpu.setOpaque(false);
        panelCpu.add(btnCpu);
        contenedor.add(panelCpu);
        contenedor.add(Box.createRigidArea(new Dimension(0, 4)));

        // Sección Autobots
        JLabel lblAutobots = new JLabel("AUTOBOTS (JUGADORES):");
        lblAutobots.setForeground(new Color(100, 180, 255));
        lblAutobots.setFont(new Font("Arial", Font.BOLD, 11));
        contenedor.add(lblAutobots);
        contenedor.add(Box.createRigidArea(new Dimension(0, 3)));

        JPanel panelAutobots = new JPanel(new GridLayout(1, 5, 8, 0));
        panelAutobots.setOpaque(false);
        for (Jugador j : listaAutobots) {
            panelAutobots.add(new TarjetaPersonaje(j, new Color(100, 180, 255), this));
        }
        contenedor.add(panelAutobots);
        contenedor.add(Box.createRigidArea(new Dimension(0, 6)));

        // Sección Decepticons
        JLabel lblDecepticons = new JLabel("DECEPTICONS (ENEMIGOS):");
        lblDecepticons.setForeground(new Color(255, 120, 100));
        lblDecepticons.setFont(new Font("Arial", Font.BOLD, 11));
        contenedor.add(lblDecepticons);
        contenedor.add(Box.createRigidArea(new Dimension(0, 3)));

        JPanel panelDecepticons = new JPanel(new GridLayout(1, 5, 8, 0));
        panelDecepticons.setOpaque(false);
        for (Enemigo e : listaDecepticons) {
            panelDecepticons.add(new TarjetaPersonaje(e, new Color(255, 120, 100), this));
        }
        contenedor.add(panelDecepticons);
        contenedor.add(Box.createRigidArea(new Dimension(0, 6)));

        // Consola de resultados
        JLabel lblConsola = new JLabel("REGISTRO DE PELEAS:");
        lblConsola.setForeground(Color.YELLOW);
        lblConsola.setFont(new Font("Arial", Font.BOLD, 11));
        contenedor.add(lblConsola);
        contenedor.add(Box.createRigidArea(new Dimension(0, 2)));

        consola = new JTextArea(5, 50);
        consola.setEditable(false);
        consola.setBackground(new Color(10, 12, 16));
        consola.setForeground(new Color(0, 255, 128));
        consola.setFont(new Font("Monospaced", Font.PLAIN, 11));
        consola.setText("Selecciona un Autobot para comenzar...\n");

        JScrollPane scrollConsola = new JScrollPane(consola);
        contenedor.add(scrollConsola);

        add(contenedor);
    }

    public void procesarSeleccion(Personaje p) {
        if (p instanceof Jugador) {
            autobotSeleccionado = (Jugador) p;
            consola.append("> Seleccionaste a: " + autobotSeleccionado.getNombre() + ". Ahora elige un enemigo.\n");
        } else if (p instanceof Enemigo) {
            if (autobotSeleccionado == null) {
                consola.append("> Primero debes seleccionar un Autobot.\n");
            } else {
                iniciarPelea(autobotSeleccionado, (Enemigo) p);
            }
        }
    }

    private void peleaCPU() {
        Random r = new Random();
        
        Jugador auto = (autobotSeleccionado != null) 
                ? autobotSeleccionado 
                : listaAutobots.get(r.nextInt(listaAutobots.size()));

        Enemigo decep = listaDecepticons.get(r.nextInt(listaDecepticons.size()));
        consola.append("\n[ MODO CPU ] La computadora eligió a " + decep.getNombre() + "\n");
        iniciarPelea(auto, decep);
    }

    private void iniciarPelea(Jugador auto, Enemigo decep) {
        consola.append("=== PELEA: " + auto.getNombre() + " VS " + decep.getNombre() + " ===\n");

        Random r = new Random();

        int danioAuto = auto.getDanio() + r.nextInt(10);
        int danioDecep = decep.getDanio() + r.nextInt(10);

        consola.append(auto.getNombre() + " ataca y causa " + danioAuto + " de daño.\n");
        consola.append(decep.getNombre() + " contraataca y causa " + danioDecep + " de daño.\n");

        if (danioAuto > danioDecep) {
            consola.append("¡Ganó " + auto.getNombre() + "!\n");
        } else if (danioDecep > danioAuto) {
            consola.append("¡Ganó " + decep.getNombre() + "!\n");
        } else {
            consola.append("¡Fue un empate!\n");
        }
        consola.append("=========================================\n\n");

        autobotSeleccionado = null;
    }

    public static void main(String[] args) {
        AlbumPersonajes ventana = new AlbumPersonajes();
        ventana.setVisible(true);
    }
}