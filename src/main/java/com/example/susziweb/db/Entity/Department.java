package com.example.susziweb.db.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_name")
    private String dept_name;
    @Column(name = "building")
    private String building;
    @Column(name = "budget")
    private int budget;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dept_name", referencedColumnName = "dept_name", insertable = false, updatable = false)
    private Course courseD;
}
