package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Donar;

@Repository
public interface DonarRepository extends JpaRepository<Donar,Integer> {
    
    @Modifying
    @Query("update Donar donar set donar.age = ?2 where donar.id = ?1")
    void updateAge(int id,int age);
}