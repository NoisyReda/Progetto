
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mattia
 */
public class Data {

    private InetAddress address;
    private int port;
    private String messaggio;
    private String HostC;
    private String nome;
    private static Data instance;
    private boolean Connected;
    private boolean busy;
    private String VisMessaggio;

    public String getVisMessaggio() {
        return VisMessaggio;
    }

    public void setVisMessaggio(String VisMessaggio) {
        this.VisMessaggio = VisMessaggio;
    }

    private Data() throws UnknownHostException {
        Random i = new Random();
        HostC = "";
        address = InetAddress.getByName("0.0.0.0");
        port = i.nextInt((65535 - 12349) + 1) + 12349;
        messaggio = "";
        nome = "";
        Connected = false;
        busy = false;
        VisMessaggio = "";
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public boolean isConnected() {
        return Connected;
    }

    public void setConnected(boolean Connected) {
        this.Connected = Connected;
    }

    public InetAddress getAddress() {
        return address;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    public String getHostC() {
        return HostC;
    }

    public void setHostC(String HostC) {
        this.HostC = HostC;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static Data getInstance() throws UnknownHostException {
        if (instance == null) {
            return instance = new Data();
        } else {
            return instance;
        }
    }

    public void send() throws SocketException, IOException {
        DatagramSocket ds = new DatagramSocket();
        byte[] buff = new byte[1500];
        DatagramPacket dp = new DatagramPacket(buff, buff.length);
        dp.setAddress(address);
        buff = messaggio.getBytes();
        dp.setData(buff);
        dp.setPort(12346);
        ds.send(dp);
        messaggio = "";
    }

}
