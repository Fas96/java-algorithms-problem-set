function makeIntegerBeautiful(n: number, target: number): number {
    let sum = 0;
    let num = n;
    while (num > 0) {
        sum += num % 10;
        num = Math.floor(num / 10);
    }
    let thatNum=1;
    if (sum > target) {
        sum= 0;
        while (sum > target) {
            n=n-(thatNum++);
            let num2 = n;
            while (num2 > 0) {
                sum += num2 % 10;
                num2 = Math.floor(num2 / 10);
            }
        }
    }

    return thatNum-1;

};