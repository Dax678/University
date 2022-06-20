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
@Table(name = "user_message_with_informations")
public class UserMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;

    @Column(name = "username")
    private String receiver_name;

    @Column(name = "message_title")
    private String message_title;

    @Column(name = "body")
    private String body;

    @Column(name = "send_date")
    private Date send_date;

    @Column(name = "read_date")
    private Date read_date;

    @Column(name = "sender_username")
    private String sender_name;
}
