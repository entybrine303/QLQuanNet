/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import java.awt.Component;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Validator {

    public static void isEmpty(Component parent, String s) {
        if (s.length() == 0) {
            MessDiaLogHelper.showMessDiaLog(parent, "Không cho phép để trống", "Thông báo");

        }
    }

    public static void isEmail(Component parent, String s) {
        if (!s.matches("\\w+@\\w+(\\.\\w+)+{1,2}")) {
            MessDiaLogHelper.showMessDiaLog(parent, "Không đúng định dạnh email", "Thông báo");

        }
    }

    public static boolean isNumber(Component parent, String s) {
        try {
            int so = Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            MessDiaLogHelper.showMessDiaLog(parent, "Không đúng định dạng số", "Thông báo");
            return false;
        }
        
    }

    public static void isDate(Component parent, String s) {
        try {
            Date ngay = XDate.toDate(s, "dd-MM-yyyy");
        } catch (Exception e) {
            MessDiaLogHelper.showMessDiaLog(parent, "Không đúng định dạng ngày", "THông báo");
        }
    }

}
