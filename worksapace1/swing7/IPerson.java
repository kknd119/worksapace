package java1101.swing7;

import java.sql.ResultSet;
import java.sql.SQLException;


public interface IPerson {

    
int getCount(ModelPerson person)throws SQLException;
    
    int getMaxPersonid() throws SQLException;
    
    ResultSet selectAll() throws SQLException;
    
    ResultSet selectLike(ModelPerson person)throws SQLException;
    
    ResultSet selectEqual(ModelPerson person)throws SQLException;
    
    ResultSet selectDynamic(ModelPerson person)throws SQLException;
    
    int insertperson(ModelPerson person)throws SQLException;
    
    int updateperson(ModelPerson  whereperson,ModelPerson setperson)throws SQLException;
    
    int deletperson(ModelPerson person)throws SQLException;
    
}
