package com.example.testenglish.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Data
public class Role implements GrantedAuthority {
    @Id
    @SequenceGenerator(name = "role_sequence",
            sequenceName = "role_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "role_sequence")
    private Long id;
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
