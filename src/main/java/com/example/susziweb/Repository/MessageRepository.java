package com.example.susziweb.Repository;

import com.example.susziweb.db.Entity.User;
import com.example.susziweb.db.View.UserMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<UserMessage, Long> {

    @Query(
            value = "SELECT usm " +
                    "FROM UserMessage usm " +
                    "WHERE usm.receiver_name = :#{#user.login}"
    )
    List<UserMessage> findUserMessageByReceiver_name(@Param("user") User user);
}
