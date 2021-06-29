package work_shop.WorkShop.Models;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    @Column(unique = true)
    private String isbn;
    private String title;
    private int MaxLoanDays;

    @ManyToMany(

            cascade = {CascadeType.DETACH,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH

            }
    )
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn( name = "book_id") ,
            inverseJoinColumns = @JoinColumn(name = "author_id")

    )
    private Set<Author> authors;

    public Book(int bookId, String isbn, String title, int maxLoanDays) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        MaxLoanDays = maxLoanDays;
    }

    public Book(int bookId, String isbn, String title, int maxLoanDays, Set<Author> authors) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        MaxLoanDays = maxLoanDays;
        this.authors = authors;
    }

    public Book() {
    }

    public int getBookId() {
        return bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaxLoanDays() {
        return MaxLoanDays;
    }

    public void setMaxLoanDays(int maxLoanDays) {
        MaxLoanDays = maxLoanDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return MaxLoanDays == book.MaxLoanDays && Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, MaxLoanDays);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", MaxLoanDays=" + MaxLoanDays +
                '}';
    }
}
