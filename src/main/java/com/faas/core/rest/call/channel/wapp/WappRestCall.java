package com.faas.core.rest.call.channel.wapp;

import com.faas.core.base.model.db.channel.account.WappAccountDBModel;
import com.faas.core.base.model.db.operation.channel.WappMessageDBModel;
import com.faas.core.base.repo.operation.channel.WappMessageRepository;
import com.faas.core.rest.call.content.RestCall;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
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
public class WappRestCall {

    @Autowired
    RestCall restCall;

    @Autowired
    WappMessageRepository wappMessageRepository;

    @Autowired
    AppUtils appUtils;


    public String initWappInstanceRest(String serverUrl) throws IOException {

        String requestUrl = restCall.urlBuilder(serverUrl,"/instance/init",null);
        String response = restCall.sendGetRequest(requestUrl);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonPrimitive("key").getAsString();
        }
        return null;
    }


    public String scanWappQRCode(String serverUrl, String instanceKey) throws IOException {

        Map<String, String> paramObjs = new HashMap<>();
        paramObjs.put("key", instanceKey);
        String requestUrl = restCall.urlBuilder(serverUrl,"/instance",paramObjs);
        String response = restCall.sendGetRequest(requestUrl);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonPrimitive("key").getAsString();
        }
        return null;
    }


    public String getWappQRCodeInBase64Rest(String serverUrl, String instanceKey) throws IOException {

        Map<String, String> paramObjs = new HashMap<>();
        paramObjs.put("key", instanceKey);
        String requestUrl = restCall.urlBuilder(serverUrl,"/instance/qrbase64",paramObjs);
        String response = restCall.sendGetRequest(requestUrl);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonPrimitive("qrcode").getAsString();
        }
        return null;
    }


    public String getWappInstanceInfoRest(String serverUrl, String instanceKey) throws IOException {

        Map<String, String> paramObjs = new HashMap<>();
        paramObjs.put("key", instanceKey);
        String requestUrl = restCall.urlBuilder(serverUrl,"/instance/info",paramObjs);

        String response = restCall.sendGetRequest(requestUrl);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonObject("qrcode").getAsString();
        }
        return null;
    }


    public String restoreAllWappInstancesRest(String serverUrl, String instanceKey) throws IOException {

        Map<String, String> paramObjs = new HashMap<>();
        paramObjs.put("key", instanceKey);
        String requestUrl = restCall.urlBuilder(serverUrl,"/instance/info",paramObjs);

        String response = restCall.sendGetRequest(requestUrl);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonObject("qrcode").getAsString();
        }
        return null;
    }

    public String deleteWappInstanceRest(String serverUrl, String instanceKey) throws IOException {

        Map<String, String> paramObjs = new HashMap<>();
        paramObjs.put("key", instanceKey);
        String requestUrl = restCall.urlBuilder(serverUrl,"/instance/info",paramObjs);

        String response = restCall.sendGetRequest(requestUrl);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonObject("qrcode").getAsString();
        }
        return null;
    }


    public String logOutWappInstanceRest(String serverUrl, String instanceKey) throws IOException {

        Map<String, String> paramObjs = new HashMap<>();
        paramObjs.put("key", instanceKey);
        String requestUrl = restCall.urlBuilder(serverUrl,"/instance/info",paramObjs);

        String response = restCall.sendGetRequest(requestUrl);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonObject("qrcode").getAsString();
        }
        return null;
    }


    public String listAllWappInstancesRest(String serverUrl) throws IOException {

        String requestUrl = restCall.urlBuilder(serverUrl,"/instance/list",null);
        String response = restCall.sendGetRequest(requestUrl);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonObject("qrcode").getAsString();
        }
        return null;
    }


    public void sendWappTextMessageRest(WappMessageDBModel wappMessageDBModel, WappAccountDBModel wappAccountDBModel) throws IOException {

        Map<String, String> paramObjs = new HashMap<>();
        paramObjs.put("key", wappAccountDBModel.getInstanceKey());
        String requestUrl = restCall.urlBuilder(wappAccountDBModel.getServerUrl(),"/message/text",paramObjs);

        Map<String,String> formData = new HashMap<>();
        //formData.put("id", wappMessageDBModel.getPhoneNumber());
        //formData.put("message", wappMessageDBModel.getWappMessage().getWappBody());
        formData.put("id", "905458189014");
        formData.put("message",wappMessageDBModel.getWappMessage().getWappBody());

        String response = restCall.sendPostFormRequest(requestUrl,formData);
        if (response != null){
            wappMessageDBModel.setMessageState(AppConstant.MESSAGE_SENT);
        }else {
            wappMessageDBModel.setMessageState(AppConstant.MESSAGE_FAILED);
        }
        wappMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());
        wappMessageRepository.save(wappMessageDBModel);
    }


    public String sendWappImageMessageRest(String serverUrl, String instanceKey, String phoneNumber, String fileCaption, String fileName, String fileUrl) throws IOException {

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

        return null;
    }


    public String sendWappVideoMessageRest(String serverUrl, String instanceKey, String phoneNumber, String fileCaption, String fileName, String fileUrl) throws IOException {

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

        return null;
    }

    public String sendWappAudioMessageRest(String serverUrl, String instanceKey, String phoneNumber, String fileCaption, String fileName, String fileUrl) throws IOException {

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

        return null;

    }

    public String sendWappDocumentMessageRest(String serverUrl, String instanceKey, String phoneNumber, String fileCaption, String fileName, String fileUrl) throws IOException {

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

        return null;

    }

    public String sendWappFileUrlMessageRest(String serverUrl, String instanceKey, String phoneNumber, String fileUrl, String fileType, String mimeType, String fileCaption) throws IOException {

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

        return null;

    }


    public String sendWappListMessageRest() throws IOException {

        return null;
    }

    public String setWappStatusRest() throws IOException {
        return null;
    }



    public String isUserOnWappRest(String serverUrl, String instanceKey, String phoneNumber) throws IOException {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(serverUrl + "/misc/onwhatsapp").newBuilder();
        urlBuilder.addQueryParameter("key", instanceKey);
        urlBuilder.addQueryParameter("id", phoneNumber);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .header("Accept", "text/plain")
                .build();

        return null;
    }


    public String downloadWappProfilePicRest(String serverUrl, String instanceKey, String phoneNumber) throws IOException {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(serverUrl + "/misc/downProfile").newBuilder();
        urlBuilder.addQueryParameter("key", instanceKey);
        urlBuilder.addQueryParameter("id", phoneNumber);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .header("Accept", "text/plain")
                .build();

        return null;
    }


    public String getWappUserStatusRest(String serverUrl, String instanceKey, String phoneNumber) throws IOException {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(serverUrl + "/misc/getStatus").newBuilder();
        urlBuilder.addQueryParameter("key", instanceKey);
        urlBuilder.addQueryParameter("id", phoneNumber);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .header("Accept", "text/plain")
                .build();

        return null;
    }


    public String blockUnblockWappUserRest() throws IOException {
        return null;
    }


    public String updateWappProfilePictureRest() throws IOException {
        return null;
    }


}
