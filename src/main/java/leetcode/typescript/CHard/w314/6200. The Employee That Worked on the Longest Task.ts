function hardestWorker(n: number, logs: number[][]):number {
    // Return the id of the employee that worked the task with the longest time. If there is a tie between two or more employees, return the smallest id among them.
    //if work time between the employee with longest work time is same, return the smallest id
    //if work time between the employee with longest work time is not same, return the employee with longest work time
    //if there is a tie between two or more employees, return the smallest id among them.
    //if there is no employee, return -1
    //if there is only one employee, return the id of the employee
    //if there is only one task, return the id of the employee

    // n = 10, logs = [[0,3],[2,5],[0,9],[1,15]], Output: 1
    //n = 26, logs = [[1,1],[3,7],[2,12],[7,17]], Output: 3
    //n = 2, logs = [[0,10],[1,20]], Output: 0
    // n=450, [[110,5],[360,7],[48,8],[286,10],[167,12],[110,13],[221,18]] Output: 110
    let map= new Map();
    for(let i=0;i<logs.length;i++){
        // if employee id is already in the map replace the value with the max of the current value and the new value


        if(i==0){
            map.set(logs[i][0],logs[i][1]);
            if(map.has(logs[i][0])){
                map.set(logs[i][0],Math.max(map.get(logs[i][0]),logs[i][1]));
            }
        }else{
            let time=logs[i][1]-logs[i-1][1];
            map.set(logs[i][0],time);
            if(map.has(logs[i][0])){
                map.set(logs[i][0],Math.max(map.get(logs[i][0]),logs[i][1]));
            }
        }
    }
    let max=0;
    let id=-1;
    console.log(map);
    // @ts-ignore
    for(let [key,value] of map){
        if(value>max){
            max=value;
            id=key;
        }else if(value==max){
            id=Math.min(id,key);
        }
    }
    return id;





}

//test
describe('hardestWorker', () => {
    //There are n employees, each with a unique id from 0 to n - 1.
    //You are given a 2D integer array logs where logs[i] = [idi, leaveTimei] where:
   // idi is the id of the employee that worked on the ith task, and
    //leaveTimei is the time at which the employee finished the ith task. All the values leaveTimei are unique.
   // Note that the ith task starts the moment right after the (i - 1)th task ends, and the 0th task starts at time 0.
    //Return the id of the employee that worked the task with the longest time. If there is a tie between two or more employees, return the smallest id among them.
    it('hardestWorker', () => {
        expect(hardestWorker(10, [[0,3],[2,5],[0,9],[1,15]])).toEqual(1);
        expect(hardestWorker(26, [[1,1],[3,7],[2,12],[7,17]])).toEqual(3);
        expect(hardestWorker(2, [[0,10],[1,20]])).toEqual(0);
    }
    );
});