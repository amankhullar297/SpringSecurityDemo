package com.springsecuritydemo.entity;
import javax.persistence.*;

@Entity
@Table(name="USER_TABLE")
public class User {

    public User(){   }



    public User(String name, String email, Role role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long   userId;

    @Column(name = "USER_NAME",unique = true)
    private String  name;

    @Column(name = "USER_EMAIL")
    private String  email;

    @Column(name = "USER_PASSWORD")
    private String  password;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private Role role;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}


