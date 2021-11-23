
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
        while (Condivisa.getInstance().isRunning()) {
            try {
                DatagramSocket ds = new DatagramSocket(12345);
                byte[] buff = new byte[1500];
                DatagramPacket dp = new DatagramPacket(buff, buff.length);
                Condivisa.getInstance().setWait(false);
                Condivisa.getInstance().setListening(true);
                ds.receive(dp);
                if (Condivisa.getInstance().getRicevuto().equals("") || (new String(dp.getData()).charAt(0) != 'n') && (new String(dp.getData()).charAt(0) != ';')) {
                    if (new String(dp.getData()).charAt(0) == 'a') {
                        int choose = JOptionPane.YES_NO_CANCEL_OPTION;
                        JOptionPane.showConfirmDialog(null, "Accettare la connessione?", "?", choose);
                        if (choose == JOptionPane.YES_OPTION) {
                            Condivisa.getInstance().setRicevuto(new String(dp.getData()));
                            buff = new byte[(Condivisa.getInstance().getNomeR() + "y").length()];
                            buff = (Condivisa.getInstance().getNomeR() + "y").getBytes();
                            dp.setData(buff);
                            ds.send(dp);
                            Condivisa.getInstance().setRicevuto("");
                        } else {
                            buff = new byte["c".length()];
                            buff = "c".getBytes();
                            dp.setData(buff);
                            ds.send(dp);
                            Condivisa.getInstance().setRicevuto("");
                        }
                    } else {
                        buff = new byte["c".length()];
                        buff = "c".getBytes();
                        dp.setData(buff);
                        ds.send(dp);
                    }
                } else if (new String(dp.getData()).charAt(0) == 'm') {
                    
                }
            } catch (SocketException ex) {
                Condivisa.getInstance().setListening(false);
                Condivisa.getInstance().setWait(false);
            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
