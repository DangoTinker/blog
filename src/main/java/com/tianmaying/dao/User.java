package com.tianmaying.dao;

@Entity
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private long id;


    @Column(
            unique = true
    )
    private String email;
    private String username;
    private String password;


    public User(){}
    public User(String email,String username,String password){
        this.email=email;
        this.username=username;
        this.password=password;
    }
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
