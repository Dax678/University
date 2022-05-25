package com.example.susziweb.db.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "section_course")
public class Section_course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_id")
    private Long course_id;
    @Column(name = "class_num")
    private Long class_num;

    @OneToMany(mappedBy = "section_course")
    private List<Section> section;

    @OneToMany(mappedBy = "section_course")
    private List<Course> course;
}
