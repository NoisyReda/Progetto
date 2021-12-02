
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
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
 * @author Mattia
 */
public class Server extends Thread {

    private DatagramSocket ds;
    private DatagramPacket dp;
    private byte[] buff;

    public Server() throws SocketException {
        ds = new DatagramSocket(12346);
        buff = new byte[1500];
        dp = new DatagramPacket(buff, buff.length);
    }

    @Override
    public void run() {
        try {
            while (Data.getInstance().isConnected()) {
                ds.receive(dp);
                if (new String(dp.getData()).charAt(0) == 'a' && new String(dp.getData()).charAt(1) == ';' && !Data.getInstance().isBusy()) {
                    Data.getInstance().setBusy(true);
                    int choose = JOptionPane.YES_NO_CANCEL_OPTION;
                    JOptionPane.showConfirmDialog(null, "Accettare la connessione?", "?", choose);
                    if (choose == 1) {
                        Data.getInstance().setHostC(new String(dp.getData()).split(";")[1].trim());
                        Data.getInstance().setAddress(dp.getAddress());
                        Data.getInstance().setMessaggio("");
                        Data.getInstance().setMessaggio("y;" + Data.getInstance().getNome());
                        Data.getInstance().send();
                    } else {
                        Data.getInstance().setMessaggio("");
                        Data.getInstance().setMessaggio("n;");
                        Data.getInstance().setAddress(dp.getAddress());
                        Data.getInstance().send();
                        Data.getInstance().setBusy(false);
                    }
                } else if (new String(dp.getData()).charAt(0) == 'c' && new String(dp.getData()).charAt(1) == ';') {
                    JOptionPane.showConfirmDialog(null, "Disconnesso da" + Data.getInstance().getHostC(), "XX", 0);
                    Data.getInstance().setHostC("");
                    Data.getInstance().setBusy(false);
                    Data.getInstance().setPort(0);
                    Data.getInstance().setAddress(InetAddress.getByName("0.0.0.0"));
                } else if (new String(dp.getData()).charAt(0) == 'y' && new String(dp.getData()).charAt(1) == ';' && new String(dp.getData()).trim().length() < 2) {
                    JOptionPane.showConfirmDialog(null, "Connessione accettata", "XX", 0);
                    Data.getInstance().setMessaggio("");
                } else if (new String(dp.getData()).charAt(0) == 'n' && new String(dp.getData()).charAt(1) == ';') {
                    JOptionPane.showConfirmDialog(null, "Connessione non accettata", "XX", 0);
                    Data.getInstance().setMessaggio("");
                } else if (new String(dp.getData()).charAt(0) == 'm' && new String(dp.getData()).charAt(1) == ';') {
                    try {
                        Data.getInstance().setVisMessaggio(new String(dp.getData()).trim().split(";")[1]);
                    } catch (Exception ex) {
                        Data.getInstance().setVisMessaggio(" ");
                    }
                } else if (new String(dp.getData()).charAt(0) == 'y' && new String(dp.getData()).charAt(1) == ';' && new String(dp.getData()).trim().length() > 2) {
                    Data.getInstance().setHostC(new String(dp.getData()).split(";")[1].trim());
                    Data.getInstance().setBusy(true);
                } else if (!Data.getInstance().isBusy()) {
                    Data.getInstance().setAddress(dp.getAddress());
                    Data.getInstance().setMessaggio("");
                    Data.getInstance().setMessaggio("n;");
                    Data.getInstance().send();
                }
                buff = new byte[1500];
                dp.setData(buff);
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
