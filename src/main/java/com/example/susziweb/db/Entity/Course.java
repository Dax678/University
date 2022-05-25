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
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "dept_name")
    private String dept_name;
    @Column(name = "description")
    private String description;
    @Column(name = "user_id")
    private Long user_id;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id",
            insertable = false, updatable = false)
    private Section_course section_course;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id",
            insertable = false, updatable = false)
    private Time_slot time_slot;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id",
            insertable = false, updatable = false)
    private Teaches teaches;

    @OneToMany(mappedBy = "courseD")
    private List<Department> departments;
}
