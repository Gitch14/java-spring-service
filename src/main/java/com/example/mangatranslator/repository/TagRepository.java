package com.example.mangatranslator.repository;

import com.example.mangatranslator.model.Genre;
import com.example.mangatranslator.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
