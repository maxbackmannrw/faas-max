package com.faas.core.rest.client.utility;

import com.faas.core.rest.client.content.RestClient;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Component
public class UtilityRestClient {

    @Autowired
    RestClient restClient;

    @Autowired
    AppUtils appUtils;


    public String urlShortener(String httpUrl) throws IOException {

        String requestUrl = restClient.urlBuilder(AppConstant.URL_SHORTENER_API_URL,"",null);

        Gson gson = new Gson();
        Map<String, String> bodyObjs = new HashMap<>();
        bodyObjs.put("originalUrl", httpUrl);

        String response = restClient.sendPostJsonRequest(requestUrl,gson.toJson(bodyObjs));
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonObject("data").get("shortUrl").getAsString();
        }
        return null;
    }



}
