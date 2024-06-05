package com.example.springRestApi.dto;

import lombok.Builder;
import lombok.Data;

@Data
// dto클래스이다. 데이터를 주고 받을때 사용
// 요청 dto와 응답 dto로 나누기도 한다.
public class ItemDto {

    private Long id;
    private String name;
    private Long count;

    @Builder
    public ItemDto(Long id, String name, Long count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }
}
