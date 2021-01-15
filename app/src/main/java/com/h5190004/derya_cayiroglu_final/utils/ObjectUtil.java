package com.h5190004.derya_cayiroglu_final.utils;

import com.google.gson.Gson;
import com.h5190004.derya_cayiroglu_final.model.BilimKadiniModel;

public class ObjectUtil {
    public static String bilimKadiniToJsonString(BilimKadiniModel bilimKadiniModel)
    {
        Gson gson = new Gson();
        return gson.toJson(bilimKadiniModel);
    }
    public static BilimKadiniModel jsonStringToBilimKadini(String jsonString)
    {
        Gson gson = new Gson();
        return gson.fromJson(jsonString,BilimKadiniModel.class);
    }
}
