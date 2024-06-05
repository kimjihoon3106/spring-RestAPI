## Spring Boot로 REST API

### Postman
API를 쉽게 테스트 할 수 있는 도구

* POST localhost:8080/items : 물건 추가 요청이에요.
  * JSON 형식으로 데이터를 입력
```json
{
  "name" : "user1",
  "count" : 10
}
```

* GET localhost:8080/items/1 : id가 1인 물건 조회 요청이에요.

  
* PATCH localhost:8080/items/1 : id가 1인 물건 정보 수정 요청이에요.
  * JSON 형식으로 데이터를 수정
```json
{
  "name" : "user2",
  "count" : 20
}
```
  
* DELETE localhost:8080/items/1 : id가 1인 물건 삭제 요청이에요.
