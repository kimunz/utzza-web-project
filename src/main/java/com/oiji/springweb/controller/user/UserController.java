package com.oiji.springweb.controller.user;

import com.oiji.springweb.dto.user.User;
import com.oiji.springweb.entity.UserEntity;
import com.oiji.springweb.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;


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
    public String signUpForm(Model model) {

        model.addAttribute("user", new User());
        return "user/signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@Valid @ModelAttribute User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "user/signUp";
        }

        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/myPage")
    public String myPage(@AuthenticationPrincipal UserEntity user, Model model) {
        log.info("userName={}",user.getUsername());
        model.addAttribute("user", user);
        return "user/myPage";
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
