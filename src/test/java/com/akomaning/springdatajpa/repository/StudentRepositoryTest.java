package com.akomaning.springdatajpa.repository;

import com.akomaning.springdatajpa.entity.Guardian;
import com.akomaning.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.sql.SQLOutput;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void saveStudent() {
        Student student = Student.builder()
                .emailId("duixe@eachap.com")
                .firstName("emma")
                .lastName("Sunny")
//                .guardianName("kwabena")
//                .guardianEmail("ojoku@gmail.dev")
//                .guardianMobile("777-555-344")
                .build();

        studentRepository.save(student);
    }

    //test after extracting Guardian and making it an extendable
    @Test
    void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("addo kuffour")
                .email("addo@junk.gmail")
                .mobile("777-222-345")
                .build();

        Student student = Student.builder()
                .firstName("shegs")
                .lastName("appiah")
                .emailId("sheg@gmail.io")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    void getAllStudent() {
        List<Student> studentList =
                studentRepository.findAll();
        System.out.println("list_of_student = " + studentList);
    }

    @Test
    void getStudentByFirstName() {

        List<Student> student = studentRepository.findByFirstName("emma");
        System.out.println("student: " + student);
    }

    @Test
    void getStudentByFirstNameContaining() {
        List<Student> student = studentRepository.findByFirstNameContaining("gs");
        System.out.println("student: " + student);
    }

    @Test
    void getStudentPerGuardianName() {
        List<Student> student = studentRepository.findByGuardianName("addo kuffour");
        System.out.println("student: " + student);
    }

    @Test
    void getStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("sheg@gmail.io");
        System.out.println("student: " + student);
    }

    @Test
    void getGuardianNameByStudentEmailAddress() {
        String guardianName = studentRepository.getStudentGuardianNameByEmailAddress("sheg@gmail.io");
        System.out.println("student: " + guardianName);
    }

    @Test
    void getStudentByEmailAddressSQL() {
        Student student = studentRepository.getStudentByEmailAddressSQL("sheg@gmail.io");
        System.out.println("student: " + student);
    }

    @Test
    void getStudentByEmailAddressNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNamedParam("duixe@eachap.com");
        System.out.println("student: " + student);
    }

    @Test
    void updateStudentFirstNameByEmail() {
        studentRepository.updateStudentFirstNameByEmail(
                "upated_emma",
                "duixe@eachap.com"
        );
    }

}