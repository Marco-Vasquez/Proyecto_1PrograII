/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoxianquiproyecto;

/**
 *
 * @author andres
 */
public class Soldado extends Pieza{
    public Soldado(int fila,int columna,ColorPieza color){
        super(fila,columna,color);
    }
    public String getNombre(){
        return "Soldado";
    }
    private boolean haCruzadoRio(){
        if(getColor()==ColorPieza.ROJO){
            return getFila()<=4;
        }
        else{
            return getFila()>=5;
        }
    }
    public boolean isValidMovement(int filaDestino, int colDestino, Pieza[][] tablero) {
        if(!dentroDelTablero(filaDestino,colDestino)){
            return false;
        }
        if(destinoOcupado(filaDestino,colDestino,tablero)){
            return false;
        }
        int difFila,difCol;
        difFila=filaDestino-getFila();
        difCol=colDestino-getColumna();
        boolean cruzoRio=haCruzadoRio();
        if(!cruzoRio){
            if(getColor()==ColorPieza.ROJO){
                return difFila==-1 && difCol==0;
            }
            else{
                return difFila==1 && difCol==0;
            }
        }
        else{
            if(getColor()==ColorPieza.ROJO){
                return (difFila==-1 && difCol==0) || (difFila==0 && Math.abs(difCol)==1);
            }
            else{
                return (difFila==1 && difCol==0) || (difFila==0 && Math.abs(difCol)==1);
            }
        }
    }        
}
