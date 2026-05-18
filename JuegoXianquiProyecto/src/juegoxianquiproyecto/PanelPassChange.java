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
public class PanelPassChange extends JPanel {
    private final VentanaPrincipalApp ventana;
    private final String nombreUser;
    private JPasswordField campoAct;
    private JPasswordField campoNuevo;
    private JLabel msjError;
    public PanelPassChange(VentanaPrincipalApp ventana){
        this(ventana,"Jugador");
    }
    public PanelPassChange(VentanaPrincipalApp ventana, String nombreUser){
        this.ventana=ventana;
        this.nombreUser=nombreUser;
        setBackground(TemaGUI.FONDO_OSCURO);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(60,80,60,80));
        construirUI();
    }
    private void intentarCambiar(){
        String actual, nueva;
        actual=new String(campoAct.getPassword());
        nueva=new String(campoNuevo.getPassword());
        if(actual.isEmpty()){
            msjError.setText("Debes de ingresar tu contraseña actual");
            return;
        }
        if(!TemaGUI.validPassword(nueva)){
            msjError.setText("Minimo: 5 caracteres, 1 mayúscula, 1 minúscula y 1 numero");
            campoNuevo.setText("");
            return;
        }
        boolean cambio;
        cambio=ventana.getGestor().changePassword(nombreUser,actual,nueva);
        if(cambio){
            ventana.recargarPantalla(VentanaPrincipalApp.PANTALLA_MYACCOUNT,new PanelMyAccount(ventana,nombreUser,"Contraseña cambiada exitosamente"));   
        }
        else{
            msjError.setText("Revisa que ingresaste la contraseña actual correcta");
            campoAct.setText("");
        }
        
    }
    private void construirUI(){
        JLabel titulo, aviso;
        titulo=new JLabel("Cambiar Contraseña", SwingConstants.CENTER);
        titulo.setFont(TemaGUI.fuente(Font.BOLD,24));
        titulo.setForeground(TemaGUI.DORADO);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setMaximumSize(new Dimension(320,44));
        aviso=TemaGUI.crearTexto("La nueva contraseña debe contener exactamente 5 caracteres");
        campoAct=TemaGUI.crearCampoContraseña();
        campoAct.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoNuevo=TemaGUI.crearCampoContraseña();
        campoNuevo.setAlignmentX(Component.CENTER_ALIGNMENT);
        msjError=TemaGUI.crearMsjError();
        msjError.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnGuardar,btnVolver;
        btnGuardar=TemaGUI.crearBoton("Guardar");
        btnGuardar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVolver=TemaGUI.crearBoton("Volver");
        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnGuardar.addActionListener(e->intentarCambiar());
        btnVolver.addActionListener(e->ventana.recargarPantalla(VentanaPrincipalApp.PANTALLA_MYACCOUNT,new PanelMyAccount(ventana,nombreUser)));
        campoAct.addActionListener(e->campoNuevo.requestFocus());
        campoNuevo.addActionListener(e->intentarCambiar());
        add(titulo);
        add(Box.createVerticalStrut(6));
        add(aviso);
        add(Box.createVerticalStrut(28));
        add(TemaGUI.crearEtiqueta("Contraseña actual:"));
        add(Box.createVerticalStrut(4));
        add(campoAct);
        add(Box.createVerticalStrut(14));
        add(TemaGUI.crearEtiqueta("Nueva contraseña (5 caracteres):"));
        add(Box.createVerticalStrut(4));
        add(campoNuevo);
        add(Box.createVerticalStrut(10));
        add(msjError);
        add(Box.createVerticalStrut(10));
        add(btnGuardar);
        add(Box.createVerticalStrut(10));
        add(btnVolver);
    }
}
