/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poy.database.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ThongKeDao {
    public List<Object[]> getHoaDon(Date NgayMua) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call SelectAllHoaDon (?)}";
                rs = JdbcHelper.executeQuery(sql,NgayMua);
                 while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaHD"),
                        rs.getString("MaNV"),
                        rs.getInt("SoLuongMatHang"),
                        rs.getDouble("TongTien")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    public List<Object[]> getTop5MatHangBanNhieuNhat() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_SelectTop5Ban}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaMH"),
                        rs.getString("TenMH"),
                        rs.getInt("SoLuong"),
                        rs.getDouble("DonGia")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    public List<Object[]> getTop5MatHangNhapNhieuNhat() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_SelectTop5Nhap}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaMH"),
                        rs.getString("TenMH"),
                        rs.getInt("SoLuong"),
                        rs.getDouble("DonGia")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    public List<Object[]> getNgayDiLamNV() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_SelectNgayDiLamNV}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaNV"),
                        rs.getString("TenNV"),
                        rs.getInt("VaiTro"),
                        rs.getInt("SoNgayLamViec")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    public List<Date> getDateHD() {
        List<Date> lsx = new ArrayList<>();
        String s_SQL = "select Distinct(NgayMuaHang) From [dbo].[Hoa_Don]";
        ResultSet rs = JdbcHelper.executeQuery(s_SQL);
        try {
            while(rs.next()){
                Date date = rs.getDate(1);
                lsx.add(date);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lsx;
    }
    
}
