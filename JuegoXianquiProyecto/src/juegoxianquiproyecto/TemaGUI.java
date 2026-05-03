/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoxianquiproyecto;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
/**
 *
 * @author andres
 */
public class TemaGUI {
    public static final Color FONDO_OSCURO=new Color(30,15,15);
    public static final Color PANEL=new Color(50,25,25);
    public static final Color DORADO=new Color(200,160,50);
    public static final Color ROJO_OSCURO=new Color(120,10,10);
    public static final Color CREMA=new Color(240,225,195);
    public static final Color GRIS_TEXTOS=new Color(150,135,120);
    public static Font fuente(int estilo, int tamaño){
        Font kaiTi=new Font("KaiTi",estilo,tamaño);
        if(kaiTi.getFamily().equals("KaiTi"))
            return kaiTi;
        return new Font("Serif",estilo,tamaño);
    }
    public static JButton crearBoton(String texto){
        JButton boton=new JButton(texto);
        boton.setFont(fuente(Font.BOLD,15));
        boton.setForeground(CREMA);
        boton.setBackground(ROJO_OSCURO);
        boton.setFocusPainted(false);
        boton.setBorder(new LineBorder(DORADO,1));
        boton.setPreferredSize(new Dimension(260,42));
        boton.setMaximumSize(new Dimension(260,42));
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return boton;
    }
    public static JLabel crearEtiqueta(String texto){
        JLabel etiqueta=new JLabel(texto);
        etiqueta.setFont(fuente(Font.BOLD,13));
        etiqueta.setForeground(DORADO);
        etiqueta.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiqueta.setMaximumSize(new Dimension(260,20));
        etiqueta.setPreferredSize(new Dimension(260,20));
        return etiqueta;
    }
    public static JLabel crearMsjError(){
        JLabel etiqueta=new JLabel(" ",SwingConstants.CENTER);
        etiqueta.setFont(fuente(Font.PLAIN,12));
        etiqueta.setForeground(new Color(220,60,60));
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setPreferredSize(new Dimension(260,18));
        etiqueta.setMaximumSize(new Dimension(260,18));
        etiqueta.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiqueta.setPreferredSize(new Dimension(320,18));
        etiqueta.setMaximumSize(new Dimension(320,18));
        return etiqueta;
    }
    public static JTextField crearCampoTexto(){
        JTextField campo=new JTextField();
        campo.setFont(fuente(Font.PLAIN,14));
        campo.setForeground(CREMA);
        campo.setBackground(new Color(60,35,35));
        campo.setCaretColor(DORADO);
        campo.setBorder(BorderFactory.createCompoundBorder(new LineBorder(DORADO,1),BorderFactory.createEmptyBorder(4,8,4,8)));
        campo.setPreferredSize(new Dimension(260,36));
        campo.setMaximumSize(new Dimension(260,36));
        return campo;
    }
    public static JPasswordField crearCampoContraseña(){
        JPasswordField campo=new JPasswordField();
        campo.setFont(fuente(Font.PLAIN,14));
        campo.setForeground(CREMA);
        campo.setBackground(new Color(60,35,35));
        campo.setCaretColor(DORADO);
        campo.setBorder(BorderFactory.createCompoundBorder(new LineBorder(DORADO,1),BorderFactory.createEmptyBorder(4,8,4,8)));
        campo.setPreferredSize(new Dimension(260,36));
        campo.setMaximumSize(new Dimension(260,36));
        return campo;
    }
    public static JLabel crearTexto(String texto){
        JLabel etiqueta=new JLabel(texto,SwingConstants.CENTER);
        etiqueta.setFont(fuente(Font.ITALIC,12));
        etiqueta.setForeground(GRIS_TEXTOS);
        etiqueta.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiqueta.setMaximumSize(new Dimension(320,20));
        etiqueta.setPreferredSize(new Dimension(320,20));
        return etiqueta;
    }
}
