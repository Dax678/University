package com.example.susziweb.db.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "message", schema = "public")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;

    @Column(name = "body")
    private String body;

    @Column(name = "send_date")
    private Date send_date;

    @Column(name = "message_read_state")
    private String message_read_state;

    @Column(name = "read_date")
    private Date read_date;

    @Column(name = "sender")
    private Long sender;

    @Column(name = "message_title")
    private String title;

    @OneToMany(mappedBy = "messages")
    private List<User_message> user_messages;
}
