package student;

import java.util.Arrays;

public class Test2 {

	public static void main(String[] args) {
		Student sts[] = new Student[3];
		sts[0] = new Student("Lee", "100", 20);
		sts[1] = new Student("Kim", "101", 30);
		sts[2] = new Student("Seo", "102", 40);

		double score1[] = {80,90,70,80};
		sts[0].setScore(score1);
		double score2[] = {84,95,72,82};
		sts[1].setScore(score2);
		double score3[] = {82,90,73,83};
		sts[2].setScore(score3);
		
		System.out.println(Arrays.deepToString(sts));
		int sum = 0;
		for (int i=0 ; i<sts.length ; i++) {
			sum += sts[i].getSum();
		}
		System.out.println(sum);
	}

}
