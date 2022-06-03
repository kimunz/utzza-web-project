package com.oiji.springweb.entity;

import com.oiji.springweb.dto.user.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
public class UserEntity implements UserDetails {

    private String loginId;
    private String password;
    private String name;
    private String email;
    private String auth;

    public User toDto(){
        return new User(loginId, "", name, email, auth);
    }

    public UserEntity(String loginId, String password, String name, String email, String auth) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.auth = auth;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(this.auth));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.loginId;
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
