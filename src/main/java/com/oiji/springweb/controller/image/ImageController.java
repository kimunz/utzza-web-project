package com.oiji.springweb.controller.image;

import com.oiji.springweb.dto.image.Image;
import com.oiji.springweb.service.image.FileStore;
import com.oiji.springweb.service.image.ImageService;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.MalformedURLException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;
    private final FileStore fileStore;

    @GetMapping("/view")
    public String detailedImage(@RequestParam String id, Model model) {
        Image image = imageService.getImageById(id);
        model.addAttribute("image", image);
        return "";
    }

    @GetMapping("/search")
    public String search(@RequestParam String q, Model model) {
        List<Image> list = imageService.getImageList(q, 1);
        model.addAttribute("list", list);
        return "image/search";
    }

    @ResponseBody
    @GetMapping("/ajax/list")
    public String moreList(@RequestParam String query, int page) {
        List<Image> list = imageService.getImageList(query, page);
        JSONArray jary = new JSONArray();

        if(list.isEmpty()) {
            jary.put("none");
        }
        else {
            for(Image li : list) {
                JSONObject json = new JSONObject();
                JSONArray titleArr = new JSONArray();
                for(String t: li.getTitle()) {
                    titleArr.put(t);
                }
                json.put("id", li.getId());
                json.put("title", titleArr);
                json.put("imgPath", li.getImgPath());
                json.put("hit", li.getHit());
                jary.put(json);
            }
        }
        return jary.toString();
    }

    @ResponseBody
    @GetMapping("/storage/{imgPath}")
    public Resource loadImage(@PathVariable String imgPath) throws MalformedURLException {
        return new UrlResource("file:" + fileStore.getFullPath(imgPath));
    }
}
