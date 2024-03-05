package com.example.mangatranslator.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class FileConverter {

    public static String fileBase64(String base64File) {
        byte[] fileContent = new byte[0];
        try {
            fileContent = FileUtils.readFileToByteArray(new File(base64File));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        System.out.println(encodedString);
        return encodedString;
    }
}
