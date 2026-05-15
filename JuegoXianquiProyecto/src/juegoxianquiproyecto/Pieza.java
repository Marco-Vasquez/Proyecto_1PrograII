/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoxianquiproyecto;

/**
 *
 * @author andres
 */
public abstract class Pieza {
    private int fila,columna;
    private ColorPieza color;
    private boolean viva;
    public Pieza(int fila,int columna,ColorPieza color){
        this.fila=fila;
        this.columna=columna;
        this.color=color;
        this.viva=true;
    }
    public abstract boolean isValidMovement(int filaDestino,int colDestino,Pieza[][] tablero);
    public abstract String getNombre();
    public int getFila(){
        return fila;
    }
    public int getColumna(){
        return columna;
    }
    public ColorPieza getColor(){
        return color;
    }
    public boolean isViva(){
        return viva;
    }
    public void setFila(int fila){
        this.fila=fila;
    }
    public void setColumna(int columna){
        this.columna=columna;
    }
    public void setViva(boolean viva){
        this.viva=viva;
    }
    public boolean destinoOcupado(int filaDestino,int colDestino, Pieza[][] tablero){
        Pieza destino=tablero[filaDestino][colDestino];
        if(destino==null)
            return false;
        return destino.getColor()==this.color;
    }
    public boolean dentroDelTablero(int fila,int columna){
        return fila>=0 && fila<10 && columna>=0 && columna<9;
    }
    public String toString(){
        return getNombre()+"("+color+") en ["+fila+","+columna+"]";
    }
}
