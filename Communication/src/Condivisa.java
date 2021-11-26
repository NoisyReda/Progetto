
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Random;

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
    private InetAddress address;
    private boolean wait;
    private String nome;
    private String messaggio;
    private boolean running;
    private ArrayList<String> connected;
    private DatagramSocket ds;

    public ArrayList<String> getConnected() {
        return connected;
    }

    public void setConnected(String connected) {
        this.connected.add(connected);
    }

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRicevuto() {
        return ricevuto;
    }

    public void setRicevuto(String ricevuto) {
        this.ricevuto = ricevuto;
    }

    public DatagramSocket getDs() {
        return ds;
    }

    public void setDs() throws SocketException {
        Random i = new Random();
        int port = i.nextInt((65535 - 12357) + 1) + 12357;
        this.ds = new DatagramSocket(port);
    }

    private Condivisa() {
        port = 0;
        ricevuto = "";
        address = null;
        wait = true;
        messaggio = "";
        nome = "";
        connected = new ArrayList<>();
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

    public static Condivisa getInstance() {
        if (instance == null) {
            return instance = new Condivisa();
        } else {
            return instance;
        }
    }

}
