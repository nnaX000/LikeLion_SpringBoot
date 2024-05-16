package com.example.study.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.study.entity.Item; // 올바른 Book 클래스

public interface ItemRepository extends JpaRepository<Item,Long>{
}