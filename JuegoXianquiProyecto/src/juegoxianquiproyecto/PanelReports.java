/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoxianquiproyecto;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author andres
 */
public class PanelReports extends JPanel {
    private final VentanaPrincipalApp ventana;
    private final String nombreUser;
    public PanelReports(VentanaPrincipalApp ventana){
        this(ventana,"Jugador");
    }
    public PanelReports(VentanaPrincipalApp ventana,String nombreUser){
        this.ventana=ventana;
        this.nombreUser=nombreUser;
        setBackground(TemaGUI.FONDO_OSCURO);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(60,80,60,80));
        construirUI();
    }
    private void construirUI(){
        JLabel titulo=new JLabel("Reportes",SwingConstants.CENTER);
        titulo.setFont(TemaGUI.fuente(Font.BOLD,26));
        titulo.setForeground(TemaGUI.DORADO);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnRanking,btnHistorial,btnVolver;
        btnRanking=TemaGUI.crearBoton("Ranking de Jugadores");
        btnRanking.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnHistorial=TemaGUI.crearBoton("Mis últimos juegos");
        btnHistorial.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVolver=TemaGUI.crearBoton("Volver");
        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRanking.addActionListener(e->ventana.recargarPantalla(VentanaPrincipalApp.PANTALLA_RANKING,new PanelRanking(ventana,nombreUser)));
        btnHistorial.addActionListener(e->ventana.recargarPantalla(VentanaPrincipalApp.PANTALLA_HISTORIAL,new PanelHistorial(ventana,nombreUser)));
        btnVolver.addActionListener(e->ventana.recargarPantalla(VentanaPrincipalApp.PANTALLA_MAINMENU,new PanelMainMenu(ventana,nombreUser)));
        add(titulo);
        add(Box.createVerticalStrut(40));
        add(btnRanking);
        add(Box.createVerticalStrut(12));
        add(btnHistorial);
        add(Box.createVerticalStrut(24));
        add(btnVolver);
    }
}
