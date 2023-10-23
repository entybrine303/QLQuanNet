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
public class NhatKiHeThong {
    private String tenMay, tenNguoiSuDung, trangThai, daSuDung, ghiChu, thoiGian;
    private Date ngay;

    public String getTenMay() {
        return tenMay;
    }

    public void setTenMay(String tenMay) {
        this.tenMay = tenMay;
    }

    public String getTenNguoiSuDung() {
        return tenNguoiSuDung;
    }

    public void setTenNguoiSuDung(String tenNguoiSuDung) {
        this.tenNguoiSuDung = tenNguoiSuDung;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getDaSuDung() {
        return daSuDung;
    }

    public void setDaSuDung(String daSuDung) {
        this.daSuDung = daSuDung;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public NhatKiHeThong() {
    }

    public NhatKiHeThong(String tenMay, String tenNguoiSuDung, String trangThai, String daSuDung, String ghiChu, String thoiGian, Date ngay) {
        this.tenMay = tenMay;
        this.tenNguoiSuDung = tenNguoiSuDung;
        this.trangThai = trangThai;
        this.daSuDung = daSuDung;
        this.ghiChu = ghiChu;
        this.thoiGian = thoiGian;
        this.ngay = ngay;
    }

}
