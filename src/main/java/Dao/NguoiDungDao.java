/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Data.NguoiDung;
import Library.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NguoiDungDao extends QLQN<NguoiDung, String> {

    String insertSql = "insert into taikhoan(tendn, matkhau) values(?,?) "
            + "insert into nguoidung(tendn, hoten, gioitinh, sodt, ngaytao, tongtien, tienconlai, tongthoigian, thoigianconlai) values(?,?,?,?,?,?,?,?,?)";

    @Override
    public boolean insert(NguoiDung nd) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(insertSql);) {
            pstmt.setString(1, nd.getTenDN());
            pstmt.setString(2, nd.getMatKhau());

            pstmt.setString(3, nd.getTenDN());
            pstmt.setString(4, nd.getHoTen());
            pstmt.setBoolean(5, nd.isGioiTinh());
            pstmt.setString(6, nd.getSoDth());
            pstmt.setDate(7, nd.getNgayTaoTk());
            pstmt.setFloat(8, nd.getTongTien());
            pstmt.setFloat(9, nd.getTienConLai());
            pstmt.setString(10, nd.getTongThoiGian());
            pstmt.setDate(11, nd.getThoiGianConLai());

            return pstmt.executeUpdate() > 0;
        }
    }

    public String phutSangGio(double tongTien) {
        int tienRaSoPhut=(int) (tongTien*0.012);
        long g = (long) (tienRaSoPhut * 60);
        int gio, phut, giay;

        gio = (int) (g / 3600);
        phut = (int) (g % 3600 / 60);
        giay = (int) (g % 3600 / 60);
        return gio + ":" + phut + ":" + giay;
    }

    String updateSql = "update nguoidung set hoten=?, gioitinh=?, sodt=?, ngaytao=?, tongtien=?, tienconlai=?, tongthoigian=?, thoigianconlai=? where tendn=?";

    @Override
    public boolean update(NguoiDung nd) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(updateSql);) {
            pstmt.setString(9, nd.getTenDN());
            pstmt.setString(1, nd.getHoTen());
            pstmt.setBoolean(2, nd.isGioiTinh());
            pstmt.setString(3, nd.getSoDth());
            pstmt.setDate(4, nd.getNgayTaoTk());
            pstmt.setFloat(5, nd.getTongTien());
            pstmt.setFloat(6, nd.getTienConLai());
            pstmt.setString(7, nd.getTongThoiGian());
            pstmt.setDate(8, nd.getThoiGianConLai());

            this.updateMk(nd);
            

            return pstmt.executeUpdate() > 0;
        }
    }
    
    String updateMkSql = "update taikhoan set matkhau=? where tendn=?";

    public boolean updateMk(NguoiDung nd) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(updateMkSql);) {

            pstmt.setString(1, nd.getMatKhau());
            pstmt.setString(2, nd.getTenDN());
            

            return pstmt.executeUpdate() > 0;
        }
    }

    String deleteSql = "delete from nguoidung where tendn=?";

    @Override
    public boolean delete(String tendn) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(deleteSql);) {
            pstmt.setString(1, tendn);

            return pstmt.executeUpdate() > 0;
        }
    }

    String selectAllSql = "select * from nguoidung";

    @Override
    public List<NguoiDung> selectAll() throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(selectAllSql);) {
            try ( ResultSet rs = pstmt.executeQuery();) {
                List<NguoiDung> list = new ArrayList<>();
                while (rs.next()) {
                    NguoiDung nd = createNguoiDung(rs);
                    list.add(nd);
                }
                return list;
            }
        }
    }

    String selectByIdSql = "select * from nguoidung where tendn=?";

    @Override
    public NguoiDung selectById(String id) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(selectByIdSql);) {
            pstmt.setString(1, id);
            try ( ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    NguoiDung nd = createNguoiDung(rs);
                    return nd;
                }
            }
            return null;
        }
    }

    public NguoiDung createNguoiDung(final ResultSet rs) throws SQLException {
        NguoiDung nd = new NguoiDung();
        nd.setTenDN(rs.getString("tendn"));
        nd.setHoTen(rs.getString("hoten"));
        nd.setGioiTinh(rs.getBoolean("gioitinh"));
        nd.setSoDth(rs.getString("sodt"));
        nd.setNgayTaoTk(rs.getDate("ngaytao"));
        nd.setTongTien(rs.getFloat("tongtien"));
        nd.setTienConLai(rs.getFloat("tienconlai"));
        nd.setTongThoiGian(rs.getString("tongthoigian"));
        nd.setThoiGianConLai(rs.getDate("thoigianconlai"));

        return nd;
    }

    public List<NguoiDung> searchByName(String name) throws Exception {
        String sql = "select * from nguoidung where tendn like ?";
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, "%" + name + "%");
            try ( ResultSet rs = pstmt.executeQuery();) {
                List<NguoiDung> list = new ArrayList<>();
                while (rs.next()) {
                    NguoiDung nh = createNguoiDung(rs);
                    list.add(nh);
                }
                return list;

            }

        }
    }

    String tongThoiGianSql = "update nguoidung set tongthoigian=? where tendn=?";

    public boolean tongThoiGian(String tenDn) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(tongThoiGianSql);) {
            pstmt.setString(2, tenDn);
            pstmt.setString(1, phutSangGio(selectTongTien(tenDn)));

            return pstmt.executeUpdate() > 0;
        }
    }

    String tongTienSql = "select tongtien from nguoidung where tendn=?";

    double selectTongTien(String tenDn) throws Exception {
        double tongTien;

        try ( Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt1 = con.prepareStatement(tongTienSql);) {
            pstmt1.setString(1, tenDn);
            try ( ResultSet rs = pstmt1.executeQuery();) {
                if (rs.next()) {
                    tongTien = rs.getDouble("tongtien");
                    return tongTien;
                }
                return 0;
            }
        }
    }

    String napTienSql = "update nguoidung set tongtien=tongtien+? where tendn=?";

    public boolean napTien(String tenDn, float tien) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(napTienSql);) {
            pstmt.setString(2, tenDn);
            pstmt.setFloat(1, tien);

            return pstmt.executeUpdate() > 0;
        }
    }
    
    String update= "update nguoidung set tongthoigian=?, tongtien=tongtien-? where tendn=?";

    public boolean capNhatTk(String tenDn, String tongThoiGian, String thoiGian) throws Exception {
        float tongTienHienTai=(float) (Integer.parseInt(thoiGian)/0.012);
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(update);) {
            pstmt.setString(3, tenDn);
            pstmt.setString(1, tongThoiGian);
            pstmt.setFloat(2, tongTienHienTai);

            return pstmt.executeUpdate() > 0;
        }
    }
}
