package com.example.susziweb.Repository;

import com.example.susziweb.db.Entity.Teaches;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeachesRepository extends JpaRepository<Teaches, Long> {
    Teaches findTeachesByUser_id(Long user_id);
}
