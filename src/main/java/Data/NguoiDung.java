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
public class NguoiDung {
    private String tenDN, hoTen, soDth, tongThoiGian, matKhau;

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    private boolean gioiTinh;
    private Date ngayTaoTk,  thoiGianConLai;
    private float tongTien, tienConLai;

    public String getTenDN() {
        return tenDN;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDth() {
        return soDth;
    }

    public void setSoDth(String soDth) {
        this.soDth = soDth;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgayTaoTk() {
        return ngayTaoTk;
    }

    public void setNgayTaoTk(Date ngayTaoTk) {
        this.ngayTaoTk = ngayTaoTk;
    }

    public String getTongThoiGian() {
        return tongThoiGian;
    }

    public void setTongThoiGian(String tongThoiGian) {
        this.tongThoiGian = tongThoiGian;
    }

    public Date getThoiGianConLai() {
        return thoiGianConLai;
    }

    public void setThoiGianConLai(Date thoiGianConLai) {
        this.thoiGianConLai = thoiGianConLai;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public float getTienConLai() {
        return tienConLai;
    }

    public void setTienConLai(float tienConLai) {
        this.tienConLai = tienConLai;
    }

    public NguoiDung() {
    }

    public NguoiDung(String tenDN, String hoTen, String soDth, boolean gioiTinh, Date ngayTaoTk, String tongThoiGian, Date thoiGianConLai, float tongTien, float tienConLai, String matKhau) {
        this.tenDN = tenDN;
        this.hoTen = hoTen;
        this.soDth = soDth;
        this.gioiTinh = gioiTinh;
        this.ngayTaoTk = ngayTaoTk;
        this.tongThoiGian = tongThoiGian;
        this.thoiGianConLai = thoiGianConLai;
        this.tongTien = tongTien;
        this.tienConLai = tienConLai;
        this.matKhau=matKhau;
    }
}
