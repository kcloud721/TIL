package op;

import java.util.Random;

public class Ws20200715 {
	public static void main(String[] args) {
		int num1 = (int) (Math.random() * 100) + 1;
		int num2 = (int) (Math.random() * 100) + 1;

		Random r = new Random();
		int num3 = r.nextInt(100) + 1;
		int num4 = r.nextInt(100) + 1;

		double avg = (num1 + num2 + num3 + num4) / 4.0;
		//double avgPrint = (double)Math.round(avg * 10) / 10;	//반올림
		double avgPrint = Math.ceil(avg * 10)/10;				//올림
		char grade = (avg >= 90 ? 'A' : (avg >= 80 ? 'B' : (avg >= 70 ? 'C' : (avg >= 60 ? 'D' : 'F'))));
		
		System.out.println("your score is " + num1 + " " + num2 + " " + num3 + " " + num4);
		System.out.println("Your grade is " + grade);
		System.out.println("And your avg is " + avgPrint);
	}
}
