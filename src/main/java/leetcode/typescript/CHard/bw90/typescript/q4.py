#
# function secondGreaterElement(nums: number[]): number[] {
#     let result = [];
# for (let i = 0; i < nums.length; i++) {
#     let second = -1;
# let cnt = 0;
# let subArray = nums.slice(i + 1, nums.length);
#
# for (let j = 0; j < subArray.length; j++) {
# if (subArray[j] > nums[i]) {
#     cnt++;
# if (cnt === 2) {
#     second = subArray[j];
# break;
# }
# }
#
# }
# result.push(second);
# }
# return result;
# };

# //prevent squared time complexity
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        result = []
        for i in range(len(nums)):
            second = -1
            cnt = 0
            subArray = nums[i + 1:len(nums)]
            for j in range(len(subArray)):
                if subArray[j] > nums[i]:
                    cnt += 1
                    if cnt == 2:
                        second = subArray[j]
                        break
            result.append(second)
        return result

