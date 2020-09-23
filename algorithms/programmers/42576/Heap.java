package hash;

import java.util.Arrays;

public class Heap {	
	public static void main(String[] args) {
		int number = 9;
		int [] heap = new int[]{7, 6, 5, 8, 3, 5, 9, 1, 6};
		System.out.println(Arrays.toString(heap));
		
		// 트리 구조를 힙 구조로 바
		for(int i = 1; i < number; i++) {
			int c = 1;
			do {
				int root = (c - 1) / 2; //특정 원소의 부모 
				if(heap[root] < heap[c]) {
					int temp = heap[root];
					heap[root] = heap[c];
					heap[c] = temp;
				}
				c = root;
				System.out.println(Arrays.toString(heap));
			} while (c != 0);
		}
	}

}
