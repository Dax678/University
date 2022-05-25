package com.example.susziweb.db.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "role", schema = "public")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", table = "role")
    private Long id;
    @Column(name = "role_name")
    private String role_name;
    @Column(name = "role_full_name")
    private String role_full_name;

    @OneToMany(mappedBy = "role")
    private List<User> user;
}
