package com.faas.core.utils.config;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.Map;
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


    public String generateUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }



    public String convertSmsType(String smsType){
        if (smsType.equalsIgnoreCase(AppConstant.FLASH_MESSAGE)){
            return "1";
        }
        if (smsType.equalsIgnoreCase(AppConstant.TEXT_MESSAGE)){
            return "0";
        }
        return "";
    }


    public String getSelectedUrl(SessionDBModel sessionDBModel, ProcessDBModel processDBModel, String urlType){


        return null;
    }


    public String getValueFromMap(Map<String,String> stringMap,String key){

        if (stringMap != null && stringMap.get(key) != null){
            return stringMap.get(key);
        }
        return null;
    }

}
