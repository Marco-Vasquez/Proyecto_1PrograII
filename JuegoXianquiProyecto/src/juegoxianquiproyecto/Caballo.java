/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoxianquiproyecto;

/**
 *
 * @author andres
 */
public class Caballo extends Pieza {
    public Caballo(int fila,int columna,ColorPieza color){
        super(fila,columna,color);
    }
    public String getNombre(){
        return "Caballo";
    }
    public boolean isValidMovement(int filaDestino, int colDestino, Pieza[][] tablero){
        if(!dentroDelTablero(filaDestino,colDestino)){
            return false;
        }
        if(destinoOcupado(filaDestino,colDestino,tablero)){
            return false;
        }
        int difFila,difCol;
        difFila=filaDestino-getFila();
        difCol=colDestino-getColumna();
        if(Math.abs(difFila)==2 && Math.abs(difCol)==1){
            int filaMedia=getFila()+(difFila/2);
            if(tablero[filaMedia][getColumna()]!=null){
                return false;
            }
            return true;
        }
        if(Math.abs(difFila)==1 && Math.abs(difCol)==2){
            int colMedia=getColumna()+(difCol/2);
            if(tablero[getFila()][colMedia]!=null){
                return false;
            }
            return true;
        }
        return false;
    }
    public String getRutaImagen(){
        if(getColor()==ColorPieza.ROJO){
            return "imagenes/caballo_rojo.png";
        }
        else{
            return "imagenes/caballo_negro.png";
        }
    }
}
