package com.faas.core.utils.config;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@Component
public class AppUtils {

    public String tokenGenerator() {
        return "token";
    }

    public boolean tokenValidator(String token) {
        return true;
    }

    public String base64Encoder(String value) {
        return Base64.getEncoder().encodeToString(value.getBytes());
    }

    public String base64Decoder(String value) {
        byte[] decodedBytes = Base64.getDecoder().decode(value);
        return new String(decodedBytes);
    }

    public long getCurrentTimeStamp() {
        Date date = new Date();
        return date.getTime();
    }

    public String urlEncodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public String generateUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }



    public String convertSmsType(String smsType){

        if (smsType.equalsIgnoreCase(AppConstant.FLASH_SMS)){
            return "1";
        }
        if (smsType.equalsIgnoreCase(AppConstant.STANDARD_SMS)){
            return "0";
        }
        return "";
    }

}
