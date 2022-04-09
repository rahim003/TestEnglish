package com.example.testenglish.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "questions")
public class Question {
    @Id
    @SequenceGenerator(name = "questions_sequence",
            sequenceName = "questions_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "questions_sequence")
    private Long id;

    private String question;
    @ManyToOne(cascade = {DETACH, REFRESH, PERSIST, MERGE})
    @JoinColumn(name = "test_id")

    private Test test;
    @OneToMany(cascade = ALL, mappedBy = "question")


    private List<Answers> answers;
}
