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
public class SanPham {
    private String MaMatHang;
    private String MaLoaiHang;
    private String TenMatHang;
    private int SoLuong;
    private double DonGia;
    private Date NgayNhap;
    private Date NgayHetHan;
    private String MaNhaCungCap;
    private String TrangThai;

    public SanPham(String MaMatHang, String MaLoaiHang, String TenMatHang, int SoLuong, double DonGia, Date NgayNhap, Date NgayHetHan, String MaNhaCungCap, String TrangThai) {
        this.MaMatHang = MaMatHang;
        this.MaLoaiHang = MaLoaiHang;
        this.TenMatHang = TenMatHang;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.NgayNhap = NgayNhap;
        this.NgayHetHan = NgayHetHan;
        this.MaNhaCungCap = MaNhaCungCap;
        this.TrangThai = TrangThai;
    }

    

    public SanPham() {
    }

    public SanPham(String MaMatHang) {
        this.MaMatHang = MaMatHang;
    }

    @Override
    public String toString() {
        return this.TenMatHang;
    }

    public String getMaMatHang() {
        return MaMatHang;
    }

    public void setMaMatHang(String MaMatHang) {
        this.MaMatHang = MaMatHang;
    }

    public String getMaLoaiHang() {
        return MaLoaiHang;
    }

    public void setMaLoaiHang(String MaLoaiHang) {
        this.MaLoaiHang = MaLoaiHang;
    }

    public String getTenMatHang() {
        return TenMatHang;
    }

    public void setTenMatHang(String TenMatHang) {
        this.TenMatHang = TenMatHang;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public Date getNgayHetHan() {
        return NgayHetHan;
    }

    public void setNgayHetHan(Date NgayHetHan) {
        this.NgayHetHan = NgayHetHan;
    }

    public String getMaNhaCungCap() {
        return MaNhaCungCap;
    }

    public void setMaNhaCungCap(String MaNhaCungCap) {
        this.MaNhaCungCap = MaNhaCungCap;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
}
