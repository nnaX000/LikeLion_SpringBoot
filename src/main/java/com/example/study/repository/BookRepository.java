package com.example.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.study.entity.Book; // 올바른 Book 클래스
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>{

}
