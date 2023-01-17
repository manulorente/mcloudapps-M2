package mcloudapps.rest_db.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nickname;
    private String email;

    @OneToMany(mappedBy = "userName", cascade = CascadeType.REMOVE)
    List<Comment> comments;

    public User() {
    }

    public User(String nickname, String email) {
        super();
        this.nickname = nickname;
        this.email = email;
        this.comments = new ArrayList<>();
    }

    public Long getId() {
        return this.id;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getEmail() {
        return this.email;
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
