package com.faas.core.rest.client.utility;

import com.faas.core.base.model.db.operation.channel.dao.MessageDataDAO;
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
import java.util.List;
import java.util.Map;


@Component
public class UtilityRestClient {

    @Autowired
    RestClient restClient;

    @Autowired
    AppUtils appUtils;


    public Map<String,String> urlShortenerRest(String httpUrl) throws IOException {

        String requestUrl = restClient.urlBuilder(AppConstant.URL_SHORTENER_API_URL,"/create",null);

        Map<String, String> formData = new HashMap<>();
        formData.put("apiKey", AppConstant.URL_SHORTENER_API_KEY);
        formData.put("url", httpUrl);

        String response = restClient.sendPostFormRequest(requestUrl,formData);
        if (response != null){
            JsonObject resObject = JsonParser.parseString(response).getAsJsonObject();
            if (resObject.get("success").getAsBoolean()){
                Map<String,String> urlShortMap = new HashMap<>();
                if (resObject.get("linkId") != null){
                    urlShortMap.put("linkId", resObject.get("linkId").getAsString());
                }
                if (resObject.get("statsUrl") != null){
                    urlShortMap.put("statsUrl", resObject.get("statsUrl").getAsString());
                }
                if (resObject.get("shortnedUrl") != null){
                    urlShortMap.put("shortnedUrl", resObject.get("shortnedUrl").getAsString());
                }
                return urlShortMap;
            }
        }
        return null;
    }



}
