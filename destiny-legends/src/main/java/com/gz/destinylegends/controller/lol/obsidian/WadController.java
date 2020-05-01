package com.gz.destinylegends.controller.lol.obsidian;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author Destiny_Xue
 * @Date 2019/10/23 17:44
 * @Description
 */
@RestController
@RequestMapping("lol/obsidian/wad")
public class WadController {

//    @Autowired
//    ObsidianFeign obsidianFeign;

    @PostMapping("convert")
    public Object convert(MultipartFile file) {
//        return obsidianFeign.convert(file);
        return null;
    }

    @PostMapping("toObj")
    public Object toObj(String hash) {

        return null;
    }
}
