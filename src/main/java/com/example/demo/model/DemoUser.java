package com.example.demo.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.enums.UserRoles;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
// import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class DemoUser implements UserDetails{
    @Id
    @GeneratedValue
    private Integer id;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRoles role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));    
    }
    @Override
    public String getUsername() {
        return this.email;
    }
    @Override
    public String getPassword(){
        return this.password;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
        }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
