# [2750](https://www.acmicpc.net/problem/2750) : 수 정렬하기

## 1. 선택정렬

### 나의 풀이

for문을 오지게 돌림

```java
public class Q2750_sol1 {	// 선택정렬 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int [n];
		
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		
		for(int i=0; i<n-1; i++) {
			int minPtr = i;
			for(int j=i+1; j<n; j++) {
				if(arr[j] < arr[minPtr])
					minPtr = j;
			}
			int temp = arr[i];
			arr[i] = arr[minPtr];
			arr[minPtr] = temp;
		}
		
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]);
	}
}
```

### 다른 사람의 풀이



