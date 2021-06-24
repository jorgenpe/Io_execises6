package Models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appUserId;
    @Column(unique = true)
    private String userName;
    private String password;
    private LocalDate regDate;
    @OneToOne(cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
    @JoinColumn(name = "app_user_detailsId" )
    private Details userDetails;

    public AppUser(int appUserId, String userName, String password, LocalDate regDate, Details userDetails) {
        this.appUserId = appUserId;
        this.userName = userName;
        this.password = password;
        this.regDate = regDate;
        this.userDetails = userDetails;
    }

    public AppUser(String userName, String password, LocalDate regDate, Details userDetails) {
        this.userName = userName;
        this.password = password;
        this.regDate = regDate;
        this.userDetails = userDetails;
    }

    public AppUser() {
    }

    public int getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(int appUserId) {
        this.appUserId = appUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return userName.equals(appUser.userName) && password.equals(appUser.password) && regDate.equals(appUser.regDate) && userDetails.equals(appUser.userDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password, regDate, userDetails);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "appUserId=" + appUserId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", regDate=" + regDate +
                ", userDetails=" + userDetails +
                '}';
    }
}


