package com.akomaning.springdatajpa.entity;

import com.akomaning.springdatajpa.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String staffId;

    //👇 defining a OneToMany Relationship
    //However it is advisable to use Many-to-One Relationship
    //by Jpa
    /**@OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "id"
    )
    List<Subject> subjects;
    **/
}
