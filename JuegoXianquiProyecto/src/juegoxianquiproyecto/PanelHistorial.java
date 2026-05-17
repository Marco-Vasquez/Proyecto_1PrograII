/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoxianquiproyecto;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
/**
 *
 * @author andres
 */
public class PanelHistorial extends JPanel {
    private final VentanaPrincipalApp ventana;
    private final String nombreUser;
    private JTextArea texto;
    public PanelHistorial(VentanaPrincipalApp ventana){
        this(ventana,"Jugador");
    }
    public PanelHistorial(VentanaPrincipalApp ventana,String nombreUser){
        this.ventana=ventana;
        this.nombreUser=nombreUser;
        setBackground(TemaGUI.FONDO_OSCURO);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(40,50,40,50));
        construirUI();
        cargarHistorial();
    }
    private void cargarHistorial(){
        ArrayList<String> historial=ventana.getGestor().obtenerHistorial(nombreUser);
        if(historial.isEmpty()){
            texto.setText("(Sin partidas registradas actualmente)");
        }
        else{
            StringBuilder construir=new StringBuilder();
            for(String entrada:historial){
                construir.append(entrada).append("\n");
            }
            texto.setText(construir.toString());
        }
    }
    private void construirUI(){
        JLabel titulo=new JLabel("Registro de mis partidas");
        titulo.setFont(TemaGUI.fuente(Font.BOLD,24));
        titulo.setForeground(TemaGUI.DORADO);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        texto=new JTextArea("(Sin partidas registradas aún)");
        texto.setFont(new Font("Monospaced",Font.PLAIN,12));
        texto.setForeground(TemaGUI.CREMA);
        texto.setBackground(TemaGUI.PANEL);
        texto.setEditable(false);
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);
        JScrollPane scrollear=new JScrollPane(texto);
        scrollear.setMaximumSize(new Dimension(360,260));
        scrollear.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnActualizar,btnVolver;
        btnVolver=TemaGUI.crearBoton("Volver");
        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVolver.addActionListener(e->ventana.recargarPantalla(VentanaPrincipalApp.PANTALLA_REPORTS,new PanelReports(ventana,nombreUser)));
        add(titulo);
        add(Box.createVerticalStrut(16));
        add(scrollear);
        add(Box.createVerticalStrut(14));
        add(btnVolver);
    }
}
