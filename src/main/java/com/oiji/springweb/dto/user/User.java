package com.oiji.springweb.dto.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class User {

    @NotEmpty
    private String loginId;
    @NotEmpty
    private String password;
    @NotEmpty
    private String name;
    @NotEmpty
    private String email;
    @NotEmpty
    private String auth;

    public User(String loginId, String password, String name, String email, String auth)  {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.auth = auth;
    }
}
