package model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity                                             // adnotacja tworząca tabelkę user w DB
//@Table(name = "uzytkownicy")
public class User {
    @Id                                             // adnotacja determinująca PK
    @GeneratedValue(strategy = GenerationType.AUTO) // adnotacja determinująca AI
//    @Column(name = "identyfikator")
    private int id_u;
//    @Column(name = "mejl")
    @Column(unique = true)
//    @NotNull
    private String email;
//    @NotNull
    private String password;
    @Enumerated
    private RoleEnum role;                          // umozliwia przypisanie nazw rol zgodnie z roleEnum
    private boolean enable;
    private LocalDate date_added = LocalDate.now();
    @Transient                                       // adnotacja wylaczajaca pole przy mapowaniu
    private String secret_code;

    public User(String email, String password, RoleEnum role, boolean enable, LocalDate date_added, String secret_code) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.enable = enable;
        this.date_added = date_added;
        this.secret_code = secret_code;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_u=" + id_u +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", enable=" + enable +
                ", date_added=" + date_added +
                ", secret_code='" + secret_code + '\'' +
                '}';
    }

    public User() {
    }

    public int getId_u() {
        return id_u;
    }

    public void setId_u(int id_u) {
        this.id_u = id_u;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public LocalDate getDate_added() {
        return date_added;
    }

    public void setDate_added(LocalDate date_added) {
        this.date_added = date_added;
    }

    public String getSecret_code() {
        return secret_code;
    }

    public void setSecret_code(String secret_code) {
        this.secret_code = secret_code;
    }
}
