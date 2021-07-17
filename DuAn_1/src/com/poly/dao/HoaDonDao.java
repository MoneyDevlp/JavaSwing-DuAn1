/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poy.database.JdbcHelper;
import com.poly.model.HoaDon;
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
public class HoaDonDao {
    Connection conn = null;
    PreparedStatement ps = null;
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
    public int add(HoaDon hd) {
        try {
            String Ssql = "Insert Hoa_Don values(?,?,?,?)";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Ssql);
            ps.setString(1, hd.getMaHoaDon());
            ps.setString(2, hd.getMaKhachHang());
            ps.setString(3, hd.getMaNV());
            ps.setString(4, formater.format(hd.getNgayMua()));
            if (ps.executeUpdate() > 0) {
                System.out.println("Add thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return -1;
    }

    public int update(HoaDon hd) {
        try {
            String Ssql = "Update Hoa_Don set MaKhachHang = ?,MaNhanVien = ?, NgayMua = ? where MaHoaDon = ?";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Ssql);
            ps.setString(4, hd.getMaHoaDon());
            ps.setString(1, hd.getMaKhachHang());
            ps.setString(2, hd.getMaNV());
            ps.setString(3, formater.format(hd.getNgayMua()));
            if (ps.executeUpdate() > 0) {
                System.out.println("Update thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return -1;
    }

    public int delete(String maHD) {
        try {
            String Ssql = "Delete Hoa_Don where MaHoaDon = ?";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Ssql);
            ps.setString(1, maHD);
            if (ps.executeUpdate() > 0) {
                System.out.println("Delete thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return -1;
    }

    public List<HoaDon> getAllHoaDon() {
        List<HoaDon> list = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String Query = "Select * from Hoa_Don";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getString(1));
                hd.setMaKhachHang(rs.getString(2));
                hd.setMaNV(rs.getString(3));
                hd.setNgayMua(rs.getDate(4));
                list.add(hd);
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
    public HoaDon getHDById(String maHD) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String Query = "Select * from Hoa_Don where MaHoaDon = ?";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            ps.setString(1, maHD);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getString(1));
                hd.setMaKhachHang(rs.getString(2));
                hd.setMaNV(rs.getString(3));
                hd.setNgayMua(rs.getDate(4));
                return hd;
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
    public List<HoaDon> FindtoByHD(String maHD){
        List<HoaDon> li = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String Query = "Select * from Hoa_Don where MaHoaDon like '%" + maHD + "%'";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            rs = ps.executeQuery();
            while (rs.next()) {                
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getString(1));
                hd.setMaKhachHang(rs.getString(2));
                hd.setMaNV(rs.getString(3));
                hd.setNgayMua(rs.getDate(4));
                li.add(hd);
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
    public List<HoaDon> FindtoByNgayMua(String ngayMua){
        List<HoaDon> li = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String Query = "Select * from Hoa_Don where NgayMuaHang like '%" + ngayMua + "%'";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            rs = ps.executeQuery();
            while (rs.next()) {                
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getString(1));
                hd.setMaNV(rs.getString(3));
                hd.setNgayMua(rs.getDate(4));
                li.add(hd);
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
