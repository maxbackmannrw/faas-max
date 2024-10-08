package com.faas.core.misc.rest.utility;

import com.faas.core.misc.config.AppConstant;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Component
public class CommonRestCall {

    @Autowired
    RestCallTemplate restCallTemplate;


    public Map<String, String> urlShortenerRest(String httpUrl) throws IOException {

        Map<String, String> formData = new HashMap<>();
        formData.put("apiKey", AppConstant.URL_SHORTENER_API_KEY);
        formData.put("url", httpUrl);

        String response = restCallTemplate.callPostXFormRequest(restCallTemplate.httpUrlBuilder(AppConstant.URL_SHORTENER_API_URL, "/create", null), formData);
        if (response != null) {
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            if (resObject.get("success").getAsBoolean()) {
                Map<String, String> urlShortMap = new HashMap<>();
                if (resObject.get("linkId") != null) {
                    urlShortMap.put("linkId", resObject.get("linkId").getAsString());
                }
                if (resObject.get("statsUrl") != null) {
                    urlShortMap.put("statsUrl", resObject.get("statsUrl").getAsString());
                }
                if (resObject.get("shortnedUrl") != null) {
                    urlShortMap.put("shortnedUrl", resObject.get("shortnedUrl").getAsString());
                }
                return urlShortMap;
            }
        }
        return null;
    }


}
