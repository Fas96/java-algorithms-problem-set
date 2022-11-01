# /*
# function makeIntegerBeautiful(n: number, target: number): number {
#     let sum = 0;
# let num = n;
# while (num > 0) {
# sum += num % 10;
# num = Math.floor(num / 10);
# }
#
# if (sum > target) {
# for (let i = 0; i < Math.pow(10,12); i++) {
# let sum2 = 0;
# let num2 = n + i;
# while (num2 > 0) {
# sum2 += num2 % 10;
# num2 = Math.floor(num2 / 10);
# }
# if (sum2 <= target) {
# return i;
# }
# }
# }
# return 0;
#
# };
# */

class Solution:
    def makeIntegerBeautiful(self, n: int, target: int) -> int:
        sum = 0
        num = n
        while num > 0:
            sum += num % 10
            num = num // 10
        if sum > target:
            for i in range(0, 10 ** 12):
                sum2 = 0
                num2 = n + i
                while num2 > 0:
                    sum2 += num2 % 10
                    num2 = num2 // 10
                if sum2 <= target:
                    return i
        return 0