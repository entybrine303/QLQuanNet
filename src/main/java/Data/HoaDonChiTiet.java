/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author Admin
 */
public class HoaDonChiTiet {

    private int soLuong;
    private String maHD, maDV, tenDV, ghiChu, trangThai, tenDn;

    public String getTenDn() {
        return tenDn;
    }

    public void setTenDn(String tenDn) {
        this.tenDn = tenDn;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    private float gia;

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String maHD, int soLuong, String maDV, String tenDV, String ghiChu, String trangThai, String tenDn, float gia) {
        this.maHD = maHD;
        this.soLuong = soLuong;
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.ghiChu = ghiChu;
        this.trangThai=trangThai;
        this.tenDn=tenDn;
        this.gia = gia;
    }
}
