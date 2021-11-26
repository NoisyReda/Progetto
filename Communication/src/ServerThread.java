
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
        Invia i = new Invia();
        while (Condivisa.getInstance().isRunning()) {
            try {
                DatagramSocket ds = new DatagramSocket(12345);
                byte[] buff = new byte[1500];
                DatagramPacket dp = new DatagramPacket(buff, buff.length);
                Condivisa.getInstance().setWait(false);
                ds.receive(dp);
                if (Condivisa.getInstance().getRicevuto().equals("") || (new String(dp.getData()).charAt(0) != 'n') && (new String(dp.getData()).charAt(0) != ';')) {
                    if (new String(dp.getData()).charAt(0) == 'a') {
                        int choose = JOptionPane.YES_NO_CANCEL_OPTION;
                        JOptionPane.showConfirmDialog(null, "Accettare la connessione?", "?", choose);
                        if (choose == JOptionPane.YES_OPTION) {
                            Condivisa.getInstance().setRicevuto(new String(dp.getData()));
                           Condivisa.getInstance().setMessaggio(Condivisa.getInstance().getNome() + "y");                           
                            i.send();
                            Condivisa.getInstance().setRicevuto("");
                        } else {
                            Condivisa.getInstance().setMessaggio("n");                           
                            i.send();
                            Condivisa.getInstance().setRicevuto("");
                        }
                    } else {
                        Condivisa.getInstance().setMessaggio("n");                           
                            i.send();
                    }
                } else if (new String(dp.getData()).charAt(0) == 'm') {

                }
            } catch (SocketException ex) {
                Condivisa.getInstance().setWait(false);
            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
