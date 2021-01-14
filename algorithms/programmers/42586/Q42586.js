function solution(progresses, speeds) {
    var answer = [];
    var days = [];

    for(var i=0; i<progresses.length; i++){
        var q = (100 - progresses[i]) / speeds[i];
		days.push(Math.ceil(q));
    }
    
    var tasks = 0;
    var troll = days[0];
    
    for(var i=1; i<=days.length; i++){
        tasks++;
        if(i == days.length){
            answer.push(tasks);
            break;
        } else if(troll < days[i]) {
            answer.push(tasks);
            tasks = 0;
            troll = days[i];
        }
    }

    return answer;
}