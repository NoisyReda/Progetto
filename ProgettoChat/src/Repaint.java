
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Mattia
 */
public class Repaint extends Thread {

    private JFrame jf;

    public Repaint(JFrame jf) {
        this.jf = jf;
    }

    @Override
    public void run() {
        try {
            while (Data.getInstance().isConnected()) {
                jf.repaint();
                try {
                    Thread.sleep(17);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Repaint.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(Repaint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
