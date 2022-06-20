package com.example.susziweb.db.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "course_details")
public class Course_details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;

    @Column(name = "ects")
    private String ects;

    @Column(name = "level")
    private String level;

    @OneToMany(mappedBy = "course_details")
    private List<Course> course;
}
