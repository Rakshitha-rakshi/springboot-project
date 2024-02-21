package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Charity;

@Repository
public interface CharityRepo extends JpaRepository<Charity,Integer>{
}