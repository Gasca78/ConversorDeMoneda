import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.http.HttpResponse;

public class Json {
    static Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    public static Conversion jsonToGson(HttpResponse<String> response) {
        String json = response.body();
        return gson.fromJson(json, Conversion.class);
    }
}
