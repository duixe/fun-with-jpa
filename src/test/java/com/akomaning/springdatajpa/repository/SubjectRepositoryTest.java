package com.akomaning.springdatajpa.repository;

import com.akomaning.springdatajpa.entity.Student;
import com.akomaning.springdatajpa.entity.Subject;
import com.akomaning.springdatajpa.entity.Teacher;
import org.aspectj.weaver.ast.Var;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SubjectRepositoryTest {

    @Autowired
    private SubjectRepository subjectRepository;

    @Test
    void getAllSubjects() {
        List<Subject> subjects = subjectRepository.findAll();
        System.out.println("List of Subjects: " + subjects);
    }

    @Test
    void saveSubjectWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Kweku")
                .lastName("Appiah")
                .staffId("stfkwt")
                .build();

        Subject subject = Subject.builder()
                .title("Core English")
                .score(75)
                .teacher(teacher)
                .build();

        subjectRepository.save(subject);
    }

    //Pagination
    @Test
    void gettingPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Subject> subjects = subjectRepository
                .findAll(secondPageWithTwoRecords)
                .getContent();

        Long totalElements = subjectRepository
                .findAll(secondPageWithTwoRecords)
                .getTotalElements();

        int totalPages = subjectRepository
                .findAll(secondPageWithTwoRecords)
                .getTotalPages();

        System.out.println("Total Elements: " + totalElements);
        System.out.println("Total Pages: " + totalPages);
        System.out.println("Subjects: " + subjects);
    }

    @Test
    void getAllBySorting() {
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByScoreDesc = PageRequest.of(
                0,
                2,
                 Sort.by("score").descending()
        );
        Pageable sortByTitleAndCreditDesc = PageRequest.of(
                0,
                2,
                Sort.by("title").descending().and(Sort.by("score"))
        );

        List<Subject> subjects = subjectRepository.findAll(sortByTitle).getContent();
        System.out.println("Subjects: " + subjects);
    }

    @Test
    void getfindByTitleContaining() {
        Pageable firstPageThreeRecords = PageRequest.of(0, 3);
        List<Subject> subjects = subjectRepository
                .findByTitleContaining("C", firstPageThreeRecords).getContent();

        System.out.println("Subjects: " + subjects);
    }

    @Test
    void saveSubjectWithStudentAndTeacher() {
        Teacher teacher = Teacher
                .builder()
                .firstName("Ojoku")
                .lastName("kenny")
                .staffId("stfjkl")
                .build();

        Student student = Student
                .builder()
                .firstName("Joshua")
                .lastName("Atinga")
                .emailId("student@stu.gmail")
                .build();

        Subject subject = Subject
                .builder()
                .title("Technical Draawing")
                .score(60)
                .teacher(teacher)
                .build();

        subject.addStudents(student);

        subjectRepository.save(subject);
    }
}