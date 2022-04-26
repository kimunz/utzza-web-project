package com.oiji.springweb.dto.member;

import lombok.Data;

@Data
public class Member {

    private String loginId;
    private String password;
    private String name;
    private String email;

    public Member(String loginId, String password, String name, String email) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
