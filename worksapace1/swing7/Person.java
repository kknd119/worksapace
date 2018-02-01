package java1101.swing7;

public class Person {
    Integer pid;
    String name ;
    String phone;
    String idno;
    String email;
    
    
    ////생성자
    public Person( Integer pid,String name, String phone, String idno, String email) {
        super();
        this.pid = pid;
        this.name = name;
        this.phone = phone;
        this.idno = idno;
        this.email = email;
    }


    public Person() {
        super();
    }

    ///////// get set
    public Integer getpid() {
        return pid;
    }


    public void setpid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getIdno() {
        return idno;
    }


    public void setIdno(String idno) {
        this.idno = idno;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


   

    /// to string/////

    @Override
    public String toString() {
        return "Person [pid=" + pid + ", name=" + name + ", phone=" + phone
                + ", idno=" + idno + ", email=" + email + "]";
    }
    
    
    

    
    
}
