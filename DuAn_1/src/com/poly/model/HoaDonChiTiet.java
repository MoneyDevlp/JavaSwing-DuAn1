/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.model;



/**
 *
 * @author ASUS
 */
public class HoaDonChiTiet {
    private String MaHoaDon;
    private String MaMatHang;
    private int SoLuong;
    private double TongTien;

    public HoaDonChiTiet(String MaHoaDon, String MaMatHang, int SoLuong, double TongTien) {
        this.MaHoaDon = MaHoaDon;
        this.MaMatHang = MaMatHang;
        this.SoLuong = SoLuong;
        this.TongTien = TongTien;
    }

    public HoaDonChiTiet(String MaHoaDon, String MaMatHang) {
        this.MaHoaDon = MaHoaDon;
        this.MaMatHang = MaMatHang;
    }

    public HoaDonChiTiet() {
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getMaMatHang() {
        return MaMatHang;
    }

    public void setMaMatHang(String MaMatHang) {
        this.MaMatHang = MaMatHang;
    }

    

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

   
    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }
    
    
}
