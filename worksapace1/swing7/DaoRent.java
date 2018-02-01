package java1101.swing7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoRent implements IRent {
    
    private java.sql.Connection conn =null;
    
    
    public DaoRent(Connection conn) {
        super();
        this.conn = conn;
    }

    @Override
    public int getCount(ModelRent rent) throws SQLException {
 
        int result = -1;
        
        //SQL 문장
        String query = "SELECT count(*) as total from rents where 1 = 1";
        
        try {
            // 문장 객체 생성
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            
            //SQL 문장 실행
            java.sql.ResultSet rs = stmt.executeQuery();
            
            rs.next();// 데이터를 가져오면서 커서가 내려간다? 한칸씩?/
            result = rs.getInt("total");
        } catch(java.sql.SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public int getMaxRentid() throws SQLException {
       
        int result =-1;
        //SQL 문장
        String query = " select max(rent_no) maxid from rents";
        //문장객체생성
        java.sql.PreparedStatement stmt = conn.prepareStatement(query);
        //SQL 문장 실행
        java.sql.ResultSet rs = stmt.executeQuery();
        
        rs.next();
        result = rs.getInt("maxid");
        return result;
    }
    
    @Override
    public ResultSet selectAll() throws SQLException {
       
        java.sql.ResultSet rs = null;
        //sql 문장 실행
        String query = "SELECT * FROM rents ORDER BY rent_no ASC";
        try {
            java.sql.PreparedStatement stmt = conn.prepareStatement(query) ;
            rs = stmt.executeQuery();
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet selectLike(ModelRent rent) throws SQLException {

        ResultSet rs = null;
        
        try {
            String query ="SELECT * FROM rents where rent_no like  ?";
            
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,"%"+rent.getRent_no()+"%");
            rs = stmt.executeQuery();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet selectEqual(ModelRent rent) throws SQLException {
        
        java.sql.ResultSet rs = null;
        try {
            String query = "SELECT* FROM rent where rent_no = ?";
            
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,rent.getRent_no());
            rs=stmt.executeQuery();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet selectDynamic(ModelRent rent) throws SQLException {
        

        ResultSet result =null;
        
        //문장 객체 생성
     
     try {
         String query  = " select * from rnets \n";
                   query += " where 1 = 1 \n";
            if(rent.getB_no() != null) query +=" and rent_no =?  \n";
            if(!rent.getTitle().isEmpty()) query +=" and title=? \n";
            
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            
            int c =1;
            if(rent.getB_no()!=null)stmt.setInt(c++,rent.getB_no());
            if(!rent.getTitle().isEmpty())stmt.setString(c++, rent.getTitle());
            
            result = stmt.executeQuery();
     } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }
        
        //query 실행
        return result;
        
    }
    
    @Override
    public int insertRent(ModelRent rent) throws SQLException {
        
        int rs =-1;
        try {
            String query =" INSERT INTO ";
            query +=" RENTS( name, phone, pid, email, title, publisher,genre,author,b_no,rent_date) ";
            query +=" VALUES(?,?,?,?,?,?,?,?,?,?)";
            
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString (1,rent.getName () );
            stmt.setString (2,rent.getPhone() );
            stmt.setString (3,rent.getPid  () );
            stmt.setString (4,rent.getEmail() );
            stmt.setString (5,rent.getTitle() );
            stmt.setString (6,rent.getPublisher () );
            stmt.setString (7,rent.getGenre     () );
            stmt.setString (8,rent.getAuthor    () );
            stmt.setInt    (9,rent.getB_no      () );
            stmt.setString (10,rent.getRent_date() );
            
            rs=stmt.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public int updateRent(ModelRent whererent, ModelRent setrent)
            throws SQLException {
        int rs = 0;
        
        try {
     String query = " UPDATE books set  \n ";
            query       += " name         =? ,\n ";
            query       += " phone        =? ,\n ";
            query       += " pid          =? ,\n ";
            query       += " email        =? ,\n ";
            query       += " title        =? ,\n ";
            query       += " publisher    =? ,\n ";
            query       += " genre        =? ,\n ";
            query       += " author       =? ,\n ";
            query       += " b_no         =? ,\n ";
            query       += " rent_date    =? ,\n ";
            query       += " WHERE B_no   =?  \n ";
            
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, setrent.getName   ());
            stmt.setString(2, setrent.getPhone  ());
            stmt.setString(3, setrent.getPid    ());
            stmt.setString(4, setrent.getEmail  ());
            stmt.setString(5, setrent.getTitle  ());
            stmt.setString(6, setrent.getPublisher ());
            stmt.setString(7, setrent.getGenre     ());
            stmt.setString(8, setrent.getAuthor    ());
            stmt.setInt   (9, setrent.getB_no      ());
            stmt.setString(10, setrent.getRent_date());
            
            stmt.setInt(7, setrent.getRent_no());
            
            
            rs = stmt.executeUpdate();
       } catch (Exception e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
           return rs;
    }
    
    @Override
    public int deletRent(ModelRent rent) throws SQLException {

        int rs =-1;
        
        try {
            String query ="delete from rents where rent_no =?";
            
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, rent.getRent_no());
            
            rs = stmt.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return rs;
    }
    
}
