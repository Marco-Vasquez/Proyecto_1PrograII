/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoxianquiproyecto;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
/**
 *
 * @author andres
 */
public class PanelRanking extends JPanel {
    private final VentanaPrincipalApp ventana;
    private final String nombreUser;
    public PanelRanking(VentanaPrincipalApp ventana){
        this(ventana,"Jugador");
    }
    public PanelRanking(VentanaPrincipalApp ventana,String nombreUser){
        this.ventana=ventana;
        this.nombreUser=nombreUser;
        setBackground(TemaGUI.FONDO_OSCURO);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(40,50,40,50));
        construirUI();
    }
    private void construirUI(){
        JLabel titulo=new JLabel("Ranking de Jugadores",SwingConstants.CENTER);
        titulo.setFont(TemaGUI.fuente(Font.BOLD,24));
        titulo.setForeground(TemaGUI.DORADO);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        String columnas[]={"#","Jugador","Punto"};
        //falta codigo con los datos reales del juego
        Object datos[][]={};
        DefaultTableModel tablaModelo=new DefaultTableModel(datos,columnas){
            public boolean isCellEditable(int fila,int columna){
                return false;
            }
        };
        JTable tablaRanking=new JTable(tablaModelo);
        tablaRanking.setFont(TemaGUI.fuente(Font.PLAIN,13));
        tablaRanking.setForeground(TemaGUI.CREMA);
        tablaRanking.setBackground(TemaGUI.PANEL);
        tablaRanking.setRowHeight(28);
        tablaRanking.getTableHeader().setFont(TemaGUI.fuente(Font.BOLD,13));
        tablaRanking.getTableHeader().setBackground(TemaGUI.ROJO_OSCURO);
        tablaRanking.getTableHeader().setForeground(TemaGUI.DORADO);
        JScrollPane scrollear=new JScrollPane(tablaRanking);
        scrollear.setMaximumSize(new Dimension(360,280));
        scrollear.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnVolver=TemaGUI.crearBoton("Volver");
        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVolver.addActionListener(e->ventana.recargarPantalla(VentanaPrincipalApp.PANTALLA_REPORTS,new PanelReports(ventana,nombreUser)));
        add(titulo);
        add(Box.createVerticalStrut(20));
        add(scrollear);
        add(Box.createVerticalStrut(20));
        add(btnVolver);
    }
}
