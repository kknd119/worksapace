package java1101.swing7;

import java23.jdbc.ModelBook1;

public interface IServiceBook extends IBook{
    
    
    //추가되는 메서드 service 레이어에서만 사용되는 메서드다.
    
    public int transcommit(ModelBook b1, ModelBook b2);
    public int transRollback(ModelBook b1, ModelBook b2);
    
}
