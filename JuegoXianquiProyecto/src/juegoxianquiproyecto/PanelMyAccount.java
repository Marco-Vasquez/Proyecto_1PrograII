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
public class PanelMyAccount extends JPanel {
    private final VentanaPrincipalApp ventana;
    private final String nombreUser;
    public PanelMyAccount(VentanaPrincipalApp ventana){
        this(ventana,"Jugador");
    }
    public PanelMyAccount(VentanaPrincipalApp ventana,String nombreUser){
        this.ventana=ventana;
        this.nombreUser=nombreUser;
        setBackground(TemaGUI.FONDO_OSCURO);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(50,80,50,80));
        construirUI();
    }
    private JLabel crearDato(String texto){
        JLabel etiqueta=new JLabel(texto);
        etiqueta.setFont(TemaGUI.fuente(Font.PLAIN,13));
        etiqueta.setForeground(TemaGUI.CREMA);
        etiqueta.setAlignmentX(Component.CENTER_ALIGNMENT);
        return etiqueta;
    }
    private void confirmDelete(){
        int respuesta;
        respuesta=JOptionPane.showConfirmDialog(ventana,"Estás seguro de eliminar tu cuenta? Esta acción es irreversible.","Eliminar cuenta",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(respuesta==JOptionPane.YES_OPTION){
            //codigo de eliminación de cuenta
            ventana.mostrarPantalla(VentanaPrincipalApp.PANTALLA_INICIO);
        }
    }
    private void construirUI(){
        JLabel titulo,datoUser,datoPoints,datoGames,datoDate;
        titulo=new JLabel("Mi Cuenta",SwingConstants.CENTER);
        titulo.setFont(TemaGUI.fuente(Font.BOLD,26));
        titulo.setForeground(TemaGUI.DORADO);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setMaximumSize(new Dimension(320,44));
        datoUser=crearDato("Usuario: "+nombreUser);
        datoPoints=crearDato("Puntos: 0");
        datoGames=crearDato("Partidas jugadas: 0");
        datoDate=crearDato("Miembro desde: 27/4/2026");
        JSeparator separador=new JSeparator();
        separador.setForeground(TemaGUI.DORADO);
        separador.setMaximumSize(new Dimension(300,2));
        JButton btnPassword,btnDelete,btnVolver;
        btnPassword=TemaGUI.crearBoton("Cambiar contraseña");
        btnDelete=TemaGUI.crearBoton("Eliminar mi cuenta");
        btnVolver=TemaGUI.crearBoton("Volver");
        btnPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDelete.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnPassword.addActionListener(e->ventana.recargarPantalla(VentanaPrincipalApp.PANTALLA_PASSCHANGE,new PanelPassChange(ventana,nombreUser)));
        btnDelete.addActionListener(e->confirmDelete());
        btnVolver.addActionListener(e->ventana.recargarPantalla(VentanaPrincipalApp.PANTALLA_MAINMENU,new PanelMainMenu(ventana,nombreUser)));
        add(titulo);
        add(Box.createVerticalStrut(24));
        add(datoUser);
        add(Box.createVerticalStrut(8));
        add(datoPoints);
        add(Box.createVerticalStrut(8));
        add(datoGames);
        add(Box.createVerticalStrut(8));
        add(datoDate);
        add(Box.createVerticalStrut(24));
        add(separador);
        add(Box.createVerticalStrut(24));
        add(btnPassword);
        add(Box.createVerticalStrut(10));
        add(btnDelete);
        add(Box.createVerticalStrut(10));
        add(btnVolver);
    }
}
