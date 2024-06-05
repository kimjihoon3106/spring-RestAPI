package com.example.springRestApi.repository;

import com.example.springRestApi.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @Component : @Repository나 @Controller 등에 포함되어 있다.
// 스프링 빈으로 등록하려고 할 때 사용한다.
// 스프링이 관리하는 객체임을 알리는 어노테이션이다.

@Repository
// 스프링에서 지원하지 않는 Exception을 Spring Exception으로 전환하기 위해서 @Repository어노테이션을 사용한다.
// 여기서 Exception이 발생할 경우 Unchecked Exception을 DataAccessException으로 전환시킨다.
// 주로 DAO에서 사용한다 예를들어 트랜잭션을 적용한 메소드에서 DB오류가 발생해도 롤백이 가능한 이유이다.
// 데이터베이스 기술을 사용하지 않고, 메모리에 저장하는 방식으로 MemoryItemRepository를 구현
public class MemoryItemRepository implements ItemRepository{

    private static Map<Long, Item> store = new HashMap<>();
    // id를 생성하기 위한 sequence
    private static Long sequence = 0L;

    @Override
    public void save(Item item) {
        item.initId(++sequence); // id를 생성하고 item에 저장
        store.put(item.getId(), item); // store에 저장
    }

    @Override
    public Item findById(Long id) {
        return store.get(id); // id에 해당하는 item을 찾아서 반환
    }

    @Override
    public List<Item> findAll() {
        return store.values().stream().toList(); // store에 있는 모든 value를 ArrayList에 담아서 반환
    }

    @Override
    public void updateById(Long id, Item item) {
        store.put(id, item); // store에 저장, hash map은 key가 같으면 덮어씌워지기 때문에 id는 그대로 두고 내용만 수정
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id); // id에 해당하는 item을 찾아서 삭제
    }
}
