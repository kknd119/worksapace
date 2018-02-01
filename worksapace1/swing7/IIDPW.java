package java1101.swing7;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IIDPW {

    
int getCount(ModelIDPW idpw)throws SQLException;
    
    int getMaxpwid() throws SQLException;
    
    ResultSet selectAll() throws SQLException;
    
    ResultSet selectLike(ModelIDPW idpw)throws SQLException;
    
    ResultSet selectEqual(ModelIDPW idpw)throws SQLException;
    
    ResultSet selectDynamic(ModelIDPW idpw)throws SQLException;
    
    int insertidpw(ModelIDPW idpw)throws SQLException;
    
    int updateidpw(ModelIDPW  whereidpw,ModelIDPW setidpw)throws SQLException;
    
    int deletidpw(ModelIDPW idpw)throws SQLException;
    
}
