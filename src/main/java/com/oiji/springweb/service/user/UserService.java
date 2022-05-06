package com.oiji.springweb.service.user;

import com.oiji.springweb.dto.user.User;
import com.oiji.springweb.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserMapper userMapper;

    public boolean existsLoginId(String loginId) {
        if (!userMapper.findByLoginId(loginId).isEmpty())
            return true;
        return false;
    }

    public boolean existsName(String name) {
        if (!userMapper.findByLoginId(name).isEmpty())
            return true;
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        return userMapper.findByLoginId(loginId)
                .orElseThrow(() -> new UsernameNotFoundException((loginId)));
    }

    public void save(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuth("USER");
        userMapper.save(user);
    }
}
