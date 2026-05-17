/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoxianquiproyecto;

/**
 *
 * @author andres
 */
public final class CarroDeGuerra extends Pieza {
    public CarroDeGuerra(int fila,int columna,ColorPieza color){
        super(fila,columna,color);
    }
    public String getNombre(){
        return "CarroDeGuerra";
    }
    private final boolean caminoLibre(int filaDestino,int colDestino,Pieza[][] tablero){
        if(filaDestino==getFila()){
            int desde,hasta;
            desde=Math.min(getColumna(),colDestino)+1;
            hasta=Math.max(getColumna(),colDestino);
            for(int control=desde;control<hasta;control++){
                if(tablero[getFila()][control]!=null){
                    return false;
                }
            }
        }
        else{
            int desde,hasta;
            desde=Math.min(getFila(),filaDestino)+1;
            hasta=Math.max(getFila(),filaDestino);
            for(int control=desde;control<hasta;control++){
                if(tablero[control][getColumna()]!=null){
                    return false;
                }
            }
        }
        return true;
    }
    public final boolean isValidMovement(int filaDestino,int colDestino,Pieza[][] tablero){
        if(!dentroDelTablero(filaDestino,colDestino)){
            return false;
        }
        if(destinoOcupado(filaDestino,colDestino,tablero)){
            return false;
        }
        boolean mismaFila,mismaColum;
        mismaFila=filaDestino==getFila();
        mismaColum=colDestino==getColumna();
        if(!mismaFila && !mismaColum){
            return false;
        }
        return caminoLibre(filaDestino,colDestino,tablero);
    }
    public String getRutaImagen(){
        if(getColor()==ColorPieza.ROJO){
            return "imagenes/carro_rojo.png";
        }
        else{
            return "imagenes/carro_negro.png";
        }
    }
}
