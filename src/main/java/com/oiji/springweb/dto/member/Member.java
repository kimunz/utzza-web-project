package com.oiji.springweb.dto.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Member {

    @NotEmpty
    private String loginId;
    @NotEmpty
    private String password;
    @NotEmpty
    private String name;
    @NotEmpty
    private String email;

    public Member(String loginId, String password, String name, String email) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
