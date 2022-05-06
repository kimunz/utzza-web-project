package com.oiji.springweb.controller.user;

import com.oiji.springweb.dto.user.User;
import com.oiji.springweb.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String loginForm() {
        return "user/loginForm";
    }

    @PostMapping("/login")
    public String login() {
        return "user/loginForm";
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

    @ResponseBody
    @PostMapping("/auth/loginId")
    public String confirmLoginId(String loginId) {
        if (userService.existsLoginId(loginId))
            return "fail";
        return "success";
    }

    @ResponseBody
    @PostMapping("/auth/name")
    public String confirmName(String name) {
        if (userService.existsName(name))
            return "fail";
        return "success";
    }
}
