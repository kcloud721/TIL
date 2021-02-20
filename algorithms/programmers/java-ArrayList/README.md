# Java ArrayList

* ArrayList Import

  ```java
  import java.util.ArrayList;
  ```

* ArrayList 선언

  ```bash
  ArrayList<String> my_arr_list = new ArrayList<String>();
  ```

* add

  ```bash
  my_arr_list.add("hello");
  my_arr_list.add("world");
  my_arr_list.add("java");
  ```

* remove

  ```bash
  my_arr_list.remove(2);
  // 2번째 원소를 지운다는 뜻
  ```

  Q. Integer형 ArrayList인 경우?

  A. 이 경우 역시 "2"가 들어있는 원소가 아니라 "2번째" 원소를 삭제

* get

  ```bash
  System.out.println(my_arr_list.get(1));
  //1번째 원소를 출력
  ```

* iterator (반복)

  * ArrayList를 탐색할 때는 Iterator를 사용. 반복기법?

  ```java
  // 객체 선언
  Iterator it<Integer> = numbers.iterator();
  ```

  * `it.next()` : 호출될 때 마다 다음 순서의 원소를 리턴

     `it.hasNext()` : 더 순회할 엘레먼트가 있는지 알 수 있음. `it.next()` 가 끝까지 도달할 경우 `it.hasNext` 는 false를 리턴하여 while 문 종료

  ```java
  while(it.hasNext()) {
  			System.out.println("1st: "+it.next());
  			int value = it.next();
  			System.out.println("2nd: "+value);
  			if(value == 2) {
  				System.out.println("wat"+it);
  				it.remove();
  			}
  	}
  ```

  ```bash
  입력 : [3, 9, 1, 2, 8]
  결과 : 
  3
  9
  1
  2
  8
  ```

  
