/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Admin
 */
public class XDate {

    static SimpleDateFormat formater = new SimpleDateFormat();

    public static Date toDate(String date, String pattern) {
        try {
            formater.applyPattern(pattern);
            return formater.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static String toString(Date date, String pattern) {
        formater.applyPattern(pattern);
        return formater.format(date);
    }

    public static Date addDays(Date date, long days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }

    public static String secondToHour(long s) {
        //khai báo 3 biến hour, minute, second đại diện cho giờ phút giây
        long hour, minute, second;
        //1h = 3600s -> hour = n / 3600
        hour = s / 3600;
        //1p = 60s, vì ở trên ta đã chia 3600 để lấy giờ
        //vậy nên ta cần lấy phần dư của nó chia cho 60
        minute = s % 3660 / 60;
        //phần dư còn lại chính là số giây
        second = s % 3600 % 60;
        
        return hour+"/"+minute+"/"+second;
    }
}
