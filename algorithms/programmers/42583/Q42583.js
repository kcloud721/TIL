function solution(bridge_length, weight, truck_weights) {
    var count_time = 0;
    var on_bridge = 0;
    var waitingArr = new Array();
    var progressArr = new Array();
    var completedArr = new Array();
    
    for(var i=0; i<truck_weights.length; i++){
        var truckInfo = {
            weight: truck_weights[i],
            location: 0
        };
        waitingArr.push(truckInfo);
    }  
    
    while(completedArr.length != truck_weights.length){
        // 다리 위 트럭 끝까지 도달시 하차 
        if(progressArr.length != 0){
            if(progressArr[0].location == bridge_length){
                on_bridge -= progressArr[0].weight;
                completedArr.push(progressArr.shift());
            } 
        } 
        
        // 다리 여유 가능하면 다리 탑승 
        if(waitingArr.length != 0){
            if(on_bridge + waitingArr[0].weight <= weight){
                on_bridge += waitingArr[0].weight;
                progressArr.push(waitingArr.shift());
            }
        }
                
        // 다리 위 트럭들 한칸 씩 이동 
        for(var i=0; i<progressArr.length; i++){
            progressArr[i].location++;
        }
        count_time++;
        
    }
    
    return count_time;
}