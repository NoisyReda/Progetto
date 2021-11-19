
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
    private String inviato;
    private String ricevuto;
    private boolean listening;
    private InetAddress address;
    private boolean wait;

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

    public void setListening(boolean listening) {
        this.listening = listening;
    }

    public String getInviato() {
        return inviato;
    }

    public void setInviato(String inviato) {
        this.inviato = inviato;
    }

    public String getRicevuto() {
        return ricevuto;
    }

    public void setRicevuto(String ricevuto) {
        this.ricevuto = ricevuto;
    }

    private Condivisa() {
        port = 0;
        inviato = "";
        ricevuto = "";
        listening = false;
        address = null;
        wait = true;
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
