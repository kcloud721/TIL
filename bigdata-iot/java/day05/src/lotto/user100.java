package lotto;

import java.util.Arrays;
import java.util.Random;

public class user100 {

	public static void main(String[] args) {
		// 99명 랜덤번호 생성
		// 2차배열 > 1차는 사용자식별번호 / 2차는 랜덤로또번호
		
		//당첨번호 랜덤생성 중복없이 1~45
		int user100[][] = new int[100][6];
		Random r = new Random();
		
		for(int i=0 ; i<user100.length ; i++) { //맨앞에는 직접입력한 유저 번호 부여
			for(int j=0 ; j<user100[j].length ; j++) {
				if(i!=0) { //유저별 랜덤번호 부여 + 중복제거
					user100[i][j] = r.nextInt(45)+1; // 랜덤번호 생성
					for(int k=0 ; k<j ; k++) { //중복검사
						if(user100[i][j] == user100[i][k]) {
							k--;
							break;
						}
					}
					
				} else { //직접 입력란 초기화
					user100[i][j] = 0;
				}
			}
		}
		
		
		System.out.println("99명 로또번호 생성 : ");
		System.out.println(Arrays.deepToString(user100));
	}
}
