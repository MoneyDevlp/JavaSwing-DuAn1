/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poy.database.JdbcHelper;
import com.poly.model.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class SanPhamDao {

    Connection conn = null;
    PreparedStatement ps = null;
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

    public int add(SanPham sp) {
        try {
            String Ssql = "Insert Hang_Hoa values(?,?,?,?,?,?,?,?,?)";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Ssql);
            ps.setString(1, sp.getMaMatHang());
            ps.setString(2, sp.getMaLoaiHang());
            ps.setString(3, sp.getTenMatHang());
            ps.setString(4, String.valueOf(sp.getSoLuong()));
            ps.setDouble(5, sp.getDonGia());
            ps.setString(6, formater.format(sp.getNgayNhap()));
            ps.setString(7, formater.format(sp.getNgayHetHan()));
            ps.setString(8, sp.getMaNhaCungCap());
            ps.setString(9, sp.getTrangThai());
            if (ps.executeUpdate() > 0) {
                System.out.println("Add thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return -1;
    }

    public int update(SanPham sp) {
        try {
            String Ssql = "Update Hang_Hoa set MaLoaiHang = ?,TenMatHang = ?, SoLuong = ?,DonGia = ? ,NgayNhap = ?,NgayHetHang = ?, MaNhaCungCap = ?,TrangThai = ? where MaMatHang = ?";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Ssql);
            ps.setString(9, sp.getMaMatHang());
            ps.setString(1, sp.getMaLoaiHang());
            ps.setString(2, sp.getTenMatHang());
            ps.setString(3, String.valueOf(sp.getSoLuong()));
            ps.setDouble(4, sp.getDonGia());
            ps.setString(5, formater.format(sp.getNgayNhap()));
            ps.setString(6, formater.format(sp.getNgayHetHan()));
            ps.setString(7, sp.getMaNhaCungCap());
            ps.setString(8, sp.getTrangThai());
            if (ps.executeUpdate() > 0) {
                System.out.println("Update thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return -1;
    }

    public int delete(String maSP) {
        try {
            String Ssql = "Delete Hang_Hoa where MaMatHang = ?";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Ssql);
            ps.setString(1, maSP);
            if (ps.executeUpdate() > 0) {
                System.out.println("Delete thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return -1;
    }

    public List<SanPham> getAllSanPham() {
        List<SanPham> list = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String Query = "Select * from Hang_Hoa";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaMatHang(rs.getString(1));
                sp.setMaLoaiHang(rs.getString(2));
                sp.setTenMatHang(rs.getString(3));
                sp.setSoLuong(rs.getInt(4));
                sp.setDonGia(rs.getDouble(5));
                sp.setNgayNhap(rs.getDate(6));
                sp.setNgayHetHan(rs.getDate(7));
                sp.setMaNhaCungCap(rs.getString(8));
                sp.setTrangThai(rs.getString(9));
                list.add(sp);
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.toString());
        } finally {
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return list;
    }

    public SanPham getSPById(String masp) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String Query = "Select * from Hang_Hoa where MaMatHang = ?";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            ps.setString(1, masp);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaMatHang(rs.getString(1));
                sp.setMaLoaiHang(rs.getString(2));
                sp.setTenMatHang(rs.getString(3));
                sp.setSoLuong(rs.getInt(4));
                sp.setDonGia(rs.getDouble(5));
                sp.setNgayNhap(rs.getDate(6));
                sp.setNgayHetHan(rs.getDate(7));
                sp.setMaNhaCungCap(rs.getString(8));
                sp.setTrangThai(rs.getString(9));
                return sp;
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.toString());
        } finally {
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public List<SanPham> FindtoBySP(String tenmathang) {
        List<SanPham> li = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String Query = "Select * from Hang_Hoa where TenMatHang like '%" + tenmathang + "%'";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaMatHang(rs.getString(1));
                sp.setMaLoaiHang(rs.getString(2));
                sp.setTenMatHang(rs.getString(3));
                sp.setSoLuong(rs.getInt(4));
                sp.setDonGia(rs.getDouble(5));
                sp.setNgayNhap(rs.getDate(6));
                sp.setNgayHetHan(rs.getDate(7));
                sp.setMaNhaCungCap(rs.getString(8));
                sp.setTrangThai(rs.getString(9));
                li.add(sp);
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.toString());
        } finally {
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return li;
    }
}
