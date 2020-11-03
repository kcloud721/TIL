package forwhile;

public class For4 {

	public static void main(String[] args) {
		System.out.println("START ...");
		out: //for문에 대한 이름이 "out"
		for (int i=0; i < 5; i++) {
			for(int j=0 ; j<5 ; j++) {
				if(i==2 && j==2)
					break out; 
					//continue; //밑에있는거 실행 안하고 for문 한 사이클 끝냄
				if(i==j)
					System.out.println(i + " " + j);
			}
		}
		System.out.println("END ...");
	}

}
