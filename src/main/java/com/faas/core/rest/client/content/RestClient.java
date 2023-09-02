package com.faas.core.rest.client.content;

import com.faas.core.utils.config.AppUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;


@Component
public class RestClient {


    @Autowired
    AppUtils appUtils;

    private final OkHttpClient client = new OkHttpClient();


    public String sendGetRequest(String requestUrl) throws IOException {

        Request request = new Request.Builder().url(requestUrl)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Accept", "text/plain")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                System.out.println("sendGetRequest response :" + response.body().string());
                return response.body().string();
            } else {
                throw new IOException("Unexpected code " + response);
            }
        }
    }


    public String sendPostFormRequest(String requestUrl,Map<String,String>formData) throws IOException {

        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for (Map.Entry<String, String> entry : formData.entrySet()) {
            builder.addFormDataPart(entry.getKey(), entry.getValue());
        }
        RequestBody requestBody = builder.build();

        Request request = new Request.Builder()
                .url(requestUrl)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                System.out.println("sendPostFormRequest response :" + response.body().string());
                return response.body().string();
            } else {
                throw new IOException("Unexpected code " + response);
            }
        }
    }


    public String sendPostJsonRequest(String requestUrl,String requestJson) throws IOException {

        RequestBody requestBody = RequestBody.create(requestJson,MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(requestUrl)
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                System.out.println("sendPostJsonRequest response :" + response.body().string());
                return response.body().string();
            } else {
                throw new IOException("Unexpected code " + response);
            }
        }
    }


    public String urlBuilder(String baseUrl,String subUrl,Map<String,String> keyValues){

        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseUrl+subUrl).newBuilder();
        if (keyValues != null) {
            for (Map.Entry<String, String> entry : keyValues.entrySet()) {
                urlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        return urlBuilder.build().toString();
    }


}
