/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class TinhThoiGIan implements Runnable {

    long tongThoiGian;
    int gioSD, phutSD, giaySD;
    int gioTT, phutTT, giayTT;

    JTextField txtThoiGianSuDung, txtThoiGianConLai, txtTongThoiGian;

    public TinhThoiGIan(JTextField txtTongThoiGian, JTextField txtThoiGianSuDung, JTextField txtThoiGianConLai, long tongThoiGian) {
        this.txtThoiGianSuDung = txtThoiGianSuDung;
        this.txtThoiGianConLai = txtThoiGianConLai;
        this.txtTongThoiGian = txtTongThoiGian;
        this.tongThoiGian = tongThoiGian;
    }

    public TinhThoiGIan(JTextField txtTongThoiGian, long tongThoiGian) {
        this.txtTongThoiGian = txtTongThoiGian;
        this.tongThoiGian = tongThoiGian;
    }

    @Override
    public void run() {
        

        long g = tongThoiGian * 60;

        String thoiGian[]=txtTongThoiGian.getText().split(":");
        gioTT = Integer.parseInt(thoiGian[0]);
        phutTT = Integer.parseInt(thoiGian[1]);
        giayTT = Integer.parseInt(thoiGian[2]);

        gioSD = 0;
        phutSD = 0;
        giaySD = 0;
        
        while (true) {
            giaySD++;

            if (giaySD >= 59) {
                giaySD = 00;
                phutSD++;
            } else if (phutSD >= 59) {
                phutSD = 00;
                gioSD++;
            }

            giayTT--;
            if (giayTT <= 00) {
                giayTT = 59;
                phutTT--;
            } else if (phutTT <= 00) {
                phutTT = 59;
                gioTT--;
            }

            txtThoiGianSuDung.setText(gioSD + ":" + phutSD + ":" + giaySD);
            txtThoiGianConLai.setText(gioTT + ":" + phutTT + ":" + giayTT);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                break;
            }
        }
    }

    public void phutSangGio() {
        long g = tongThoiGian * 60;

        gioTT = (int) (g / 3600);
        phutTT = (int) (g % 3600 / 60);
        giayTT = (int) (g % 3600 % 60);

        txtTongThoiGian.setText(gioTT + ":" + phutTT + ":" + giayTT);

    }

    public String thoiGianConLai() {
        long g = tongThoiGian * 60;

        gioTT = (int) (g / 3600);
        phutTT = (int) (g % 3600 / 60);
        giayTT = (int) (g % 3600 % 60);

        giayTT--;

        if (giayTT == 00) {
            giayTT = 59;
            phutSD--;
        } else if (phutTT == 00) {
            phutTT = 59;
            gioTT--;
        }
        return gioTT + ":" + phutTT + ":" + giayTT;

    }
}
