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
public class PanelMainMenu extends JPanel{
    private final VentanaPrincipalApp ventana;
    private final String nombreUser;
    public PanelMainMenu(VentanaPrincipalApp ventana){
        this(ventana,"Jugador");
    }
    public PanelMainMenu(VentanaPrincipalApp ventana, String nombreUser){
        this.ventana=ventana;
        this.nombreUser=nombreUser;
        setBackground(TemaGUI.FONDO_OSCURO);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(60,60,60,60));
        construirUI();
    }
    private void construirUI(){
        JLabel titulo=new JLabel("Menú Principal",SwingConstants.CENTER);
        titulo.setFont(TemaGUI.fuente(Font.BOLD, 28));
        titulo.setForeground(TemaGUI.DORADO);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setMaximumSize(new Dimension(320,44));
        JLabel msjBienvenida=new JLabel("Bienvenido "+nombreUser,SwingConstants.CENTER);
        msjBienvenida.setFont(TemaGUI.fuente(Font.ITALIC,14));
        msjBienvenida.setForeground(TemaGUI.GRIS_TEXTOS);
        msjBienvenida.setAlignmentX(Component.CENTER_ALIGNMENT);
        msjBienvenida.setMaximumSize(new Dimension(320,22));
        JSeparator separador=new JSeparator();
        separador.setForeground(TemaGUI.DORADO);
        separador.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnJugar,btnCuenta,btnReports,btnExit;
        btnJugar=TemaGUI.crearBoton("Jugar Xiangqi");
        btnCuenta=TemaGUI.crearBoton("Mi Cuenta");
        btnReports=TemaGUI.crearBoton("Reportes");
        btnExit=TemaGUI.crearBoton("Cerrar Sesión");
        btnJugar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCuenta.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnReports.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnJugar.addActionListener(e->ventana.recargarPantalla(VentanaPrincipalApp.PANTALLA_PLAY,new PanelPlay(ventana,nombreUser)));
        btnCuenta.addActionListener(e->ventana.recargarPantalla(VentanaPrincipalApp.PANTALLA_MYACCOUNT,new PanelMyAccount(ventana,nombreUser)));
        btnReports.addActionListener(e->ventana.recargarPantalla(VentanaPrincipalApp.PANTALLA_REPORTS,new PanelReports(ventana,nombreUser)));
        btnExit.addActionListener(e->{
            int respuesta;
            respuesta=JOptionPane.showConfirmDialog(ventana, "Deseas cerrar sesión?","Cerrar Sesión",JOptionPane.YES_NO_OPTION);
            if(respuesta==JOptionPane.YES_OPTION)
                ventana.mostrarPantalla(VentanaPrincipalApp.PANTALLA_INICIO);
        });
        add(titulo);
        add(Box.createVerticalStrut(6));
        add(msjBienvenida);
        add(Box.createVerticalStrut(20));
        add(separador);
        add(Box.createVerticalStrut(36));
        add(btnJugar);
        add(Box.createVerticalStrut(12));
        add(btnCuenta);
        add(Box.createVerticalStrut(12));
        add(btnReports);
        add(Box.createVerticalStrut(24));
        add(btnExit);
    
    }
}
