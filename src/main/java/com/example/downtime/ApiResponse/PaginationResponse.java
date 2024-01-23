package com.example.downtime.ApiResponse;

import com.example.downtime.utils.Util;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class PaginationResponse<T> {
    private int pageIndex;
    private int rowPerPage;
    private int totalElements;
    private int totalPages;
    private List<T> dataList;

    public PaginationResponse(int pageIndex, int rowPerPage, int totalElements, List<T> dataList) {
        this.pageIndex = pageIndex;
        this.rowPerPage = rowPerPage;
        this.totalElements = totalElements;
        this.totalPages = (int) Math.ceil((double) totalElements / rowPerPage);
        this.dataList = dataList;
    }

    @JsonIgnore
    public List<String> getHeaderDataList() {
        if (this.dataList.isEmpty()) return new ArrayList<>();

        Util util = new Util();
        Class<?> dataClass = this.dataList.get(0).getClass();
        return util.getColumnNames(dataClass);
    }

}
