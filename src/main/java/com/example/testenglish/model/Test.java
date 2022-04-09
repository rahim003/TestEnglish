package com.example.testenglish.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@Data
@Table(name = "tests")
public class Test {
    @Id
    @SequenceGenerator(name = "tests_sequence",
            sequenceName = "tests_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "tests_sequence")
    private Long id;
    @JoinColumn(name = "test_name")
    private String testName;
    private String duration;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "test")
    private List<Question> questions;
    @ManyToMany
    private List<User> users;
}
