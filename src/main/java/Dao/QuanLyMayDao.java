/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Data.QuanLyMay;
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
public class QuanLyMayDao extends QLQN<QuanLyMay, String> {

    String insertSql = "insert into quanlymay(tenmay, nguoisudung, tinhtrang, ghichu) values(?,?,?,?)";

    public boolean insertQuanLymay(QuanLyMay qlm, String nguoidung, String tinhTrang) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(insertSql);) {
            pstmt.setString(1, qlm.getTenMay());
            pstmt.setString(2, nguoidung);
            pstmt.setString(3, tinhTrang);
            pstmt.setString(4, qlm.getGhiChu());

            return pstmt.executeUpdate() > 0;
        }
    }

    String updateSql = "update quanlymay set nguoisudung=?,  tinhtrang=? where tenmay=?";

    public boolean updateQuanLyMay(String tenmay, String nguoidung, String tinhtrang) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(updateSql);) {
            pstmt.setString(3, tenmay);
            pstmt.setString(1, nguoidung);
            pstmt.setString(2, tinhtrang);

            return pstmt.executeUpdate() > 0;
        }
    }

    String deleteSql = "delete from quanlymay where tenmay=?";

    @Override
    public boolean delete(String tenmay) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(deleteSql);) {
            pstmt.setString(1, tenmay);

            return pstmt.executeUpdate() > 0;
        }
    }

    String selectAllSql = "select * from quanlymay";

    @Override
    public List<QuanLyMay> selectAll() throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(selectAllSql);) {
            try ( ResultSet rs = pstmt.executeQuery();) {
                List<QuanLyMay> list = new ArrayList<>();
                while (rs.next()) {
                    QuanLyMay qlm = createQuanLyMay(rs);
                    list.add(qlm);
                }
                return list;
            }
        }
    }

    String selectByIdSql = "select * from quanlymay where tenmay=?";

    @Override
    public QuanLyMay selectById(String id) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(selectByIdSql);) {
            pstmt.setString(1, id);
            try ( ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    QuanLyMay qlm = createQuanLyMay(rs);
                    return qlm;
                }
            }
            return null;
        }
    }

    public QuanLyMay createQuanLyMay(final ResultSet rs) throws SQLException {
        QuanLyMay qlm = new QuanLyMay();
        qlm.setTenMay(rs.getString("tenmay"));
        qlm.setNguoiSuDung(rs.getString("nguoisudung"));
        qlm.setTinhTrang(rs.getString("tinhtrang"));
        qlm.setGhiChu(rs.getString("ghichu"));

        return qlm;
    }

    java.util.Date gioMoMay;

    public void MoMay(String tenMay, String tenDn) throws Exception {
        long millis = System.currentTimeMillis();
        gioMoMay = new java.util.Date(millis);
        updateQuanLyMay(tenMay, tenDn, "ĐANG ONLINE");

        
    }

    java.util.Date gioTatMay;

    public void TatMay(String tenMay) throws Exception {
        long millis = System.currentTimeMillis();
        gioTatMay = new java.util.Date(millis);
        updateQuanLyMay(tenMay, null, "ĐANG OFFLINE");

    }
//
//    public boolean insertNktkGioBd(NhatKiTaiKhoan nktk, String tenDn) throws Exception {
//        String sqlGiobd = "INSERT INTO NhatKiTaiKhoan(TenDN, Ngay, GioBatDau, GioKetThuc, Tien, TongThoiGian, GhiChu)"
//                + "VALUES (?, getdate(), getdate(), ?, ?, ?, ?)";
//        try (
//                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(sqlGiobd);) {
//            pstmt.setString(1, tenDn);
//            pstmt.setDate(2, nktk.getGioKetThuc());
//            pstmt.setFloat(3, nktk.getTien());
//            pstmt.setDate(4, nktk.getTongThoiGian());
//            pstmt.setString(5, nktk.getGhiChu());
//
//            return pstmt.executeUpdate() > 0;
//        }
//    }
//
//    public boolean insertNktkGioKt(NhatKiTaiKhoan nktk, String tenDn) throws Exception {
//        String sqlGiokt = "INSERT INTO NhatKiTaiKhoan(TenDN, Ngay, GioBatDau, GioKetThuc, Tien, TongThoiGian, GhiChu)"
//                + "VALUES (?, ?, ?, getdate, ?, ?, ?)";
//        try (
//                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(sqlGiokt);) {
//            pstmt.setString(1, tenDn);
//            pstmt.setDate(3, nktk.getNgay());
//            pstmt.setDate(3, nktk.getGioBatDau());
//            pstmt.setFloat(4, nktk.getTien());
//            pstmt.setDate(5, nktk.getTongThoiGian());
//            pstmt.setString(6, nktk.getGhiChu());
//
//            return pstmt.executeUpdate() > 0;
//        }
//    }

    @Override
    public boolean insert(QuanLyMay entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(QuanLyMay entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
