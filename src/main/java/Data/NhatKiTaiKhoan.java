/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class NhatKiTaiKhoan {
    private String tenDN, ghiChu, gioBatDau, gioKetThuc, tongThoiGian;
    private Date ngay;
    private float tien;

    public String getTenDN() {
        return tenDN;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(String gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public String getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(String gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    public String getTongThoiGian() {
        return tongThoiGian;
    }

    public void setTongThoiGian(String tongThoiGian) {
        this.tongThoiGian = tongThoiGian;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public float getTien() {
        return tien;
    }

    public void setTien(float tien) {
        this.tien = tien;
    }

    public NhatKiTaiKhoan() {
    }

    public NhatKiTaiKhoan(String tenDN, String ghiChu, String gioBatDau, String gioKetThuc, String tongThoiGian, Date ngay, float tien) {
        this.tenDN = tenDN;
        this.ghiChu = ghiChu;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
        this.tongThoiGian = tongThoiGian;
        this.ngay = ngay;
        this.tien = tien;
    }


}
