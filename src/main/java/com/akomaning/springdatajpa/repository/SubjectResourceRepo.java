package com.akomaning.springdatajpa.repository;

import com.akomaning.springdatajpa.entity.SubjectResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectResourceRepo extends JpaRepository<SubjectResource, Long> {
}
