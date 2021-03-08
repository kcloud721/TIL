# 소소한 python

## 몫과 나머지

```python
print(a//b)	#몫
print(a%b)	#나머지
```



## 비트연산

* ~ : not
* & : and
* ^ : xor
* << : left shift
* `>>` : right shift



## 반복문

파이썬의 for 문은 정수형이 아니라 list 형식으로 받아진다. 

```python
marks = [90, 25, 67, 45, 80]
for mark in marks: 
  print(mark)
```

자바나 c 에서 인자를 정수형으로 사용하는 것과 다름.

```python
# 자바 또는 C의 반복문
for(int i=0; i<n; i++){
  ...
}

# 위와 같이 정수 n만큼 반복문을 돌리고 싶다면 range() 활용
for i in range(0,n):
  print(i)
```



## 아스키코드

알파벳 a 의 아스키코드는 `ord('a')` 로 출력.

정수 n의 유니코드 문자 변환은 `chr(n)` 으로 출력.