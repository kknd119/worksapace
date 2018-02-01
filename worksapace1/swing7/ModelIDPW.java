package java1101.swing7;

public class ModelIDPW {
    private String  ID="";//`ID` VARCHAR(50) NOT NULL,
    private String  PW="";//`PW` VARCHAR(50) NOT NULL,
    
    ////////////////////////////////////////
    public ModelIDPW(String iD, String pW) {
        super();
        ID = iD;
        PW = pW;
    }


    public ModelIDPW() {
        super();
    }
    //////////////////////////////////////////

    public String getID() {
        return ID;
    }


    public void setID(String iD) {
        ID = iD;
    }


    public String getPW() {
        return PW;
    }


    public void setPW(String pW) {
        PW = pW;
    }


    @Override
    public String toString() {
        return "ModelIDPW [ID=" + ID + ", PW=" + PW + "]";
    }
    
    
    //////////////////////////////////////////////////
    
    
    
}
