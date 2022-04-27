package com.oiji.springweb.controller;

import com.oiji.springweb.dto.image.Image;
import com.oiji.springweb.dto.member.Member;
import com.oiji.springweb.service.image.FileStore;
import com.oiji.springweb.service.image.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.MalformedURLException;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ImageService imageService;
    private final FileStore fileStore;

    //@GetMapping("/")
    public String home(Model model) {
        List<Image> list = imageService.getHomeImageList();
        model.addAttribute("list", list);
        return "home";
    }

    @GetMapping("/")
    public String loginHome(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)
                    Member loginMember, Model model) {

        List<Image> list = imageService.getHomeImageList();
        model.addAttribute("list", list);

        if (loginMember == null) {
            return "home";
        }
        model.addAttribute("member", loginMember);
        return "loginHome";
    }

    @ResponseBody
    @GetMapping("/images/{imgPath}")
    public Resource loadImage(@PathVariable String imgPath) throws MalformedURLException {
        return new UrlResource("file:" + fileStore.getFullPath(imgPath));
    }
}
