package java1101.swing7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoIDPW implements IIDPW {
    private java.sql.Connection conn =null;
    
    // 생성자
    public DaoIDPW(Connection conn) {
    super();
    this.conn=conn;
    }
    
    @Override
    public int getCount(ModelIDPW idpw) throws SQLException {

        int result = -1;
        
        //SQL 문장
        String query = "SELECT count(*) as total from IDPW where 1 = 1";
        
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
    public int getMaxpwid() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public ResultSet selectAll() throws SQLException {
        
        java.sql.ResultSet rs = null;
        //sql 문장 실행
        String query = "SELECT * FROM IDPW ORDER BY ID ASC";
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
    public ResultSet selectLike(ModelIDPW idpw) throws SQLException {

        ResultSet rs = null;
        
        try {
            String query ="SELECT * FROM IDPW where ID like  ?";
            
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,"%"+idpw.getID()+"%");
            rs = stmt.executeQuery();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet selectEqual(ModelIDPW idpw) throws SQLException {
        
        java.sql.ResultSet rs = null;
        try {
            String query = "SELECT* FROM IDPW where ID = ?";
            
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,idpw.getID());
            rs=stmt.executeQuery();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet selectDynamic(ModelIDPW idpw) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public int insertidpw(ModelIDPW idpw) throws SQLException {
       
        int rs =-1;
        try {
            String query =" INSERT INTO ";
            query +=" IDPW( ID, PW) ";
            query +=" VALUES(?,?)";
            
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString (1,idpw.getID() );
            stmt.setString (2,idpw.getPW() );
            
            
            rs=stmt.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public int updateidpw(ModelIDPW whereidpw, ModelIDPW setidpw)
            throws SQLException {
        int rs = 0;
        
        try {
           String query = " UPDATE IDPW set      \n ";
            query       += " ID        =? ,\n ";
            query       += " PW    =? ,\n ";
            
            query       += " WHERE ID =?     \n ";
            
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, setidpw.getID());
            stmt.setString(2, setidpw.getPW());
            
            stmt.setString(3, setidpw.getID());
            
            
            rs = stmt.executeUpdate();
       } catch (Exception e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
           return rs;
    }
    
    @Override
    public int deletidpw(ModelIDPW idpw) throws SQLException {

        int rs =-1;
        
        try {
            String query ="delete from idpw where ID =?";
            
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, idpw.getID());
            
            rs = stmt.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return rs;
    }
    
}
