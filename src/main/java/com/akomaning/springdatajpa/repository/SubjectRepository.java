package com.akomaning.springdatajpa.repository;

import com.akomaning.springdatajpa.entity.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Page<Subject> findByTitleContaining(String title, Pageable pageable);
}
