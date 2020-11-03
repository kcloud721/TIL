package ws06;

import java.util.Arrays;

public class AccountTest2 {

	public static void main(String[] args) {
		//5개의 Account형 객체배열 선언
		Account[] acc2 = new Account[5];
		//for문으로 Account객체를 배열에 생성
		for (int i=0 ; i<acc2.length ; i++) {
			acc2[i] = new Account("221-0101-211"+(i+1), 100000, 4.5);
		}
		//for문으로 Account 정보 출력
		for (int i=0 ; i<acc2.length ; i++) {
			acc2[i].accountInfo();
		}
		//for문으로 이자율 변경, 화면출력
		for (int i=0 ; i<acc2.length ; i++) {
			acc2[i].interestRate = 3.7;
			System.out.println("변경된이자율: " + acc2[i].interestRate);
		}
		
		System.out.println(Arrays.deepToString(acc2));
		
	}
}
