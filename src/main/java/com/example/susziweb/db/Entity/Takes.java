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
@Table(name = "takes")
public class Takes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "class_num", insertable = false, updatable = false)
    private Long class_num;
    @Column(name = "album_num")
    private int album_num;
    @Column(name = "field_of_study")
    private String field_of_study;

    //Adding relation to table: user
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    //Adding relation to table: section
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "class_num")
    private Section section;

    @OneToMany(mappedBy = "takes")
    private List<Mark> marks;
}
