package java1101.swing7;

public class ModelRent {
    
 private Integer rent_no   = null ;   //`rent_no` INT(11) NULL DEFAULT NULL,
 private String name       = "" ;   //`name` VARCHAR(50) NULL DEFAULT NULL,
 private String phone      = "";   //`phone` VARCHAR(50) NULL DEFAULT NULL,
 private String pid        = "";   //`pid` VARCHAR(50) NULL DEFAULT NULL,
 private String email      = "";   //`email` VARCHAR(50) NULL DEFAULT NULL,
 private String title      = "";   //`title` VARCHAR(50) NULL DEFAULT NULL,
 private String publisher  = "";   //`publisher` VARCHAR(50) NULL DEFAULT NULL,
 private String genre      = "";   //`genre` VARCHAR(50) NULL DEFAULT NULL,
 private String author     = "";   //`author` VARCHAR(50) NULL DEFAULT NULL,
 private Integer b_no      = null ;   //`b_no` INT(11) NULL DEFAULT NULL,
 private String rent_date  = "";   //`rent_date` DATE NULL DEFAULT NULL

 
 public ModelRent(Integer rent_no, String name, String phone, String pid,
        String email, String title, String publisher, String genre,
        String author, Integer b_no, String rent_date) {
    super();
    this.rent_no = rent_no;
    this.name = name;
    this.phone = phone;
    this.pid = pid;
    this.email = email;
    this.title = title;
    this.publisher = publisher;
    this.genre = genre;
    this.author = author;
    this.b_no = b_no;
    this.rent_date = rent_date;
}


public ModelRent() {
    super();
}


public Integer getRent_no() {
    return rent_no;
}


public void setRent_no(Integer rent_no) {
    this.rent_no = rent_no;
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


public String getPid() {
    return pid;
}


public void setPid(String pid) {
    this.pid = pid;
}


public String getEmail() {
    return email;
}


public void setEmail(String email) {
    this.email = email;
}


public String getTitle() {
    return title;
}


public void setTitle(String title) {
    this.title = title;
}


public String getPublisher() {
    return publisher;
}


public void setPublisher(String publisher) {
    this.publisher = publisher;
}


public String getGenre() {
    return genre;
}


public void setGenre(String genre) {
    this.genre = genre;
}


public String getAuthor() {
    return author;
}


public void setAuthor(String author) {
    this.author = author;
}


public Integer getB_no() {
    return b_no;
}


public void setB_no(Integer b_no) {
    this.b_no = b_no;
}


public String getRent_date() {
    return rent_date;
}


public void setRent_date(String rent_date) {
    this.rent_date = rent_date;
}


@Override
public String toString() {
    return "ModelRent [rent_no=" + rent_no + ", name=" + name + ", phone="
            + phone + ", pid=" + pid + ", email=" + email + ", title=" + title
            + ", publisher=" + publisher + ", genre=" + genre + ", author="
            + author + ", b_no=" + b_no + ", rent_date=" + rent_date + "]";
}
 

    
}

//////////////////////////////////////////////////////////////////////////////

