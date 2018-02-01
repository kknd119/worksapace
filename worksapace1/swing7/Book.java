package java1101.swing7;

public class Book {
    
    private Integer bookid;
    private String title;
    private String publisher;
    private String genre;
    private String author;
    private Integer sal;
    private String bi;
    
    //생성자
    public Book(Integer bookid, String title, String publisher, String genre,
            String author, Integer sal, String bi) {
        super();
        this.bookid = bookid;
        this.title = title;
        this.publisher = publisher;
        this.genre = genre;
        this.author = author;
        this.sal = sal;
        this.bi = bi;
    }

    public Book() {
        super();
    }
    //get set

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
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

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    
    
    //    to String
    @Override
    public String toString() {
        return "Book [bookid=" + bookid + ", title=" + title + ", publisher="
                + publisher + ", genre=" + genre + ", author=" + author
                + ", sal=" + sal + ", bi=" + bi + "]";
    }
    
   
}
