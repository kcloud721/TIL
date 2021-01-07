# 자바스크립트 알고리즘

## codewars 풀이 목록

#### 

| 문제                                                         | 나의 풀이                                                    | 풀이 키워드     |
| ------------------------------------------------------------ | ------------------------------------------------------------ | --------------- |
| [Disemvowel Trolls](https://www.codewars.com/kata/52fba66badcd10859f00097e) | [🥸](https://github.com/kcloud721/TIL/blob/master/algorithms/javascript/Disemvowel-Trolls.js) | 정규식, replace |
|                                                              |                                                              |                 |
|                                                              |                                                              |                 |
|                                                              |                                                              |                 |



# 소소한 javascript

## 특정 문자 제거하기 (모음 제거)

정규식 + replace 메서드 활용

* 정규식

  ```javascript
  const vowels = /[aeiou]+/g;
  ```

  * g : 발생할 모든 패턴에 대한 전역 검색
  * i : 대소문자 구분 안함
  * m : 여러 줄 검색

* replace 활용 세 가지 풀이

```javascript
return string.replace(vowels, "");
```

```javascript
function disemvowel(string){
  const vowels = /[aeiou]+/g;
  return string.replace(vowels, "");
}
```

```javascript
function disemvowel(string){
  return string.replace(/[aeiou]+/g, "");
}
```





