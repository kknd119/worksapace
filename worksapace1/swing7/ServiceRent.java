package java1101.swing7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceRent implements IServiceRent {
   
    private java.sql.Connection conn = null;
    
    public ServiceRent() {
        super();
        this.conn = DBConnect.makeConnection();
    }

    

    @Override
    public int getCount(ModelRent rent) throws SQLException {
       
        int rs =-1;
        try {
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoRent dao = new DaoRent(conn);
            rs=dao.getCount(rent);
            
            conn.commit();//트랜젝션 종료
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            conn.rollback();//트랜젝션 롤백
        }
        return rs;
        
    }
    
    @Override
    public int getMaxRentid() throws SQLException {
        
        int rs =-1;
        try {
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoRent dao = new DaoRent(conn);
            rs=dao.getMaxRentid();
            
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
            
            DaoRent dao = new DaoRent(conn);
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
    public ResultSet selectLike(ModelRent rent) throws SQLException {
        
        ResultSet rs =null;
        try {
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoRent dao = new DaoRent(conn);
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
    public ResultSet selectEqual(ModelRent rent) throws SQLException {
        
        ResultSet rs =null;
        try {
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoRent dao = new DaoRent(conn);
            rs=dao.selectEqual(rent);
            
            conn.commit();//트랜젝션 종료
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            conn.rollback();//트랜젝션 롤백
        }
        return rs;
    }
    
    @Override
    public ResultSet selectDynamic(ModelRent rent) throws SQLException {
        
        ResultSet rs =null;
        try {
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoRent dao = new DaoRent(conn);
            rs=dao.selectDynamic(rent);
            
            conn.commit();//트랜젝션 종료
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            conn.rollback();//트랜젝션 롤백
        }
        return rs;
    }
    
    @Override
    public int insertRent(ModelRent rent) throws SQLException {
        int rs =-1;
        try {
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoRent dao = new DaoRent(conn);
            rs=dao.insertRent(rent);
            
            conn.commit();//트랜젝션 종료
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            conn.rollback();//트랜젝션 롤백
        }
        return rs;
    }
    
    @Override
    public int updateRent(ModelRent whererent, ModelRent setrent)
            throws SQLException {
        int rs =-1;
        try {
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoRent dao = new DaoRent(conn);
            rs=dao.updateRent(whererent,setrent);
            
            conn.commit();//트랜젝션 종료
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            conn.rollback();//트랜젝션 롤백
        }
        return rs;
    }
    
    @Override
    public int deletRent(ModelRent rent) throws SQLException {
        int rs =-1;
        try {
            //트렌젝션 시작
            conn.setAutoCommit(false);
            
            DaoRent dao = new DaoRent(conn);
            rs=dao.deletRent(rent);
            
            conn.commit();//트랜젝션 종료
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            conn.rollback();//트랜젝션 롤백
        }
        return rs;
    }
    
    @Override
    public int transcommit(ModelRent r1, ModelRent r2) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int transRollback(ModelRent r1, ModelRent r2) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
