
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Redaelli_Mattia03
 */
public class ServerThread extends Thread {

    @Override
    public void run() {
        try {
            DatagramSocket ds = new DatagramSocket(12345);
            byte[] buff = new byte[1500];
            DatagramPacket dp = new DatagramPacket(buff, buff.length);
            Condivisa.getInstance().setWait(false);
            Condivisa.getInstance().setListening(true);
            ds.receive(dp);
            System.out.println((new String(dp.getData())));
            Condivisa.getInstance().setRicevuto(new String(dp.getData()));
        } catch (SocketException ex) {
            Condivisa.getInstance().setListening(false);
            Condivisa.getInstance().setWait(false);
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
