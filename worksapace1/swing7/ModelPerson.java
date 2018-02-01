package java1101.swing7;

public class ModelPerson {
    

 private  Integer p_no  = null; // `p_no` INT(3) NULL DEFAULT NULL,
 private  String  name  = ""; // `name` VARCHAR(50) NULL DEFAULT NULL,
 private  String  pid   = ""; // `pid` VARCHAR(50) NULL DEFAULT NULL,
 private  String  phone = ""; // `phone` VARCHAR(50) NULL DEFAULT NULL,
 private  String  email = ""; // `email` VARCHAR(50) NULL DEFAULT NULL

 
 public ModelPerson(Integer p_no, String name, String pid, String phone,
        String email) {
    super();
    this.p_no = p_no;
    this.name = name;
    this.pid = pid;
    this.phone = phone;
    this.email = email;
}


public ModelPerson() {
    super();
}


public Integer getP_no() {
    return p_no;
}


public void setP_no(Integer p_no) {
    this.p_no = p_no;
}


public String getName() {
    return name;
}


public void setName(String name) {
    this.name = name;
}


public String getPid() {
    return pid;
}


public void setPid(String pid) {
    this.pid = pid;
}


public String getPhone() {
    return phone;
}


public void setPhone(String phone) {
    this.phone = phone;
}


public String getEmail() {
    return email;
}


public void setEmail(String email) {
    this.email = email;
}


@Override
public String toString() {
    return "ModelPerson [p_no=" + p_no + ", name=" + name + ", pid=" + pid
            + ", phone=" + phone + ", email=" + email + "]";
}
 
 
////////////////////////////////////////////////////////////////////////    
}
