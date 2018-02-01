package java1101.swing7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoBook implements IBook {
    
    private java.sql.Connection conn =null;
    
    // 생성자
    public DaoBook(Connection conn) {
    super();
    this.conn=conn;
    }
    
    @Override
    public int getCount(ModelBook book) throws SQLException {
        
        int result = -1;
        
        //SQL 문장
        String query = "SELECT count(*) as total from books where 1 = 1";
        
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
    public int getMaxBookid() throws SQLException {
        int result =-1;
        //SQL 문장
        String query = " select max(b_no) maxid from books";
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
        String query = "SELECT * FROM books ORDER BY b_no ASC";
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
    public ResultSet selectLike(ModelBook title) throws SQLException {
    
        ResultSet rs = null;
        
        try {
            String query ="SELECT * FROM books where title like  ?";
            
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,"%"+title.getTitle()+"%");
            rs = stmt.executeQuery();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet selectEqual(ModelBook book) throws SQLException {
        
        java.sql.ResultSet rs = null;
        try {
            String query = "SELECT* FROM books where title = ?";
            
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,book.getTitle());
            rs=stmt.executeQuery();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet selectDynamic(ModelBook book) throws SQLException {
        ResultSet result =null;
        
        //문장 객체 생성
     
     try {
         String query  = " select * from books \n";
                   query += " where 1 = 1 \n";
            if(book.getB_no() != null) query +=" and b_no =?  \n";
            if(!book.getTitle().isEmpty()) query +=" and title=? \n";
            
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            
            int c =1;
            if(book.getB_no()!=null)stmt.setInt(c++,book.getB_no());
            if(!book.getTitle().isEmpty())stmt.setString(c++, book.getTitle());
            
            result = stmt.executeQuery();
     } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }
        
        //query 실행
        return result;
        
        
    }
    
    @Override
    public int insertBook(ModelBook book) throws SQLException {
        
        int rs =-1;
        try {
            String query =" INSERT INTO ";
            query +=" BOOKS( title, publisher, genre, author, sal, rent_if) ";
            query +=" VALUES(?,?,?,?,?,?)";
            
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString (1,book.getTitle() );
            stmt.setString (2,book.getPublisher() );
            stmt.setString (3,book.getGenre() );
            stmt.setString (4,book.getAuthor() );
            stmt.setInt    (5,book.getSal() );
            stmt.setString (6,book.getRent_if() );
            
            rs=stmt.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public int updateBook(ModelBook wherebook, ModelBook setbook)
            throws SQLException {
        int rs = 0;
            
            try {
               String query = " UPDATE books set      \n ";
                query       += " title        =? ,\n ";
                query       += " publisher    =? ,\n ";
                query       += " genre        =? ,\n ";
                query       += " author       =? ,\n ";
                query       += " sal          =? ,\n ";
                query       += " rent_if      =? \n ";
                query       += " WHERE B_no =?     \n ";
                
                java.sql.PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, setbook.getTitle());
                stmt.setString(2, setbook.getPublisher());
                stmt.setString(3, setbook.getGenre());
                stmt.setString(4, setbook.getAuthor());
                stmt.setInt   (5, setbook.getSal());
                stmt.setString(6, setbook.getRent_if());
                stmt.setInt(7, setbook.getB_no());
                
                
                rs = stmt.executeUpdate();
           } catch (Exception e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
               return rs;
    }
    
    @Override
    public int deletBook(ModelBook book) throws SQLException {

        int rs =-1;
        
        try {
            String query ="delete from books where title =?";
            
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, book.getTitle());
            
            rs = stmt.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return rs;
    }
    
}
