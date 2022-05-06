package com.oiji.springweb.controller;

import com.oiji.springweb.dto.image.Image;
import com.oiji.springweb.service.image.FileStore;
import com.oiji.springweb.service.image.ImageService;
import com.oiji.springweb.service.image.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ImageService imageService;
    private final FileStore fileStore;

    @GetMapping("/")
    public String home(Model model) {
        List<Image> list = imageService.getHomeImageList();
        model.addAttribute("list", list);
        return "home";
    }

    @ResponseBody
    @GetMapping("/storage/{imgPath}")
    public Resource loadImage(@PathVariable String imgPath) throws MalformedURLException {
        return new UrlResource("file:" + fileStore.getFullPath(imgPath));
    }

    @ResponseBody
    @GetMapping("/ajax/more")
    public String moreList(String query, int page) {


    }
}
