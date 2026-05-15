/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoxianquiproyecto;
import java.util.ArrayList;
/**
 *
 * @author andres
 */
public class GestorPlayers implements Almacenamiento{
    private ArrayList<Player> listaPlayers;
    private ArrayList<String> listaHistorial;
    public GestorPlayers(){
        listaPlayers=new ArrayList<>();
        listaHistorial=new ArrayList<>();
    }
    private Player buscarPlayer(String user,int indice){
        if(indice>=listaPlayers.size())
            return null;
        if(listaPlayers.get(indice).getUser().equals(user)){
            return listaPlayers.get(indice);
        }
        return buscarPlayer(user,indice+1);
    }
    private void ordenarRanking(ArrayList<Player> lista,int recorrido){
        if(recorrido>=lista.size()-1){
            return;
        }
        for(int control=0;control<lista.size()-1-recorrido;control++){
            if(lista.get(control).getPuntos()<lista.get(control+1).getPuntos()){
                Player temp=lista.get(control);
                lista.set(control,lista.get(control+1));
                lista.set(control+1,temp);
            }
        }
        ordenarRanking(lista,recorrido+1);
    }
    public ArrayList<Player> getListaPLayers(){
        return listaPlayers;
    }
    public void crearJugador(String user, String password) throws UserExistenteException {
        if(buscarPlayer(user,0)!=null){
            throw new UserExistenteException("El usuario ´"+user+"´ ya existe, escoge otro nombre");
        }
        listaPlayers.add(new Player(user,password));
    }
    public Player login(String user, String password) {
        Player jugador=buscarPlayer(user,0);
        if(jugador!=null && jugador.getPassword().equals(password)&&jugador.isActivo()){
            return jugador;
        }
        return null;
    }
    public boolean eliminarPlayer(String user, String password) {
        Player jugador=buscarPlayer(user,0);
        if(jugador!=null && jugador.getPassword().equals(password)){
            listaPlayers.remove(jugador);
            return true;
        }
        return false;
    }
    public boolean changePassword(String user, String actPassword, String newPassword) {
        Player jugador=buscarPlayer(user,0);
        if(jugador!=null && jugador.getPassword().equals(actPassword)){
            jugador.setPassword(newPassword);
            return true;
        }
        return false;
    }
    public ArrayList<Player> obtenerRanking() {
        ArrayList<Player> activos=new ArrayList<>();
        for(Player jugador:listaPlayers){
            if(jugador.isActivo())
                activos.add(jugador);
        }
        ordenarRanking(activos,0);
        return activos;
    }
    public ArrayList<String> obtenerHistorial(String user) {
        ArrayList<String> historialUser=new ArrayList<>();
        for(String entrada:listaHistorial){
            if(entrada.contains("["+user+"]")){
                historialUser.add(entrada);
            }
        }
        return historialUser;
    }
    public void guardarResultadoPartida(String user, String resultado) {
        listaHistorial.add(0,"["+user+"]"+resultado);
    }
    public Player buscarPlayerPublico(String user){
        return buscarPlayer(user,0);
    }
    public void eliminarPlayerValidado(String user,String password) throws IncorrectPasswordException{
        Player jugador=buscarPlayer(user,0);
        if(jugador!=null && jugador.getPassword().equals(password)){
            listaPlayers.remove(jugador);
        }
        else{
            throw new IncorrectPasswordException("Contraseña incorrecta, intentalo de nuevo");
        }
    }
}
