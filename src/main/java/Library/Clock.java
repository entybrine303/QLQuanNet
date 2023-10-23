package Library;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author Nguyễn Minh Thành
 */
public class Clock extends Thread {

    JLabel lbl;

    public Clock(JLabel lbl) {
        this.lbl = lbl;
    }

    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
        while (true) {
            Date now = new Date();
            String st = sdf.format(now);

            lbl.setText(st);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                break;
            }
        }
    }
}
