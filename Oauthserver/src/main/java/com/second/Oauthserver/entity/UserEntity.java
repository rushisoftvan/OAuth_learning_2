package com.second.Oauthserver.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstname;

    private String email;

    private String password;

    @ManyToOne
     @JoinColumn(name = "ROLE_ID")
    private RoleEntity role;
}
