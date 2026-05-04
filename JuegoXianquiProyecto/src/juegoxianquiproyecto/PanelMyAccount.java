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
    private JLabel msjExito;
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
    public PanelMyAccount(VentanaPrincipalApp ventana,String nombreUser,String mensajeExito){
        this.ventana=ventana;
        this.nombreUser=nombreUser;
        setBackground(TemaGUI.FONDO_OSCURO);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(50,80,50,80));
        construirUI();
        msjExito.setForeground(new Color(80,200,80));
        msjExito.setText(mensajeExito);
    }
    private JLabel crearDato(String texto){
        JLabel etiqueta=new JLabel(texto);
        etiqueta.setFont(TemaGUI.fuente(Font.PLAIN,13));
        etiqueta.setForeground(TemaGUI.CREMA);
        etiqueta.setAlignmentX(Component.CENTER_ALIGNMENT);
        return etiqueta;
    }
    private void confirmDelete(){
        JDialog dialogo=new JDialog(ventana,"Elminar Cuenta",true);
        dialogo.setSize(380,280);
        dialogo.setLocationRelativeTo(ventana);
        dialogo.setResizable(false);
        dialogo.setUndecorated(false);
        JPanel panelEliminar=new JPanel();
        panelEliminar.setLayout(new BoxLayout(panelEliminar,BoxLayout.Y_AXIS));
        panelEliminar.setBackground(TemaGUI.FONDO_OSCURO);
        panelEliminar.setBorder(BorderFactory.createEmptyBorder(30,40,300,40));
        JLabel titulo;
        titulo=new JLabel("Eliminar Cuenta",SwingConstants.CENTER);
        titulo.setFont(TemaGUI.fuente(Font.BOLD,20));
        titulo.setForeground(new Color(220,60,60));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setMaximumSize(new Dimension(300,32));
        JLabel aviso,msjError;
        aviso=TemaGUI.crearTexto("Esta accion es irreversible. Ingresa tu contraseña para validar:");
        JPasswordField campoConfirm=TemaGUI.crearCampoContraseña();
        campoConfirm.setAlignmentX(Component.CENTER_ALIGNMENT);
        msjError=TemaGUI.crearMsjError();
        JButton btnConfirm,btnCancel;
        btnConfirm=TemaGUI.crearBoton("Confirmar eliminación");
        btnConfirm.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCancel=TemaGUI.crearBoton("Cancelar");
        btnCancel.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnConfirm.addActionListener(e->{
            String ingreso=new String(campoConfirm.getPassword());
            if(ingreso.isEmpty()){
                msjError.setText("Debes ingresar tu contraseña");
                return;
            }
            boolean eliminado=ventana.getGestor().eliminarPlayer(nombreUser, ingreso);
            if(eliminado){
                dialogo.dispose();
                ventana.mostrarPantalla(VentanaPrincipalApp.PANTALLA_INICIO);
            }
            else{
                msjError.setText("Contraseña incorrecta, intentalo de nuevo");
                campoConfirm.setText("");
            }
        });
        btnCancel.addActionListener(e->dialogo.dispose());
        campoConfirm.addActionListener(e->btnConfirm.doClick());
        panelEliminar.add(titulo);
        panelEliminar.add(Box.createVerticalStrut(10));
        panelEliminar.add(aviso);
        panelEliminar.add(Box.createVerticalStrut(16));
        panelEliminar.add(campoConfirm);
        panelEliminar.add(Box.createVerticalStrut(8));
        panelEliminar.add(msjError);
        panelEliminar.add(Box.createVerticalStrut(12));
        panelEliminar.add(btnConfirm);
        panelEliminar.add(Box.createVerticalStrut(8));
        panelEliminar.add(btnCancel);
        dialogo.setContentPane(panelEliminar);
        dialogo.setVisible(true);
    }
    private void construirUI(){
        JLabel titulo,datoUser,datoPoints,datoGames,datoDate;
        titulo=new JLabel("Mi Cuenta",SwingConstants.CENTER);
        titulo.setFont(TemaGUI.fuente(Font.BOLD,26));
        titulo.setForeground(TemaGUI.DORADO);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setMaximumSize(new Dimension(320,44));
        datoUser=crearDato("Usuario: "+nombreUser);
        Player jugador=ventana.getGestor().buscarPlayerPublico(nombreUser);
        datoPoints=crearDato("Puntos: "+(jugador!=null ? jugador.getPuntos():0));
        datoGames=crearDato("Partidas jugadas: 0");
        datoDate=crearDato("Miembro desde: "+(jugador!=null ? jugador.getIngreso():"-"));
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
        add(Box.createVerticalStrut(10));
        msjExito=TemaGUI.crearMsjError();
        msjExito.setForeground(new Color(80,200,80));
        add(msjExito);
        add(Box.createVerticalStrut(10));
        add(btnPassword);
        add(Box.createVerticalStrut(10));
        add(btnDelete);
        add(Box.createVerticalStrut(10));
        add(btnVolver);
    }
}
