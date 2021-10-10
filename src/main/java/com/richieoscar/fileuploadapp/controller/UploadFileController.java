package com.richieoscar.fileuploadapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadFileController {
    private  Map<String, Object> result= new HashMap<>();

    @RequestMapping("/upload")
    public Map<String, Object> uploadFile(@RequestParam("attach")MultipartFile file) throws IOException {

        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());
        String filePath = "C:\\Users\\NAJCOM LAPTOP 4\\Documents";
        file.transferTo(new File(filePath, file.getOriginalFilename()));
        result.put("Succes", true);
        return result;
    }
}
