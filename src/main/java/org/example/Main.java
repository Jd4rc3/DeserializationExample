package org.example;

import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
//        HeroDeserializer
//        Hulk
        var respuesta = run("http://gateway.marvel.com/v1/public/characters/1009220?ts=2022-07-08%2018:33:53"
                    + ".521453&apikey=83fedad959b733cd02f7979e45f30213&hash"
                    + "=ea9ce6c2277e11d3a3146d75cf883430");

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Hulk.class, new HeroDeserializer());

        Hulk hulk= gsonBuilder.create().fromJson(respuesta, Hulk.class);

        System.out.println(hulk);
    }

    public static String run(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url)
                                               .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}