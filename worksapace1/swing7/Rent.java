package java1101.swing7;

public class Rent {
    Integer    no;
    String name;
    String phone;
    String pid;
    String email;
    String title;
    String publisher;
    String gener;
    String author;
    Integer   bookid;
    String rentDate;
    
    // 생성자
    
    
    public Rent(int no, String name, String phone, String pid, String email,
            String title,String publisher, String gener, String author, int bookid,
            String rentDate) {
        super();
        this.no = no;
        this.name = name;
        this.phone = phone;
        this.pid = pid;
        this.email = email;
        this.title = title;
        this.publisher=publisher;
        this.gener = gener;
        this.author = author;
        this.bookid = bookid;
        this.rentDate = rentDate;
    }

    public Rent(String name, String title, String rentDate) {
        super();
        this.name = name;
        this.title = title;
        this.rentDate = rentDate;
    }

    public Rent() {
        super();
    }

    //////// get set
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
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

    public String getGener() {
        return gener;
    }

    public void setGener(String gener) {
        this.gener = gener;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    /// to string
    @Override
    public String toString() {
        return "Rent [no=" + no + ", name=" + name + ", phone=" + phone
                + ", pid=" + pid + ", email=" + email + ", title=" + title
                + ", publisher=" + publisher
                + ", gener=" + gener + ", author=" + author + ", bookid="
                + bookid + ", rentDate=" + rentDate + "]";
    }

   
    
    
   
    
    
    
   
    
    
}

