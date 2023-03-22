# Blog search

---
- 다운로드 파일 경로
```
https://github.com/itdar/kb/blob/master/kb.jar
```

--- 

## 구성
- java 11, spring, gradle, junit
- embedded redis (inmemory db, caching)
- lombok: 코드 간소화
- jackson: 직렬화/역직렬화

---

## API
### 1. search (블로그 검색)
- url 
```http request
localhost:8080/search
```
- body example (json)
```json
{
  "query": "blog5",
  "sort": "recency",
  "page": 4,
  "size": 4
}
```
- 내용
```text
카카오 검색 우선, 예외 발생 시 네이버 검색

query - 검색어
sort - 결과 문서 정렬 방식, accuracy(정확도순) 또는 recency(최신순)
page - 결과 페이지 번호, 1~50 사이의 값, 기본 값 1
size - 한 페이지에 보여질 문서 수, 1~50 사이의 값, 기본 값 10
```

- response example
```json
{
    "info": {
        "totalCount": 13494472,
        "pageableCount": 798,
        "isEnd": false
    },
    "contents": [
        {
            "title": "[주식테마] 2023년03월22일 주식 테마 입니다.",
            "description": "독자 기술로 제품을 양산하기 시작한 후 협동로봇시장 국내 1위, 글로벌 <b>5</b>위에 올라선 바 있음.▷한편, 정부는 내달 로봇 보급 확대와 제조 역량 강화를 지원...챗GPT 대항마 &#39;바드&#39; 출시 소식 등에 상승▷구글은 전일(현지시간) <b>블로그</b>를 통해 미국과 영국에서 일부 이용자들을 대상으로 대화형 인공지능(AI) 바드(Bard...",
            "url": "http://sanebot.tistory.com/1168",
            "blogName": "주식하는 산이봇",
            "dateTime": null
        },
        {
            "title": "[공지] [무료EVENT]돈공 타임타이머 출시기념 <b>5</b>개 나눔 이벤트",
            "description": "그 정도로 효율적이라 여러분들께도 강력하게 추천드려요.(돈공 로고가 있으니, 매일 보며 돈버는 의지도 불태우는 효과? 일석이조 개꿀) ​ ​ <b>블로그</b>에서 <b>5</b>개, 인스타에서 <b>5</b>개, 총 10개를 무료로 나눠드릴 예정입니다. ​ ​ 10초면 참여가 가능하니, 빠르게 신청하세요! ​ ​ 이벤트 선물 돈공 타임타이머 무료나눔 이벤트 돈공...",
            "url": "https://blog.naver.com/sungon531/223052487500",
            "blogName": "돈버는 공략집, 곤팀장",
            "dateTime": null
        },
        {
            "title": "데모메이커<b>5</b> 최적화 <b>블로그</b> 만들기",
            "description": "데모메이커<b>5</b>의 <b>블로그</b> 최적화 만들기 스무 글자를 입력해야 합니다.",
            "url": "http://5.demo-maker.com/1",
            "blogName": "DemoMaker5's Blog",
            "dateTime": null
        },
        {
            "title": "여러 Optimization 기법에 대해 알아보자",
            "description": "이 <b>블로그</b>의 포스팅에서 다룬적이 있으니 보고오자 https://roki9914.tistory.com/4 경사하강법과 선형회귀 경사하강법이란? 경사하강법은 미분값을 이용해 함수의 최소값을 구하는 방법으로, 음의 미분값을 가지는 방향으로 이동하는 것이다. 쉽게 그림을 통해 알아보면 그림과 같이 음의 미분값을 가...",
            "url": "http://roki9914.tistory.com/11",
            "blogName": "개발자를 위한 발걸음",
            "dateTime": null
        }
    ]
}
```

---

### 2. popular (인기검색어 목록)
- url
```http request
localhost:8080/popular
```
- body example (json)
```json
{
  "size": 10
}
```
- 내용
```text
카카오와 네이버의 블로그 인기검색어

size - 사용자들이 많이 검색한 순서대로, 최대 10개
```
- response example
```json
{
    "queryCountResponses": [
        {
            "query": "blog2",
            "count": 4
        },
        {
            "query": "blog1",
            "count": 3
        },
        {
            "query": "blog5",
            "count": 1
        },
        {
            "query": "blog3",
            "count": 1
        }
    ]
}
```


