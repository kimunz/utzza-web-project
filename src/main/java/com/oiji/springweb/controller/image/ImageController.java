package com.oiji.springweb.controller.image;

import com.oiji.springweb.dto.image.Image;
import com.oiji.springweb.service.image.FileStore;
import com.oiji.springweb.service.image.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;
    private final FileStore fileStore;

    @GetMapping("/view")
    public String detailedImage(@RequestParam String id, Model model) {
        imageService.updateImageHit(id);
        Image image = imageService.getImageById(id);
        model.addAttribute("image", image);
        return "image/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam String q, Model model) {
        List<Image> list = imageService.getImageList(q, 1);
        model.addAttribute("list", list);
        return "image/search";
    }

    @GetMapping("/upload")
    public String uploadForm() {
        return "image/uploadForm";
    }

    @PostMapping("/upload")
    public String saveImage(@RequestParam("file") MultipartFile file,
                            @RequestParam(required = false) String theme,
                            @RequestParam(required = false) String context,
                            @RequestParam String[] keyword) throws IOException {

        if (theme.equals("none")) {
            theme = null;
        }
        if (context.equals("none")) {
            context = null;
        }

        String imgPath = fileStore.storeImage(file);
        String title = String.join(" ", keyword);
        imageService.addImage(title, imgPath, theme, context);

        return "redirect:/upload";
    }

    @ResponseBody
    @GetMapping("/ajax/list")
    public String moreList(@RequestParam String q, @RequestParam int page) {
        List<Image> list = imageService.getImageList(q, page);
        JSONArray jary = new JSONArray();

        if (list.isEmpty()) {
            jary.put("none");
        } else {
            for (Image img : list) {
                JSONObject json = new JSONObject();

                JSONArray titleArr = new JSONArray();
                for (String t : img.getTitle()) {
                    titleArr.put(t);
                }

                json.put("id", img.getId());
                json.put("title", titleArr);
                json.put("imgPath", img.getImgPath());
                json.put("hit", img.getHit());
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

    @GetMapping("/download/{imgPath}")
    public void downloadImage(@PathVariable String imgPath, HttpServletResponse response) throws IOException {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmSS");
        String time = dateFormat.format(cal.getTime());
        String ext = fileStore.extractExt(imgPath);

        String realFile = fileStore.getFullPath(imgPath);

        BufferedOutputStream out = null;
        InputStream in = null;

        try {
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "inline;filename="+ time + "." + ext);
            File file = new File(realFile);
            if(file.exists()) {
                in = new FileInputStream(file);
                out = new BufferedOutputStream(response.getOutputStream());
                int len;
                byte[] buf = new byte[1024];
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(out != null) { out.flush();}
            if(out != null) { out.close();}
            if(out != null) { in.close();}
        }
    }
}
