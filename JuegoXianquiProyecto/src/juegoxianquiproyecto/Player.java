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
public class Player {
    private String user;
    private String password;
    private int puntos;
    private String fechaIngreso;
    private boolean activo;
    public Player(String user,String password){
        this.user=user;
        this.password=password;
        this.puntos=0;
        this.fechaIngreso=LocalDate.now().toString();
        this.activo=true;
    }
    public String getUser(){
        return user;
    }
    public String getPassword(){
        return password;
    }
    public int getPuntos(){
        return puntos;
    }
    public String getIngreso(){
        return fechaIngreso;
    }
    public boolean isActivo(){
        return activo;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setPuntos(int puntos){
        this.puntos=puntos;
    }
    public void setActivo(boolean activo){
        this.activo=activo;
    }
    public void sumarPuntos(int cant){
        this.puntos+=cant;
    }
}
