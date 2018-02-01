package java1101.swing7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static java.sql.Connection connectionMySQL() {
        String url = "jdbc:mysql://localhost:3306/testbook?useUnicode=true&characterEncoding=utf8"; 
                 
                   // ?useUnicode=true&characterEncoding=utf8 을 추가함으로써 한글로 인코딩\n"  
                 
              
        String user = "root";
        String password ="1234";
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = java.sql.DriverManager.getConnection(url,user,password);
            
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }catch(java.sql.SQLException e) {
            e.printStackTrace();
        }
        return conn;
        
    }
    public static java.sql.Connection makeConnection() {
        return connectionMySQL();
    }
}
