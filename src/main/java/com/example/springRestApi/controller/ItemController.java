package com.example.springRestApi.controller;

import com.example.springRestApi.dto.ItemDto;
import com.example.springRestApi.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    private final ItemService itemService;

    // 의존성 생성장 주입
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("items")
    public void save(@RequestBody ItemDto itemDto) {
        itemService.saveItem(itemDto);
    }

    @GetMapping("items/{id}")
    public ItemDto findItemById(@PathVariable Long id) {
        return itemService.findItemById(id);
    }

    @GetMapping("items")
    public List<ItemDto> findAllItem() {
        return itemService.findAllItem();
    }

    @PatchMapping("items/{id}")
    public void updateItemById(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        itemService.updateItemById(id, itemDto);
    }

    @DeleteMapping("items/{id}")
    public void deleteItemById(@PathVariable Long id) {
        itemService.deleteItemById(id);
    }
}

// @RequestBody : HTTP 요청의 본문(json)을 자바 객체로 변환해주는 어노테이션이다
// @RespnseBody : 반대이다.
// @PathVariable : URL에 변수를 넣을 수 있게 해줘요. "items/1" 경로로 GET 요청을 보내면 id가 1인 물건을 조회할 수 있다.
// 이때 Controller에서는 "items/{id}" 형태로 요청을 받도록 할 수 있다.
