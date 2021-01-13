class Solution {
	    public int[] solution(int[] prices) {
	        int[] answer = new int[prices.length];
	        for(int i=0; i<prices.length; i++){
	            int sec = 0;
	            for(int j=i+1; j<prices.length; j++){
	            	if(prices[i] <= prices[j]) {	// 유지 
	            		sec++;
	            	} else { // 하락 
	            		sec++;
	            		break;
	            	}
	            }
	            answer[i] = sec;
	        }
	        return answer;
	    }
	}