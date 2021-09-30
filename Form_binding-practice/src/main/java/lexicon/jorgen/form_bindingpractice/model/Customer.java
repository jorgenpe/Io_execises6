package lexicon.jorgen.form_bindingpractice.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;


public class Customer {


    private String customerId;
    private String email;
    private LocalDate regDate;
    private boolean active = true;
    private CustomerDetails details;

    public Customer() {
    }

    public Customer(String customerId, String email, LocalDate regDate, boolean active, CustomerDetails details) {
        this.customerId = customerId;
        this.email = email;
        this.regDate = regDate;
        this.active = active;
        this.details = details;
    }

    public Customer(String email, LocalDate regDate, CustomerDetails details) {
        this(UUID.randomUUID().toString(),email,regDate, true,details);
    }

    public Customer(String email, LocalDate regDate, boolean active, CustomerDetails details) {
        this.email = email;
        this.regDate = regDate;
        this.active = active;
        this.details = details;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CustomerDetails getDetails() {
        return details;
    }

    public void setDetails(CustomerDetails details) {
        this.details = details;
    }
}
