package com.example.susziweb.Service;

import com.example.susziweb.Repository.MessageRepository;
import com.example.susziweb.db.Entity.User;
import com.example.susziweb.db.View.UserMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<UserMessage> findUserMessageByReceiver_name(User user) {
        return messageRepository.findUserMessageByReceiver_name(user);
    }

    public List<UserMessage> findAllMessages() {
        return messageRepository.findAll();
    }
}
