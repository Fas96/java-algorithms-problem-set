function max(start1: string, start2: string) {
    return start1 > start2 ? start1 : start2;
}

function min(end1: string, end2: string) {
    return end1 < end2 ? end1 : end2;
}

function haveConflict(event1: string[], event2: string[]): boolean {
    const [start1, end1] = event1;
    const [start2, end2] = event2;
     return    max( start1 ,start2) <= min(end1,  end2);

};