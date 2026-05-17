/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoxianquiproyecto;

/**
 *
 * @author andres
 */
public class Tablero {
    private Pieza[][] casillas;
    public static final int FILAS=10;
    public static final int COLUMNAS=9;
    public Tablero(){
        casillas=new Pieza[FILAS][COLUMNAS];
        colocarPiezasIniciales();
    }
    private void colocarPiezasIniciales(){
        casillas[0][0]=new CarroDeGuerra(0,0,ColorPieza.NEGRO);
        casillas[0][1]=new Caballo(0,1,ColorPieza.NEGRO);
        casillas[0][2]=new Elefante(0,2,ColorPieza.NEGRO);
        casillas[0][3]=new Oficial(0,3,ColorPieza.NEGRO);
        casillas[0][4]=new General(0,4,ColorPieza.NEGRO);
        casillas[0][5]=new Oficial(0,5,ColorPieza.NEGRO);
        casillas[0][6]=new Elefante(0,6,ColorPieza.NEGRO);
        casillas[0][7]=new Caballo(0,7,ColorPieza.NEGRO);
        casillas[0][8]=new CarroDeGuerra(0,8,ColorPieza.NEGRO);
        casillas[2][1]=new Cañon(2,1,ColorPieza.NEGRO);
        casillas[2][7]=new Cañon(2,7,ColorPieza.NEGRO);
        casillas[3][0]=new Soldado(3,0,ColorPieza.NEGRO);
        casillas[3][2]=new Soldado(3,2,ColorPieza.NEGRO);
        casillas[3][4]=new Soldado(3,4,ColorPieza.NEGRO);
        casillas[3][6]=new Soldado(3,6,ColorPieza.NEGRO);
        casillas[3][8]=new Soldado(3,8,ColorPieza.NEGRO);
        casillas[9][0]=new CarroDeGuerra(9,0,ColorPieza.ROJO);
        casillas[9][1]=new Caballo(9,1,ColorPieza.ROJO);
        casillas[9][2]=new Elefante(9,2,ColorPieza.ROJO);
        casillas[9][3]=new Oficial(9,3,ColorPieza.ROJO);
        casillas[9][4]=new General(9,4,ColorPieza.ROJO);
        casillas[9][5]=new Oficial(9,5,ColorPieza.ROJO);
        casillas[9][6]=new Elefante(9,6,ColorPieza.ROJO);
        casillas[9][7]=new Caballo(9,7,ColorPieza.ROJO);
        casillas[9][8]=new CarroDeGuerra(9,8,ColorPieza.ROJO);
        casillas[7][1]=new Cañon(7,1,ColorPieza.ROJO);
        casillas[7][7]=new Cañon(7,7,ColorPieza.ROJO);
        casillas[6][0]=new Soldado(6,0,ColorPieza.ROJO);
        casillas[6][2]=new Soldado(6,2,ColorPieza.ROJO);
        casillas[6][4]=new Soldado(6,4,ColorPieza.ROJO);
        casillas[6][6]=new Soldado(6,6,ColorPieza.ROJO);
        casillas[6][8]=new Soldado(6,8,ColorPieza.ROJO);
    }
    public Pieza getPieza(int fila,int columna){
        return casillas[fila][columna];
    }
    public Pieza[][] getCasillas(){
        return casillas;
    }
    public void moverPieza(int filaOrigen,int colOrigen,int filaDestino,int colDestino){
        Pieza pieza=casillas[filaOrigen][colOrigen];
        casillas[filaDestino][colDestino]=pieza;
        casillas[filaOrigen][colOrigen]=null;
        pieza.setFila(filaDestino);
        pieza.setColumna(colDestino);
    }
    public boolean hayGeneralVivo(ColorPieza color){
        for(int filas=0;filas<FILAS;filas++){
            for(int col=0;col<COLUMNAS;col++){
                if(casillas[filas][col]!=null && casillas[filas][col] instanceof General && casillas[filas][col].getColor()==color){
                    return true;
                }    
            }
        }
        return false;
    }
    public boolean generalesEnfrentados(){
        int filaGenRojo,filaGenNegro,colGen;
        filaGenRojo=-1;
        filaGenNegro=-1;
        colGen=-1;
        for(int filas=0;filas<FILAS;filas++){
            for(int col=0;col<COLUMNAS;col++){
                if(casillas[filas][col] instanceof General){
                    if(casillas[filas][col].getColor()==ColorPieza.ROJO){
                        filaGenRojo=filas;
                        colGen=col;
                    }
                    else{
                        filaGenNegro=filas;
                    }
                }
            }
        }
        if(filaGenRojo==-1 || filaGenNegro==-1){
            return false;
        }
        if(colGen==-1){
            return false;
        }
        int colGenNegro=-1;
        for(int filas=0;filas<FILAS;filas++){
            if(casillas[filas][colGen] instanceof General && casillas[filas][colGen].getColor()==ColorPieza.NEGRO){
                colGenNegro=colGen;
            }
        }
        if(colGenNegro!=colGen){
            return false;
        }
        int filaMin,filaMax;
        filaMin=Math.min(filaGenRojo,filaGenNegro)+1;
        filaMax=Math.max(filaGenRojo,filaGenNegro);
        for(int filas=filaMin;filas<filaMax;filas++){
            if(casillas[filas][colGen]!=null){
                return false;
            }
        }
        return true;
    }
}
