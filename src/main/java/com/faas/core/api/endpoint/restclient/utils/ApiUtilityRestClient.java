package com.faas.core.api.endpoint.restclient.utils;

import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Component
public class ApiUtilityRestClient {

    private final OkHttpClient client = new OkHttpClient();

    @Autowired
    AppUtils appUtils;


    public String createShorterUrl(String pwaLink) throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Gson gson = new Gson();
        MediaType JSON = MediaType.get("application/json; charset=utf-8");

        Map<String, String> jsonObj = new HashMap<>();
        jsonObj.put("originalUrl", pwaLink);
        String jsonString = gson.toJson(jsonObj);

        RequestBody body = RequestBody.create(jsonString, JSON);
        Request request = new Request.Builder()
                .url(AppConstant.URL_SHORTENER_API_ENDPOINT)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.body() != null) {
                JsonObject resJsonObject = JsonParser.parseString(response.body().string()).getAsJsonObject();
                return resJsonObject.getAsJsonObject("data").get("shortUrl").getAsString();
            }
        }
        return null;
    }



}
