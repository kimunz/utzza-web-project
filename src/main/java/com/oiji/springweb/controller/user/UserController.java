package com.oiji.springweb.controller.user;

import com.oiji.springweb.dto.login.LoginForm;
import com.oiji.springweb.dto.user.User;
import com.oiji.springweb.service.login.LoginService;
import com.oiji.springweb.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String loginForm() {
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login() {
        return "login/loginForm";
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/";
    }

    @GetMapping("/signUp")
    public String signUpForm() {
        return "user/signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/login";
    }
}
