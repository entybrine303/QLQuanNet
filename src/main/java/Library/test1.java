
package Library;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author 
 */
public class test1 {
    public static void main(String[] args) {
        try {
            Connection con=JdbcHelper.opConnection();
            Statement stmt=con.createStatement();
            String sql="select * from nhanvien";
            
            ResultSet rs=stmt.executeQuery(sql);
            if (rs.next()) {
                System.out.println("Họ nv: "+rs.getNString("honv"));
                System.out.println("Ten lot: "+rs.getNString("tenlot"));
                System.out.println("Ten nv: "+rs.getNString("tennv"));
                System.out.println("Ma nv: "+rs.getNString("manv"));
                
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }
    
    
}
