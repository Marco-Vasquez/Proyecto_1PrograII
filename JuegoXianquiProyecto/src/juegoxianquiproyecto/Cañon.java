/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoxianquiproyecto;

/**
 *
 * @author andres
 */
public class Cañon extends PiezaDeAtaque {
    public Cañon(int fila,int columna,ColorPieza color){
        super(fila,columna,color);
    }
    public String getNombre(){
        return "Cañon";
    }
    public boolean isValidMovement(int filaDestino,int colDestino,Pieza[][] tablero){
        if(!dentroDelTablero(filaDestino,colDestino)){
            return false;
        }
        if(destinoOcupado(filaDestino,colDestino,tablero)){
            return false;
        }
        boolean mismaFila,mismaCol;
        mismaFila=filaDestino==getFila();
        mismaCol=colDestino==getColumna();
        if(!mismaFila && !mismaCol){
            return false;
        }    
        int piezasEnMedio;
        piezasEnMedio=contarPiezasMedio(filaDestino,colDestino,tablero);
        Pieza destino;
        destino=tablero[filaDestino][colDestino];
        if(destino==null){
           return piezasEnMedio==0;
        }
        else{
            return piezasEnMedio==1;
        }
    }
    public String getRutaImagen(){
        if(getColor()==ColorPieza.ROJO){
            return "imagenes/canon_rojo.png";
        }
        else{
            return "imagenes/canon_negro.png";
        }
    }
}
