package fr.arthurbr02.vue3templateback.backend.core.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class EntityUtils {
    public static Map<String, Object> convertEntityToMap(Object object) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field: fields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(object));
        }

        return map;
    }
}
