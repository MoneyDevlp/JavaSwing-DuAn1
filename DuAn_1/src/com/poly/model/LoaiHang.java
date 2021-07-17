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
public class LoaiHang {
    private String MaLoaiHang;
    private String TenLoaiHang;

    public LoaiHang() {
    }

    public LoaiHang(String MaLoaiHang, String TenLoaiHang) {
        this.MaLoaiHang = MaLoaiHang;
        this.TenLoaiHang = TenLoaiHang;
    }

    public String getMaLoaiHang() {
        return MaLoaiHang;
    }

    public void setMaLoaiHang(String MaLoaiHang) {
        this.MaLoaiHang = MaLoaiHang;
    }

    public String getTenLoaiHang() {
        return TenLoaiHang;
    }

    public void setTenLoaiHang(String TenLoaiHang) {
        this.TenLoaiHang = TenLoaiHang;
    }
    
    
}
