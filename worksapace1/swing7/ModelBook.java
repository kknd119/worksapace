package java1101.swing7;

public class ModelBook {
    
 private Integer b_no     = null ;   //`b_no` INT(3) NULL DEFAULT NULL,
 private String  title    = "";   //`title` VARCHAR(50) NULL DEFAULT NULL,
 private String  publisher= "";   //`publisher` VARCHAR(50) NULL DEFAULT NULL,
 private String  genre    = "";   //`genre` VARCHAR(50) NULL DEFAULT NULL,
 private String  author   = "";   //`author` VARCHAR(50) NULL DEFAULT NULL,
 private Integer sal      = null;   //`sal` INT(5) NULL DEFAULT NULL,
 private String  rent_if  = "";   //`rent_if` DATE NULL DEFAULT NULL

 ///////////////////////////////////////////////////////////////////////
 public ModelBook(Integer b_no, String title, String publisher, String genre,
        String author, Integer sal, String rent_if) {
    super();
    this.b_no = b_no;
    this.title = title;
    this.publisher = publisher;
    this.genre = genre;
    this.author = author;
    this.sal = sal;
    this.rent_if = rent_if;
}

public ModelBook() {
    super();
}

public Integer getB_no() {
    return b_no;
}

public void setB_no(Integer b_no) {
    this.b_no = b_no;
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

public Integer getSal() {
    return sal;
}

public void setSal(Integer sal) {
    this.sal = sal;
}

public String getRent_if() {
    return rent_if;
}

public void setRent_if(String rent_if) {
    this.rent_if = rent_if;
}

@Override
public String toString() {
    return "ModelBook [b_no=" + b_no + ", title=" + title + ", publisher="
            + publisher + ", genre=" + genre + ", author=" + author + ", sal="
            + sal + ", rent_if=" + rent_if + "]";
}
 

 
 //////////////////////////////////////////////////////////////////
 
}
