package java1101.swing7;

public interface IServiceRent extends IRent {
    

    //추가되는 메서드 service 레이어에서만 사용되는 메서드다.
    
    public int transcommit(ModelRent r1, ModelRent r2);
    public int transRollback(ModelRent r1, ModelRent r2);
    
    
}
