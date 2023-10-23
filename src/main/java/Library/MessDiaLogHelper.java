/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class MessDiaLogHelper {
    public static void showMessDiaLog(Component parent, String content, String title){
        JOptionPane.showMessageDialog(parent, content, title, JOptionPane.INFORMATION_MESSAGE);
    }
    public static void showErrorDiaLog(Component parent, String content, String title){
        JOptionPane.showMessageDialog(parent,content, title,  JOptionPane.ERROR_MESSAGE);
    }
    public static int showConfirmDiaLog(Component parent, String content, String title){
        int choose=JOptionPane.showConfirmDialog(parent, content,title,  
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return choose;
    }
    public static String showInputDiaLog(Component parent, String content, String title){
        String txt=JOptionPane.showInputDialog(parent, content, title);
        return txt;
    }
    
}
