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
public class PanelNewPlayer extends JPanel {
    private final VentanaPrincipalApp ventana;
    private JTextField campoUser;
    private JPasswordField campoContra;
    private JLabel msjError;
    public PanelNewPlayer(VentanaPrincipalApp ventana){
        this.ventana=ventana;
        setBackground(TemaGUI.FONDO_OSCURO);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(60,80,60,80));
        construirUI();
    }
    private void construirUI(){
        JLabel titulo=new JLabel("Crear Jugador",SwingConstants.CENTER);
        titulo.setFont(TemaGUI.fuente(Font.BOLD, 26));
        titulo.setForeground(TemaGUI.DORADO);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setMaximumSize(new Dimension(320,40));
        JLabel aviso=TemaGUI.crearTexto("La contraseña debe tener exactamente 5 caracteres");
        campoUser=TemaGUI.crearCampoTexto();
        campoContra=TemaGUI.crearCampoContraseña();
        msjError=TemaGUI.crearMsjError();
        campoUser.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoContra.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnCrear,btnVolver;
        btnCrear=TemaGUI.crearBoton("Crear");
        btnVolver=TemaGUI.crearBoton("Volver");
        btnCrear.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCrear.addActionListener(e->intentarCrear());
        btnVolver.addActionListener(e->{
            limpiarCampos();
            ventana.mostrarPantalla(VentanaPrincipalApp.PANTALLA_INICIO);
        });
        campoUser.addActionListener(e->campoContra.requestFocus());
        campoContra.addActionListener(e->intentarCrear());
        add(titulo);
        add(Box.createVerticalStrut(6));
        add(aviso);
        add(Box.createVerticalStrut(26));
        add(TemaGUI.crearEtiqueta("Usuario"));
        add(Box.createVerticalStrut(4));
        add(campoUser);
        add(Box.createVerticalStrut(14));
        add(TemaGUI.crearEtiqueta("Contraseña (5 caracteres):"));
        add(Box.createVerticalStrut(4));
        add(campoContra);
        add(Box.createVerticalStrut(10));
        add(msjError);
        add(Box.createVerticalStrut(10));
        add(btnCrear);
        add(Box.createVerticalStrut(10));
        add(btnVolver);
    }
    private void intentarCrear(){
        String user, contra;
        user=campoUser.getText().trim();
        contra=new String(campoContra.getPassword());
        if(user.isEmpty()){
            msjError.setText("El usuario no puede estar vacio");
            return;
        }
        if(!TemaGUI.validPassword(contra)){
            msjError.setText("Minimo: 5 caracteres, 1 mayúscula, 1 minúscula y 1 numero");
            campoContra.setText("");
            return;
        }
        try{
            ventana.getGestor().crearJugador(user,contra);
            limpiarCampos();
            ventana.recargarPantalla(VentanaPrincipalApp.PANTALLA_MAINMENU,new PanelMainMenu(ventana,user));
        }
        catch(UserExistenteException e){
            msjError.setText(e.getMessage());
        }
    }
    private void limpiarCampos(){
        campoUser.setText("");
        campoContra.setText("");
        msjError.setText("");
    }
}
