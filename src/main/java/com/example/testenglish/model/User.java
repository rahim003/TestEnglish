package com.example.testenglish.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @SequenceGenerator(name = "users_sequence",
            sequenceName = "users_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "users_sequence")
    private Long id;
    private String name;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isCredentialsNonExpired = true;
    private boolean isEnabled = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.synchronizedCollection(roles);
    }

    @Override
    public String getUsername() {
        return email;
    }

    public void setRoles(Role role){
        if(roles == null){
            roles = new ArrayList<>();
        }
        roles.add(role);
    }
}
