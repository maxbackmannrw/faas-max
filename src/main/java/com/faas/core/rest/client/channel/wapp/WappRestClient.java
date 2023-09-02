package com.faas.core.rest.client.channel.wapp;

import com.faas.core.rest.client.content.RestClient;
import com.faas.core.utils.config.AppUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Component
public class WappRestClient {

    @Autowired
    RestClient restClient;

    @Autowired
    AppUtils appUtils;


    public String initWappInstance(String serverUrl) throws IOException {

        String requestUrl = restClient.urlBuilder(serverUrl,"/instance/init",null);

        String response = restClient.sendGetRequest(requestUrl);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonPrimitive("key").getAsString();
        }
        return null;
    }


    public String scanWappQRCode(String serverUrl, String instanceKey) throws IOException {

        Map<String, String> jsonObj = new HashMap<>();
        jsonObj.put("key", instanceKey);
        String requestUrl = restClient.urlBuilder(serverUrl,"/instance",jsonObj);

        String response = restClient.sendGetRequest(requestUrl);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonPrimitive("key").getAsString();
        }
        return null;
    }


    public String getWappQRCodeInBase64(String serverUrl, String instanceKey) throws IOException {

        Map<String, String> jsonObj = new HashMap<>();
        jsonObj.put("key", instanceKey);
        String requestUrl = restClient.urlBuilder(serverUrl,"/instance/qrbase64",jsonObj);

        String response = restClient.sendGetRequest(requestUrl);
        if (response != null){
            JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonObject("qrcode").getAsString();
        }
        return null;
    }


    public String getWappInstanceInfo(String serverUrl, String instanceKey) throws IOException {

        Map<String, String> jsonObj = new HashMap<>();
        jsonObj.put("key", instanceKey);
        String requestUrl = restClient.urlBuilder(serverUrl,"/instance/info",jsonObj);

        String response = restClient.sendGetRequest(requestUrl);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonObject("qrcode").getAsString();
        }
        return null;
    }


    public String restoreAllWappInstances(String serverUrl, String instanceKey) throws IOException {

        Map<String, String> jsonObj = new HashMap<>();
        jsonObj.put("key", instanceKey);
        String requestUrl = restClient.urlBuilder(serverUrl,"/instance/info",jsonObj);

        String response = restClient.sendGetRequest(requestUrl);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonObject("qrcode").getAsString();
        }
        return null;
    }

    public String deleteWappInstanceRest(String serverUrl, String instanceKey) throws IOException {

        Map<String, String> jsonObj = new HashMap<>();
        jsonObj.put("key", instanceKey);
        String requestUrl = restClient.urlBuilder(serverUrl,"/instance/info",jsonObj);

        String response = restClient.sendGetRequest(requestUrl);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonObject("qrcode").getAsString();
        }
        return null;
    }


    public String logOutWappInstance(String serverUrl, String instanceKey) throws IOException {

        Map<String, String> jsonObj = new HashMap<>();
        jsonObj.put("key", instanceKey);
        String requestUrl = restClient.urlBuilder(serverUrl,"/instance/info",jsonObj);

        String response = restClient.sendGetRequest(requestUrl);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonObject("qrcode").getAsString();
        }
        return null;
    }


    public String listAllWappInstances(String serverUrl) throws IOException {

        String requestUrl = restClient.urlBuilder(serverUrl,"/instance/list",null);
        String response = restClient.sendGetRequest(requestUrl);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonObject("qrcode").getAsString();
        }
        return null;
    }



    public boolean sendWappTextMessage(String serverUrl, String instanceKey, String phoneNumber, String messageBody) throws IOException {

        Map<String, String> jsonObj = new HashMap<>();
        jsonObj.put("key", instanceKey);
        String requestUrl = restClient.urlBuilder(serverUrl,"/instance/info",jsonObj);

// from here

        HttpUrl.Builder urlBuilder = HttpUrl.parse(serverUrl + "/message/text").newBuilder();
        urlBuilder.addQueryParameter("key", instanceKey);
        String url = urlBuilder.build().toString();

        RequestBody requestBody = new FormBody.Builder()
                .add("id", phoneNumber)
                .add("message", messageBody)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println("response" + response);
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return true;
        }
    }


    public String sendWappImageMessage(String serverUrl, String instanceKey, String phoneNumber, String fileCaption, String fileName, String fileUrl) throws IOException {

        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file", fileName,
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File(fileUrl)))
                .addFormDataPart("id", phoneNumber)
                .addFormDataPart("caption", fileCaption)
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(serverUrl + "/message/image").newBuilder();
        urlBuilder.addQueryParameter("key", instanceKey);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .header("Accept", "text/plain")
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            System.out.println(response.body().string());
            return null;
        }
    }


    public String sendWappVideoMessage(String serverUrl, String instanceKey, String phoneNumber, String fileCaption, String fileName, String fileUrl) throws IOException {

        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file", fileName,
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File(fileUrl)))
                .addFormDataPart("id", phoneNumber)
                .addFormDataPart("caption", fileCaption)
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(serverUrl + "/message/video").newBuilder();
        urlBuilder.addQueryParameter("key", instanceKey);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .header("Accept", "text/plain")
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            System.out.println(response.body().string());
            return null;
        }
    }

    public String sendWappAudioMessage(String serverUrl, String instanceKey, String phoneNumber, String fileCaption, String fileName, String fileUrl) throws IOException {

        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file", fileName,
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File(fileUrl)))
                .addFormDataPart("id", phoneNumber)
                .addFormDataPart("caption", fileCaption)
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(serverUrl + "/message/audio").newBuilder();
        urlBuilder.addQueryParameter("key", instanceKey);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .header("Accept", "text/plain")
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            System.out.println(response.body().string());
            return null;
        }
    }

    public String sendWappDocumentMessage(String serverUrl, String instanceKey, String phoneNumber, String fileCaption, String fileName, String fileUrl) throws IOException {

        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file", fileName,
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File(fileUrl)))
                .addFormDataPart("id", phoneNumber)
                .addFormDataPart("caption", fileCaption)
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(serverUrl + "/message/doc").newBuilder();
        urlBuilder.addQueryParameter("key", instanceKey);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .header("Accept", "text/plain")
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            System.out.println(response.body().string());
            return null;
        }
    }

    public String sendWappFileUrlMessage(String serverUrl, String instanceKey, String phoneNumber, String fileUrl, String fileType, String mimeType, String fileCaption) throws IOException {

        RequestBody requestBody = new FormBody.Builder()
                .add("id", phoneNumber)
                .add("url", fileUrl)
                .add("type", fileType)
                .add("mimetype", mimeType)
                .add("caption", fileCaption)
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(serverUrl + "/message/text").newBuilder();
        urlBuilder.addQueryParameter("key", instanceKey);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Accept", "text/plain")
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            System.out.println(response.body().string());
            return null;
        }
    }


    public String sendWappListMessage() throws IOException {

        return null;
    }

    public String setWappStatus() throws IOException {
        return null;
    }



    public String isUserOnWapp(String serverUrl, String instanceKey, String phoneNumber) throws IOException {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(serverUrl + "/misc/onwhatsapp").newBuilder();
        urlBuilder.addQueryParameter("key", instanceKey);
        urlBuilder.addQueryParameter("id", phoneNumber);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .header("Accept", "text/plain")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            System.out.println(response.body().string());
            return null;
        }
    }


    public String downloadWappProfilePic(String serverUrl, String instanceKey, String phoneNumber) throws IOException {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(serverUrl + "/misc/downProfile").newBuilder();
        urlBuilder.addQueryParameter("key", instanceKey);
        urlBuilder.addQueryParameter("id", phoneNumber);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .header("Accept", "text/plain")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            System.out.println(response.body().string());
            return null;
        }
    }

    public String getWappUserStatus(String serverUrl, String instanceKey, String phoneNumber) throws IOException {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(serverUrl + "/misc/getStatus").newBuilder();
        urlBuilder.addQueryParameter("key", instanceKey);
        urlBuilder.addQueryParameter("id", phoneNumber);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .header("Accept", "text/plain")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            System.out.println(response.body().string());
            return null;
        }
    }


    public String blockUnblockWappUser() throws IOException {
        return null;
    }

    public String updateWappProfilePicture(Rest) throws IOException {
        return null;
    }



}
