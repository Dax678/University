package com.example.susziweb.db.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "time_slot", schema = "public")
public class Time_slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="course_id")
    private Long course_id;

    @Column(name="class_num")
    private Long class_num;

    @Column(name="day")
    private String day;

    @Column(name="start_time")
    private Time start_time;

    @Column(name="end_time")
    private Time end_time;

    @OneToMany(mappedBy = "time_slot")
    private List<Section> sectionT;

    @OneToMany(mappedBy = "time_slot")
    private List<Course> courseT;
}
