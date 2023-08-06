package model_weither_api;

import com.google.gson.Gson;
import model_weither_api.weither.Weither;

public class Formatter {
    public Weither parse(String json){
        Gson gson = new Gson();
        Weither weither = gson.fromJson(json, Weither.class);
        return weither;

    }
}
