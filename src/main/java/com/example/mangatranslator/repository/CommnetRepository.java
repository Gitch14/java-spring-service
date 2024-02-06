package com.example.mangatranslator.repository;

import com.example.mangatranslator.model.Comment;
import com.example.mangatranslator.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommnetRepository extends JpaRepository<Comment, Long> {
}
