package TestFile.practice.entity;

import lombok.*;
import TestFile.practice.constant.Authority;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
@Getter @Setter @ToString
public class UserEntity {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;
 
    @Column(name = "age_group", nullable = false)
    private String ageGroup;

    @Column(name = "profileimage", nullable = false)
    private String profileImage;


    @Enumerated(EnumType.STRING)
    private Authority authority;



}


