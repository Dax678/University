package com.example.susziweb.Service;

import com.example.susziweb.Repository.TeachesRepository;
import com.example.susziweb.db.Entity.Teaches;
import org.springframework.stereotype.Service;

@Service
public class TeachesService {
    private final TeachesRepository teachesRepository;

    public TeachesService(TeachesRepository teachesRepository) {
        this.teachesRepository = teachesRepository;
    }

    public Teaches findTeachesById(Long id) {
        return teachesRepository.findTeachesByUser_id(id);
    }
}
