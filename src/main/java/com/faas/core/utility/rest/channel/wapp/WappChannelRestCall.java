package com.faas.core.utility.rest.channel.wapp;

import com.faas.core.base.model.db.channel.account.WappAccountDBModel;
import com.faas.core.base.model.db.operation.details.channel.OperationWappMessageDBModel;
import com.faas.core.base.repo.operation.details.channel.WappMessageRepository;
import com.faas.core.utility.rest.utility.RestCallTemplate;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
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
public class WappChannelRestCall {

    @Autowired
    RestCallTemplate restCallTemplate;

    @Autowired
    WappMessageRepository wappMessageRepository;

    @Autowired
    AppUtils appUtils;


    public String initWappChannelRequest(String serverUrl) throws IOException {

        String requestUrl = restCallTemplate.httpUrlBuilder(serverUrl,"/instance/init",null);
        String response = restCallTemplate.callGetRequest(requestUrl);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonPrimitive("key").getAsString();
        }
        return null;
    }


    public String scanWappQRCode(String serverUrl, String instanceKey) throws IOException {

        Map<String, String> paramObjs = new HashMap<>();
        paramObjs.put("key", instanceKey);
        String requestUrl = restCallTemplate.httpUrlBuilder(serverUrl,"/instance",paramObjs);
        String response = restCallTemplate.callGetRequest(requestUrl);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonPrimitive("key").getAsString();
        }
        return null;
    }


    public String getWappAccountQRCodeRequest(String serverUrl, String instanceKey) throws IOException {

        Map<String, String> paramObjs = new HashMap<>();
        paramObjs.put("key", instanceKey);
        String requestUrl = restCallTemplate.httpUrlBuilder(serverUrl,"/instance/qrbase64",paramObjs);
        String response = restCallTemplate.callGetRequest(requestUrl);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonPrimitive("qrcode").getAsString();
        }
        return null;
    }


    public String getWappInstanceInfoRest(String serverUrl, String instanceKey) throws IOException {

        Map<String, String> paramObjs = new HashMap<>();
        paramObjs.put("key", instanceKey);
        String requestUrl = restCallTemplate.httpUrlBuilder(serverUrl,"/instance/info",paramObjs);
        String response = restCallTemplate.callGetRequest(requestUrl);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonObject("qrcode").getAsString();
        }
        return null;
    }


    public String restoreAllWappInstancesRest(String serverUrl, String instanceKey) throws IOException {

        Map<String, String> paramObjs = new HashMap<>();
        paramObjs.put("key", instanceKey);
        String requestUrl = restCallTemplate.httpUrlBuilder(serverUrl,"/instance/info",paramObjs);
        String response = restCallTemplate.callGetRequest(requestUrl);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonObject("qrcode").getAsString();
        }
        return null;
    }

    public String deleteWappInstanceRest(String serverUrl, String instanceKey) throws IOException {

        Map<String, String> paramObjs = new HashMap<>();
        paramObjs.put("key", instanceKey);
        String requestUrl = restCallTemplate.httpUrlBuilder(serverUrl,"/instance/info",paramObjs);
        String response = restCallTemplate.callGetRequest(requestUrl);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonObject("qrcode").getAsString();
        }
        return null;
    }


    public String logOutWappInstanceRest(String serverUrl, String instanceKey) throws IOException {

        Map<String, String> paramObjs = new HashMap<>();
        paramObjs.put("key", instanceKey);
        String requestUrl = restCallTemplate.httpUrlBuilder(serverUrl,"/instance/info",paramObjs);
        String response = restCallTemplate.callGetRequest(requestUrl);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonObject("qrcode").getAsString();
        }
        return null;
    }


    public String listAllWappInstancesRest(String serverUrl) throws IOException {

        String requestUrl = restCallTemplate.httpUrlBuilder(serverUrl,"/instance/list",null);
        String response = restCallTemplate.callGetRequest(requestUrl);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            return resObject.getAsJsonObject("qrcode").getAsString();
        }
        return null;
    }


    public void sendWappTextMessageRest(OperationWappMessageDBModel operationWappMessageDBModel, WappAccountDBModel wappAccountDBModel) throws IOException {

        Map<String, String> paramObjs = new HashMap<>();
        paramObjs.put("key", wappAccountDBModel.getInstanceKey());
        String requestUrl = restCallTemplate.httpUrlBuilder(wappAccountDBModel.getServerUrl(),"/message/text",paramObjs);

        Map<String,String> formData = new HashMap<>();
        //formData.put("id", wappMessageDBModel.getPhoneNumber());
        //formData.put("message", wappMessageDBModel.getWappMessage().getWappBody());
        formData.put("id", "905458189014");
        formData.put("message", operationWappMessageDBModel.getOperationWappMessage().getWappBody());

        String response = restCallTemplate.callPostXFormRequest(requestUrl,formData);
        if (response != null){
            operationWappMessageDBModel.setMessageState(AppConstant.MESSAGE_SENT);
        }else {
            operationWappMessageDBModel.setMessageState(AppConstant.MESSAGE_FAILED);
        }
        operationWappMessageDBModel.setuDate(appUtils.getCurrentTimeStamp());
        wappMessageRepository.save(operationWappMessageDBModel);
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
