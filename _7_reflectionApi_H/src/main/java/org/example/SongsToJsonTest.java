package org.example;

import org.example.json_serializer.JsonSerialization;

public class SongsToJsonTest {
    public static void main(String[] args) throws Exception {
        Songs song = new Songs("Ярче и теплее", 1000, "Нервы");
        JsonSerialization serialization = new JsonSerialization();
        String json = serialization.getJsonString(song);

        System.out.println(json);

    }
}
