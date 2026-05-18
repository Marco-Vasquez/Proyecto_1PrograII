/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoxianquiproyecto;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author andres
 */
public class PanelTablero extends JPanel {
    private final VentanaPrincipalApp ventana;
    private final Partida partida;
    private static final int TAM_CELDA=52;
    private static final int MARGEN=50;
    private static final int ESPACIO_CAPTURADAS=75;
    private static final int ESPACIO_CONTROLES=120;
    private int filaSelec=-1;
    private int columnaSelec=-1;
    private JLabel labelEstado;
    private JButton btnRetirar;
    private java.util.ArrayList<int[]> movimientosDisponibles=new java.util.ArrayList<>();
    private java.util.ArrayList<Pieza> piezasCapturadas=new java.util.ArrayList<>();
    public PanelTablero(VentanaPrincipalApp ventana,Partida partida){
        this.ventana=ventana;
        this.partida=partida;
        int anchoPanel,altoPanel;
        anchoPanel=TAM_CELDA*8+MARGEN*2;
        altoPanel=TAM_CELDA*9+MARGEN*2+ESPACIO_CAPTURADAS+ESPACIO_CONTROLES;
        setPreferredSize(new Dimension(anchoPanel,altoPanel));
        setBackground(TemaGUI.FONDO_OSCURO);
        setLayout(null);
        construirBotones();
        addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                manejarClick(e.getX(),e.getY());
            }
        });
        ventana.cambiarSizeVentana(TAM_CELDA*8+MARGEN*2+30,TAM_CELDA*10+MARGEN*2+180);
    }  
    private void construirBotones(){
        int anchoPanel,yBotones;
        anchoPanel=TAM_CELDA*8+MARGEN*2;
        yBotones=MARGEN+TAM_CELDA*9+95;
        labelEstado=new JLabel("Turno: "+partida.getNombreTurno(),SwingConstants.CENTER);
        labelEstado.setFont(TemaGUI.fuente(Font.BOLD,14));
        labelEstado.setForeground(TemaGUI.DORADO);
        labelEstado.setBounds(0,yBotones,anchoPanel,24);
        add(labelEstado);
        btnRetirar=TemaGUI.crearBoton("Retirar");
        btnRetirar.setBounds((anchoPanel-260)/2,yBotones+30,260,40);
        btnRetirar.addActionListener(e->{
            partida.retirar();
            ventana.getGestor().guardarResultadoPartida(partida.getPlayerRojo().getUser(),partida.getLogCorto());
            ventana.getGestor().guardarResultadoPartida(partida.getPlayerNegro().getUser(),partida.getLogCorto());
            mostrarResultado();
        });
        add(btnRetirar);
    }
    private void dibujarTablero(Graphics2D g2){
        int anchoTablero,altoTablero;
        anchoTablero=TAM_CELDA*8;
        altoTablero=TAM_CELDA*9;
        g2.setColor(new Color(80,45,15));
        g2.fillRect(MARGEN,MARGEN,anchoTablero,altoTablero);
        g2.setColor(new Color(212,175,55));
        g2.setStroke(new BasicStroke(1f));
        for(int filas=0;filas<10;filas++){
            int vertical;
            vertical=MARGEN+filas*TAM_CELDA;
            g2.drawLine(MARGEN,vertical,MARGEN+8*TAM_CELDA,vertical);
        }
        for(int columnas=0;columnas<9;columnas++){
            int horizontal;
            horizontal=MARGEN+columnas*TAM_CELDA;
            if(columnas==0 || columnas==8){
                g2.drawLine(horizontal,MARGEN,horizontal,MARGEN+9*TAM_CELDA);
            }
            else{
                g2.drawLine(horizontal,MARGEN,horizontal,MARGEN+4*TAM_CELDA);
                g2.drawLine(horizontal,MARGEN+5*TAM_CELDA,horizontal,MARGEN+9*TAM_CELDA);
            }
        }
        g2.setColor(new Color(100,160,200,180));
        g2.setFont(TemaGUI.fuente(Font.ITALIC,13));
        String textoRio="-  XIANGQI  XIANGQI   -";
        FontMetrics fuentes=g2.getFontMetrics();
        int horizontalTexto,verticalTexto;
        horizontalTexto=MARGEN+(8*TAM_CELDA-fuentes.stringWidth(textoRio))/2;
        verticalTexto=MARGEN+(4*TAM_CELDA)+(TAM_CELDA/2)+fuentes.getAscent()/2;
        g2.drawString(textoRio,horizontalTexto,verticalTexto);
        g2.setColor(new Color(212,175,55,160));
        g2.drawLine(MARGEN+3*TAM_CELDA,MARGEN,MARGEN+5*TAM_CELDA,MARGEN+2*TAM_CELDA);
        g2.drawLine(MARGEN+5*TAM_CELDA,MARGEN,MARGEN+3*TAM_CELDA,MARGEN+2*TAM_CELDA);
        g2.drawLine(MARGEN+3*TAM_CELDA,MARGEN+7*TAM_CELDA,MARGEN+5*TAM_CELDA,MARGEN+9*TAM_CELDA);
        g2.drawLine(MARGEN+5*TAM_CELDA,MARGEN+7*TAM_CELDA,MARGEN+3*TAM_CELDA,MARGEN+9*TAM_CELDA);
   }
    private void dibujarPiezas(Graphics2D g2){
        Pieza[][] casillas;
        casillas=partida.getTablero().getCasillas();
        int radio;
        radio=TAM_CELDA/2-4;
        for(int filas=0;filas<10;filas++){
            for(int columnas=0;columnas<9;columnas++){
                Pieza pieza=casillas[filas][columnas];
                if(pieza==null){
                    continue;
                }
                int casillaHoriz,casillaVert;
                casillaHoriz=MARGEN+columnas*TAM_CELDA;
                casillaVert=MARGEN+filas*TAM_CELDA;
                if(pieza.getColor()==ColorPieza.ROJO){
                    g2.setColor(new Color(180,20,20));
                }
                else{
                    g2.setColor(new Color(20,20,20));
                }
                g2.fillOval(casillaHoriz-radio,casillaVert-radio,radio*2,radio*2);
                g2.setColor(TemaGUI.DORADO);
                g2.setStroke(new BasicStroke(1.5f));
                g2.drawOval(casillaHoriz-radio,casillaVert-radio,radio*2,radio*2);
                try{
                    java.net.URL url;
                    url=getClass().getClassLoader().getResource(pieza.getRutaImagen());
                    if(url!=null){
                        Image imagen;
                        imagen=javax.imageio.ImageIO.read(url);
                        int tamaño;
                        tamaño=radio*2-4;
                        g2.drawImage(imagen,casillaHoriz-tamaño/2,casillaVert-tamaño/2,tamaño,tamaño,null);
                    }
                    else{
                        dibujarTextoFallback(g2,pieza,casillaHoriz,casillaVert);
                    }
                }
                catch(Exception e){
                    dibujarTextoFallback(g2,pieza,casillaHoriz,casillaVert);
                }
            }
        }
    }
    private void dibujarTextoFallback(Graphics2D g2,Pieza pieza, int casillaHoriz,int casillaVert){
        g2.setColor(TemaGUI.CREMA);
        g2.setFont(TemaGUI.fuente(Font.BOLD,10));
        String nombre;
        nombre=pieza.getNombre().substring(0,Math.min(2,pieza.getNombre().length()));
        FontMetrics fuentes;
        fuentes=g2.getFontMetrics();
        g2.drawString(nombre,casillaHoriz-fuentes.stringWidth(nombre)/2,casillaVert+fuentes.getAscent()/2-1);
    }
    private void dibujarSeleccion(Graphics2D g2){
        for(int[] mov:movimientosDisponibles){
            int casillaHoriz,casillaVert;
            casillaHoriz=MARGEN+mov[1]*TAM_CELDA;
            casillaVert=MARGEN+mov[0]*TAM_CELDA;
            g2.setColor(new Color(0,255,0,80));
            g2.fillOval(casillaHoriz-TAM_CELDA/2+4,casillaVert-TAM_CELDA/2+4,TAM_CELDA-8,TAM_CELDA-8);
            g2.setColor(new Color(0,200,0,160));
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawOval(casillaHoriz-TAM_CELDA/2+4,casillaVert-TAM_CELDA/2+4,TAM_CELDA-8,TAM_CELDA-8);
        }
        if(filaSelec==-1){
            return;
        }
        int casillaHoriz,casillaVert,radio;
        casillaHoriz=MARGEN+columnaSelec*TAM_CELDA;
        casillaVert=MARGEN+filaSelec*TAM_CELDA;
        radio=TAM_CELDA/2-2;
        g2.setColor(new Color(255,255,0,180));
        g2.setStroke(new BasicStroke(2.5f));
        g2.drawOval(casillaHoriz-radio,casillaVert-radio,radio*2,radio*2);
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        dibujarTablero(g2);
        dibujarPiezas(g2);
        dibujarSeleccion(g2);
        dibujarCapturadas(g2);
    }
    private void manejarClick(int x,int y){
        if(partida.isTerminada()){
            return;
        }
        int columna,fila;
        columna=Math.round((float)(x-MARGEN)/TAM_CELDA);
        fila=Math.round((float)(y-MARGEN)/TAM_CELDA);
        if(fila<0 || fila>=10 || columna<0 || columna>=9){
            return;
        }
        Pieza[][] casillas;
        casillas=partida.getTablero().getCasillas();
        if(filaSelec==-1){
            Pieza pieza;
            pieza=casillas[fila][columna];
            if(pieza!=null && pieza.getColor()==partida.getTurnoAct()){
                filaSelec=fila;
                columnaSelec=columna;
                movimientosDisponibles.clear();
                for(int filas=0;filas<10;filas++){
                    for(int columnas=0;columnas<9;columnas++){
                        if(pieza.isValidMovement(filas, columnas, casillas)){
                            movimientosDisponibles.add(new int[]{filas,columnas});
                        }
                    }
                }
            }
        }
        else{
            movimientosDisponibles.clear();
            boolean movimientoValid;
            movimientoValid=partida.realizarMovimiento(filaSelec,columnaSelec,fila,columna);
            filaSelec=-1;
            columnaSelec=-1;
            if(movimientoValid){
                actualizarEstado();
                if(partida.isTerminada()){
                    ventana.getGestor().guardarResultadoPartida(partida.getPlayerRojo().getUser(),partida.getLogCorto());
                    ventana.getGestor().guardarResultadoPartida(partida.getPlayerNegro().getUser(),partida.getLogCorto());
                    mostrarResultado();
                }
            }
        }
        repaint();
    }
    private void actualizarEstado(){
        if(!partida.isTerminada()){
            labelEstado.setText("Turno: "+partida.getNombreTurno());
        }
    }
    private void mostrarResultado(){
        btnRetirar.setVisible(false);
        labelEstado.setBounds(20, MARGEN + TAM_CELDA*9+95,TAM_CELDA*8+MARGEN*2,24);
        labelEstado.setText(partida.getResultado());
        labelEstado.setForeground(new Color(80,200,80));
        int anchoPanel,botonVert;
        anchoPanel=TAM_CELDA*8+MARGEN*2;
        botonVert=MARGEN+TAM_CELDA*9+125;
        JButton btnVolver;
        btnVolver=TemaGUI.crearBoton("Volver al menú");
        btnVolver.setBounds((anchoPanel-260)/2,botonVert,260,40);
        btnVolver.addActionListener(e->{
            ventana.restaurarSizeVentana();
            ventana.recargarPantalla(VentanaPrincipalApp.PANTALLA_MAINMENU,new PanelMainMenu(ventana,partida.getPlayerRojo().getUser()));
        });
        add(btnVolver);
        revalidate();
        repaint();
    }
    private void dibujarCapturadas(Graphics2D g2){
        java.util.ArrayList<Pieza> capturadas=partida.getCapturadas();
        if(capturadas.isEmpty()){
            return;
        }
        java.util.ArrayList<Pieza> rojas=new java.util.ArrayList<>();
        java.util.ArrayList<Pieza> negras=new java.util.ArrayList<>();
        for(Pieza p:capturadas){
            if(p.getColor()==ColorPieza.ROJO){
                rojas.add(p);
            }
            else{
                negras.add(p);
            }
        }
        int yBase=MARGEN+9*TAM_CELDA+30;
        int radioP=15;
        int separac=36;
        int xIzq=MARGEN;
        g2.setColor(TemaGUI.GRIS_TEXTOS);
        g2.setFont(TemaGUI.fuente(Font.PLAIN, 11));
        g2.drawString("Negras capturadas:", xIzq, yBase + 12);
        dibujarFilaCapturadas(g2, negras, xIzq + 150, yBase - 8, radioP, separac);
        g2.drawString("Rojas capturadas:", xIzq, yBase + 55);
        dibujarFilaCapturadas(g2, rojas, xIzq + 150, yBase + 35, radioP, separac);
    }

    private void dibujarFilaCapturadas(Graphics2D g2,java.util.ArrayList<Pieza> lista,int xInicio,int y,int radio,int separador){
        for(int control=0;control<lista.size();control++){
            Pieza pieza=lista.get(control);
            int casillaHoriz=xInicio+control*separador+radio;
            int casillaVert=y+radio;
            if(casillaHoriz + radio > MARGEN + 8*TAM_CELDA){
                break;
            }
            if(pieza.getColor()==ColorPieza.ROJO){
                g2.setColor(new Color(180,20,20));
            }
            else {
                g2.setColor(new Color(20,20,20));
            }
            g2.fillOval(casillaHoriz-radio, casillaVert-radio, radio*2, radio*2);
            g2.setColor(TemaGUI.DORADO);
            g2.setStroke(new BasicStroke(1f));
            g2.drawOval(casillaHoriz-radio, casillaVert-radio, radio*2, radio*2);
            try{
                java.net.URL url=getClass().getClassLoader().getResource(pieza.getRutaImagen());
                if(url!=null){
                    Image img=javax.imageio.ImageIO.read(url);
                    int tam=radio*2-4;
                    g2.drawImage(img, casillaHoriz-tam/2, casillaVert-tam/2, tam, tam, null);
                }
            } catch(Exception ex){
            }
        }
    }
}
