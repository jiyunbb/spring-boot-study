# spring-study
thymeleaf + spring boot + docker + oracle xe-11g 사용하여 학습차 시작한 프로젝트
-> thymeleaf 는 일단 하다가 잠시 멈추고.. REST API를 먼저 만들고 붙이려고 합니다.


## docker 세팅 및 오라클 db 설치
```
-- 찾기
docker search oracle-xe-11g

-- 이미지 풀 땡겨오기
docker pull jaspeen/oracle-xe-11g

-- 다운받은 도커 이미지 확인
docker images

-- 도커 띄우기
docker run --name oracle11g -d -p 8080:8080 -p 1521:1521 jaspeen/oracle-xe-11g

-- 띄워진 도커 목록 확인
docker ps -a

-- 커맨드 라인으로 실행
docker exec -it oracle11g sqlplus
```

## 테이블 생성 (테이블은 기능 추가됨에 따라 더 추가될 예정)
- <img width="786" alt="스크린샷 2023-10-15 오전 11 49 54" src="https://github.com/jiyunbb/spring-boot-study/assets/23615455/b26cd1eb-d6ee-4689-a2ee-79b7d55d9f6e">


## API 목록
### 앞으로 필요한 API들
- 주문하기
- 주문취소
- 유저별 주문목록조회
- 상품등록(버전관리)

### API : /sign-up
- METHOD : POST
- 용도 : 회원가입
- 요청 : Request Body
```
{
    "name" : "오징어",
    "phone" : "010-5172-9988"
}
```
- 응답 : 
```
{
    "message": "회원가입 성공.",
    "code": "1000"
}
```

### API : /sign-in
- METHOD : POST
- 용도 : 로그인
- 요청 : Request Body
```
{
  "name" : "왕지윤",
  "phone" : "010-1111-1111"
}
```
- 응답 : 
```
{
    "message": "로그인 성공.",
    "code": "1000"
}
```

### API : /members
- METHOD : GET
- 용도 : 로그인
- 요청 : N/A
- 응답 : 
```
[
    {
        "id": 1,
        "name": "왕지윤",
        "phone": "010-0000-0000"
    },
    {
        "id": 2,
        "name": "호랑이",
        "phone": "010-1111-1111"
    },
    {
        "id": 3,
        "name": "감자깡",
        "phone": "010-3333-3333"
    },
    {
        "id": 4,
        "name": "구미호",
        "phone": "010-4444-4444"
    },
    {
        "id": 5,
        "name": "마우스",
        "phone": "010-5555-5555"
    },
    {
        "id": 32,
        "name": "오징어",
        "phone": "010-6666-6666"
    }
]
```

### API : /members/{member_ID}
- METHOD : DELETE
- 용도 : 멤버 삭제
- 요청 : Path Paramter
- 응답 : 
```
[
    {
        "id": 1,
        "name": "왕지윤",
        "phone": "010-0000-0000"
    },
    {
        "id": 2,
        "name": "호랑이",
        "phone": "010-1111-1111"
    },
    {
        "id": 3,
        "name": "감자깡",
        "phone": "010-3333-3333"
    },
    {
        "id": 4,
        "name": "구미호",
        "phone": "010-4444-4444"
    },
    {
        "id": 5,
        "name": "마우스",
        "phone": "010-5555-5555"
    },
    {
        "id": 32,
        "name": "오징어",
        "phone": "010-6666-6666"
    }
]
```

### API : /goods
- METHOD : GET
- 용도 : 상품 목록 조회
- 요청 : N/A
- 응답 : 
```
[
    {
        "id": 1,
        "version": 1,
        "name": "[각질패드]바하 필링 패드 50매 (110ml)",
        "customerPrice": 24000,
        "productPrice": 16800,
        "discountRate": 30
    },
    {
        "id": 2,
        "version": 1,
        "name": "[각질케어]바하 필링 앰플 30ml",
        "customerPrice": 24000,
        "productPrice": 16800,
        "discountRate": 30
    }
]
```

### API : /goods
- METHOD : GET
- 용도 : 상품 목록 조회
- 요청 : Query Parameter -> id
- 응답 : 
```
{
    "id": 1,
    "version": 1,
    "name": "[각질패드]바하 필링 패드 50매 (110ml)",
    "customerPrice": 24000,
    "productPrice": 16800,
    "discountRate": 30
}
```

### API : /carts
- METHOD : POST
- 용도 : 카트 담기 및 카드 수량 수정
- 요청 : Request Body
```
{
    "goods" : {
        "id" : 2,
        "version" : 1,
        "name" : "[각질패드]바하 필링 패드 50매 (110ml)",
        "customerPrice" : 24000,
        "productPrice" : 16800,
        "discountRate" : 30
    },
    "member" : {
        "id" : 1,
        "name" : "왕지윤",
        "phone" : "010-1111-1111"
    },
    "count" : 5
}
```
- 응답 : 
```
{
    "message": "장바구니가 담겼습니다.",
    "code": "1000"
}
```

### API : /members/{MEMBER_ID}/address
- METHOD : GET
- 용도 : 유저의 주소지 정보 조회
- 요청 : N/A
- 응답 : 
```
[
    {
        "id": 1,
        "member": {
            "id": 1,
            "name": "오징어",
            "phone": "010-5172-9988"
        },
        "defaultAddress": "서울특별시 강남구 튤립아파트",
        "detailAddress": "207동 203호",
        "shippingName": "구렁이",
        "shippingPhone": "010-3341-3333",
        "zipcode": "10523",
        "isDefault": 0
    },
    {
        "id": 2,
        "member": {
            "id": 1,
            "name": "오징어",
            "phone": "010-5172-9988"
        },
        "defaultAddress": "서울특별시 강남구 삼성아파트",
        "detailAddress": "205동 803호",
        "shippingName": "오징어",
        "shippingPhone": "010-5172-9988",
        "zipcode": "10523",
        "isDefault": 1
    }
]
```

### API : /members/{MEMBER_ID}/address
- METHOD : POST
- 용도 : 유저의 주소지 정보 입력
- 요청 : Request Body
```
{
    "defaultAddress" : "서울특별시 강남구 삼성아파트",
    "detailAddress" : "205동 803호",
    "shippingName" : "오징어",
    "shippingPhone" : "010-5172-9988",
    "zipcode" : "10523",
    "isDefault" : 1 //TODO boolean 으로 바꿔보자!
}
```
- 응답 : 
```
{
    "message": "주소지 입력 성공.",
    "code": "1000"
}
```
