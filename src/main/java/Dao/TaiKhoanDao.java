/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Data.TaiKhoan;
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
public class TaiKhoanDao extends QLQN<TaiKhoan, String> {

    String insertSql = "insert into taikhoan(tendn, tendnhau, vaitro) values(?,?,?)";

    @Override
    public boolean insert(TaiKhoan tk) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(insertSql);) {
            pstmt.setString(1, tk.getTenDN());
            pstmt.setString(2, tk.getMatKhau());
            pstmt.setBoolean(3, tk.isVaiTro());

            return pstmt.executeUpdate() > 0;
        }
    }

    String updateSql = "update taikhoan set matkhau=?,  vaitro=? where tendn=?";

    @Override
    public boolean update(TaiKhoan tk) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(updateSql);) {
            pstmt.setString(1, tk.getMatKhau());
            pstmt.setString(3, tk.getTenDN());
            pstmt.setBoolean(2, tk.isVaiTro());

            return pstmt.executeUpdate() > 0;
        }
    }

    String deleteSql = "delete from taikhoan where tendn=?";

    @Override
    public boolean delete(String tendn) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(deleteSql);) {
            pstmt.setString(1, tendn);

            return pstmt.executeUpdate() > 0;
        }
    }

    String selectAllSql = "select * from taikhoan";

    @Override
    public List<TaiKhoan> selectAll() throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(selectAllSql);) {
            try ( ResultSet rs = pstmt.executeQuery();) {
                List<TaiKhoan> list = new ArrayList<>();
                while (rs.next()) {
                    TaiKhoan tk = createTaiKhoan(rs);
                    list.add(tk);
                }
                return list;
            }
        }
    }

    String selectByIdSql = "select * from taikhoan where tendn=?";

    @Override
    public TaiKhoan selectById(String id) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(selectByIdSql);) {
            pstmt.setString(1, id);
            try ( ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    TaiKhoan tk = createTaiKhoan(rs);
                    return tk;
                }
            }
            return null;
        }
    }

    public TaiKhoan createTaiKhoan(final ResultSet rs) throws SQLException {
        TaiKhoan tk = new TaiKhoan();
        tk.setTenDN(rs.getString("tendn"));       
        tk.setMatKhau(rs.getString("Matkhau"));
        tk.setVaiTro(rs.getBoolean("vaitro"));

        return tk;
    }
}
