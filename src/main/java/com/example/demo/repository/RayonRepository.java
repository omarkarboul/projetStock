package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Rayon;

@Repository
public interface RayonRepository extends JpaRepository<Rayon, Long>{

}
