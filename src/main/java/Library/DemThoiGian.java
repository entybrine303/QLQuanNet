/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

/**
 *
 * @author Admin
 */
public class DemThoiGian extends Thread {

    int h, m, s;

    @Override
    public void run() {
        h = 0;
        m = 0;
        s = 0;
        while (true) {
            s++;

            if (s >= 59) {
                s = 00;
                m++;
            } else if (m >= 59) {
                m = 00;
                h++;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                break;
            }
        }
    }
    
    public String demThoiGian(){
        return h+":"+m+":"+s;
    }
}
