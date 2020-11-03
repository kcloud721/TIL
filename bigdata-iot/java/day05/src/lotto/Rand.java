package lotto;

import java.util.Arrays;
import java.util.Random;

public class Rand {

	public static void main(String[] args) {
		// 1명 사용자 직접입력
		// 99명 랜덤
		
		//당첨번호 랜덤생성 중복없이 1~45
		int winnum[] = new int[6];
		Random r = new Random();
		for(int i=0 ; i<winnum.length ; i++) {
			winnum[i] = r.nextInt(45)+1; //랜덤번호 생성
			for(int j=0 ; j<i ; j++) { //중복검사
				if(winnum[i] == winnum[j]) {
					i--;
					break;
				}
			}
		}
		System.out.println("당첨번호 : ");
		System.out.println(Arrays.toString(winnum));
		
		//오름차순 정렬
		for(int i=0 ; i<winnum.length ; i++) {
			for(int j=i+1 ; j<winnum.length ; j++) {
				if(winnum[i] > winnum[j]) {
					int temp = winnum[i];
					winnum[i] = winnum[j];
					winnum[j] = temp;
				}
			}
		}
		System.out.println("당첨번호(오름차순) : ");
		System.out.println(Arrays.toString(winnum));
	}
}
