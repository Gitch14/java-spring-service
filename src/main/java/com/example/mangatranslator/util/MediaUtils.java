package com.example.mangatranslator.util;

import com.example.mangatranslator.model.dto.MediaDTO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;


import static com.example.mangatranslator.util.FileConverter.fileBase64;

public class MediaUtils {

    public static String detectFileType(String filePath) throws IOException {
        File file = new File(filePath);
        String mimeType = Files.probeContentType(file.toPath());
        return mimeType;
    }


    public static MediaDTO encodeImageToBase64(String base64File) throws IOException {
        MediaDTO mediaDTO = new MediaDTO();
        String fileType = detectFileType(base64File);

       mediaDTO.setFormat("png");

        String file = base64File;


        String[] parts = file.split("base64,");
        String base64Data = parts[1];
        //String format = parts[0];
        mediaDTO.setType("image");

        mediaDTO.setData(base64Data);
        return mediaDTO;
    }
}
