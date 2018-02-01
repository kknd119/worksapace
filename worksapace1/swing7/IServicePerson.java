package java1101.swing7;

public interface IServicePerson extends IPerson {
   //추가되는 메서드 service 레이어에서만 사용되는 메서드다.
    
    public int transcommit  (ModelPerson p1, ModelPerson p2);
    public int transRollback(ModelPerson p1, ModelPerson p2);
    
}
