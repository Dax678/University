package com.example.susziweb.Service;

import com.example.susziweb.Repository.MarkRepository;
import com.example.susziweb.db.Entity.Course;
import com.example.susziweb.db.Entity.Mark;
import com.example.susziweb.db.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MarkService {
    private final MarkRepository markRepository;

    public MarkService(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    public List<Object[]> findUserMarks(User user) {
        return markRepository.findUserMarks(user);
    }

    public List<Mark> findMarksById(User user, Course course) {
        return markRepository.findMarksById(user, course);
    }
}
