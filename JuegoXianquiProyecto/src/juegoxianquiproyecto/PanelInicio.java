/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoxianquiproyecto;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author andres
 */
public class PanelInicio extends JPanel {
    private final VentanaPrincipalApp ventana;
    public PanelInicio(VentanaPrincipalApp ventana){
        this.ventana=ventana;
        setBackground(TemaGUI.FONDO_OSCURO);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(60,60,60,60));
        construirUI();
    }
    private void construirUI(){
        JLabel titulo=new JLabel("--XIANGQI--",SwingConstants.CENTER);
        titulo.setFont(TemaGUI.fuente(Font.BOLD,36));
        titulo.setForeground(TemaGUI.DORADO);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setMaximumSize(new Dimension (360,55));
        JLabel subtitulo=new JLabel("Ajedrez Chino",SwingConstants.CENTER);
        subtitulo.setFont(TemaGUI.fuente(Font.ITALIC,16));
        subtitulo.setForeground(TemaGUI.GRIS_TEXTOS);
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitulo.setMaximumSize(new Dimension(320,24));
        JSeparator separador=new JSeparator();
        separador.setForeground(TemaGUI.DORADO);
        separador.setMaximumSize(new Dimension (300,2));
        separador.setMaximumSize(new Dimension(300,2));
        JLabel etiquetaMenu=new JLabel("--Menú de Inicio--",SwingConstants.CENTER);
        etiquetaMenu.setFont(TemaGUI.fuente(Font.PLAIN, 13));
        etiquetaMenu.setForeground(TemaGUI.GRIS_TEXTOS);
        etiquetaMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiquetaMenu.setMaximumSize(new Dimension (320,20));
        JButton botonLogin=TemaGUI.crearBoton("Iniciar Sesión");
        botonLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton botonCrear=TemaGUI.crearBoton("Crear Jugador");
        botonCrear.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton botonSalir=TemaGUI.crearBoton("Salir");
        botonSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonLogin.addActionListener(e->ventana.mostrarPantalla(VentanaPrincipalApp.PANTALLA_LOGIN));
        botonCrear.addActionListener(e->ventana.mostrarPantalla(VentanaPrincipalApp.PANTALLA_NEWPLAYER));
        botonSalir.addActionListener(e->System.exit(0));
        add(titulo);
        add(Box.createVerticalStrut(6));
        add(subtitulo);
        add(Box.createVerticalStrut(20));
        add(separador);
        add(Box.createVerticalStrut(10));
        add(etiquetaMenu);
        add(Box.createVerticalStrut(40));
        add(botonLogin);
        add(Box.createVerticalStrut(12));
        add(botonCrear);
        add(Box.createVerticalStrut(12));
        add(botonSalir);
    }
}
