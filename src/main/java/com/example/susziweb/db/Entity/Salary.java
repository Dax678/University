package com.example.susziweb.db.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "salary", schema = "public")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salary_id")
    private Long id;

    @Column(name = "remuneration")
    private Long remuneration;

    @Column(name = "currency")
    private String currency;

    @OneToMany(mappedBy = "salary")
    private List<Teaches> teaches;
}
