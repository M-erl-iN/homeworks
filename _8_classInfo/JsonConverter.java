package Homeworks._8_classInfo;

import com.google.gson.Gson;

public class JsonConverter {
    public static String toJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }
    public static <T> T fromJson(String json, Class<T> classOfT) {
        Gson gson = new Gson();
        return gson.fromJson(json, classOfT);
    }
}