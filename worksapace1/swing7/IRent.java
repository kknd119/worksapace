package java1101.swing7;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IRent {
int getCount(ModelRent rent)throws SQLException;
    
    int getMaxRentid() throws SQLException;
    
    ResultSet selectAll() throws SQLException;
    
    ResultSet selectLike(ModelRent rent)throws SQLException;
    
    ResultSet selectEqual(ModelRent rent)throws SQLException;
    
    ResultSet selectDynamic(ModelRent rent)throws SQLException;
    
    int insertRent(ModelRent rent)throws SQLException;
    
    int updateRent(ModelRent  whererent,ModelRent setrent)throws SQLException;
    
    int deletRent(ModelRent rent)throws SQLException;
    
}
