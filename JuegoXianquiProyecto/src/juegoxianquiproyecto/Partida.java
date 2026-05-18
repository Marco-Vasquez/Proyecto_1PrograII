/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoxianquiproyecto;

/**
 *
 * @author andres
 */
public class Partida {
    private Tablero tablero;
    private Player playerRojo;
    private Player playerNegro;
    private ColorPieza turnoActual;
    private boolean terminada;
    private String resultado;
    private String logCorto;
    private java.util.ArrayList<Pieza> capturadas=new java.util.ArrayList<>();
    public Partida(Player jugadorRojo,Player jugadorNegro){
        this.playerRojo=jugadorRojo;
        this.playerNegro=jugadorNegro;
        this.tablero=new Tablero();
        this.turnoActual=ColorPieza.ROJO;
        this.terminada=false;
        this.resultado="";
        this.logCorto="";
    }
    public Tablero getTablero(){
        return tablero;
    }
    public ColorPieza getTurnoAct(){
        return turnoActual;
    }
    public boolean isTerminada(){
        return terminada;
    }
    public String getResultado(){
        return resultado;
    }
    public Player getPlayerRojo(){
        return playerRojo;
    }
    public Player getPlayerNegro(){
        return playerNegro;
    }
    public Player getPlayerActual(){
        return(turnoActual==ColorPieza.ROJO) ? playerRojo:playerNegro; 
    }
    public String getNombreTurno(){
        return(turnoActual==ColorPieza.ROJO) ? playerRojo.getUser():playerNegro.getUser();
    }
    public String getLogCorto(){
        return logCorto;
    }
    public java.util.ArrayList<Pieza> getCapturadas(){
        return capturadas;
    }
    private void cambiarTurno(){
        turnoActual=(turnoActual==ColorPieza.ROJO) ? ColorPieza.NEGRO:ColorPieza.ROJO;
    }
    private void terminarPartida(ColorPieza colorWinner){
        Player ganador,perdedor;
        ganador=(colorWinner==ColorPieza.ROJO) ? playerRojo:playerNegro;
        perdedor=(colorWinner==ColorPieza.ROJO) ? playerNegro:playerRojo;
        resultado=ganador.getUser()+" venció a "+perdedor.getUser()+". Felicidades "+ganador.getUser()+" has ganado 3 puntos";
        logCorto=ganador.getUser()+" venció a "+perdedor.getUser();
        ganador.sumarPuntos(3);
        ganador.sumarPartidaGanada();
        ganador.sumarPartidaJugada();
        perdedor.sumarPartidaPerdida();
        perdedor.sumarPartidaJugada();
        terminada=true;
    }
    public void retirar(){
        if(terminada){
            return;
        }
        ColorPieza ganador;
        ganador=(turnoActual==ColorPieza.ROJO) ? ColorPieza.NEGRO:ColorPieza.ROJO;
        Player perdedor,ganadorPlayer;
        perdedor=getPlayerActual();
        ganadorPlayer=(ganador==ColorPieza.ROJO) ? playerRojo:playerNegro;
        resultado=perdedor.getUser()+" se ha retirado. Felicidades "+ganadorPlayer.getUser()+" has ganado 3 puntos";
        logCorto=perdedor.getUser()+" se ha retirado. Ganó "+ganadorPlayer.getUser();
        ganadorPlayer.sumarPuntos(3);
        ganadorPlayer.sumarPartidaGanada();
        ganadorPlayer.sumarPartidaJugada();
        perdedor.sumarPartidaPerdida();
        perdedor.sumarPartidaJugada();
        terminada=true;
    }
    public boolean realizarMovimiento(int filaOrigen,int colOrigen,int filaDestino,int colDestino){
        if(terminada){
            return false;
        }
        Pieza pieza=tablero.getPieza(filaOrigen,colOrigen);
        if(pieza==null){
            return false;
        }
        if(pieza.getColor()!=turnoActual){
            return false;
        }
        if(!pieza.isValidMovement(filaDestino,colDestino,tablero.getCasillas())){
            return false;
        }
        Pieza piezaDestino=tablero.getPieza(filaDestino,colDestino);
        tablero.getCasillas()[filaDestino][colDestino]=pieza;
        tablero.getCasillas()[filaOrigen][colOrigen]=null;
        pieza.setFila(filaDestino);
        pieza.setColumna(colDestino);
        if(tablero.generalesEnfrentados()){
            tablero.getCasillas()[filaOrigen][colOrigen]=pieza;
            tablero.getCasillas()[filaDestino][colDestino]=piezaDestino;
            pieza.setFila(filaOrigen);
            pieza.setColumna(colOrigen);
            return false;
        }
        if(piezaDestino!=null){
            capturadas.add(piezaDestino);
        }
        if(piezaDestino instanceof General){
            terminarPartida(turnoActual);
            return true;
        }
        cambiarTurno();
        return true;
    }
}   
