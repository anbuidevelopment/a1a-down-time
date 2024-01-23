package com.example.downtime.utils;

import com.example.downtime.ApiResponse.ApiResponse;
import com.example.downtime.ApiResponse.DataResponse;
import com.example.downtime.ApiResponse.PaginationResponse;
import com.example.downtime.constants.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class Util {

    public List<String> getColumnNames(Class<?> className) {
        List<String> columnNames = new ArrayList<>();
        Field[] fields = className.getDeclaredFields();

        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().getSimpleName().equals("Column")) {
                   columnNames.add(field.getName());
                }
            }
        }

        return columnNames;
    }



    public <T>  Map<String, List<String>> groupByFacZone(List<T> data,
                                                         Function<T, String> keyExtractor,
                                                         Function<T, String> valueExtractor
                                                         ) {
        Map<String, List<String>> groupedData = new HashMap<>();

        for (T item : data) {
            String key = keyExtractor.apply(item);
            String value = valueExtractor.apply(item);

            if (groupedData.containsKey(key)) {
                groupedData.get(key).add(value);
            } else {
                List<String> valueList = new ArrayList<>();
                valueList.add(value);
                groupedData.put(key, valueList);
            }
        }

        return groupedData;
    }
}
