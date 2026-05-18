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
public class Usuario {
    private String user;
    private String password;
    private boolean activo;
    private String fechaIngreso;
    public Usuario(String user,String password){
        this.user=user;
        this.password=password;
        this.activo=true;
        this.fechaIngreso=LocalDate.now().toString();
    }
    public String getUser(){
        return user;
    }
    public String getPassword(){
        return password;
    }
    public boolean isActivo(){
        return activo;
    }
    public String getIngreso(){
        return fechaIngreso;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setActivo(boolean activo){
        this.activo=activo;
    }
}
