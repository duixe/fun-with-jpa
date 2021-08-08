package com.akomaning.springdatajpa.repository;

import com.akomaning.springdatajpa.entity.Subject;
import com.akomaning.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void saveTeacher() {
        Subject subject = Subject.builder()
                .title("Social Studies")
                .score(60)
                .build();

        Subject subject2 = Subject.builder()
                .title("I.C.T")
                .score(75)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Kwame")
                .lastName("teacherOne")
                .staffId("stfkwt")
//                .subjects(List.of(subject, subject2))
                .build();

        teacherRepository.save(teacher);
    }
}