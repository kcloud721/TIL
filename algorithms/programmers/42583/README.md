# Q. 42583 : 다리를 지나는 트럭

스택/큐 (3 of 4)

### [문제링크](https://programmers.co.kr/learn/courses/30/lessons/42583)

### 문제설명

트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.

예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

### 제한 사항

- bridge_length는 1 이상 10,000 이하입니다.
- weight는 1 이상 10,000 이하입니다.
- truck_weights의 길이는 1 이상 10,000 이하입니다.
- 모든 트럭의 무게는 1 이상 weight 이하입니다.

### 입출력 예

| bridge_length | weight | truck_weights                   | return |
| ------------- | ------ | ------------------------------- | ------ |
| 2             | 10     | [7,4,5,6]                       | 8      |
| 100           | 100    | [10]                            | 101    |
| 100           | 100    | [10,10,10,10,10,10,10,10,10,10] | 110    |



## 접근

문제를 푸는 데 꽤 오래 걸렸다.  한 트럭에 대해 `무게`  와 `다리 위 위치` 가 반드시 포함되어야 했는데, 클래스를 만들지 않고 풀어보려고 했기 때문이다.

클래스는 IDE에서 뚝딱 만들 수는 있어도, 실전 코테 환경에서 일일이 타이핑해서 만들기 쉽지 않을 것이라 생각했다. 다 외워야 하고 있으니까!

그래서 클래스를 만들지 않고 이차원 배열, ArrayList 등 이것 저것 조합하면서 풀어보려고 했는데 도무지 풀리지가 않았다.

> 그래 C에서도 구조체 써서 문제 많이 풀었었는데.. 자바 클래스나 C 구조체나 비슷하지..

그래서 결국 가장 먼저 떠오른 방법인 구조체 클래스를 만들어 해쉬맵으로 저장하는 방법으로 풀어보기로.

그랬더니 금방 뚝딱 풀렸당.



## 나의 풀이 (1)

* 대기, 진행, 완료 세 개의 큐를 만든다.
* 트럭 식별id와 무게, 다리 위 트럭의 위치를 저장할 클래스를 만든다.
* 이 클래스를 해쉬맵에 저장한다.
* 문제의 조건에 따라 다리를 건너게 한다.
* 완료 큐에 모든 트럭이 들어왔을 경우 함수 종료.

### java

```java
import java.util.*;

class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int count_time = 0;
    int on_bridge_weight = 0;
		Queue<truckInfo> waitingQ = new LinkedList<>();
		Queue<truckInfo> progressQ = new LinkedList<>();
		Queue<truckInfo> completedQ = new LinkedList<>();

		// 트럭 정보를 해쉬맵에 저장 
    for (int i = 0; i < truck_weights.length; i++) {
			String truckId = "t" + i;
			int truckWeights = truck_weights[i];
			int truckLoc = 0;
			truckInfo t = new truckInfo(truckId, truckWeights, truckLoc);
			waitingQ.add(t);
		}

		while (completedQ.size() != truck_weights.length) {
			if (progressQ.size() != 0) {
				if (progressQ.element().getLocation() == bridge_length) {
					// 끝까지 이동한 트럭 completed에 옮김
					on_bridge_weight -= progressQ.element().getWeights(); // 다리 무게 다시 감소
					completedQ.add(progressQ.poll()); // 큐 이동
					System.out.println("BYE");
				}
			}

			if (waitingQ.size() != 0) {
				if (on_bridge_weight + waitingQ.element().getWeights() <= weight) { // 다리무게 견딜 수 있을 경우 waiting 트럭 탑승
					on_bridge_weight += waitingQ.element().weights; // 다리 무게 카운트
					progressQ.add(waitingQ.poll()); // 진행중 큐로 옮김
				}
			}

			// 다리 위 트럭들 한칸씩 이동
			for (truckInfo prog : progressQ) {
				prog.setLocation(prog.getLocation() + 1);
			}

			// 경과시간 카운트
			count_time++;

			// System.out.println(waitingQ);
			// System.out.println(progressQ);
			// System.out.println(completedQ);
			// System.out.println("경과시간 " + count_time);
			// System.out.println();

		}

		return count_time;
	}
}

class truckInfo {
	String id;
	int weights;
	int location;

	public truckInfo() {

	}

	public truckInfo(String id, int weights, int location) {
		this.id = id;
		this.weights = weights;
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getWeights() {
		return weights;
	}

	public void setWeights(int weights) {
		this.weights = weights;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "truckInfo [id=" + id + ", weights=" + weights + ", location=" + location + "]";
	}

}
```

### 문제점

* 트럭 정보를 담은 truckInfo 클래스에 truckId는 필요가 없다. 이미 해쉬맵에서 ID 부여가 되었기 때문.
* 클래스 선언 시, IDE 도움이 아닌 직접 타이핑하여 실전 테스트 환경에 대비해야 한다.

### 의문점

* Queue를 세 개나 쓸 필요가 있을까?

### 개선점

* 빈 큐인지 확인하는 방법으로 `size()` 메서드를 사용했는데, 더 간단한  `isEmpty()` 가 있었음.

  ```java
  if(waitingQ.size() != 0)	// 내가 쓴 방법
  if(waitingQ.isEmpty())		// 더 직관적으로 표현 가능
  ```

  

## 나의 풀이 (2) : 조금 다듬은 코드

### java

```java
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int count_time = 0;
		Queue<truckInfo> waitingQ = new LinkedList<>();
		Queue<truckInfo> progressQ = new LinkedList<>();
		Queue<truckInfo> completedQ = new LinkedList<>();
		int on_bridge_weight = 0;

		for (int i = 0; i < truck_weights.length; i++) {
			int truckWeights = truck_weights[i];
			int truckLoc = 0;
			truckInfo t = new truckInfo(truckWeights, truckLoc);
			waitingQ.add(t);
		}

		while (completedQ.size() != truck_weights.length) {
			if (progressQ.size() != 0) {
				if (progressQ.element().getLocation() == bridge_length) {
					// 끝까지 이동한 트럭 completed에 옮김
					on_bridge_weight -= progressQ.element().getWeights(); // 다리 무게 다시 감소
					completedQ.add(progressQ.poll()); // 큐 이동
					System.out.println("BYE");
				}
			}

			if (waitingQ.size() != 0) {
				if (on_bridge_weight + waitingQ.element().getWeights() <= weight) { // 다리무게 견딜 수 있을 경우 waiting 트럭 탑승
					on_bridge_weight += waitingQ.element().weights; // 다리 무게 카운트
					progressQ.add(waitingQ.poll()); // 진행중 큐로 옮김
				}
			}

			// 다리 위 트럭들 한칸씩 이동
			for (truckInfo prog : progressQ) {
				prog.setLocation(prog.getLocation() + 1);
			}

			// 경과시간 카운트
			count_time++;

			System.out.println(waitingQ);
			System.out.println(progressQ);
			System.out.println(completedQ);
			System.out.println("경과시간 " + count_time);
			System.out.println();

		}

		return count_time;
	}
}

class truckInfo {
	int weights;
	int location;

	public truckInfo(int weights, int location) {
		this.weights = weights;
		this.location = location;
	}

	public int getWeights() {
		return this.weights;
	}

	public int getLocation() {
		return this.location;
	}

	public void setWeights(int weights) {
		this.weights = weights;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	// toString 이건 외우면 좋을듯 하다.. @Override 필!
	@Override
	public String toString() {
		return "truckInfo [weights=" + weights + ", location=" + location + "]";
	}

}
```





## 자바스크립트 ver.

### javascript

자바에선 클래스를 만들어 객체에 정보를 담았는데, 자바스크립트 또한 Object를 활용하여 비슷하게 구현할 수 있었다.

### 객체 선언 (key-value)

```javascript
var truckInfo = {
  truckId: 'truck1'
  weight: 7,
  location: 5
};
```



### js 로 작성한 풀이

```javascript
function solution(bridge_length, weight, truck_weights) {
    var count_time = 0;
    var on_bridge = 0;
    var waitingArr = new Array();
    var progressArr = new Array();
    var completedArr = new Array();
    
    for(var i=0; i<truck_weights.length; i++){
        var truckInfo = {
            weight: truck_weights[i],
            location: 0
        };
        waitingArr.push(truckInfo);
    }  
    
    while(completedArr.length != truck_weights.length){
        // 다리 위 트럭 끝까지 도달시 하차 
        if(progressArr.length != 0){
            if(progressArr[0].location == bridge_length){
                on_bridge -= progressArr[0].weight;
                completedArr.push(progressArr.shift());
            } 
        } 
        
        // 다리 여유 가능하면 다리 탑승 
        if(waitingArr.length != 0){
            if(on_bridge + waitingArr[0].weight <= weight){
                on_bridge += waitingArr[0].weight;
                progressArr.push(waitingArr.shift());
            }
        }
                
        // 다리 위 트럭들 한칸 씩 이동 
        for(var i=0; i<progressArr.length; i++){
            progressArr[i].location++;
        }
        count_time++;
        
    }
    
    return count_time;
}
```




