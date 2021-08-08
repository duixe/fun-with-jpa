package com.akomaning.springdatajpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "subject")
public class SubjectResource {

    @Id
    @SequenceGenerator(
            name = "subject_resource_sequence",
            sequenceName = "subject_resource_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subject_resource_sequence"
    )
    private Long id;
    private String link;

    //fetchType.Lazy allows activates Lazy fetching from the parent -
    // meaning, the SubjectResource data is only fetched when queried
    //Nb: with the optional param, you'll have to define a subject when
    //saving a subjectResource - subject is compulsory
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "id"
    )
    private Subject subject;
}
