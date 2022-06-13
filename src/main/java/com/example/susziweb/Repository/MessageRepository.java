package com.example.susziweb.Repository;

import com.example.susziweb.db.Entity.User;
import com.example.susziweb.db.View.UserMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<UserMessage, Long> {
    /*@Query(value = "SELECT usm.sender, usm.receiver_name, usm.message_title, usm.body, usm.send_date " +
            "FROM UserMessage usm " +
            "WHERE usm.receiver_id = :#{#user.id}")
    List<UserMessage> findUserMessages(@Param("user") User user);

    @Query(value = "SELECT usm.sender, usm.receiver_name, usm.message_title, usm.body, usm.send_date " +
            "FROM UserMessage usm " +
            "WHERE usm.sender = :#{#user.id}")
    List<UserMessage> findSendMessages(@Param("user") User user);*/
}
