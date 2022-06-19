package com.example.susziweb.Repository;

import com.example.susziweb.db.Entity.Course;
import com.example.susziweb.db.Entity.Mark;
import com.example.susziweb.db.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark, Long> {
    @Query(
            value = "SELECT co.name, co.type, ( " +
                    "SELECT usd_ins " +
                    "FROM Teaches te " +
                    "JOIN User us_ins " +
                    "ON us_ins.id=te.user_id " +
                    "JOIN User_details usd_ins " +
                    "ON us_ins.id=usd_ins.id " +
                    "WHERE te.course_id=co.id " +
                    ") as teacher_name " +
                    "FROM User us " +
                    "JOIN User_details usd " +
                    "ON us.id=usd.id " +
                    "JOIN Takes ta " +
                    "ON us.id=ta.id " +
                    "JOIN Mark ma " +
                    "ON ta.id=ma.user_id " +
                    "JOIN Course co " +
                    "ON ma.course_id=co.id " +
                    "WHERE us.login= :#{#user.login} " +
                    "GROUP BY co.name, co.type, teacher_name"
    )
    List<Object[]> findUserMarks(@Param("user") User user);

    @Query(
            value = "SELECT ma " +
                    "FROM User us " +
                    "JOIN Takes ta " +
                    "ON us.id=ta.id " +
                    "JOIN Mark ma " +
                    "ON ma.user_id=ta.id " +
                    "JOIN Course co " +
                    "ON ma.course_id=co.id " +
                    "WHERE us.id= :#{#user.id} AND co.id= :#{#course.id}"
    )
    List<Mark> findMarksById(@Param("user") User user, @Param("course") Course course);
}
