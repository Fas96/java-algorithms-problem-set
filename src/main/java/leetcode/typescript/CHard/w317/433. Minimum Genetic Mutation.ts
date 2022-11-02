function isMutation(current: string, next: string) {
    let count = 0;
    for (let i = 0; i < current.length; i++) {
        if (current[i] !== next[i]) {
            count++;
        }
    }
    return count === 1;
}

function minMutation(start: string, end: string, bank: string[]): number {
   let answer = 0;
    let queue = [start];
    let visited = new Set();
    while (queue.length > 0) {
        let size = queue.length;
        for (let i = 0; i < size; i++) {
            let current = queue.shift();
            //we keep changing the current string
            if (current === end) {
                return answer;
            }
            for (let j = 0; j < bank.length; j++) {
                let next = bank[j];
                if (visited.has(next)) {
                    continue;
                }
                if (isMutation(current, next)) {
                    queue.push(next);
                    visited.add(next);
                }
            }
        }
        answer++;
    }
    return -1;



};