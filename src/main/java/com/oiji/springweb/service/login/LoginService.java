package com.oiji.springweb.service.login;

import com.oiji.springweb.dao.LoginDao;
import com.oiji.springweb.dto.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginDao loginDao;

    public Member login(String loginId, String password) {
        return loginDao.findByLoginId(loginId);
    }
}
