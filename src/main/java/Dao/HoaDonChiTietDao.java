/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Data.HoaDonChiTiet;
import Library.JdbcHelper;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietDao {

    String insertSql = "insert into hoadon(mahd, tendn, ngay, trangthai) values(?,?,getdate(),?)"
            + "insert into hoadonchitiet(mahd, madv, tendv, gia, soluong, ghichu) values(?,?,?,?,?,?)";

    public boolean insert(HoaDonChiTiet hdct, String tenDn) throws Exception {
        Random random = new Random();
        int i = random.nextInt(10000);
        String maHD = "HD" + i;
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(insertSql);) {
            pstmt.setString(4, maHD);
            pstmt.setString(5, hdct.getMaDV());
            pstmt.setString(6, hdct.getTenDV());
            pstmt.setFloat(7, hdct.getGia());
            pstmt.setInt(8, hdct.getSoLuong());
            pstmt.setString(9, hdct.getGhiChu());

            pstmt.setString(1, maHD);
            pstmt.setString(2, tenDn);
            pstmt.setString(3, "CHƯA HOÀN THÀNH");

            i++;

            return pstmt.executeUpdate() > 0;
        }
    }

    String updateSql = "update hoadonchitiet set soluong=?, ghichu=? where mahd=?";

    public boolean update(HoaDonChiTiet hdct) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(updateSql);) {
            pstmt.setString(3, hdct.getMaHD());
            pstmt.setInt(1, hdct.getSoLuong());
            pstmt.setString(2, hdct.getGhiChu());

            return pstmt.executeUpdate() > 0;
        }
    }

    String deleteSql = "delete from dichvu where mahdct=?";

    public boolean delete(String mahdct) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(deleteSql);) {
            pstmt.setString(1, mahdct);

            return pstmt.executeUpdate() > 0;
        }
    }

    String huyDonSql = "update hoadon set trangthai=? where mahd=?";

    public boolean capNhatTrangThai(String mahd, String trangThai) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(huyDonSql);) {
            pstmt.setString(2, mahd);
            pstmt.setString(1, trangThai);

            return pstmt.executeUpdate() > 0;
        }
    }

    String selectAllSql = "select b.*, a.trangthai, a.tendn from hoadon a inner join hoadonchitiet b "
            + "on a.mahd=b.mahd where ngay=?";

    public List<HoaDonChiTiet> selectAll() throws Exception {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(selectAllSql);) {
            pstmt.setDate(1, sqlDate);

            try ( ResultSet rs = pstmt.executeQuery();) {
                List<HoaDonChiTiet> list = new ArrayList<>();
                while (rs.next()) {
                    HoaDonChiTiet hdct = createHoaDonChiTiet(rs);
                    list.add(hdct);
                }
                return list;
            }
        }
    }

    String selectByIdSql = "select b.*, a.trangthai, a.tendn from hoadon a inner join hoadonchitiet b "
            + "on a.mahd=b.mahd where b.mahd=?";

    public HoaDonChiTiet selectById(String id) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(selectByIdSql);) {
            pstmt.setString(1, id);
            try ( ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    HoaDonChiTiet hdct = createHoaDonChiTiet(rs);
                    return hdct;
                }
            }
            return null;
        }
    }

    public HoaDonChiTiet createHoaDonChiTiet(final ResultSet rs) throws SQLException {
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        hdct.setMaHD(rs.getString("mahd"));
        hdct.setMaDV(rs.getString("madv"));
        hdct.setTenDV(rs.getString("tendv"));
        hdct.setGia(rs.getFloat("gia"));
        hdct.setSoLuong(rs.getInt("soluong"));
        hdct.setTrangThai(rs.getString("trangthai"));
        hdct.setTenDn(rs.getString("tendn"));

        return hdct;
    }

    public List<HoaDonChiTiet> searchByName(String name) throws Exception {
        String sql = "select b.mahd, b.madv, b.tendv, b.gia, b.soluong, a.trangthai from hoadon a inner join hoadonchitiet b "
                + "on a.mahd=b.mahd where b.tendv like ?";
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, "%" + name + "%");
            try ( ResultSet rs = pstmt.executeQuery();) {
                List<HoaDonChiTiet> list = new ArrayList<>();
                while (rs.next()) {
                    HoaDonChiTiet nh = createHoaDonChiTiet(rs);
                    list.add(nh);
                }
                return list;

            }

        }
    }

    String tinhTienSql = "select b.*, a.trangthai, a.tendn from hoadon a inner join hoadonchitiet b "
            + "on a.mahd=b.mahd where a.TenDN=? and a.ngay=?";

    public List<HoaDonChiTiet> tinhTien(String tenDn) throws Exception {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(tinhTienSql);) {
            pstmt.setString(1, tenDn);
            pstmt.setDate(2, sqlDate);
            try ( ResultSet rs = pstmt.executeQuery();) {
                List<HoaDonChiTiet> list = new ArrayList<>();
                while (rs.next()) {
                    HoaDonChiTiet hdct = createHoaDonChiTiet(rs);
                    list.add(hdct);
                }
                return list;
            }
        }
    }
    
    String donHangnSql = "select b.*, a.trangthai, a.tendn from hoadon a inner join hoadonchitiet b "
            + "on a.mahd=b.mahd where a.TenDN=? and a.ngay=?";

    public List<HoaDonChiTiet> donHang(String tenDn) throws Exception {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(tinhTienSql);) {
            pstmt.setString(1, tenDn);
            pstmt.setDate(2, sqlDate);
            try ( ResultSet rs = pstmt.executeQuery();) {
                List<HoaDonChiTiet> list = new ArrayList<>();
                while (rs.next()) {
                    HoaDonChiTiet hdct = createHoaDonChiTiet(rs);
                    list.add(hdct);
                }
                return list;
            }
        }
    }

}
