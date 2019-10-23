package com.gz.destinylegends.util.file;

import cn.hutool.core.io.FileTypeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author Destiny_Xue
 * @Date 2019/9/14 12:24
 * @Description TODO 文件工具类
 */
@Slf4j
public class FileUtils {

    /**
     * 保存文件
     * @param multipartFile 文件
     * @param path 保存路径
     * @return 相对路径
     */
    public String save(MultipartFile multipartFile, String path){

        try {
            String type = FileTypeUtil.getType(multipartFile.getInputStream());


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
