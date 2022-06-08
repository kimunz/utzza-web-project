package com.oiji.springweb.controller.image;

import com.oiji.springweb.dto.image.Image;
import com.oiji.springweb.service.image.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SpecificController {

    private final ImageService imageService;

    @GetMapping("/theme")
    public String themeImage(@RequestParam String item, Model model) {
        List<Image> list = imageService.getImageList(item, 1);
        model.addAttribute("list", list);

        return "image/theme";
    }

    @GetMapping("/situation")
    public String situationImage(@RequestParam String item, Model model) {
        List<Image> list = imageService.getImageList(item, 1);
        model.addAttribute("list", list);

        return "image/situation";
    }
}
