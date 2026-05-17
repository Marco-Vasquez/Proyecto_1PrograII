/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoxianquiproyecto;

/**
 *
 * @author andres
 */
public class PiezaDeAtaque extends Pieza {
    public PiezaDeAtaque(int fila,int columna,ColorPieza color){
        super(fila,columna,color);
    }
    public boolean caminoLibre(int filaDestino,int colDestino,Pieza[][] tablero){
        if(filaDestino==getFila()){
            int desde,hasta;
            desde=Math.min(getColumna(),colDestino)+1;
            hasta=Math.max(getColumna(),colDestino);
            for(int columnas=desde;columnas<hasta;columnas++){
                if(tablero[getFila()][columnas]!=null){
                    return false;
                }
            }
        }
        else{
            int desde,hasta;
            desde=Math.min(getFila(),filaDestino)+1;
            hasta=Math.max(getFila(),filaDestino);
            for(int filas=desde;filas<hasta;filas++){
                if(tablero[filas][getColumna()]!=null){
                    return false;
                }
            }
        }
        return true;
    }
    public int contarPiezasMedio(int filaDestino,int colDestino,Pieza[][] tablero){
        int contador=0;
        if(filaDestino==getFila()){
            int desde,hasta;
            desde=Math.min(getColumna(),colDestino)+1;
            hasta=Math.max(getColumna(),colDestino);
            for(int columnas=desde;columnas<hasta;columnas++){
                if(tablero[getFila()][columnas]!=null){
                    contador++;
                }
            }
        }
        else{
            int desde,hasta;
            desde=Math.min(getFila(),filaDestino)+1;
            hasta=Math.max(getFila(),filaDestino);
            for(int filas=desde;filas<hasta;filas++){
                if(tablero[filas][getColumna()]!=null){
                    contador++;
                }
            }
        }
        return contador;
    }
    public boolean isValidMovement(int filaDestino,int ColDestino,Pieza[][] tablero){
        return false;
    }
    public String getNombre(){
        return "PiezaDeAtaque";
    }
    public String getRutaImagen(){
        return "";
    }
}
