package ifelse4;

import java.util.Random;

public class If4 {
	
	public static void main(String[] args) {
		Random r = new Random();
		int ko = r.nextInt(100)+1;
		int en = r.nextInt(100)+1;
		int ma = r.nextInt(100)+1;
		int si = r.nextInt(100)+1;
		String grade = "";
		
		System.out.printf("%d, %d, %d, %d \n", ko, en, ma, si);
		//평균을 구한다.
		int avg = (ko + en + ma + si) / 4;
		
		// 90이상 A : 95이상 A+, 미만이면  A-
		if(avg >= 90) {
			/*
			if(avg >= 95)
				grade = "A+";
			else
				grade = "A-";
			*/
			grade = (avg >= 95) ? "A+" : "A-";
		}
		// 80이상 B : 95이상 B+, 미만이면  B-
		if(avg >= 80) {
			if(avg >= 85)
				grade = "B+";
			else
				grade = "B-";
		}
		// 70이상 C : 95이상 C+, 미만이면  C-
		if(avg >= 70) {
			if(avg >= 75)
				grade = "C+";
			else
				grade = "C-";
		}
		// 60이상 D : 95이상 D+, 미만이면  D-
		if(avg >= 60) {
			if(avg >= 65)
				grade = "D+";
			else
				grade = "D-";
		}
		// 60미만은 F
		if(avg < 60)
			grade = "F";
		
		// 평균과 성적을 출력하쇼
		System.out.printf("평균 : %d \n", avg);
		System.out.printf("성적 : %s \n", grade);
		
		//====== 3항
		// grade = (avg >= 90) ? ((avg >= 95) ? "A+" : "A-");
		
		
	}

}
