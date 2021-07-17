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
public class KhachHang {
    private String MaKhachHang;
    private String TenKhachHang;
    private String SoDienThoai;

    public KhachHang(String MaKhachHang, String TenKhachHang, String SoDienThoai) {
        this.MaKhachHang = MaKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.SoDienThoai = SoDienThoai;
    }

    public KhachHang() {
    }

    @Override
    public String toString() {
        return this.MaKhachHang;
    }
    
    
    public KhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SóDienThoai) {
        this.SoDienThoai = SóDienThoai;
    }
    
    
}
