package com.example.mangatranslator.model.dto;

import lombok.Data;

@Data
public class MediaDTO {
    private String type; // (image или video)
    private String format; // format(png, jpeg, mp4 и т.д.)
    private String data; // data in format Base64


}
