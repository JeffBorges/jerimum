package br.com.jerimum.fw.json;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Utility class for JSON operations.
 * 
 * @author Dali Freire - dalifreire@gmail.com
 */
public final class JSONUtils {

    private JSONUtils() {

    }

    public static String serialize(Object object) {
        return serialize(null, object);
    }

    public static String serialize(Type type, Object object) {

        if (type == null) {
            return new Gson().toJson(object);
        }
        return new Gson().toJson(object, type);
    }

    public static <T> T deserialize(Class<T> returnType, String jsonText) {

        TypeToken<T> typeToken = new TypeToken<T>() {
        };
        return deserialize(typeToken, jsonText);
    }

    public static <T> T deserialize(TypeToken<T> typeToken, String jsonText) {

        Type type = typeToken.getType();
        return deserialize(type, jsonText);
    }

    public static <T> T deserialize(Type type, String jsonText) {

        return new Gson().fromJson(jsonText, type);
    }

}
