package com.example.susziweb.db.Entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "user_details", schema = "public")
public class User_details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", table = "user_details")
    private Long id;

    @Column(name="name", table = "user_details")
    private String name;

    @Column(name = "surname", table = "user_details")
    private String surname;

    @Column(name = "dob", table = "user_details")
    private Date dob;

    @Column(name = "address")
    private String address;

    @Column(name = "apt_num")
    private String apt_num;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "description")
    private String description;

    @Column(name = "user_img")
    private String user_img;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
