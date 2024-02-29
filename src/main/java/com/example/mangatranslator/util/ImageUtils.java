package com.example.mangatranslator.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class ImageUtils {

        public static String encodeImageToBase64(Path imagePath) throws IOException {
            byte[] imageBytes = Files.readAllBytes(Path.of(imagePath.toUri()));
            return Base64.getEncoder().encodeToString(imageBytes);
        }
}
