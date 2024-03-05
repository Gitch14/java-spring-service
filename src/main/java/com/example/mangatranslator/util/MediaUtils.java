package com.example.mangatranslator.util;

import com.example.mangatranslator.model.dto.MediaDTO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class MediaUtils {

    public static MediaDTO encodeImageToBase64(String base64Image) {
        MediaDTO mediaDTO = new MediaDTO();

        String[] parts = base64Image.split("base64,");
        String base64Data = parts[1];
        String format = parts[0];

        if (format.contains("png") || format.contains("jpg") || format.contains("image")) {
            mediaDTO.setType("image");
            if (format.contains("png")) {
                mediaDTO.setFormat("png");
            } else if (format.contains("jpg")) {
                mediaDTO.setFormat("jpg");
            } else {
                mediaDTO.setFormat("unknown");
            }
        }

        mediaDTO.setData(base64Data);

        return mediaDTO;
    }
}
