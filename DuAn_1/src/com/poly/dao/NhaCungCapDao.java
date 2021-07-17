/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poy.database.JdbcHelper;
import com.poly.model.NhaCungCap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class NhaCungCapDao {
    Connection conn = null;
    PreparedStatement ps = null ;
    
    public int add(NhaCungCap ncc){
        try {
            String Ssql = "Insert Nha_Cung_Cap values(?,?,?,?,?)";
            conn= JdbcHelper.getDBConnect(); 
            ps = conn.prepareStatement(Ssql);
            ps.setString(1, ncc.getMaNhaCungCap());
            ps.setString(2, ncc.getTenNhaCungCap());
            ps.setString(3, ncc.getDiaChi());
            ps.setString(4, ncc.getEmail());
            ps.setString(5, ncc.getSoDienThoai());
            if(ps.executeUpdate() > 0){
                System.out.println("Add thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }
        return -1;
    }
     public int update(NhaCungCap ncc){
        try {
            String Ssql = "Update Nha_Cung_Cap set TenNhaCungCap = ?,DiaChi = ?,Email = ?,SoDienThoai = ? where MaNhaCungCap = ?";
            conn= JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Ssql);
            ps.setString(5, ncc.getMaNhaCungCap());
            ps.setString(1, ncc.getTenNhaCungCap());
            ps.setString(2, ncc.getDiaChi());
            ps.setString(3, ncc.getEmail());
            ps.setString(4, ncc.getSoDienThoai());
            if(ps.executeUpdate() > 0){
                System.out.println("Update thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }
        return -1;
    }
    public int delete(String maNCC){
        try {
            String Ssql = "Delete Nha_Cung_Cap where MaNhaCungCap = ?";
            conn= JdbcHelper.getDBConnect(); 
            ps = conn.prepareStatement(Ssql);
            ps.setString(1, maNCC);
            if(ps.executeUpdate() > 0){
                System.out.println("Delete thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }
        return -1;
    }
    public List<NhaCungCap> getAllNhaCungCap() {
     List<NhaCungCap> list = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String Query= "Select * from Nha_Cung_Cap";
            conn= JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            rs = ps.executeQuery();
            while(rs.next()){
             NhaCungCap ncc = new NhaCungCap();
             ncc.setMaNhaCungCap(rs.getString(1));
             ncc.setTenNhaCungCap(rs.getString(2));
             ncc.setDiaChi(rs.getString(3));
             ncc.setEmail(rs.getString(4));
             ncc.setSoDienThoai(rs.getString(5));
             list.add(ncc);
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.toString());
        }finally{
             try {
               rs.close(); ps.close(); conn.close(); 
            } catch (Exception e) {
            } 
        }
        return list;
    }
    public NhaCungCap getNCCById(String mancc) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String Query= "Select * from Nha_Cung_Cap where MaNhaCungCap = ?";
            conn= JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            ps.setString(1, mancc);
            rs = ps.executeQuery();
            while(rs.next()){
             NhaCungCap ncc = new NhaCungCap();
             ncc.setMaNhaCungCap(rs.getString(1));
             ncc.setTenNhaCungCap(rs.getString(2));
             ncc.setDiaChi(rs.getString(3));
             ncc.setEmail(rs.getString(4));
             ncc.setSoDienThoai(rs.getString(5));
             return ncc;
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.toString());
        }finally{
             try {
               rs.close(); ps.close(); conn.close(); 
            } catch (Exception e) {
            } 
        }
        return null;
    }
}
