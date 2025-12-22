/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040127.modul09;

import java.io.Serializable;

/**
 *
 * @author Lenovo
 */
public class UserConfig implements Serializable {
    private String username;
    private int fontsize;
    
    private String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public int getFontsize() {
        return fontsize;
    }
    
    public void setFontsize() {
        this.fontsize = fontsize;
    }
}
