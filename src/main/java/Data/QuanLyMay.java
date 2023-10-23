/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author Admin
 */
public class QuanLyMay {
    private String tenMay, nguoiSuDung, tinhTrang, ghiChu;

    public String getTenMay() {
        return tenMay;
    }

    public void setTenMay(String tenMay) {
        this.tenMay = tenMay;
    }

    public String getNguoiSuDung() {
        return nguoiSuDung;
    }

    public void setNguoiSuDung(String nguoiSuDung) {
        this.nguoiSuDung = nguoiSuDung;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public QuanLyMay() {
    }

    public QuanLyMay(String tenMay, String nguoiSuDung, String tinhTrang, String ghiChu) {
        this.tenMay = tenMay;
        this.nguoiSuDung = nguoiSuDung;
        this.tinhTrang = tinhTrang;
        this.ghiChu = ghiChu;
    }
}
