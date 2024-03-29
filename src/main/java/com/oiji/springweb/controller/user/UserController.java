package com.oiji.springweb.controller.user;

import com.oiji.springweb.dto.user.PasswordInfo;
import com.oiji.springweb.dto.user.User;
import com.oiji.springweb.entity.UserEntity;
import com.oiji.springweb.service.user.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Slf4j
@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

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
            return "user/signUp";
        }

        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/myPage")
    public String myPage(@AuthenticationPrincipal UserEntity user, Model model) {
        model.addAttribute("user", user.toDto());
        return "user/myPage";
    }

    @PostMapping("/myPage")
    public String modifyInfo(@Valid @ModelAttribute User user, BindingResult bindingResult,
                             @AuthenticationPrincipal UserEntity userEntity) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (!bCryptPasswordEncoder.matches(user.getPassword(), userEntity.getPassword())) {
            bindingResult.reject("passwordError", "비밀번호가 맞지 않습니다.");
        }

        if (bindingResult.hasErrors()) {
            return "user/myPage";
        }
        userService.modifyInfo(userEntity.getUsername(), user);

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                user.getLoginId(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "redirect:/myPage";
    }

    @GetMapping("/myPage/pwd")
    public String changePwdForm(Model model) {
        model.addAttribute("pInfo", new PasswordInfo());
        return "user/pwdForm";
    }

    @PostMapping("/myPage/pwd")
    public String changePwd(@AuthenticationPrincipal UserEntity user,
                            @Valid @ModelAttribute(name = "pInfo") PasswordInfo passwordInfo,
                            BindingResult bindingResult) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (!bCryptPasswordEncoder.matches(passwordInfo.getPassword(), user.getPassword())) {
            bindingResult.reject("passwordError", "비밀번호가 맞지 않습니다.");
        }
        if (bindingResult.hasErrors()) {
            return "user/pwdForm";
        }
        userService.changePassword(user.getUsername(), bCryptPasswordEncoder.encode(passwordInfo.getNewPwd()));

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                user.getLoginId(), passwordInfo.getNewPwd()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "redirect:/myPage";
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
