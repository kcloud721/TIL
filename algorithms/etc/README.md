# 자바스크립트 알고리즘

## codewars 풀이 목록

| 문제                                                         | 나의 풀이                                                    | 풀이 키워드     |
| ------------------------------------------------------------ | ------------------------------------------------------------ | --------------- |
| [Disemvowel Trolls](https://www.codewars.com/kata/52fba66badcd10859f00097e) | [🥸](https://github.com/kcloud721/TIL/blob/master/algorithms/javascript/Disemvowel-Trolls.js) | 정규식, replace |
|                                                              |                                                              |                 |
|                                                              |                                                              |                 |
|                                                              |                                                              |                 |



# 소소한 javascript

## 숫자형 데이터형이 따로 없다!

int, float 이런거 없고 var, const, let 으로 표현

#### 문자형 > 숫자형

```javascript
var 변수 = parseInt(문자);    //문자를 정수형 숫자로 변환해줌
var 변수 = parseFloat(문자);     //문자를 실수형 숫자로 변환해줌
var 변수 = Nember(문자);    //문자를 정수&실수형 숫자로 변환해줌
```

#### 숫자형 > 문자형

```javascript
var 변수 = String(숫자);    //숫자를 문자로 변환해줌
var 변수 = 숫자.toString(진법);    //숫자를 문자로 변환해줌 - 변환하면서 진법을 바꿀 수 있음
var 변수 = 숫자.toFixed(소수자리수);    //숫자를 문자로 변환해줌 - 실수형의 소수점 자리를 지정할 수 있음
var 변수 = 숫자 + "문자열";    //숫자와 문자열을 한 문자열로 더해줌
```



## 반올림, 올림, 내림

```javascript
Math.round(3.8);	// 반올림
> 4
```

```javascript
Math.ceil(3.1); // 올림
> 4
```

```javascript
Math.floor(3.9);	// 내림 
> 3
```







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



## 객체(Object) 만들기

상세: https://www.zerocho.com/category/JavaScript/post/572c6f759a5f1c4db2481ee3

### 객체 선언 (key-value)

```javascript
var truckInfo = {
  truckId: 'truck1'
  weight: 7,
  location: 5
};
```

### 객체 정보 출력

```javascript
console.log(truckInfo.truckId);
```

