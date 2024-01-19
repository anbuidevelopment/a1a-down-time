package com.example.downtime.utils;

import com.example.downtime.ApiResponse.ApiResponse;
import com.example.downtime.ApiResponse.DataResponse;
import com.example.downtime.ApiResponse.PaginationResponse;
import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class Util {

    public List<String> getColumnNames(Class className) {
        List<String> columnNames = new ArrayList<>();
        Field[] fields = className.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column columnAnnotation = field.getAnnotation(Column.class);
                columnNames.add(columnAnnotation.name());
            }
        }

        return columnNames;
    }

    public <T> ApiResponse FormatApi (List<T> g, Integer pageSize, Integer pageNumber, Integer totalElements) {
        Integer x = (int) Math.ceil((double) totalElements / pageSize);
        PaginationResponse c = new PaginationResponse(pageNumber,pageSize,totalElements,x,g);
        List<String> columnNames = new ArrayList<>();

        if(!g.isEmpty()) {
            Class model = g.get(0).getClass();
            columnNames = this.getColumnNames(model);
        }

        DataResponse data = new DataResponse(columnNames, c);
        ApiResponse res = new ApiResponse(HttpStatus.OK.value(), "Get item successfully", data);
        return res;
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
