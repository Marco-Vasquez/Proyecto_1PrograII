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
public class PanelLogin extends JPanel{
    private final VentanaPrincipalApp ventana;
    private JTextField campoUser;
    private JPasswordField campoContra;
    private JLabel msjError;
    public PanelLogin(VentanaPrincipalApp ventana){
        this.ventana=ventana;
        setBackground(TemaGUI.FONDO_OSCURO);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(60,80,60,80));
        construirUI();
    }
    private void construirUI(){
        JLabel titulo=new JLabel("Iniciar Sesión",SwingConstants.CENTER);
        titulo.setFont(TemaGUI.fuente(Font.BOLD, 26));
        titulo.setForeground(TemaGUI.DORADO);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoUser=TemaGUI.crearCampoTexto();
        campoContra=TemaGUI.crearCampoContraseña();
        msjError=TemaGUI.crearMsjError();
        campoUser.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoContra.setAlignmentX(Component.CENTER_ALIGNMENT);
        msjError.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnEntrar=TemaGUI.crearBoton("Entrar");
        JButton btnVolver=TemaGUI.crearBoton("Volver");
        btnEntrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEntrar.addActionListener(e->intentarLogin());
        btnVolver.addActionListener(e->{
            limpiarCampos();
            ventana.mostrarPantalla(VentanaPrincipalApp.PANTALLA_INICIO);
        });
        campoUser.addActionListener(e->campoContra.requestFocus());
        campoContra.addActionListener(e->intentarLogin());
        add(titulo);
        add(Box.createVerticalStrut(30));
        add(TemaGUI.crearEtiqueta("Usuario:"));
        add(Box.createVerticalStrut(4));
        add(campoUser);
        add(Box.createVerticalStrut(14));
        add(TemaGUI.crearEtiqueta("Contraseña:"));
        add(Box.createVerticalStrut(4));
        add(campoContra);
        add(Box.createVerticalStrut(10));
        add(msjError);
        add(Box.createVerticalStrut(10));
        add(btnEntrar);
        add(Box.createVerticalStrut(10));
        add(btnVolver);
    }
    private void intentarLogin(){
        String user,contra;
        user=campoUser.getText().trim();
        contra=new String(campoContra.getPassword());
        if(user.isEmpty()){
            msjError.setText("El usuario no puede estar vacio");
            return;
        }    
        if(contra.isEmpty()){
            msjError.setText("La contraseña no puede estar vacia");
            return;
        }
        Player jugador=ventana.getGestor().login(user,contra);
        if(jugador!=null){
            limpiarCampos();
            ventana.recargarPantalla(VentanaPrincipalApp.PANTALLA_MAINMENU,new PanelMainMenu(ventana,user));
        }
        else{
            msjError.setText("Usuario o contraseña incorrectos");
            campoContra.setText("");
        }
    }
    private void limpiarCampos(){
        campoUser.setText("");
        campoContra.setText("");
        msjError.setText("");
    }
}
