function totalCost(costs: number[], k: number, candidates: number): number {
    let answer = 0;
     //Return the total cost to hire exactly k workers.
    //You will run k sessions and hire exactly one worker in each session.
    // In each hiring session, choose the worker with the lowest cost from either the first candidates workers or the last candidates workers. Break the tie by the smallest index.
    // For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session, we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
    // In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th worker but they have the smallest index [3,2,7,7,2]. Please note that the indexing may be changed in the process.

    let i = 0;
    while (i < k) {
        let min = Math.min(...costs.slice(0, candidates));
        let minIndex = costs.indexOf(min);
        answer += min;
        costs.splice(minIndex, 1);
        i++;
    }

    return answer;

};