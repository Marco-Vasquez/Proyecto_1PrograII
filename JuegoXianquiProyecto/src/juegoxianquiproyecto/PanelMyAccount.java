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
    private JPanel panelConfirm;
    private JPasswordField campoConfirmDelete;
    private JLabel msjErrorDelete;
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
    private void mostrarConfirmDelete(boolean mostrar){
        panelConfirm.setVisible(mostrar);
        campoConfirmDelete.setText("");
        msjErrorDelete.setText("");
        revalidate();
        repaint();
    }
    private void construirUI(){
        JLabel titulo=new JLabel("Mi Cuenta",SwingConstants.CENTER);
        titulo.setFont(TemaGUI.fuente(Font.BOLD,26));
        titulo.setForeground(TemaGUI.DORADO);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setMaximumSize(new Dimension(320,44));
        Player jugador;
        jugador=ventana.getGestor().buscarPlayerPublico(nombreUser);
        JLabel datoUser,datoPoints,datoGames,datoDate;
        datoUser=crearDato("Usuario: "+nombreUser);
        datoPoints=crearDato("Puntos: "+(jugador!=null ? jugador.getPuntos():0));
        datoGames=crearDato("Partidas jugadas: "+(jugador!=null ? jugador.getPartidasJugadas():0));
        datoDate=crearDato("Miembro desde: "+(jugador!=null ? jugador.getIngreso():"-"));
        JSeparator separador;
        separador=new JSeparator();
        separador.setForeground(TemaGUI.DORADO);
        separador.setMaximumSize(new Dimension(300,2));
        msjExito=TemaGUI.crearMsjError();
        msjExito.setForeground(new Color(80,200,80));
        JButton btnPassword,btnDelete,btnVolver;
        btnPassword=TemaGUI.crearBoton("Cambiar contraseña");
        btnPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDelete=TemaGUI.crearBoton("Elminiar mi cuenta");
        btnDelete.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVolver=TemaGUI.crearBoton("Volver");
        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelConfirm=new JPanel();
        panelConfirm.setLayout(new BoxLayout(panelConfirm,BoxLayout.Y_AXIS));
        panelConfirm.setBackground(TemaGUI.FONDO_OSCURO);
        panelConfirm.setVisible(false);
        JLabel avisoDelete=TemaGUI.crearTexto("Ingresa tu contraseña para confirmar:");
        campoConfirmDelete=TemaGUI.crearCampoContraseña();
        campoConfirmDelete.setAlignmentX(Component.CENTER_ALIGNMENT);
        msjErrorDelete=TemaGUI.crearMsjError();
        JButton btnConfirm,btnCancel;
        btnConfirm=TemaGUI.crearBoton("Confirmar eliminación");
        btnConfirm.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCancel=TemaGUI.crearBoton("Cancelar");
        btnCancel.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnConfirm.addActionListener(e->{
            String ingreso;
            ingreso=new String(campoConfirmDelete.getPassword());
            if(ingreso.isEmpty()){
                msjErrorDelete.setText("Debes ingresar tu contraseña");
                return;
            }
            try{
                ventana.getGestor().eliminarPlayerValidado(nombreUser, ingreso);
                ventana.mostrarPantalla(VentanaPrincipalApp.PANTALLA_INICIO);
            }
            catch(IncorrectPasswordException ex){
                msjErrorDelete.setText(ex.getMessage());
                campoConfirmDelete.setText("");
            }
        });
        btnCancel.addActionListener(e->mostrarConfirmDelete(false));
        campoConfirmDelete.addActionListener(e->btnConfirm.doClick());
        panelConfirm.add(avisoDelete);
        panelConfirm.add(Box.createVerticalStrut(6));
        panelConfirm.add(campoConfirmDelete);
        panelConfirm.add(Box.createVerticalStrut(4));
        panelConfirm.add(msjErrorDelete);
        panelConfirm.add(Box.createVerticalStrut(8));
        panelConfirm.add(btnConfirm);
        panelConfirm.add(Box.createVerticalStrut(6));
        panelConfirm.add(btnCancel);
        btnPassword.addActionListener(e->ventana.recargarPantalla(VentanaPrincipalApp.PANTALLA_PASSCHANGE,new PanelPassChange(ventana,nombreUser)));
        btnDelete.addActionListener(e->mostrarConfirmDelete(true));
        btnVolver.addActionListener(e->ventana.recargarPantalla(VentanaPrincipalApp.PANTALLA_MAINMENU,new PanelMainMenu(ventana,nombreUser)));
        add(titulo);
        add(Box.createVerticalStrut(16));
        add(datoUser);
        add(Box.createVerticalStrut(6));
        add(datoPoints);
        add(Box.createVerticalStrut(6));
        add(datoGames);
        add(Box.createVerticalStrut(6));
        add(datoDate);
        add(Box.createVerticalStrut(16));
        add(separador);
        add(Box.createVerticalStrut(8));
        add(msjExito);
        add(Box.createVerticalStrut(8));
        add(btnPassword);
        add(Box.createVerticalStrut(8));
        add(btnDelete);
        add(Box.createVerticalStrut(8));
        add(panelConfirm);
        add(Box.createVerticalStrut(8));
        add(btnVolver);
    }
}
