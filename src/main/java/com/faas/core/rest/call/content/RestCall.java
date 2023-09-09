package com.faas.core.rest.call.content;

import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;


@Component
public class RestCall {

    private final OkHttpClient client = new OkHttpClient();


    public String sendGetRequest(String requestUrl) throws IOException {

        Request request = new Request.Builder().url(requestUrl)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                try (ResponseBody responseBody = response.body()) {
                    String responseString = responseBody.string();
                    System.out.println("sendGetRequest response: " + responseString);
                    return responseString;
                }
            } else {
                throw new IOException("Unexpected code " + response);
            }
        }

    }


    public String sendPostFormRequest(String requestUrl,Map<String,String>formData) throws IOException {

        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : formData.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        RequestBody requestBody = builder.build();

        Request request = new Request.Builder()
                .url(requestUrl)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                try (ResponseBody responseBody = response.body()) {
                    String responseString = responseBody.string();
                    System.out.println("sendPostFormRequest responseString: " + responseString);
                    return responseString;
                }
            } else {
                throw new IOException("Unexpected code " + response);
            }
        }
    }


    public String sendPostJsonRequest(String requestUrl,String requestJson) throws IOException {

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


    public String urlBuilder(String baseUrl,String subUrl,Map<String,String> paramObjs){

        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseUrl+subUrl).newBuilder();
        if (paramObjs != null) {
            for (Map.Entry<String, String> entry : paramObjs.entrySet()) {
                urlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        return urlBuilder.build().toString();
    }


}
