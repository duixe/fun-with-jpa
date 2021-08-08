package com.akomaning.springdatajpa.repository;

import com.akomaning.springdatajpa.entity.Subject;
import com.akomaning.springdatajpa.entity.SubjectResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SubjectResourceRepoTest {

    @Autowired
    private SubjectResourceRepo repository;

    @Test
    void saveSubjectResource() {
        Subject subject = Subject.builder()
                .title("Core Maths")
                .score(70)
                .build();
        SubjectResource subjectResource = SubjectResource.builder()
                .link("www.wikipedia.com")
                .subject(subject)
                .build();

        repository.save(subjectResource);
    }

    @Test
    void getAllSubjectResources() {
        List<SubjectResource> subjectResources = repository.findAll();
        System.out.println("Subject Resources: " + subjectResources);
    }
}