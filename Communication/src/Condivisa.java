
import java.net.InetAddress;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Redaelli_Mattia03
 */
public class Condivisa {

    private int port;
    private static Condivisa instance;
    private String ricevuto;
    private boolean listening;
    private InetAddress address;
    private boolean wait;
    private String nomeR;
    private String messaggio;
    private String nomeS;
    private boolean running;

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public InetAddress getAddress() {
        return address;
    }

    public boolean isWait() {
        return wait;
    }

    public void setWait(boolean wait) {
        this.wait = wait;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

    public boolean isListening() {
        return listening;
    }

    public String getNomeR() {
        return nomeR;
    }

    public void setNomeR(String nomeR) {
        this.nomeR = nomeR;
    }

    public String getNomeS() {
        return nomeS;
    }

    public void setNomeS(String nomeS) {
        this.nomeS = nomeS;
    }

    public void setListening(boolean listening) {
        this.listening = listening;
    }

    public String getRicevuto() {
        return ricevuto;
    }

    public void setRicevuto(String ricevuto) {
        this.ricevuto = ricevuto;
    }

    private Condivisa() {
        port = 0;
        ricevuto = "";
        listening = false;
        address = null;
        wait = true;
        messaggio = "";
        nomeR = "";
        nomeS = "";
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public static Condivisa getInstance() {
        if (instance == null) {
            return instance = new Condivisa();
        } else {
            return instance;
        }
    }

}
