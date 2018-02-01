package java1101.swing7;

public interface IServiceIDPW extends IIDPW {
    

    //추가되는 메서드 service 레이어에서만 사용되는 메서드다.
    
    public int transcommit(ModelIDPW b1, ModelIDPW b2);
    public int transRollback(ModelIDPW b1, ModelIDPW b2);
    
}
