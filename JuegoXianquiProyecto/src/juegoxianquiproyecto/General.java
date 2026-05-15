/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoxianquiproyecto;

/**
 *
 * @author andres
 */
public class General extends Pieza{
    public General(int fila,int columna,ColorPieza color){
        super(fila,columna,color);
    }
    private boolean dentroPalacio(int fila,int columna){
        boolean enColumnas;
        enColumnas=columna>=3 && columna<=5;
        if(getColor()==ColorPieza.ROJO){
            return fila>=7 && fila<=9 && enColumnas;
        }
        else{
            return fila>=0 && fila<=2 && enColumnas;
        }
    }
    public String getNombre(){
        return "General";
    }
    public boolean isValidMovement(int filaDestino,int colDestino,Pieza[][] tablero){
        if(!dentroDelTablero(filaDestino,colDestino))
            return false;
        if(destinoOcupado(filaDestino,colDestino,tablero))
            return false;
        int difFila,difCol;
        difFila=Math.abs(filaDestino-getFila());
        difCol=Math.abs(colDestino-getColumna());
        if(!((difFila==1 && difCol==0)||(difFila==0 && difCol==1)))
            return false;
        return dentroPalacio(filaDestino,colDestino);
    }
}
