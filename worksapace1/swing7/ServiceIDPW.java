package java1101.swing7;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceIDPW implements IServiceIDPW {
    
    private java.sql.Connection conn = null;
    
    
    public ServiceIDPW() {
        super();
        this.conn= DBConnect.makeConnection();
    }
    
    @Override
    public int getCount(ModelIDPW idpw) throws SQLException {
       
        int rs =-1;
        try {
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoIDPW dao = new DaoIDPW(conn);
            rs=dao.getCount(idpw);
            
            conn.commit();//트랜젝션 종료
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            conn.rollback();//트랜젝션 롤백
        }
        return rs;
    }
    
    @Override
    public int getMaxpwid() throws SQLException {
        
        int rs =-1;
        try {
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoIDPW dao = new DaoIDPW(conn);
            rs=dao.getMaxpwid();
            
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
            
            DaoIDPW dao = new DaoIDPW(conn);
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
    public ResultSet selectLike(ModelIDPW idpw) throws SQLException {
        
        ResultSet rs =null;
        try {
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoIDPW dao = new DaoIDPW(conn);
            rs=dao.selectLike(idpw);
            
            conn.commit();//트랜젝션 종료
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            conn.rollback();//트랜젝션 롤백
        }
        return rs;
    }
    
    @Override
    public ResultSet selectEqual(ModelIDPW idpw) throws SQLException {
        
        ResultSet rs =null;
        try {
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoIDPW dao = new DaoIDPW(conn);
            rs=dao.selectEqual(idpw);
            
            conn.commit();//트랜젝션 종료
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            conn.rollback();//트랜젝션 롤백
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
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoIDPW dao = new DaoIDPW(conn);
            rs=dao.insertidpw(idpw);
            
            conn.commit();//트랜젝션 종료
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            conn.rollback();//트랜젝션 롤백
        }
        return rs;
    }
    
    @Override
    public int updateidpw(ModelIDPW whereidpw, ModelIDPW setidpw)
            throws SQLException {
        
        int rs =-1;
        try {
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoIDPW dao = new DaoIDPW(conn);
            rs=dao.updateidpw(whereidpw,setidpw);
            
            conn.commit();//트랜젝션 종료
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            conn.rollback();//트랜젝션 롤백
        }
        return rs;
    }
    
    @Override
    public int deletidpw(ModelIDPW idpw) throws SQLException {
        
        int rs =-1;
        try {
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoIDPW dao = new DaoIDPW(conn);
            rs=dao.deletidpw(idpw);
            
            conn.commit();//트랜젝션 종료
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            conn.rollback();//트랜젝션 롤백
        }
        return rs;
    }
    
    @Override
    public int transcommit(ModelIDPW b1, ModelIDPW b2) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int transRollback(ModelIDPW b1, ModelIDPW b2) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
