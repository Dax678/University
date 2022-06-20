package com.example.susziweb.Repository;

import com.example.susziweb.db.Entity.Teaches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeachesRepository extends JpaRepository<Teaches, Long> {
    Teaches findTeachesByUser_id(Long user_id);

    @Query(
            value =
                    "SELECT usd.name, usd.surname, co.name, cod.level " +
                            "FROM User us " +
                            "JOIN Teaches te " +
                            "ON us.id=te.user_id " +
                            "JOIN Course co " +
                            "ON te.course_id=co.id " +
                            "JOIN User_details usd " +
                            "ON usd.id=us.id " +
                            "JOIN Course_details  cod " +
                            "ON co.id=cod.id " +
                            "WHERE co.id=5"
    )
    List<Object[]> findAllEnglishTeachers();
}
