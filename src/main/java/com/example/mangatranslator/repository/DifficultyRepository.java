package com.example.mangatranslator.repository;

import com.example.mangatranslator.model.Comment;
import com.example.mangatranslator.model.Difficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DifficultyRepository extends JpaRepository<Difficulty, Long> {
}
