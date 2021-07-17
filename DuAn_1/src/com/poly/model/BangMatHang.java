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
public class BangMatHang {
    private SanPham MatHang;
    private int SoLuong;

    public BangMatHang() {
    }

    public BangMatHang(SanPham MatHang, int SoLuong) {
        this.MatHang = MatHang;
        this.SoLuong = SoLuong;
    }

    public SanPham getMatHang() {
        return MatHang;
    }

    public void setMatHang(SanPham MatHang) {
        this.MatHang = MatHang;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    
    
    
}
