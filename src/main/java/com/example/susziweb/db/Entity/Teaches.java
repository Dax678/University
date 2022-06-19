package com.example.susziweb.db.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "teaches", schema = "public")
public class Teaches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "course_id")
    private Long course_id;

    @Column(name = "salary_id")
    private Long salary_id;

    //Adding relation to table: user
    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id",
            insertable = false, updatable = false)
    private User user;

    //Adding relation to table: course
    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id",
            insertable = false, updatable = false)
    private Course course;

    //Adding relation to table: salary
    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "salary_id", referencedColumnName = "salary_id", insertable = false, updatable = false)
    private Salary salary;
}
