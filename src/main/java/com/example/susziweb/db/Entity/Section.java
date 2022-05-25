package com.example.susziweb.db.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_num")
    private Long id;
    @Column(name = "semester")
    private String semester;
    @Column(name = "year")
    private int year;
    @Column(name = "room_no")
    private String room_no;

    @OneToOne(mappedBy = "section", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "class_num", referencedColumnName = "class_num")
    private Takes takes;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "class_num", referencedColumnName = "class_num",
            insertable = false, updatable = false)
    private Section_course section_course;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "class_num", referencedColumnName = "class_num",
            insertable = false, updatable = false)
    private Time_slot time_slot;
}
