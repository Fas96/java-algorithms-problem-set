function largestWordCount(messages: string[], senders: string[]): string {


    let hm: Map<string, number> = new Map();

    let max: number = 0;
    let name: string = "";
    for (let i = 0; i < messages.length; i++) {
        let words: string[] = messages[i].split(" ");
        let freq: number = (hm.get(senders[i]) || 0) + words.length;
        hm.set(senders[i], freq);
        if (hm.get(senders[i]) > max) {
            max = hm.get(senders[i]);
            name = senders[i];
        } else if (hm.get(senders[i]) == max && name.localeCompare(senders[i]) < 0) {
            name = senders[i];
        }
    }

    return name;


};
