package com.oiji.springweb.controller.login;

import com.oiji.springweb.controller.SessionConst;
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
public class LoginController {

    private final LoginService loginService;
    private final UserService userService;

    //@GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
        return "login/loginForm";
    }

    //@PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult,
                        HttpServletRequest request) {

//        if (bindingResult.hasErrors()) {
//            return "login/loginForm";
//        }
//
//        User loginMember = loginService.login(form.getLoginId(), form.getPassword());
//        if (loginMember == null) {
//            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
//            return "login/loginForm";
//        }
//        HttpSession session = request.getSession();
//        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        return "redirect:/";
    }

    //@PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

    //@GetMapping("/signUp")
    public String signUpForm() {
        return "user/signUp";
    }

    //@PostMapping("/signUp")
    public String signUp(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/login";
    }
}
