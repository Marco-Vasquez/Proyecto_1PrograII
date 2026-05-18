/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoxianquiproyecto;

/**
 *
 * @author andres
 */
public class Elefante extends Pieza {
    public Elefante(int fila,int columna,ColorPieza color){
        super(fila,columna,color);
    }
    public String getNombre(){
        return "Elefante";
    }
    public boolean isValidMovement(int filaDestino,int colDestino,Pieza[][] tablero){
        if(!dentroDelTablero(filaDestino,colDestino)){
            return false;
        }
        if(destinoOcupado(filaDestino,colDestino,tablero)){
            return false;
        }
        int difFila,difCol;
        difFila=filaDestino-getFila();
        difCol=colDestino-getColumna();
        if(Math.abs(difFila)!=2 || Math.abs(difCol)!=2){
            return false;
        }
        if(getColor()==ColorPieza.ROJO && filaDestino<5){
            return false;
        }
        if(getColor()==ColorPieza.NEGRO && filaDestino>=5){
            return false;
        }
        int filaMed,colMed;
        filaMed=getFila()+(difFila/2);
        colMed=getColumna()+(difCol/2);
        if(tablero[filaMed][colMed]!=null){
            return false;
        }
        return true;
    }
    public String getRutaImagen(){
        if(getColor()==ColorPieza.ROJO){
            return "imagenes/elefante_rojo.png";
        }
        else{
            return "imagenes/elefante_negro.png";
        }
    }
}
