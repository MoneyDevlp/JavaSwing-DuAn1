/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.model;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class HoaDon {
    private String MaHoaDon;
    private String MaKhachHang;
    private String MaNV;
    private Date NgayMua;
    private double TongTien;

    public HoaDon(String MaHoaDon, String MaKhachHang, String MaNV, Date NgayMua, double TongTien) {
        this.MaHoaDon = MaHoaDon;
        this.MaKhachHang = MaKhachHang;
        this.MaNV = MaNV;
        this.NgayMua = NgayMua;
        this.TongTien = TongTien;
    }

    

    public HoaDon() {
    }

    public HoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    @Override
    public String toString() {
        return "" + "" + NgayMua;
    }
    
    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public Date getNgayMua() {
        return NgayMua;
    }

    public void setNgayMua(Date NgayMua) {
        this.NgayMua = NgayMua;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }
    
    
    
}
