package com.io.io22.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @Column(name = "id")
    @ColumnDefault("uuid_generate_v4()")

    private UUID id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "email_verified")
    @ColumnDefault("false")
    private Boolean emailVerified;

    public String getEmail() {
        return email;
    }
}
