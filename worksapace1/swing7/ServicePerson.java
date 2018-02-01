package java1101.swing7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicePerson implements IServicePerson {
   
    private java.sql.Connection conn = null;
    
    
    
    public ServicePerson() {
        super();
        this.conn = DBConnect.makeConnection();
    }
    


    @Override
    public int getCount(ModelPerson person) throws SQLException {
        
        int rs =-1;
        try {
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoPerson dao = new DaoPerson(conn);
            rs=dao.getCount(person);
            
            conn.commit();//트랜젝션 종료
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            conn.rollback();//트랜젝션 롤백
        }
        return rs;
        
    }
    
    @Override
    public int getMaxPersonid() throws SQLException {
        int rs =-1;
        try {
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoPerson dao = new DaoPerson(conn);
            rs=dao.getMaxPersonid();
            
            conn.commit();//트랜젝션 종료
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            conn.rollback();//트랜젝션 롤백
        }
        return rs;
    }
    
    @Override
    public ResultSet selectAll() throws SQLException {
        ResultSet rs =null;
        try {
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoPerson dao = new DaoPerson(conn);
            rs=dao.selectAll();
            
            conn.commit();//트랜젝션 종료
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            conn.rollback();//트랜젝션 롤백
        }
        return rs;
    }
    
    @Override
    public ResultSet selectLike(ModelPerson person) throws SQLException {
       
        ResultSet rs =null;
        try {
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoPerson dao = new DaoPerson(conn);
            rs=dao.selectLike(person);
            
            conn.commit();//트랜젝션 종료
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            conn.rollback();//트랜젝션 롤백
        }
        return rs;
    }
    
    @Override
    public ResultSet selectEqual(ModelPerson person) throws SQLException {
        
        ResultSet rs =null;
        try {
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoPerson dao = new DaoPerson(conn);
            rs=dao.selectEqual(person);
            
            conn.commit();//트랜젝션 종료
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            conn.rollback();//트랜젝션 롤백
        }
        return rs;
    }
    
    @Override
    public ResultSet selectDynamic(ModelPerson person) throws SQLException {

        ResultSet rs =null;
        try {
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoPerson dao = new DaoPerson(conn);
            rs=dao.selectDynamic(person);
            
            conn.commit();//트랜젝션 종료
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            conn.rollback();//트랜젝션 롤백
        }
        return rs;
    }
    
    @Override
    public int insertperson(ModelPerson person) throws SQLException {
        int rs =-1;
        try {
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoPerson dao = new DaoPerson(conn);
            rs=dao.insertperson(person);
            
            conn.commit();//트랜젝션 종료
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            conn.rollback();//트랜젝션 롤백
        }
        return rs;
    }
    
    @Override
    public int updateperson(ModelPerson whereperson, ModelPerson setperson)
            throws SQLException {
        int rs =-1;
        try {
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoPerson dao = new DaoPerson(conn);
            rs=dao.updateperson(whereperson,setperson);
            
            conn.commit();//트랜젝션 종료
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            conn.rollback();//트랜젝션 롤백
        }
        return rs;
        
    }
    
    @Override
    public int deletperson(ModelPerson person) throws SQLException {
        int rs =-1;
        try {
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoPerson dao = new DaoPerson(conn);
            rs=dao.deletperson(person);
            
            conn.commit();//트랜젝션 종료
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            conn.rollback();//트랜젝션 롤백
        }
        return rs;
    }
    
    @Override
    public int transcommit(ModelPerson p1, ModelPerson p2) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int transRollback(ModelPerson p1, ModelPerson p2) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
