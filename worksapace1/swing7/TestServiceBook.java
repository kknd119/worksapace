package java1101.swing7;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import java23.jdbc.ModelBook1;
import java23.jdbc.ServiceBook1;

public class TestServiceBook {
    private static ServicePerson svr = null;
    private static ServiceBook svr1 = null;
    private static ServiceRent svr2 = null;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        svr = new ServicePerson();
        svr1 = new ServiceBook();
        svr2= new ServiceRent();
    }
    
    @Test
    public void testGetCount() throws SQLException {
        ModelPerson model = new ModelPerson();
        ModelBook  model1 = new ModelBook();
        ModelRent  model2 = new ModelRent();
        
        int result = svr.getCount(model);
        int result1 = svr1.getCount(model1);
        int result2 = svr2.insertRent(model2);
        
        
        assertEquals(1,result2);   
        //assertEquals(4,result);
           
    }
    
    
    @Test
    public void testGetMaxBookid() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectAll() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectLike() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectEqual() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectDynamic() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testInsertBook() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testUpdateBook() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testDeletBook() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testTranscommit() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testTransRollback() {
        fail("Not yet implemented");
    }
    
}
