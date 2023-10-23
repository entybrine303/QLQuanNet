/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class More {
    public static void jframAdd(JFrame c,String title){
        ImageIcon img=new ImageIcon("D:\\DA_JAVA_1\\DA_1\\src\\main\\java\\Icons\\logoGcafe.png");
        c.setIconImage(img.getImage());
        c.setLocationRelativeTo(null);
        c.setTitle(title);
    }
    
    public static void jdialogAdd(JDialog c,String title){
        ImageIcon img=new ImageIcon("D:\\DA_JAVA_1\\DA_1\\src\\main\\java\\Icons\\logoGcafe.png");
        c.setIconImage(img.getImage());
        c.setLocationRelativeTo(null);
        c.setTitle(title);
    }
    
}
