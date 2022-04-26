package com.oiji.springweb.controller;

import com.oiji.springweb.dao.ImageDao;
import com.oiji.springweb.dto.image.Image;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.MalformedURLException;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ImageDao imageDao;

    @Value("${file.dir}")
    private String fileDir;

    @GetMapping("/")
    public String home(Model model) {
        int page = 1;
        List<Image> list = imageDao.getImageList("", page);
        model.addAttribute("list", list);

        return "home";
    }

    @ResponseBody
    @GetMapping("/images/{imgPath}")
    public Resource loadImage(@PathVariable String imgPath) throws MalformedURLException {
        log.info("imgPath={}", imgPath);
        return new UrlResource("file:" + fileDir + imgPath);
    }
}
