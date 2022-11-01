function productQueries(n: number, queries: number[][]): number[] {
    // 6209. Range Product Queries of Powers
    // https://leetcode.com/problems/range-product-queries-of-powers/
    // composed of the minimum number of powers of 2 that sum to n

    //generate arrays that has more of powers of 2 that sums up to n
    let arr = new Array(n + 1);
    for (let i = 0; i < arr.length; i++) {
        arr[i] = new Array();
    }
    for (let i = 1; i <= n; i++) {
        let j = 1;
        while (j <= i) {
            arr[i].push(j);
            i -= j;
            j *= 2;
        }
    }
    let result = new Array(queries.length);
    for (let i = 0; i < queries.length; i++) {
        let left = queries[i][0];
        let right = queries[i][1];
        let sum = 0;
        for (let j = left; j <= right; j++) {
            sum += arr[j].length;
        }
        result[i] = sum;
    }
    return result;

};