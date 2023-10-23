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
public class DichVu {
    private String maDV, tenDV, trangThai, nguoiTao;
    private float gia;
    private byte [] hinh;
    private Date ngayTao;

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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public byte[] getHinh() {
        return hinh;
    }

    public void setHinh(byte[] hinh) {
        this.hinh = hinh;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public DichVu() {
    }

    public DichVu(String maDV, String tenDV, String trangThai, String nguoiTao, float gia, byte[] hinh, Date ngayTao) {
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.trangThai = trangThai;
        this.nguoiTao = nguoiTao;
        this.gia = gia;
        this.hinh = hinh;
        this.ngayTao = ngayTao;
    }
}
