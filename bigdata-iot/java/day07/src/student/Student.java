package student;

public class Student {
	//Member Variable
	String name;
	String id;
	int age;
	double score[];
	
	//Constructor
	public Student() {}
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}	
	public Student(String name, String id, int age) {
		this.name = name;
		this.id = id;
		this.age = age;
	}
	
	//Member Function
	public double[] getScore() {
		return this.score;

	}
	public void setScore(double score[]){
		if(score.length > 4) {
			return;
		}
		this.score = score;
	}
	
	public double getSum() {
		double sum = 0.0;
		for(int i=0 ; i<score.length ; i++)
			sum += this.score[i];
		return sum;
	}
	
	public double getAvg() {
		double avg = 0.0;
		avg = getSum()/score.length;
		return avg;
	}
	
	public String getLevel(double avg){
		String level = "";//위에서 정의되지 않아서 초기기화 필요
		if(avg >= 95)
			level = "A+";
		else if(avg >= 90)
			level = "A";
		else if(avg >= 85)
			level = "B+";
		else if(avg >= 80)
			level = "B";
		else if(avg >= 70)
			level = "C";
		else if(avg >= 60)
			level = "D";
		else if(avg < 60)
			level = "F";
		return level;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", age=" + age + "]";
	}
	
}
