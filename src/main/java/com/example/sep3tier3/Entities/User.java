package com.example.sep3tier3.Entities;

import javax.persistence.*;


@Entity
@Table(name = "user_accounts")
public class User {

    @Id
    @Column(name ="user_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator",sequenceName = "user_accounts_seq", allocationSize = 1)
    private long id;

    private String username;

    private String password;

    private long securitylevel;

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getSecuritylevel() {
        return securitylevel;
    }

    public void setSecuritylevel(long securitylevel) {
        this.securitylevel = securitylevel;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", securitylevel=" + securitylevel +
                '}';
    }
}
