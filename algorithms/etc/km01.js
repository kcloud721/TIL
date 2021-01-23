function solution(n, record) {
    var answer = [];
    var servers = [];
    var QUEUE_SIZE = 5;
    
    for(var i=0; i<n; i++){
        var nicks = [];
        servers.push(nicks);
    }

    for(var i=0; i<record.length; i++){
        var info = record[i].split(" ");
        var sNum = info[0];
        var nickName = info[1];
        
        // 중복 닉네임 있는지 체크
        if(isDuplicate(servers[sNum-1], nickName)){
            console.log('duplicate');
            continue;
        } else {
            // 큐 꽉찼는지 체크
            if(servers[sNum-1].length >= QUEUE_SIZE){
                // 꽉 찼으면 queue poll
                // console.log('over');
                servers[sNum-1].shift();
            }
            // console.log('push');
            servers[sNum-1].push(nickName);
        }
        // console.log(servers);
    }
    
    for(var i=0; i<n; i++){
        for(var j=0; j<servers[i].length; j++){
            answer.push(servers[i][j]);
        }
    }
    
    return answer;
}

function isDuplicate(nicks, nickName){
    for(var i=0; i<nicks.length; i++){
        if(nicks[i] == nickName){
            return true;
        }
    }
    return false;
}