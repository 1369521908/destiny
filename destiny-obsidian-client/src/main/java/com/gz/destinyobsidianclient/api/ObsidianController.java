package com.gz.destinyobsidianclient.api;

import com.gz.destinyobsidianclient.feign.ObsidianFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Author Destiny_Xue
 * @Date 2019/10/23 1:46
 * @Description
 */
@RestController
@RequestMapping("api/obsidian")
public class ObsidianController {

    @Autowired
    ObsidianFeign obsidianFeign;

    @PostMapping("convert")
    public Object convert(MultipartFile file) throws IOException {
        return obsidianFeign.convert(file);
    }
}
