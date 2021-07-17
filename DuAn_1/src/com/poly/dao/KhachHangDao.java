/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poy.database.JdbcHelper;
import com.poly.model.KhachHang;
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
public class KhachHangDao {

    Connection conn = null;
    PreparedStatement ps = null;

    public int add(KhachHang kh) {
        try {
            String Ssql = "Insert Khach_Hang values(?,?,?)";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Ssql);
            ps.setString(1, kh.getMaKhachHang());
            ps.setString(2, kh.getTenKhachHang());
            ps.setString(3, kh.getSoDienThoai());
            if (ps.executeUpdate() > 0) {
                System.out.println("Add thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return -1;
    }

    public int update(KhachHang kh) {
        try {
            String Ssql = "Update Khach_Hang set TenKhachHang = ?,SoDienThoai = ? where MaKhachHang = ?";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Ssql);
            ps.setString(3, kh.getMaKhachHang());
            ps.setString(1, kh.getTenKhachHang());
            ps.setString(2, kh.getSoDienThoai());
            if (ps.executeUpdate() > 0) {
                System.out.println("Update thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return -1;
    }

    public int delete(String maKH) {
        try {
            String Ssql = "Delete Khach_Hang where MaKhachHang = ?";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Ssql);
            ps.setString(1, maKH);
            if (ps.executeUpdate() > 0) {
                System.out.println("Delete thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return -1;
    }

    public List<KhachHang> getAllKhachHang() {
        List<KhachHang> list = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String Query = "Select * from Khach_Hang";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKhachHang(rs.getString(1));
                kh.setTenKhachHang(rs.getString(2));
                kh.setSoDienThoai(rs.getString(3));
                list.add(kh);
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

    public KhachHang getKHById(String makh) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String Query = "Select * from Khach_Hang where MaKhachHang = ?";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            ps.setString(1, makh);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKhachHang(rs.getString(1));
                kh.setTenKhachHang(rs.getString(2));
                kh.setSoDienThoai(rs.getString(3));
                return kh;
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

    public List<KhachHang> FindtoByKH(String tenkhachhang) {
        List<KhachHang> li = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String Query = "Select * from Khach_Hang where TenKhachHang like '%" + tenkhachhang + "%'";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKhachHang(rs.getString(1));
                kh.setTenKhachHang(rs.getString(2));
                kh.setSoDienThoai(rs.getString(3));
                li.add(kh);
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
