package org.example.json_serializer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonSerialization {
    private String getKey(Field field) {
        return field.getName();
    }
    private String getKeyMethod(Method method) {
        return method.getName();
    }

    public String getJsonString(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        Map<String, String> jsonElementsMap = new HashMap<>();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonElement.class)) {
                jsonElementsMap.put(getKey(field), field.get(object).toString());
            }
        }for (Method method : clazz.getDeclaredMethods()) {
            method.setAccessible(true);
            if (method.isAnnotationPresent(JsonElement.class)) {
                jsonElementsMap.put(getKeyMethod(method), method.getName());
            }
        }for (Constructor cons : clazz.getDeclaredConstructors()) {
            cons.setAccessible(true);
            if (cons.isAnnotationPresent(JsonElement.class)) {
                jsonElementsMap.put(cons.getName(), cons.getName());
            }
        }

        String jsonString = jsonElementsMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\""
                        + entry.getValue() + "\"")
                .collect(Collectors.joining(","));
        return "{" + jsonString + "}";
    }
}
