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
public class NhanVien {
    private String MaNV;
    private String TenNV;
    private String MatKhau;
    private int VaiTro;
    private boolean GioiTinh;
    private Date NgaySinh;
    private String DienThoai;
    private String Email;
    private String Hinh;

    @Override
    public String toString() {
        return "" + VaiTro +'}';
    }

    public NhanVien(String MaNV, String TenNV, String MatKhau, int VaiTro, boolean GioiTinh, Date NgaySinh, String DienThoai, String Email, String Hinh) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.MatKhau = MatKhau;
        this.VaiTro = VaiTro;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.DienThoai = DienThoai;
        this.Email = Email;
        this.Hinh = Hinh;
    }

    

//    public NhanVien(String MaNV) {
//        this.MaNV = MaNV;
//    }

    public NhanVien() {
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public int getVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(int VaiTro) {
        this.VaiTro = VaiTro;
    }

    
    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }
    
    
}
