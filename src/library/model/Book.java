package library.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author hirwa
 */
@Entity
@Table(name="book")
public class Book {
    @Id
    private String bookId;
    private String title;
    private String author;
    private String bookCategory;
    private String publishingHouse;
    private String publicationDate;
    private int pages;
    private String available;

    public Book() {
    }

    public Book(String bookId, String title, String author, String bookCategory, String publishingHouse, String publicationDate, int pages, String available) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.bookCategory = bookCategory;
        this.publishingHouse = publishingHouse;
        this.publicationDate = publicationDate;
        this.pages = pages;
        this.available = available;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    
    
    
}
