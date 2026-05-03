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
public class VentanaPrincipalApp extends JFrame{
    private CardLayout flujoJuego;
    private JPanel panelNav;
    private GestorPlayers gestor;
    public static final String PANTALLA_INICIO="inicio";
    public static final String PANTALLA_LOGIN="login";
    public static final String PANTALLA_NEWPLAYER="crearJugador";
    public static final String PANTALLA_MAINMENU="menuPrincipal";
    public static final String PANTALLA_MYACCOUNT="miCuenta";
    public static final String PANTALLA_PASSCHANGE="cambiarContra";
    public static final String PANTALLA_REPORTS="reportes";
    public static final String PANTALLA_RANKING="ranking";
    public static final String PANTALLA_HISTORIAL="historial";
    public static final String PANTALLA_PLAY="jugar";
    public VentanaPrincipalApp(){
        setTitle("Xiangqui - Ajedrez Chino");
        setSize(480,580);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        gestor=new GestorPlayers();
        flujoJuego=new CardLayout();
        panelNav=new JPanel(flujoJuego);
        panelNav.setBackground(TemaGUI.FONDO_OSCURO);
        panelNav.add(new PanelInicio(this),PANTALLA_INICIO);
        panelNav.add(new PanelLogin(this),PANTALLA_LOGIN);
        panelNav.add(new PanelNewPlayer(this),PANTALLA_NEWPLAYER);
        panelNav.add(new PanelMainMenu(this),PANTALLA_MAINMENU);
        panelNav.add(new PanelMyAccount(this),PANTALLA_MYACCOUNT);
        panelNav.add(new PanelPassChange(this),PANTALLA_PASSCHANGE);
        panelNav.add(new PanelReports(this),PANTALLA_REPORTS);
        panelNav.add(new PanelRanking(this),PANTALLA_RANKING);
        panelNav.add(new PanelHistorial(this),PANTALLA_HISTORIAL);
        panelNav.add(new PanelPlay(this),PANTALLA_PLAY);
        setContentPane(panelNav);
        mostrarPantalla(PANTALLA_INICIO);
    }
    public GestorPlayers getGestor(){
        return gestor;
    }
    public void mostrarPantalla(String nombre){
        flujoJuego.show(panelNav, nombre);
    }
    public void recargarPantalla(String nombre,JPanel panelNuevo){
        panelNav.add(panelNuevo,nombre);
        flujoJuego.show(panelNav, nombre);
    }
}
