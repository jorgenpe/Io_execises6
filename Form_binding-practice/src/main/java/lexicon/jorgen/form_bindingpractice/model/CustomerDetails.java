package lexicon.jorgen.form_bindingpractice.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

public class CustomerDetails {


    private final String UNSPECIFIED = "UNSPECIFIED";
    private String detailsId;
    private String street;
    private String zipCode;
    private String city;
    private String homePhone;
    private String cellPhone;


    public CustomerDetails() {
    }

    public CustomerDetails(String detailsId, String street, String zipCode, String city, String homePhone, String cellPhone) {
        this.detailsId = detailsId;
        setStreet(street) ;
        setZipCode(zipCode);
        setCity(city);
        setHomePhone(homePhone);
        setCellPhone(cellPhone);
    }

    public String getStreet() {
        return street;
    }

    public String getDetailsId() {
        return detailsId;
    }

    public void setStreet(String street) {
        if(street == null) street = UNSPECIFIED;
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        if(zipCode == null) zipCode = UNSPECIFIED;
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if(city == null || city.isEmpty()) city = UNSPECIFIED;
        this.city = city;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        if(homePhone == null || homePhone.isEmpty()) homePhone = UNSPECIFIED;
        this.homePhone = homePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        if(cellPhone == null || cellPhone.isEmpty()) cellPhone = UNSPECIFIED;
        this.cellPhone = cellPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDetails that = (CustomerDetails) o;
        return Objects.equals(street, that.street) && Objects.equals(zipCode, that.zipCode) && Objects.equals(city, that.city) && Objects.equals(homePhone, that.homePhone) && Objects.equals(cellPhone, that.cellPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, zipCode, city, homePhone, cellPhone);
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "detailsId='" + detailsId + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                '}';
    }
}
