/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package juegoxianquiproyecto;
import java.util.ArrayList;
/**
 *
 * @author andres
 */
public interface Almacenamiento {
    void crearJugador(String user,String password) throws UserExistenteException;
    Player login(String user,String password);
    boolean eliminarPlayer(String user,String password);
    boolean changePassword(String user,String actPassword,String newPassword);
    ArrayList<Player> obtenerRanking();
    ArrayList<String> obtenerHistorial(String user);
    void guardarResultadoPartida(String user,String resultado);
}
