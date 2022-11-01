
function oddString(words: string[]): string {


    let map = new Map();
    for (let i = 0; i < words.length; i++) {
        let diff = [];
        for (let j = 0; j < words[i].length - 1; j++) {
            // the difference between their positions in the alphabet i.e. the position of 'a' is 0, 'b' is 1, and 'z' is 25.
           //postion of words[i].charCodeAt(j + 1) in alphabet - postion of words[i].charCodeAt(j) in alphabet
            diff.push(words[i].charCodeAt(j + 1) - words[i].charCodeAt(j));

        }
        diff.sort((a, b) => a - b);
        if (map.has(diff.toString())) {
            let arr = map.get(diff.toString());
            arr[0]++;
            arr.push(i);
            map.set(diff.toString(), arr);
            arr=[];

        } else {
            map.set(diff.toString(), [1, i]);
        }
        diff=[];
    }

        let index = -1;
        for (let [key, value] of map) {
            if (value[0] === 1) {
                index = value[1];
                break;
            }
        }
        return index === -1 ? "" : words[index];







};