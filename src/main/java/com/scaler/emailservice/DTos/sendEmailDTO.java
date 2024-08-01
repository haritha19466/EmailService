package com.scaler.emailservice.DTos;

import lombok.Data;

@Data
public class sendEmailDTO {
    private String from;
    private String to;
    private String body;
    private String message;
}
