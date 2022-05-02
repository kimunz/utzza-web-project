package com.oiji.springweb.dto.user;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class User {

    @NotEmpty
    private String loginId;
    @NotEmpty
    private String password;
    @NotEmpty
    private String email;
    @NotEmpty
    private String name;

    public User(String loginId, String password, String email, String name) {
        this.loginId = loginId;
        this.password = password;
        this.email = email;
        this.name = name;
    }
}
