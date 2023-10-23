/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Data.NhatKiHeThong;
import Library.DemThoiGian;
import Library.JdbcHelper;
import Library.XDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhatKiHeThongDao {

    String insertSql = "insert into nhatkihethong(tenmay, nguoisudung, ngay, thoigian, tinhtrang, dasudung, ghichu) "
            + "values(?,?, getdate(),?,?,?,?)";

    public boolean insert(String tenMay, String tenDn, String trangThai) throws Exception {
        Date today = Calendar.getInstance().getTime();
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(insertSql);) {

            pstmt.setString(1, tenMay);
            pstmt.setString(2, tenDn);
            pstmt.setString(3, XDate.toString(today, "hh:mm:ss aa"));
            pstmt.setString(4, trangThai);
            pstmt.setString(5, "");
            pstmt.setString(6, "");

            return pstmt.executeUpdate() > 0;
        }
    }

    String updateSql = "update nhatkihethong set tenmay=?, nguoisudung=?, ngay=?, thoigian=?, tinhtrang=?, dasudung=?, ghichu=? where tenmay=?";

    public boolean update(NhatKiHeThong Nkht) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(updateSql);) {
            pstmt.setString(7, Nkht.getTenMay());
            pstmt.setString(1, Nkht.getTenNguoiSuDung());
            pstmt.setDate(2, Nkht.getNgay());
            pstmt.setString(3, Nkht.getThoiGian());
            pstmt.setString(4, Nkht.getTrangThai());
            pstmt.setString(5, Nkht.getDaSuDung());
            pstmt.setString(6, Nkht.getGhiChu());
            

            return pstmt.executeUpdate() > 0;
        }
    }

    String deleteSql = "delete from nhatkihethong";

    public boolean delete() throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(deleteSql);) {
            return pstmt.executeUpdate() > 0;
        }
    }

    String selectAllSql = "select * from nhatkihethong";

    public List<NhatKiHeThong> selectAll() throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(selectAllSql);) {
            try ( ResultSet rs = pstmt.executeQuery();) {
                List<NhatKiHeThong> list = new ArrayList<>();
                while (rs.next()) {
                    NhatKiHeThong Nkht = createNkht(rs);
                    list.add(Nkht);
                }
                return list;
            }
        }
    }

    String selectByIdSql = "select * from nhatkihethong where tenmay=?";

    public NhatKiHeThong selectById(String id) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(selectByIdSql);) {
            pstmt.setString(1, id);
            try ( ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    NhatKiHeThong Nkht = createNkht(rs);
                    return Nkht;
                }
            }
            return null;
        }
    }

    public NhatKiHeThong createNkht(final ResultSet rs) throws SQLException {
        NhatKiHeThong Nkht = new NhatKiHeThong();
        Nkht.setTenMay(rs.getString("tenmay"));
        Nkht.setTenNguoiSuDung(rs.getString("nguoisudung"));
        Nkht.setNgay(rs.getDate("ngay"));
        Nkht.setThoiGian(rs.getString("thoigian"));
        Nkht.setTrangThai(rs.getString("tinhtrang"));
        Nkht.setDaSuDung(rs.getString("dasudung"));
        Nkht.setGhiChu(rs.getString("ghichu"));

        return Nkht;
    }


    public List<NhatKiHeThong> searchByName(String name) throws Exception {
        String sql = "select * from nhatkihethong where nguoisudung like ?";
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, "%" + name + "%");
            try ( ResultSet rs = pstmt.executeQuery();) {
                List<NhatKiHeThong> list = new ArrayList<>();
                while (rs.next()) {
                    NhatKiHeThong nh = createNkht(rs);
                    list.add(nh);
                }
                return list;

            }

        }
    }

    public List<NhatKiHeThong> searchByDay(String ngayBd, String ngayKt) throws Exception {
        String sql = "select * from nhatkihethong where ngay >= ? and ngay <= ?";
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, ngayBd);
            pstmt.setString(2, ngayKt);

            try ( ResultSet rs = pstmt.executeQuery();) {
                List<NhatKiHeThong> list = new ArrayList<>();
                while (rs.next()) {
                    NhatKiHeThong nh = createNkht(rs);
                    list.add(nh);
                }
                return list;

            }

        }
    }
}
