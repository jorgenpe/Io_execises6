package work_shop.WorkShop.Models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class BookLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanId;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private boolean returned;
    @ManyToOne(cascade = {
                          CascadeType.DETACH,
                          CascadeType.REFRESH},
                          fetch = FetchType.LAZY
    )

    @JoinColumn(name = "book_loan_user_id",table = "book_loan")
    private AppUser borrower;
    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "book_loan_book_id",table = "book")
    private Book book;




    public BookLoan() {
    }

    public int getLoanId() {
        return loanId;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public AppUser getBorrower() {
        return borrower;
    }

    public void setBorrower(AppUser borrower) {
        this.borrower = borrower;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookLoan bookLoan = (BookLoan) o;
        return returned == bookLoan.returned && Objects.equals(loanDate, bookLoan.loanDate) && Objects.equals(dueDate, bookLoan.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanDate, dueDate, returned);
    }

    @Override
    public String toString() {
        return "BookLoan{" +
                "loanDate=" + loanDate +
                ", dueDate=" + dueDate +
                ", returned=" + returned +
                '}';
    }
}
