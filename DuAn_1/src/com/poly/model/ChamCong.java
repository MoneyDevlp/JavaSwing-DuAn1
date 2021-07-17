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
public class ChamCong {
    private String MaNV;
    private String TenNV;
    private boolean VaiTro;
    private Date NgayLamViec;
    private boolean TrangThai;

    public ChamCong(String MaNV, String TenNV, boolean VaiTro, Date NgayLamViec, boolean TrangThai) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.VaiTro = VaiTro;
        this.NgayLamViec = NgayLamViec;
        this.TrangThai = TrangThai;
    }

    
    public ChamCong() {
    }


    public ChamCong(String MaNV) {
        this.MaNV = MaNV;
    }

    @Override
    public String toString() {
        return "" + "" + NgayLamViec;
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

    public boolean isVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(boolean VaiTro) {
        this.VaiTro = VaiTro;
    }
    
    public Date getNgayLamViec() {
        return NgayLamViec;
    }

    public void setNgayLamViec(Date NgayLamViec) {
        this.NgayLamViec = NgayLamViec;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    
    
    
}
