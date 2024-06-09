package com.faas.core.utility.rest.utility;

import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class RestCallTemplate {

    private final OkHttpClient client = new OkHttpClient();

    public String callGetRequest(String requestUrl) throws IOException {

        Request request = new Request.Builder().url(requestUrl)
                .header("Content-Type", "application/x-www-form-urlencoded").build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                try (ResponseBody responseBody = response.body()) {
                    String responseString = responseBody.string();
                    System.out.println("callGetRequest responseString: " + responseString);
                    return responseString;
                }
            } else {
                throw new IOException("Unexpected code " + response);
            }
        }
    }


    public String callPostXFormRequest(String requestUrl,Map<String,String>formData) throws IOException {

        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : formData.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        RequestBody requestBody = builder.build();

        Request request = new Request.Builder().url(requestUrl)
                .header("Content-Type", "application/x-www-form-urlencoded").post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                try (ResponseBody responseBody = response.body()) {
                    String responseString = responseBody.string();
                    System.out.println("callPostXFormRequest responseString: " + responseString);
                    return responseString;
                }
            } else {
                throw new IOException("Unexpected code " + response);
            }
        }
    }


    public String callPostJsonRequest(String requestUrl,String requestJson) throws IOException {

        RequestBody requestBody = RequestBody.create(requestJson,MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder().url(requestUrl).post(requestBody).build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                System.out.println("sendPostJsonRequest response :" + response.body().string());
                return response.body().string();
            } else {
                throw new IOException("Unexpected code " + response);
            }
        }
    }


    public String httpUrlBuilder(String baseUrl,String subUrl,Map<String,String> paramObjs){

        HttpUrl httpUrl = HttpUrl.parse(baseUrl + subUrl);
        if (httpUrl != null) {
            HttpUrl.Builder urlBuilder = httpUrl.newBuilder();
            if (paramObjs != null) {
                for (Map.Entry<String, String> entry : paramObjs.entrySet()) {
                    urlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
                }
            }
            return urlBuilder.build().toString();
        } else {
            return null;
        }
    }


}
