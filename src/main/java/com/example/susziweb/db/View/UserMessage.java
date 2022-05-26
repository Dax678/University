package com.example.susziweb.db.View;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "user_messages_with_info")
public class UserMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receiver_id")
    private Long receiver_id;

    @Column(name = "receiver_name")
    private String receiver_name;

    @Column(name = "message_title")
    private String message_title;

    @Column(name = "body")
    private String body;

    @Column(name = "send_date")
    private Date send_date;

    @Column(name = "sender")
    private String sender;
}
