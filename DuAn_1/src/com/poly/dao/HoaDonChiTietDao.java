/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poy.database.JdbcHelper;
import com.poly.model.HoaDonChiTiet;
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
public class HoaDonChiTietDao {
    Connection conn = null;
    PreparedStatement ps = null;
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
    public int add(HoaDonChiTiet hdct) {
        try {
            String Ssql = "Insert Hoa_Don_Chi_Tiet values(?,?,?)";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Ssql);
            ps.setString(1, hdct.getMaHoaDon());
            ps.setString(2, hdct.getMaMatHang());
            ps.setInt(3, hdct.getSoLuong());
            if (ps.executeUpdate() > 0) {
                System.out.println("Add thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return -1;
    }
    public int delete(String maHDCT) {
        try {
            String Ssql = "Delete Hoa_Don_Chi_Tiet where MaHoaDon = ?";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Ssql);
            ps.setString(1, maHDCT);
            if (ps.executeUpdate() > 0) {
                System.out.println("Delete thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return -1;
    }
    public List<HoaDonChiTiet> getAllHoaDonChiTiet() {
        List<HoaDonChiTiet> list = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String Query = "Select * from Hoa_Don_Chi_Tiet";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hd = new HoaDonChiTiet();
                hd.setMaHoaDon(rs.getString("MaHoaDon"));
                hd.setMaMatHang(rs.getString("MaMatHang"));
                hd.setSoLuong(rs.getInt("SoLuong"));
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
 public  List<HoaDonChiTiet> getHoaDonChiTietByID(String maHoaDon) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String Query = "Select * from Hoa_Don_Chi_Tiet where MaHoaDon = ?";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            ps.setString(1, maHoaDon);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hd = new HoaDonChiTiet();
                hd.setMaHoaDon(rs.getString("MaHoaDon"));
                hd.setMaMatHang(rs.getString("MaMatHang"));
                hd.setSoLuong(rs.getInt("SoLuong"));
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
 public List<HoaDonChiTiet> FindtoByHDCT(String maHDCT){
        List<HoaDonChiTiet> li = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String Query = "Select * from Hoa_Don_Chi_Tiet where MaHoaDon like '%" + maHDCT + "%'";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            rs = ps.executeQuery();
            while (rs.next()) {                
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setMaHoaDon(rs.getString(2));
                hdct.setMaMatHang(rs.getString(3));
                hdct.setSoLuong(rs.getInt(4));
                li.add(hdct);
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
 public HoaDonChiTiet getHDCTById(String maHDCT) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String Query = "Select * from Hoa_Don_Chi_Tiet where MaHoaDon = ?";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            ps.setString(1, maHDCT);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hd = new HoaDonChiTiet();
                hd.setMaHoaDon(rs.getString("MaHoaDon"));
                hd.setMaMatHang(rs.getString("MaMatHang"));
                hd.setSoLuong(rs.getInt("SoLuong"));
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
}
