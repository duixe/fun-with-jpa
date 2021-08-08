package com.akomaning.springdatajpa.repository;

import com.akomaning.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    //find by firstName (column in a DB)
    List<Student> findByFirstName(String firstName);

    // find by firtsName column with a some string specifications
    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    //query creation from method names
    Student findByFirstNameAndLastName(String firstName, String lastName);

    //NB: Student is used because jpql requires the class name representation
    //of the database Table
    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String email);

    //Selecting a particular column
    //JPQL
    @Query("select s.guardian.name from Student s where s.emailId = ?1")
    String getStudentGuardianNameByEmailAddress(String email);

    //using a native SQL query instead of JPQL
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressSQL(String email);

    //using a native SQL query with Named Parameter
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNamedParam(@Param("emailId") String email);


    //----------update DB queries ------------//
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE tbl_student set first_name = ?1 WHERE email_address = ?2",
            nativeQuery = true
    )
    int updateStudentFirstNameByEmail(String firstName, String emailId);

}
