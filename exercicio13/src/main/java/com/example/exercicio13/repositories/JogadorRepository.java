package com.example.exercicio13.repositories;

import com.example.exercicio13.models.JogadorEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JogadorRepository extends JpaRepository<JogadorEntidade, UUID> {
}
