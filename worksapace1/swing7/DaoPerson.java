package java1101.swing7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoPerson implements IPerson {
    
    private java.sql.Connection conn =null;
    
    //생성자.

    public DaoPerson(Connection conn) {
        super();
        this.conn = conn;
    }

    
    @Override
    public int getCount(ModelPerson person) throws SQLException {

        int result = -1;
        
        //SQL 문장
        String query = "SELECT count(*) as total from persons where 1 = 1";
        
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
    public int getMaxPersonid() throws SQLException {
       
        int result =-1;
        //SQL 문장
        String query = " select max(p_no) maxid from persons";
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
        String query = "SELECT * FROM persons ORDER BY p_no ASC";
        try {
            java.sql.PreparedStatement stmt = conn.prepareStatement(query) ;
            rs = stmt.executeQuery();
            
        } catch (Exception e) {
           
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet selectLike(ModelPerson name) throws SQLException {

        ResultSet rs = null;
        
        try {
            String query ="SELECT * FROM persons where name like  ?";
            
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,"%"+name.getName()+"%");
            rs = stmt.executeQuery();
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet selectEqual(ModelPerson person) throws SQLException {
        
        java.sql.ResultSet rs = null;
        try {
            String query = "SELECT* FROM person where name = ?";
            
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,person.getName());
            rs=stmt.executeQuery();
        } catch (Exception e) {
           
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet selectDynamic(ModelPerson person) throws SQLException {
 
        ResultSet result =null;
        
        //문장 객체 생성
     
     try {
         String query  = " select * from persons \n";
                   query += " where 1 = 1 \n";
            if(person.getP_no() != null) query +=" and p_no =?  \n";
            if(!person.getName().isEmpty()) query +=" and name=? \n";
            
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            
            int c =1;
            if(person.getP_no()!=null)stmt.setInt(c++,person.getP_no());
            if(!person.getName().isEmpty())stmt.setString(c++, person.getName());
            
            result = stmt.executeQuery();
     } catch (Exception e) {
         
         e.printStackTrace();
     }
        
        //query 실행
        return result;
        
        
    }
    
    @Override
    public int insertperson(ModelPerson person) throws SQLException {
       
        int rs =-1;
        try {
            String query =" INSERT INTO ";
            query +=" PerSONS( name, pid, phone, email) ";
            query +=" VALUES(?,?,?,?)";
            
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString (1,person.getName());
            stmt.setString (2,person.getPid() );
            stmt.setString (3,person.getPhone());
            stmt.setString (4,person.getEmail());
            
            rs=stmt.executeUpdate();
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public int updateperson(ModelPerson whereperson, ModelPerson setperson)
            throws SQLException {
        int rs = 0;
        
        try {
           String query = " UPDATE persons set      \n ";
            query       += " name        =?        ,\n ";
            query       += " pid         =?        ,\n ";
            query       += " phone       =?        ,\n ";
            query       += " email       =?        ,\n ";
            
            query       += " WHERE p_no  =?        \n ";
            
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, setperson.getName());
            stmt.setString(2, setperson.getPid());
            stmt.setString(3, setperson.getPhone());
            stmt.setString(4, setperson.getEmail());
           
            stmt.setInt   (5, setperson.getP_no());
            
            
            rs = stmt.executeUpdate();
       } catch (Exception e) {
           
           e.printStackTrace();
       }
           return rs;
    }
    
    @Override
    public int deletperson(ModelPerson person) throws SQLException {

        int rs =-1;
        
        try {
            String query ="delete from persons where name =?";
            
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, person.getName());
            
            rs = stmt.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return rs;
    }
    
}
