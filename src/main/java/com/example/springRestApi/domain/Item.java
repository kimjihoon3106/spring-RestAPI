package com.example.springRestApi.domain;

import lombok.Builder;
import lombok.Getter;

// getter, setter 메소드를 자동으로 생성해주는 Lombok의 어노테이션
// 무분별한 @Setter 사용은 좋지않다
// dto 객체를 Item 객체로 만드는 과정이나, Item 객체를 dto 객체로 만드는 과정에서 많은 setter를 사용하게 되는데,
// 다른 사람이 이 코드를 보면 어떤 작업이 이루어지는지 파악하기 힘들 수 있다.
// @Builder 어노테이션을 사용해요.

@Getter
public class Item {

    private Long id; // 물건의 고유 id
    private String name; // 물건의 이름
    private Long count; // 물건의 개수 (재고)

    @Builder
    public Item(String name, Long count) {
        this.name = name;
        this.count = count;
    }

    // 기능은 setter와 동일하지만 왜 수정하려는지 명확하게 알 수 있다.
    // 하지만 실제 프로젝트에서 id 필드를 접근할 수 있게 하는 것은 굉장히 위험해요.
    // 전체적인 흐름 파악을 위해 이번에만 사용 한다.
    public void initId(Long id) {
        this.id = id;
    }

    // 추가적으로 Item 객체를 수정할 때 setter로 하나씩 필드를 수정하는 것보다 updateItem 메소드를 이용하면 좀 더 직관적으로 이해할 수 있게 됀다.
    public void updateItem(String name, Long count) {
        this.name = name;
        this.count = count;
    }
}
