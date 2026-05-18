/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoxianquiproyecto;
import java.time.LocalDate;
/**
 *
 * @author andres
 */
public class Player extends Usuario{
    private int puntos;
    private int partidasJugadas;
    private int partidasGanadas;
    private int partidasPerdidas;
    private boolean activo;
    public Player(String user,String password){
        super(user,password);
        this.puntos=0;
        this.partidasJugadas=0;
        this.partidasGanadas=0;
        this.partidasPerdidas=0;
    }
    public int getPuntos(){
        return puntos;
    }
    public int getPartidasJugadas(){
        return partidasJugadas;
    }
    public int getPartidasGanadas(){
        return partidasGanadas;
    }
    public int getPartidasPerdidas(){
        return partidasPerdidas;
    }
    public void setPuntos(int puntos){
        this.puntos=puntos;
    }
    public void sumarPartidaJugada(){
        this.partidasJugadas++;
    }
    public void sumarPartidaGanada(){
        this.partidasGanadas++;
    }
    public void sumarPartidaPerdida(){
        this.partidasPerdidas++;
    }
    public void sumarPuntos(int cant){
        this.puntos+=cant;
    }
}
