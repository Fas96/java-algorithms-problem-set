function twoEditWords(queries: string[], dictionary: string[]): string[] {
    // You are given two string arrays, queries and dictionary
    //In one edit you can take a word from queries, and change any letter in it to any other letter. Find all words from queries that, after a maximum of two edits, equal some word from dictionary.
    //Return a list of all words from queries, that match with some word from dictionary after a maximum of two edits. Return the words in the same order they appear in queries.

    let ans = [];
    for (let i = 0; i < queries.length; i++) {
        let flag = false;
        for (let j = 0; j < dictionary.length; j++) {
            if (queries[i].length === dictionary[j].length) {
                let cnt = 0;
                for (let k = 0; k < queries[i].length; k++) {
                    if (queries[i][k] !== dictionary[j][k]) cnt++;
                }
                if (cnt <= 2) {
                    flag = true;
                    break;
                }
            } else if (queries[i].length === dictionary[j].length + 1) {
                let cnt = 0;
                for (let k = 0; k < dictionary[j].length; k++) {
                    if (queries[i][k + cnt] !== dictionary[j][k]) {
                        cnt++;
                        k--;
                    }
                }
                if (cnt <= 1) {
                    flag = true;
                    break;
                }
            } else if (queries[i].length === dictionary[j].length - 1) {
                let cnt = 0;
                for (let k = 0; k < queries[i].length; k++) {
                    if (queries[i][k] !== dictionary[j][k + cnt]) {
                        cnt++;
                        k--;
                    }
                }
                if (cnt <= 1) {
                    flag = true;
                    break;
                }
            }
        }
        if (flag) ans.push(queries[i]);
    }
    return ans;

};