package com.ms.warehouse.common.utils;

import com.ms.warehouse.common.json.IJsonConvertor;
import com.ms.warehouse.common.json.INameFilter;
import com.ms.warehouse.common.json.impl.FastJsonConvertor;

public class JsonUtils {

    private static IJsonConvertor jsonConvertor = new FastJsonConvertor();

    private JsonUtils() {
    }

    public static String convert(Object value) {
        return jsonConvertor.convert(value);
    }

    public static String convert(Object value, INameFilter nameFilter) {
        return jsonConvertor.convert(value, nameFilter);
    }

    public static <T> T parse(String value, Class<T> clazz) {
        return jsonConvertor.parse(value, clazz);
    }
}
