package com.example.springRestApi.repository;

import com.example.springRestApi.domain.Item;

import java.util.List;

// 레퍼지토리는 데이터베이스와 연관되어 있는 계층이다 보니 다른 데이터베이스로 변경될 가능성이 높다
// 그렇기 때문에 인터페이스로 만들어서 구현체를 만들어 사용하는 것이 좋다.
public interface ItemRepository {

    void save(Item item);
    Item findById(Long id);
    List<Item> findAll();
    void updateById(Long id, Item item);
    void deleteById(Long id);

    // 인터페이스에 레퍼지토리 구현체가 가져야 할 메소드들을 정의해둠으로서
    // 구현제를 변경하거나 다른 구현체로 교체할 때, 새로운 구현체가 인터페이스를 준수하기만 하면,
    // 내부 코드를 수정할 필요가 없다.
}
