
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Process_Book {
    
    
    public static Connection getCon() {
       Connection cn = null;
       try {
           Class.forName("com.mysql.jdbc.Driver");
           cn = DriverManager.getConnection("jdbc:mysql://localhost/dbBook","root", "112233");
           
       } catch (Exception e) {
           
       }
       return cn;
       
   }
    
    
    
    public boolean deleteBook(String Genner){
       Connection cn = getCon();
       String sql = "delete from tb_Book where ID= ?";
       try {
           PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
           ps.setString(1, Genner);
           ps.executeQuery();
           cn.close();
           return true;
       } catch (SQLException e) {
           return false;
       }
   }
    
    
    
    
}
