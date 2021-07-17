/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poy.database.JdbcHelper;
import com.poly.model.ChamCong;
import com.poly.model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class NhanVienDao {
    Connection conn = null;
    PreparedStatement ps = null ;
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
    public static NhanVien getUserbyId(String manv) {
        Connection conn = null;
        PreparedStatement ps = null ;
        ResultSet rs = null;
        NhanVien nv = new NhanVien();
        try {
            String Query= "Select * from Nhan_Vien where MaNhanVien = ?";
            conn= JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            ps.setString(1, manv);
            rs = ps.executeQuery();
            while (rs.next()) {                
                nv.setMaNV(rs.getString(1));
                nv.setMatKhau(rs.getString(3));
                nv.setVaiTro(rs.getInt(4));
                return nv;
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
    public static boolean checkLogin(String manv , String password){
      NhanVien nv = getUserbyId(manv);
      if(nv != null){
          if(nv.getMatKhau().equals(password)){
              return true;
          }
      }
      return false;
    }
    public int add(NhanVien nv){
        try {
            String Ssql = "Insert Nhan_Vien values(?,?,?,?,?,?,?,?,?)";
            conn= JdbcHelper.getDBConnect(); 
            ps = conn.prepareStatement(Ssql);
            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getTenNV());
            ps.setString(3, nv.getMatKhau());
            ps.setInt(4, nv.getVaiTro());
            ps.setBoolean(5, nv.isGioiTinh());
            ps.setString(6, formater.format(nv.getNgaySinh()));
            ps.setString(7, nv.getDienThoai());
            ps.setString(8, nv.getEmail());
            ps.setString(9, nv.getHinh());
            if(ps.executeUpdate() > 0){
                System.out.println("Add thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }
        return -1;
    }
    public int update(NhanVien nv){
        try {
            String Ssql = "Update Nhan_Vien set TenNhanVien = ?,MatKhau = ?,VaiTro = ?, GioiTinh = ?, NgaySinh = ?, SoDienThoai = ?, Email = ?, Hinh = ? where MaNhanVien = ?";
            conn= JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Ssql);
            ps.setString(9, nv.getMaNV());
            ps.setString(1, nv.getTenNV());
            ps.setString(2, nv.getMatKhau());
            ps.setInt(3, nv.getVaiTro());
            ps.setBoolean(4, nv.isGioiTinh());
            ps.setString(5, formater.format(nv.getNgaySinh()));
            ps.setString(6, nv.getDienThoai());
            ps.setString(7, nv.getEmail());
            ps.setString(8, nv.getHinh());
            if(ps.executeUpdate() > 0){
                System.out.println("Update thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }
        return -1;
    }
    public int delete(String maNV){
        try {
            String Ssql = "Delete Nhan_Vien where MaNhanVien = ?";
            conn= JdbcHelper.getDBConnect(); 
            ps = conn.prepareStatement(Ssql);
            ps.setString(1, maNV);
            if(ps.executeUpdate() > 0){
                System.out.println("Delete thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }
        return -1;
    }
    public List<NhanVien> getAllNhanVien() {
     List<NhanVien> list = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String Query= "Select * from Nhan_Vien";
            conn= JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            rs = ps.executeQuery();
            while(rs.next()){
             NhanVien nv = new NhanVien();
             nv.setMaNV(rs.getString(1));
             nv.setTenNV(rs.getString(2));
             nv.setMatKhau(rs.getString(3));
             nv.setVaiTro(rs.getInt(4));
             nv.setGioiTinh(rs.getBoolean(5));
             nv.setNgaySinh(rs.getDate(6));
             nv.setDienThoai(rs.getString(7));
             nv.setEmail(rs.getString(8));
             nv.setHinh(rs.getString(9));
             list.add(nv);
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
    public NhanVien getNVById(String manv) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String Query= "Select * from Nhan_Vien where MaNhanVien = ?";
            conn= JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            ps.setString(1, manv);
            rs = ps.executeQuery();
            while(rs.next()){
             NhanVien nv = new NhanVien();
             nv.setMaNV(rs.getString(1));
             nv.setTenNV(rs.getString(2));
             nv.setMatKhau(rs.getString(3));
             nv.setVaiTro(rs.getInt(4));
             nv.setGioiTinh(rs.getBoolean(5));
             nv.setNgaySinh(rs.getDate(6));
             nv.setDienThoai(rs.getString(7));
             nv.setEmail(rs.getString(8));
             nv.setHinh(rs.getString(9));
             return nv;
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
    public List<NhanVien> FindtoByNV(String username){
        List<NhanVien> li = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String Query = "Select * from Nhan_Vien where TenNhanVien like '%" + username + "%'";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            rs = ps.executeQuery();
            while (rs.next()) {                
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString(1));
                nv.setTenNV(rs.getString(2));
                nv.setMatKhau(rs.getString(3));
                nv.setVaiTro(rs.getInt(4));
                nv.setGioiTinh(rs.getBoolean(5));
                nv.setNgaySinh(rs.getDate(6));
                nv.setDienThoai(rs.getString(7));
                nv.setEmail(rs.getString(8));
                nv.setHinh(rs.getString(9));
                li.add(nv);
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
    public int addCongNV(ChamCong cc){
        try {
            String Ssql = "Insert Cham_Cong values(?,?,?)";
            conn= JdbcHelper.getDBConnect(); 
            ps = conn.prepareStatement(Ssql);
            ps.setString(1, cc.getMaNV());
            ps.setString(2, formater.format(cc.getNgayLamViec()));
            ps.setBoolean(3, cc.isTrangThai());
            if(ps.executeUpdate() > 0){
                System.out.println("Add thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }
        return -1;
    }
    public List<ChamCong> getAllChamCongNV() {
     List<ChamCong> list = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String Query= "Select * from Cham_Cong";
            conn= JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            rs = ps.executeQuery();
            while(rs.next()){
             ChamCong cc = new ChamCong();
             cc.setMaNV(rs.getString("MaNhanVien"));
             cc.setNgayLamViec(rs.getDate("NgayLamViec"));
             cc.setTrangThai(rs.getBoolean("TrangThai"));
             list.add(cc);
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
    public List<ChamCong> FindtoByCongNV(String ngay){
        List<ChamCong> li = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String Query = "Select * from Cham_Cong where NgayLamViec like '%" + ngay + "%'";
            conn = JdbcHelper.getDBConnect();
            ps = conn.prepareStatement(Query);
            rs = ps.executeQuery();
            while (rs.next()) {                
                ChamCong cc = new ChamCong();
                cc.setMaNV(rs.getString("MaNhanVien"));
                cc.setNgayLamViec(rs.getDate("NgayLamViec"));
                cc.setTrangThai(rs.getBoolean("TrangThai"));
                li.add(cc);
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
