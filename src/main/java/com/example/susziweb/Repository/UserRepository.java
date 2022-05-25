package com.example.susziweb.Repository;

import com.example.susziweb.db.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByLogin(String login);

    @Query(
            value = "SELECT usf " +
            "FROM User us " +
            "JOIN User_details usf " +
            "ON usf.id=us.id " +
            "WHERE us.login = :#{#user.login}"
    )
    User_details findUserDetailsByUsername(@Param("user") User user);

    @Query(
            value = "SELECT us.login, ro.role_full_name " +
                    "FROM User us " +
                    "JOIN Role ro " +
                    "ON us.role_id=ro.id " +
                    "GROUP BY us.login, ro.role_full_name"
    )
    List<Object[]> findAllUsersWithRole();

    @Query(
            value = "SELECT ro.role_full_name " +
                    "FROM User us " +
                    "JOIN Role ro " +
                    "ON us.role_id=ro.id " +
                    "WHERE us.login = :#{#user.login}"
    )
    String findUserRole(@Param("user") User user);

    @Query(
            value = "SELECT ta.album_num, ta.field_of_study, co.dept_name, se.year, se.semester " +
                    "FROM User us " +
                    "JOIN Takes ta " +
                    "ON us.id=ta.id " +
                    "JOIN Section se " +
                    "On ta.class_num=se.id " +
                    "JOIN Section_course sec " +
                    "ON se.id=sec.class_num " +
                    "JOIN Course co " +
                    "ON sec.course_id=co.id " +
                    "WHERE us.login = :#{#user.login}"
    )
    List<Object[]> findUserSectionInfo(@Param("user") User user);

    @Query(value = "SELECT mes " +
            "FROM User us " +
            "JOIN User_message usm " +
            "ON us.id=usm.user_id " +
            "JOIN Message mes " +
            "ON usm.message_id=mes.id " +
            "WHERE us.login= :#{#user.login}")
    List<Message> findAddressedToUserMessages(@Param("user") User user);
}
