package com.example.testenglish.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.REFRESH;

@Entity
@NoArgsConstructor
@Data
@Table(name = "answers")
public class Answers {
    @Id
    @SequenceGenerator(name = "answers_sequence",
            sequenceName = "answers_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "answers_sequence")
    private Long id;
    private String answer;
    private boolean trueAnswer = false;
    @ManyToOne(cascade = {MERGE, PERSIST, DETACH, REFRESH})
    @JoinColumn(name = "question_id")
    private Question question;
}
