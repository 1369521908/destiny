package com.gz.destinylegends.feign;

import com.gz.destinylegends.config.feign.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = Constant.SERVICE_OBSIDIAN, path = Constant.PATH_OBSIDIAN,
        configuration = FeignConfiguration.class)
public interface ObsidianFeign {

    @PostMapping(value = Constant.OBSIDIAN_CONVERT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String convert(@RequestPart(value = "file") MultipartFile file);
}
