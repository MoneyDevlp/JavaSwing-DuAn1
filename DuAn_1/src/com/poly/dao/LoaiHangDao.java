/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poy.database.JdbcHelper;
import com.poly.model.LoaiHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class LoaiHangDao {
    Connection conn = null;
    PreparedStatement ps = null ;
    public int add(LoaiHang lh){
        try {
            String Ssql = "Insert Loai_Hang values(?,?)";
            conn= JdbcHelper.getDBConnect(); 
            ps = conn.prepareStatement(Ssql);
            ps.setString(1, lh.getMaLoaiHang());
            ps.setString(2, lh.getTenLoaiHang());
            if(ps.executeUpdate() > 0){
                System.out.println("Add thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }
        return -1;
    }
    public int update(LoaiHang lh) {
        try {
            String Ssql = "Update Loai_Hang set TenLoaiHang = ? where MaLoaiHang = ?";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Ssql);
            ps.setString(2, lh.getMaLoaiHang());
            ps.setString(1, lh.getTenLoaiHang());
            if (ps.executeUpdate() > 0) {
                System.out.println("Update thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return -1;
    }
    public int delete(String maLH) {
        try {
            String Ssql = "Delete Loai_Hang where MaLoaiHang = ?";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Ssql);
            ps.setString(1, maLH);
            if (ps.executeUpdate() > 0) {
                System.out.println("Delete thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return -1;
    }
    public List<LoaiHang> getAllLoaiHang() {
        List<LoaiHang> list = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String Query = "Select * from Loai_Hang";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            rs = ps.executeQuery();
            while (rs.next()) {
                LoaiHang lh = new LoaiHang();
                lh.setMaLoaiHang(rs.getString(1));
                lh.setTenLoaiHang(rs.getString(2));
                list.add(lh);
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
    public LoaiHang getLHById(String malh) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String Query = "Select * from Loai_Hang where MaLoaiHang = ?";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            ps.setString(1, malh);
            rs = ps.executeQuery();
            while (rs.next()) {
                LoaiHang lh = new LoaiHang();
                lh.setMaLoaiHang(rs.getString(1));
                lh.setTenLoaiHang(rs.getString(2));
                return lh;
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
