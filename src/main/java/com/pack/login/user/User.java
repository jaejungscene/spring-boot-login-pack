package com.pack.login.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String salt;
    private String password;
    private String phone;
    @CreationTimestamp
    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Builder
    public User(Long id, String name, String email, String salt, String password, String phone, LocalDateTime createAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salt = salt;
        this.password = password;
        this.phone = phone;
        this.createAt = createAt;
    }
}
