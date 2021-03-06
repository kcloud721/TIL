package rtest;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RTest4 {

	public static void main(String[] args) throws REXPMismatchException {
		RConnection rconn = null;
		int arg = 20;
		try {
			rconn = new RConnection("127.0.0.1");
			rconn.setStringEncoding("utf8");
			rconn.eval("source('/Users/jh/OneDrive - inu.ac.kr/study/Rproj/Rstudy/R/stavg.R', encoding='UTF-8')");
			REXP rexp = rconn.eval("stavg()"); // 함수이름 및 입력값 
			RList rlist = rexp.asList(); // 데이터 프레임 리턴위해 Rlist 사용  
			String names [] = rlist.at("NAME").asStrings(); // 컬럼명 입력 유의
			double tots [] = rlist.at("TOT").asDoubles();
			double avgs [] = rlist.at("AVG").asDoubles();
			
			for(int i=0; i<names.length; i++) {
				System.out.println(names[i] +" "+ tots[i] +" "+ avgs[i]);
			}
			
		} catch (RserveException e) {
			e.printStackTrace();
		}
		System.out.println("Complete!");
		rconn.close();
	}

}
