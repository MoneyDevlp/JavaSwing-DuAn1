/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.utils;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author ASUS
 */
public class XImage {

    public static Image getIcon() {
        URL url = XImage.class.getResource("/Image/logonem.jpg");
        return new ImageIcon(url).getImage();
    }
}
