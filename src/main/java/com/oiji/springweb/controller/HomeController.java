package com.oiji.springweb.controller;

import com.oiji.springweb.dto.image.Image;
import com.oiji.springweb.entity.ImageEntity;
import com.oiji.springweb.service.image.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ImageService imageService;

    @GetMapping("/")
    public String home(Model model) {
        List<Image> list = imageService.getHomeImageList();
        model.addAttribute("list", list);
        return "home";
    }

}
