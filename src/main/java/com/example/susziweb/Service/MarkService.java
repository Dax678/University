package com.example.susziweb.Service;

import com.example.susziweb.Repository.MarkRepository;
import com.example.susziweb.db.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {
    private final MarkRepository markRepository;

    public MarkService(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    public List<Object[]> findUserMarks(User user) {
        return markRepository.findUserMarks(user);
    }
}
