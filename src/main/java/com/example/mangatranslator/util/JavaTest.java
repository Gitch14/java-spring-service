package com.example.mangatranslator.util;

import java.io.IOException;

import static com.example.mangatranslator.util.FileConverter.fileBase64;
import static com.example.mangatranslator.util.MediaUtils.encodeImageToBase64;


public class JavaTest {
    public static void main(String[] args) throws IOException {
       // fileBase64("C:\\Users\\VladyslavBukach\\IdeaProjects\\manga-translate-service\\java-spring-service\\src\\main\\resources\\static\\source\\test.jpg");
        encodeImageToBase64("C:\\Users\\VladyslavBukach\\IdeaProjects\\manga-translate-service\\java-spring-service\\src\\main\\resources\\static\\source\\vid.MP4");
    }
}
