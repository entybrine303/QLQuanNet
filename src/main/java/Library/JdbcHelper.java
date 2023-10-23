/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class JdbcHelper {

    public static Connection opConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost;database=qlda;";
        String username, pass;
        username = "thanh";
        pass = "thanhducam";
        Connection con = DriverManager.getConnection(connectionUrl, username, pass);
        return con;
    }
    
}
