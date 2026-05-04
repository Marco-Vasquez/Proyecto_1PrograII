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
public class PanelPlay extends JPanel{
    private final VentanaPrincipalApp ventana;
    private final String nombreUser;
    public PanelPlay(VentanaPrincipalApp ventana){
        this(ventana,"Jugador");
    }
    public PanelPlay(VentanaPrincipalApp ventana,String nombreUser){
        this.ventana=ventana;
        this.nombreUser=nombreUser;
        setBackground(TemaGUI.FONDO_OSCURO);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(60,80,60,80));
        construirUI();
    }
    private void construirUI(){
        JLabel titulo=new JLabel("Jugar Xiangqi",SwingConstants.CENTER);
        titulo.setFont(TemaGUI.fuente(Font.BOLD,26));
        titulo.setForeground(TemaGUI.DORADO);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel etqPlayer1=new JLabel("Jugador 1: "+nombreUser);
        etqPlayer1.setFont(TemaGUI.fuente(Font.PLAIN,13));
        etqPlayer1.setForeground(TemaGUI.CREMA);
        etqPlayer1.setAlignmentX(Component.CENTER_ALIGNMENT);
        JComboBox<String> selecOponente=new JComboBox<>();
        selecOponente.addItem("-- Selecciona un oponente --");
        for(Player player:ventana.getGestor().getListaPLayers()){
            if(player.isActivo() && !player.getUser().equals(nombreUser)){
                selecOponente.addItem(player.getUser());
            }
        }
        selecOponente.setFont(TemaGUI.fuente(Font.PLAIN,13));
        selecOponente.setBackground(new Color(60,35,35));
        selecOponente.setForeground(TemaGUI.CREMA);
        selecOponente.setMaximumSize(new Dimension(260,36));
        selecOponente.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel msjError=TemaGUI.crearMsjError();
        msjError.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnIniciar,btnVolver;
        btnIniciar=TemaGUI.crearBoton("Iniciar Partida");
        btnVolver=TemaGUI.crearBoton("Volver");
        btnIniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnIniciar.addActionListener(e->{
            String oponente=(String) selecOponente.getSelectedItem();
            if(oponente==null || oponente.startsWith("--")){
                msjError.setText("Debes de seleccionar un oponente para jugar");
                return;
            }
            //código de los tableros
        });
        btnVolver.addActionListener(e->ventana.recargarPantalla(VentanaPrincipalApp.PANTALLA_MAINMENU,new PanelMainMenu(ventana,nombreUser)));
        add(titulo);
        add(Box.createVerticalStrut(20));
        add(etqPlayer1);
        add(Box.createVerticalStrut(16));
        add(TemaGUI.crearEtiqueta("Jugador 2 (oponente):"));
        add(Box.createVerticalStrut(6));
        add(selecOponente);
        add(Box.createVerticalStrut(10));
        add(msjError);
        add(Box.createVerticalStrut(10));
        add(btnIniciar);
        add(Box.createVerticalStrut(10));
        add(btnVolver);
    }
}
