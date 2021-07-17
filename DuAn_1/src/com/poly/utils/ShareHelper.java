/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.utils;

import com.poly.model.NhanVien;

/**
 *
 * @author ASUS
 */
public class ShareHelper {
    public static NhanVien USER = null;
    
    public static void loffout(){
        ShareHelper.USER = null;
    }
    
    public static boolean authenticated(){
        return ShareHelper.USER != null;
    }
    public static int Manager(){
        return USER.getVaiTro();
    }
}
