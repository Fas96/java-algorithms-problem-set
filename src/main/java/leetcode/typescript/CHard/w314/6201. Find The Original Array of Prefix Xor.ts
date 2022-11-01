

function findArray(pref: number[]): number[] {
    //You are given an integer array pref of size n. Find and return the array arr of size n that satisfies:
    // pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
    //If there are multiple possible answers, return any of them.
    let n=pref.length;
    let arr=new Array(n);
    arr[0]=pref[0];
    for(let i=1;i<n;i++){
        arr[i]=pref[i]^pref[i-1];
    }
    return arr;


};

describe('findArray', () => {
     //[5,2,0,3,1]
    // Output: [5,7,2,3,2]

    it('findArray', () => {
        expect(findArray([0,1,2,3,4])).toEqual([0,1,2,3,4]);
        expect(findArray([5,2,0,3,1])).toEqual([5,7,2,3,2]);
        expect(findArray([13])).toEqual([13]);
        expect(findArray([5,2,0,3,1])).toEqual([5,7,2,3,2]);
    }
    );
});