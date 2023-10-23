/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Data.DichVu;
import Library.JdbcHelper;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author Admin
 */
public class DichVuDao extends QLQN<DichVu, String> {

    String insertSql = "insert into dichvu(madv, tendv, gia, hinh, trangthai, nguoitao, ngaytao) values(?,?,?,?,?,?,?)";

    @Override
    public boolean insert(DichVu dv) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(insertSql);) {
            pstmt.setString(1, dv.getMaDV());
            pstmt.setString(2, dv.getTenDV());
            pstmt.setFloat(3, dv.getGia());
            if (dv.getHinh() != null) {
                Blob hinh = new SerialBlob(dv.getHinh());
                pstmt.setBlob(4, hinh);

            } else {
                Blob hinh = null;
                pstmt.setBlob(4, hinh);

            }
            pstmt.setString(5, dv.getTrangThai());
            
            pstmt.setString(6, dv.getNguoiTao());
            
            pstmt.setDate(7, dv.getNgayTao());

            return pstmt.executeUpdate() > 0;
        }
    }

    String updateSql = "update dichvu set tendv=?, gia=?, hinh=?, trangthai=?, nguoitao=?, ngaytao=? where madv=?";

    @Override
    public boolean update(DichVu dv) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(updateSql);) {
            pstmt.setString(7, dv.getMaDV());
            pstmt.setString(1, dv.getTenDV());
            pstmt.setFloat(2, dv.getGia());
            if (dv.getHinh() != null) {
                Blob hinh = new SerialBlob(dv.getHinh());
                pstmt.setBlob(3, hinh);

            } else {
                Blob hinh = null;
                pstmt.setBlob(3, hinh);

            }
            pstmt.setString(4, dv.getTrangThai());
            pstmt.setString(5, dv.getNguoiTao());
            pstmt.setDate(6, dv.getNgayTao());


            return pstmt.executeUpdate() > 0;
        }
    }

    String deleteSql = "delete from dichvu where madv=?";

    @Override
    public boolean delete(String madv) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(deleteSql);) {
            pstmt.setString(1, madv);

            return pstmt.executeUpdate() > 0;
        }
    }

    String selectAllSql = "select * from dichvu";

    @Override
    public List<DichVu> selectAll() throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(selectAllSql);) {
            try ( ResultSet rs = pstmt.executeQuery();) {
                List<DichVu> list = new ArrayList<>();
                while (rs.next()) {
                    DichVu dv = createDichVu(rs);
                    list.add(dv);
                }
                return list;
            }
        }
    }

    String selectByIdSql = "select * from dichvu where madv=?";

    @Override
    public DichVu selectById(String id) throws Exception {
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(selectByIdSql);) {
            pstmt.setString(1, id);
            try ( ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    DichVu dv = createDichVu(rs);
                    return dv;
                }
            }
            return null;
        }
    }

    public DichVu createDichVu(final ResultSet rs) throws SQLException {
        DichVu dv = new DichVu();
        dv.setMaDV(rs.getString("madv"));
        dv.setTenDV(rs.getString("tendv"));
        dv.setGia(rs.getFloat("gia"));
        Blob blob = rs.getBlob("hinh");
        if (blob != null) {
            dv.setHinh(blob.getBytes(1, (int) blob.length()));
        }
        dv.setTrangThai(rs.getString("trangthai"));
        dv.setNguoiTao(rs.getString("nguoitao"));
        dv.setNgayTao(rs.getDate("ngaytao"));
        return dv;
    }
    
    public List<DichVu> searchByName(String name) throws Exception {
        String sql = "select * from dichvu where tendv like ?";
        try (
                 Connection con = JdbcHelper.opConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, "%" + name + "%");
            try ( ResultSet rs = pstmt.executeQuery();) {
                List<DichVu> list = new ArrayList<>();
                while (rs.next()) {
                    DichVu nh = createDichVu(rs);
                    list.add(nh);
                }
                return list;

            }

        }
    }

}
