# Thread

## 쓰레드 체험해보기

```java
public static void main(String[] args) throws InterruptedException {
		int data1 = 0;
		int data2 = 0;
		for(int i=0; i<=10; i++) {
			data1 += i;
			System.out.println("data1: "+data1);
			Thread.sleep(300);
		}
		for(int i=0; i<=10; i++) {
			data1 += i;
			System.out.println("data2:"+data1);
			Thread.sleep(300);
		}
	}
```



```bash
data1: 0
data1: 1
data1: 3
data1: 6
data1: 10
data1: 15
data1: 21
data1: 28
data1: 36
data1: 45
data1: 55
data2:55
data2:56
data2:58
data2:61
data2:65
data2:70
data2:76
data2:83
data2:91
data2:100
data2:110
```

thread 1이 끝난 후에 2가 실행되는 것을 확인할 수 있음



## 쓰레드 구현과 실행

### Thread 클래스를 상속

```java
class T1 extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}
	
}
```

class 에 extends Thread 넣어주고 오른버튼 Source > Override Methods > run



## 쓰레드의 동기화

p537



