/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Data.NhatKiTaiKhoan;
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
public class NhatKiTaiKhoanDao extends QLQN<NhatKiTaiKhoan, String> implements Runnable{

    Date gioBatDau, gioKetThuc;

    String insertSql = "insert into nhatkitaikhoan(tendn, ngay, giobatdau, gioketthuc, tongthoigian, ghichu) values(?,getdate(),?,?,?,?)";

    public boolean insert(String tenDn) throws Exception {
        gioBatDau = Calendar.getInstance().getTime();
//        gioBatDau = new Date();
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(insertSql);) {
            pstmt.setString(1, tenDn);
            pstmt.setString(2, XDate.toString(gioBatDau, "hh:mm:ss aa"));
            pstmt.setString(3, null);
            pstmt.setString(4, null);
            pstmt.setString(5, null);

            return pstmt.executeUpdate() > 0;
        }
    }

    String updateSql = "update nhatkitaikhoan set gioketthuc=?, tongthoigian=?, ghichu=? where tendn=?";

    public boolean update(String tenDn) throws Exception {
        gioKetThuc = Calendar.getInstance().getTime();
//        gioKetThuc = new Date();
//        double tien=tongThoiGian()/0,012;

        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(updateSql);) {
            pstmt.setString(1, XDate.toString(gioKetThuc, "hh:mm:ss aa"));
            pstmt.setString(2, "");
            pstmt.setString(3, "TongThoiGian");
            pstmt.setString(4, tenDn);

            return pstmt.executeUpdate() > 0;
        }
    }

    String deleteSql = "delete from nhatkitaikhoan";

    public boolean delete() throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(deleteSql);) {

            return pstmt.executeUpdate() > 0;
        }
    }

    String selectAllSql = "select * from nhatkitaikhoan";

    @Override
    public List<NhatKiTaiKhoan> selectAll() throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(selectAllSql);) {
            try ( ResultSet rs = pstmt.executeQuery();) {
                List<NhatKiTaiKhoan> list = new ArrayList<>();
                while (rs.next()) {
                    NhatKiTaiKhoan nktk = createNhatKiTaiKhoan(rs);
                    list.add(nktk);
                }
                return list;
            }
        }
    }

    String selectByIdSql = "select * from nhatkitaikhoan where tendn=?";

    @Override
    public NhatKiTaiKhoan selectById(String id) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(selectByIdSql);) {
            pstmt.setString(1, id);
            try ( ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    NhatKiTaiKhoan nktk = createNhatKiTaiKhoan(rs);
                    return nktk;
                }
            }
            return null;
        }
    }

    public NhatKiTaiKhoan createNhatKiTaiKhoan(final ResultSet rs) throws SQLException {
        NhatKiTaiKhoan nktk = new NhatKiTaiKhoan();
        nktk.setTenDN(rs.getString("tendn"));
        nktk.setNgay(rs.getDate("ngay"));
        nktk.setGioBatDau(rs.getString("giobatdau"));
        nktk.setGioKetThuc(rs.getString("gioketthuc"));
        nktk.setTongThoiGian(rs.getString("tongthoigian"));
        nktk.setGhiChu(rs.getString("ghichu"));

        return nktk;
    }
    
    @Override
    public void run(){
        
    }

    @Override
    public boolean insert(NhatKiTaiKhoan entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(NhatKiTaiKhoan entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
