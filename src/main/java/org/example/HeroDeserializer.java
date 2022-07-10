package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;

public class HeroDeserializer implements JsonDeserializer<Hulk> {
    @Override
    public Hulk deserialize(JsonElement jElement, Type type,
            JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject jObject = jElement.getAsJsonObject();
        JsonObject data = jObject.get("data").getAsJsonObject();
        JsonObject heroe = data.get("results").getAsJsonArray().get(0).getAsJsonObject();

        var name = heroe.get("name").getAsString();
        var description = heroe.get("description").getAsString();
        return new Hulk(name, description);
    }
}
