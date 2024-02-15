package com.example.mangatranslator.repository;

import com.example.mangatranslator.model.Comment;
import com.example.mangatranslator.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
