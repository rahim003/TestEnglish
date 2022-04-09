package com.example.testenglish.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "results")
public class Result {
    @Id
    @SequenceGenerator(name = "results_sequence",
            sequenceName = "results_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "results_sequence")
    private Long id;
}
